package www.com.MYSocialBack.DAOImpl;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.UserDetail;

@Repository("userDAO")
@Transactional    //all methods are run under transaction
public  class UserDAOImpl implements UserDAO {

   
	
	
  public static final Logger log = Logger.getLogger(UserDAOImpl.class.getName());
  
  @Autowired
	private SessionFactory SessionFactory;

@Override
public boolean addUserDetails(UserDetail user) {
try{
		
		SessionFactory.getCurrentSession().save(user);
		return true;
	}
	catch(Exception e)
	{
		log.info("Exception Arised:::"+e);
		return false;
	}
}

@Override
public boolean updateOnlineStatus(String status, UserDetail user) {
	try{
		user.setIsOnline(status);
		SessionFactory.getCurrentSession().update(user);
		return true;
	}
	catch(Exception e)
	{
		log.info("Exception Arised:::"+e);
		return false;
	}
}

//@Override
public UserDetail getUser(String username) {
	Session session= SessionFactory.openSession();
	UserDetail user=(UserDetail)session.get(UserDetail.class,username);
	session.close();
	return user;
}

/*//@Override
public boolean addUser(UserDetail user) {
	try{
		
		SessionFactory.getCurrentSession().save(user);
		return true;
	}
	catch(Exception e)
	{
		log.info("Exception Arised:::"+e);
		return false;
	}
	
}


//@Override
public boolean updateOnlineStatus(String status, UserDetail user) {
	try{
		user.setIsOnline(status);
		SessionFactory.getCurrentSession().update(user);
		return true;
	}
	catch(Exception e)
	{
		log.info("Exception Arised:::"+e);
		return false;
	}
}*/

 /* @Override
  public boolean saveUser(User user) {
		log.info("****Starting save method in UserDaoImpl***");
		try {
			SessionFactory.getCurrentSession().save(user);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

   @Override
   public User getByEmail(String email) {
	 String selectQuery = "FROM User WHERE email = :email";		
	  try {
		
		return SessionFactory.getCurrentSession()
					.createQuery(selectQuery,User.class)
						.setParameter("email", email)
							.getSingleResult();
		
	}
	catch(Exception ex) {
		//ex.printStackTrace();
		return null;
	}
	
	
}

@Override
@SuppressWarnings("deprecation")
public User validateEmail(String email) {
	Session session=SessionFactory.getCurrentSession();
	 @SuppressWarnings("rawtypes")
	 Query query=session.createQuery("from User where email=?");
	 query.setString(0, email);
	 User user=(User) query.uniqueResult(); 
	return user;
}

@Override
@SuppressWarnings("deprecation")
public User validatecontactNumber(String contactNumber) {
	Session session=SessionFactory.getCurrentSession();
	 @SuppressWarnings("rawtypes")
	 Query query=session.createQuery("from User where contactNumber=?");
	 query.setString(0, contactNumber);
	 User user=(User) query.uniqueResult(); 
	return user;
}

@Override
public List<User> getAllUser() {
	log.info("getAllUser---");
	String hql = "from User";
	Query query =SessionFactory.getCurrentSession().createQuery(hql);		
	return query.list();
}

@Override
public User login(User user) {
	Session session=SessionFactory.getCurrentSession();
	Query query=session.createQuery("from User where email=? and password=?");
	query.setString(0, user.getEmail());
	query.setString(1, user.getPassword());
	return (User)query.uniqueResult();
}

@Override
public void update(User user) {
	Session session=SessionFactory.getCurrentSession();
	session.update(user);//update the values [online status]
}
	*/
   
}
