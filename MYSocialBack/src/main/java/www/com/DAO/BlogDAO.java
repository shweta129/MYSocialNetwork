package www.com.DAO;

import java.util.List;

import www.com.dto.Blog;

public interface BlogDAO {

	
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog bolg);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public boolean rejectBlog(Blog blog);
	
}
