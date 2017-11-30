package www.com.DAO;

import www.com.dto.Job;

public interface JobDAO {

	
	public boolean addJob(Job job);
	public boolean updateJob(Job job);
	public boolean deleteJob(Job job);
	public Job getJob(int jobId);
	
}
