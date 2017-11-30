package www.com.DAO;

import java.util.List;

import www.com.dto.Blog;
import www.com.dto.Forum;

public interface ForumDAO {

	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getAllForum();
	public boolean approveForum(Forum forum);
	public boolean rejectForum(Forum forum);
}
