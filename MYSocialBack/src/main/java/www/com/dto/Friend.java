package www.com.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Friend")
public class Friend {

	/*
	 * private fields
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int UserID;
	
	private int FId;
	
	private String Status;

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public int getFId() {
		return FId;
	}

	public void setFId(int fId) {
		FId = fId;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
	
	
}
