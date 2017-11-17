package www.com.MYSocialBack.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Blog")
@Component
public class Blog implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//add fields 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int BlogID;
	
	@NotBlank(message = "enter name")
	private String BlogName;
	
	private String BlogContent;
	
	private int userID;
	
	private Date CreateDate;
	private String  Status;
	
	private int Likes;
	
	//setter getter method

	public int getBlogID() {
		return BlogID;
	}

	public void setBlogID(int blogID) {
		BlogID = blogID;
	}

	public String getBlogName() {
		return BlogName;
	}

	public void setBlogName(String blogName) {
		BlogName = blogName;
	}

	public String getBlogContent() {
		return BlogContent;
	}

	public void setBlogContent(String blogContent) {
		BlogContent = blogContent;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getLikes() {
		return Likes;
	}

	public void setLikes(int likes) {
		Likes = likes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
   
	
	
}
