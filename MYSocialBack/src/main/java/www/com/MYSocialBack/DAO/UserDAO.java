package www.com.MYSocialBack.DAO;

import java.util.List;

import www.com.MYSocialBack.dto.User;

public interface UserDAO {

	boolean saveUser(User user);
	User getByEmail(String email);
	User validateEmail(String email);
    User validatecontactNumber(String contactNumber);
    List<User> getAllUser();
	
}
