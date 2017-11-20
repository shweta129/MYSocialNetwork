package www.com.MYSocialBack.Test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.MYSocialBack.DAO.BlogDAO;
import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.Blog;
import www.com.MYSocialBack.dto.User;

public class BlogTestCase {

	
	
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
	
	
	
	@Test
	public  void addBlogTest() {
		Blog blog = new Blog();
		blog.setBlogID(1007);
		blog.setBlogName("core java");
		blog.setBlogContent("It is based on simple Java Concept");
		blog.setUsername("sam");
		blog.setStatus("A");
		blog.setLikes(3);
		//blog.setCreateDate(new java.util.Date());
		blog.setCreateDate(new Date());
	
		assertEquals("Failed to add user!",true,blogDAO.addBlog(blog));
		
	}
}

