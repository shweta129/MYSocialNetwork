package www.com.MYSocialBack.DAOImpl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.User;


@Repository("userDAO")
@Transactional    //all methods are run under transaction
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory SessionFactory;
	
	
  public static final Logger log = Logger.getLogger(UserDAOImpl.class.getName());

  @Override
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
	
   
}
