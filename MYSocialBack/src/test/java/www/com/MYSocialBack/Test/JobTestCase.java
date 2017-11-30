package www.com.MYSocialBack.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.DAO.JobDAO;
import www.com.dto.Blog;
import www.com.dto.Forum;
import www.com.dto.Job;


public class JobTestCase {

	
private static final Object Forum = null;
	
	public static AnnotationConfigApplicationContext context;
	private static JobDAO jobDAO;
	private Job job;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("www.com.MYSocialBack");
		context.refresh();
		jobDAO =(JobDAO) context.getBean("jobDAO");
	}
	
	
	@Ignore
	@Test
	public  void addJobTest() {
		Job job = new Job();
		job.setJobdate("22dec2011");
		job.setJobprofile("be");
		job.setPostdate("22dec2011");
		job.setQualification("be");
		job.setStatus("A");
		
		
		
	
		assertEquals("Failed to add user!",true,jobDAO.addJob(job));
		
	} 
	
	@Test
	public void updateJobTest(){
	
		//Blog blog = (Blog)blogDAO.getBlog(1);
		Job job=(Job)jobDAO.getJob(1);
		job.setQualification("software engg");
		
		assertTrue("Problem in updation",jobDAO.updateJob(job));
	}
	
}
