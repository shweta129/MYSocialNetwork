/*package www.com.MYSocialBack.Test;

import org.hibernate.annotations.SelectBeforeUpdate;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.User;

public class UserTestCase {

	

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	
	
	
	
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("www.com.MYSocialBack");
		context.refresh();
		
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	
	@Test
	public  void testAdd() {
		
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		
		//add the user
		assertEquals("Failed to add user!",true,userDAO.saveUser(user));
	}

	}
}
*/