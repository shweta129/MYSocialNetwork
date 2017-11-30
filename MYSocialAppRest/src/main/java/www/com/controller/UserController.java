package www.com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import www.com.DAO.UserDAO;
import www.com.dto.UserDetail;

@RestController
public class UserController {

	@Autowired
	UserDetail user;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("user/createUser")
	public ResponseEntity<UserDetail> createUser(@RequestBody UserDetail user)
	{
		if(userDAO.getByEmail(user.getEmail())==null)
		{
			userDAO.addUser(user);
			user.setErrorCode("200");
			user.setErrorMsg("User Added successfully"); 
			
		}
		else{
			user.setErrorCode("301");
			user.setErrorMsg("Id already exist");
		}
		
		return new ResponseEntity<UserDetail>(user, HttpStatus.CREATED);
	}
	
	
	@RequestMapping("/user/get/{email}")
	public ResponseEntity<UserDetail> getIndividualUser(@PathVariable("email")String email)
	{
	  UserDetail user = userDAO.getByEmail(email);
	  if(user!=null)
	{
		userDAO.getByEmail(email);
		user.setErrorCode("200");
		user.setErrorMsg("User retrived successfully");
	}
	else
	{
		
		user.setErrorCode("301");
		user.setErrorMsg("User email not found");
	}
	  return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
}
	
	
	@RequestMapping("/user/deleteUser/{email}")
	public ResponseEntity<UserDetail> deleteUser(@PathVariable("email")String email)
	{
		email = email+".com";
		UserDetail user = userDAO.getByEmail(email);
		if(user!=null)
		{
			userDAO.delete(email);
			user.setErrorCode("200");
			user.setErrorMsg("User Deleted successfully");
		}
		else{
			user.setErrorCode("404");
			user.setErrorMsg("user not found");
		}
		return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
	}
	
	
	
	@RequestMapping("/user/login")
	public ResponseEntity<UserDetail> loginStatus(@RequestBody UserDetail user,HttpSession session)
	{
		user=userDAO.getByEmail(user.getEmail());
		if(user==null)
		{
			user = new UserDetail();
			user.setErrorCode("200");
			user.setErrorMsg("Successfully login");
			
		}
		else{
			user.setErrorCode("404");
			user.setErrorMsg("No login found for this user");
		}
		return new ResponseEntity<UserDetail>(user,HttpStatus.OK);
	}
}

