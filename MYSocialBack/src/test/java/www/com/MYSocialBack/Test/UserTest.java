package www.com.MYSocialBack.Test;



import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.UserDetail;

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
		
		assertTrue("Problm occure",userDAO.addUserDetails(user));
		
		
		/*userDetail = new UserDetail();
		user.setUsername("shweta chaudhari");;
		user.setFirstName("shweta");
		user.setLastName("chaudhari");
		user.setPassword("123456");
		user.setRole("Admin");
		user.setEmail("sc@gmail.com");
		
	
		assertTrue("Failed to add user!",true,userDAO.addUser(user));*/
		
	}
}

	/*@Test
	public  void testAdd() {
		user = new User();
		user.setFirstName("shweta");
		user.setLastName("chaudhari");
		user.setPassword("123456");
		user.setEmail("sc@gmail.com");
		user.setStatus("ol");
		user.setIsOnline("Online");
		user.setContactNumber("124567890");
		user.setAddress("thane");
		user.setDob("28FEB1989");
		user.setRole("female");
	
		assertEquals("Failed to add user!",true,userDAO.saveUser(user));
		}*/

	
		
	
	
	/*@Test
	public  void testAdd() {
		user = new User();
		user.setFirstName("sandy");
		user.setLastName("patil");
		user.setPassword("123456");
		user.setEmail("sp@gmail.com");
		user.setStatus("ol");
		user.setIsOnline("Online");
		user.setContactNumber("124567890");
		user.setAddress("thane");
		user.setDob("28FEB1989");
		user.setRole("male");
	
		assertEquals("Failed to add user!",true,userDAO.saveUser(user));
		}*/
	



