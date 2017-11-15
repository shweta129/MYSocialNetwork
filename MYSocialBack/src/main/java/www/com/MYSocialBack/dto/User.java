package www.com.MYSocialBack.dto;

import java.io.Serializable;

import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_detail")
@Component
public class User implements Serializable {


	private static final long serialVersionUID = 1L;

	/**
	 * Private fields
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message="Please Enter First Name!")
	private String first_name;
	
	@NotBlank(message="Please Enter Last Name!")
	private String last_name;
	
	
	
	private boolean enabled=true;
	
	@Size(min=6, max=15,message="Your Password must between 6 and 15 characters")
	@NotBlank(message="Please Enter Password!")
	private String password;
	
	@Email
	@NotBlank(message="Please Enter your  Email Address!")
	private String email;
	
	@NotBlank(message="Please Enter Contact Number!")
	@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
	private String Number;
	
	@NotBlank(message="Please Enter Address!")
	private String address;
	
	@NotBlank(message="Please Enter Date of Birth!")
	private String dob;

	
	/*
	 * getter setter method
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	
	
	
}
