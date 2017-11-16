package www.com.MYSocialBack.Test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.User;

public class UserTest {

	
	public static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user;
	
	@BeforeClass
	public static void init(){
		context =new AnnotationConfigApplicationContext();
		context.scan("www.com.MYSocialBack");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
		
	}
	
	@Test
	public  void testAdd() {
		user = new User();
		user.setFirstName("sandy");
		user.setLastName("patil");
		user.setEmail("email@gmail.com");
		user.setContactNumber("124567890");
		user.setPassword("12345");
		user.setAddress("kalwa");
		user.setDob("28FEB1989");
	
		assertEquals("Failed to add user!",true,userDAO.saveUser(user));
		
	}
	}



