package www.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import www.com.DAO.BlogDAO;
import www.com.DAO.ForumDAO;
import www.com.dto.Forum;



@RestController
public class FormController {

@Autowired
ForumDAO forumDAO;

@Autowired
Forum forum;


@RequestMapping(value="/insertForum")
public ResponseEntity<String> insertBlog(@RequestBody Forum forum)
{
	if(forumDAO.addForum(forum))
	{
		return new ResponseEntity<String>("Forum Added",HttpStatus.OK);
	}
	else
	{
		return new ResponseEntity<String>("Error in response enity",HttpStatus.SERVICE_UNAVAILABLE);
	}
	
	
}
}
