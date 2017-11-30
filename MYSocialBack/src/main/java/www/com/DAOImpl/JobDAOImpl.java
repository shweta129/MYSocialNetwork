package www.com.DAOImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.com.DAO.JobDAO;
import www.com.dto.Blog;
import www.com.dto.Job;

@Repository("jobDAO")
@Transactional    //all methods are run under transaction
public class JobDAOImpl implements JobDAO{

	@Autowired
	private SessionFactory SessionFactory;
	
	@Override
	public boolean addJob(Job job) {
		try {
			SessionFactory.getCurrentSession().save(job);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean updateJob(Job job) {
		try{
			SessionFactory.getCurrentSession().saveOrUpdate(job);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteJob(Job job) {
		try{
			SessionFactory.getCurrentSession().delete(job);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("Exception Occured"+e);
			return false;
		}
		
	}


	@Override
	public Job getJob(int jobId) {
		Session session = SessionFactory.openSession();
		Job job = session.get(Job.class, jobId);
		session.close();
		return job;

}
}
