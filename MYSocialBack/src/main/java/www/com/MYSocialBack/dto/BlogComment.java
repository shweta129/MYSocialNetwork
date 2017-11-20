package www.com.MYSocialBack.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "BlogComent")
@Component
public class BlogComment implements Serializable{

	private static final long serialVersionUID = 1L;
	/*
	 * private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	
	
}
