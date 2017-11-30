package www.com.DAO;

import www.com.dto.UserDetail;

public interface UserDAO {

	
	public boolean addUser(UserDetail user);
	public boolean updateOnlineStatus(String status,UserDetail user);
	public UserDetail getUser(String username);
	public UserDetail getByEmail(String email);
	public boolean delete(String email);
	/*boolean saveUser(User user);
	User getByEmail(String email);
	User validateEmail(String email);
    User validatecontactNumber(String contactNumber);
    List<User> getAllUser();
    User login(User user);
    void update(User user);
	*/
	
}
