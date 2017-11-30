package www.com.MYSocialBack.Test;



import static org.junit.Assert.assertTrue;

import org.apache.catalina.User;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.DAO.UserDAO;
import www.com.dto.Blog;
import www.com.dto.UserDetail;

public class UserTest {

	
	public static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private UserDetail user;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("www.com.MYSocialBack");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	@Ignore
	@Test
	public  void addUserTest() {
		UserDetail user =new UserDetail();
		user.setUsername("shweta");
		user.setFirstName("shweta");
		user.setLastName("chaudhari");
		user.setPassword("123456");
		user.setEmail("sc@gmail.com");
		user.setIsOnline("N");
		user.setRole("Admin");
		
		assertTrue("Problm occure",userDAO.addUser(user));
		
		
	}
	@Test
	public void updateUsersTest(){
		UserDetail user =(UserDetail)userDAO.getUser("sam");
		user.setLastName("patil");
		assertTrue("Problem in updation",userDAO.updateOnlineStatus("ol", user));
	}
	/*@Ignore
	@Test
	public void updateUserTest(){
	
		User user = (User)userDAO.getUser("shweta");
		user.setUsername("Sam");
		assertTrue("Problem in updation",userDAO.updateUs);
	}
	*/
	
}




