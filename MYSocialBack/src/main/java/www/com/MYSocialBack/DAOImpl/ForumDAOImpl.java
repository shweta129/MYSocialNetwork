package www.com.MYSocialBack.DAOImpl;


import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.com.MYSocialBack.DAO.ForumDAO;
import www.com.MYSocialBack.dto.Blog;
import www.com.MYSocialBack.dto.Forum;

@Repository("forumDAO")
@Transactional    //all methods are run under transaction
public class ForumDAOImpl implements ForumDAO{
	
	
public static final Logger log = Logger.getLogger(BlogDAOImpl.class.getName());
	
@Autowired
private SessionFactory SessionFactory;

	@Override
	public boolean addForum(Forum forum) {
		try {
			SessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateForum(Forum forum) {
		try{
			SessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteForum(Forum forum) {
		try{
			SessionFactory.getCurrentSession().delete(forum);
			return true;
			
		}
		catch(Exception e)
		{
			log.info("Exception Occured"+e);
			return false;
		}
		
	}

	@Override
	public Forum getForum(int forumId) {
		Session session = SessionFactory.openSession();
		Forum forum = session.get(Forum.class, forumId);
		session.close();
		return forum;
	}

	@Override
	public List<Forum> getAllForum() {
		Session session = SessionFactory.openSession();
		List<Forum> forumList=(List<Forum>)session.createQuery("from Forum");
		session.close();
		return forumList;
	}

	@Override
	public boolean approveForum(Forum forum) {
		try{
			forum.setStatus("A");
			SessionFactory.getCurrentSession().saveOrUpdate(forum);
			return true;
			
		}
		catch(Exception e)
		{
		log.info("Exception Occured:"+e);
		return false;
		}
	}

	@Override
	public boolean rejectForum(Forum forum) {
		try {
			forum.setStatus("N");
			SessionFactory.getCurrentSession().update(forum);
			return true;
			
			
		} catch (Exception e) {
			log.info("Exception Occured"+e);
			return false;
		}
	}
	
	

}
