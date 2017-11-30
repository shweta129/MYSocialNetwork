package www.com.DAOImpl;


import java.util.List;
import java.util.logging.Logger;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.com.DAO.BlogDAO;
import www.com.dto.Blog;

@Repository("blogDAO")
@Transactional    //all methods are run under transaction
public class BlogDAOImpl implements BlogDAO {

	public static final Logger log = Logger.getLogger(BlogDAOImpl.class.getName());
	
	@Autowired
	private SessionFactory SessionFactory;
	
	
	
	@Override
	public boolean addBlog(Blog blog) {
		try {
			SessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBlog(Blog bolg) {
		try{
			SessionFactory.getCurrentSession().update(bolg);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteBlog(Blog blog) {
		try{
			SessionFactory.getCurrentSession().delete(blog);
			return true;
			
		}
		catch(Exception e)
		{
			log.info("Exception Occured"+e);
			return false;
		}
		
	}

	@Override
	public Blog getBlog(int blogId) {
		Session session = SessionFactory.openSession();
		Blog blog = session.get(Blog.class, blogId);
		session.close();
		return blog;
		
	}

	@Override
	public List<Blog> getAllBlogs() {
		/*Session session = SessionFactory.openSession();
		List<Blog> blogList=(List<Blog>)session.createQuery("from Blog");
		session.close();
		return blogList;*/
		
		return SessionFactory.getCurrentSession().createQuery("FROM Blog", Blog.class).getResultList();
		
		
	}

	@Override
	public boolean approveBlog(Blog blog) {
		try{
			blog.setStatus("A");
			SessionFactory.getCurrentSession().saveOrUpdate(blog);
			return true;
			
		}
		catch(Exception e)
		{
		log.info("Exception Occured:"+e);
		return false;
		}
	}

	@Override
	public boolean rejectBlog(Blog blog) {
		try {
			blog.setStatus("N");
			SessionFactory.getCurrentSession().update(blog);
			return true;
			
			
		} catch (Exception e) {
			log.info("Exception Occured"+e);
			return false;
		}
	}

}
