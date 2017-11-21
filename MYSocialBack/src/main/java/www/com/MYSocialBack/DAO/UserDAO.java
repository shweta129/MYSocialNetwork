package www.com.MYSocialBack.DAO;

import www.com.MYSocialBack.dto.UserDetail;

public interface UserDAO {

	
	public boolean addUserDetails(UserDetail user);
	public boolean updateOnlineStatus(String status,UserDetail user);
	public UserDetail getUser(String username);
	
	/*boolean saveUser(User user);
	User getByEmail(String email);
	User validateEmail(String email);
    User validatecontactNumber(String contactNumber);
    List<User> getAllUser();
    User login(User user);
    void update(User user);
	*/
}
