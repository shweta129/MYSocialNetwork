package www.com.MYSocialBack.DAO;

import java.util.List;

import www.com.MYSocialBack.dto.User;

public interface UserDAO {

    List<User> getAllUser();
	 
	 boolean saveUser(User user);
	
}
