package www.com.MYSocialBack.Test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.DAO.BlogDAO;
import www.com.DAO.UserDAO;
import www.com.DAOImpl.BlogDAOImpl;
import www.com.dto.Blog;
import www.com.dto.UserDetail;

public class BlogTestCase {

	public static final Logger log = Logger.getLogger(BlogTestCase.class.getName());
	
	public static AnnotationConfigApplicationContext context;
	private static BlogDAO blogDAO;
	private Blog blog;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("www.com.MYSocialBack");
		context.refresh();
		//blogDAO = (BlogDAO) context.getBean("bogDAO");
		blogDAO =(BlogDAO) context.getBean("blogDAO");
	}
	
	
	@Ignore
	@Test
	public  void addBlogTest() {
		Blog blog = new Blog();
		blog.setBlogID(1007);
		blog.setBlogName("core java");
		blog.setBlogContent("It is based on simple Java Concept");
		blog.setUsername("harshu");
		blog.setStatus("A");
		blog.setLikes(3);
		//blog.setCreateDate(new java.util.Date());
		blog.setCreateDate(new Date());
	
		assertEquals("Failed to add user!",true,blogDAO.addBlog(blog));
		
	}
	@Ignore
	@Test
	public void getBlogTest(){
		
		Blog blog = blogDAO.getBlog(2);
		assertNotEquals("Blog Not Found", blog);
		
		log.info("Blog Name:"+blog.getBlogName());
		log.info("Blog Content"+blog.getBlogContent());
	}
	@Ignore	
	@Test
	public void getAllBlogTest(){
		
	    
		List<Blog> blogList=(List<Blog>)blogDAO.getAllBlogs();
		assertNotNull("Blog List Not Found", blogList.get(0));
		for(Blog blog:blogList)
			
		{
			log.info("Blog ID"+blog.getBlogID()+"::"+"Blog Name:"+blog.getBlogName());
			assertTrue("Problem in Deletion", blogDAO.deleteBlog(blog));
		}
	}
	@Ignore
    @Test
    public void deleteBlogTest()
    {
    	Blog blog = (Blog)blogDAO.getBlog(2);
    	assertTrue("Problem in deletion",blogDAO.deleteBlog(blog));
    }
	
	//@Ignore
	@Test
	public void updateBlogTest(){
	
		Blog blog = (Blog)blogDAO.getBlog(1);
		blog.setBlogContent("mmm");
		blog.setBlogName("java");
		assertTrue("Problem in updation",blogDAO.updateBlog(blog));
	}
	@Ignore
	@Test
	public void approveBlogTest(){
		
		Blog blog = (Blog)blogDAO.getBlog(3);
		assertTrue("Problem in approve",blogDAO.approveBlog(blog));
	}
}

