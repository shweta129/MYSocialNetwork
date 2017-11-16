package www.com.MYSocialBack.dto;

import java.io.Serializable;

import javax.jws.soap.SOAPBinding.Style;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
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
	@NotBlank(message = "Please Enter your First Name")
	@Column(name = "first_name")
	private String firstName;
	@NotBlank(message = "Please Enter your Last Name")
	@Column(name = "last_name")
	private String lastName;
	@Email(message = "Please Enter your Email Id")
	private String email;
	@NotBlank(message="Please Enter Contact Number!")
	@Length(max=10,min=10,message="Phone number is not valid. Should be of length 10.")
	@Column(name= "contact_number")
	private String contactNumber;
	
	@Size(min=6, max=15,message="Your Password must between 6 and 15 characters")
	@NotBlank(message="Please Enter Password!")
	private String password;
	
	@NotBlank(message="Please Enter Address!")
	private String Address;

    
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


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}

	
	
	
}