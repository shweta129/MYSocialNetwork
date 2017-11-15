package www.com.MYSocialRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import www.com.MYSocialBack.DAO.UserDAO;
import www.com.MYSocialBack.dto.User;

@RestController
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value="/getAllUsers",method=RequestMethod.GET,headers="Accept=application/json")
	public ResponseEntity getAllUser(){
		
		if(userDAO.getAllUser().isEmpty()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No User registerd..");
		}
		return new ResponseEntity(userDAO.getAllUser(),HttpStatus.OK);
				
	}
	

	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user){
		
		boolean isSaved=userDAO.saveUser(user);
		if(isSaved)
		return new ResponseEntity<User>(user,HttpStatus.OK);
		else
			return new ResponseEntity<User>(user,HttpStatus.METHOD_FAILURE);
	
		
	}
	
	}
	
	
	


