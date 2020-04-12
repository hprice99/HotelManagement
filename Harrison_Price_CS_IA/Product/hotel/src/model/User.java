package model;

import java.io.Serializable;
import java.util.Date;

public class User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;

	protected String FName;
	protected String LName;
	
	protected Date dob;
	
	protected String[] address;
	protected String[] phone;
	protected String username;
	protected String password;
	protected String Email;
	
	public User(){
		
	}
	
	public User(String fName, String lName, Date dob, String[] address, String[] phone,
			String username, String password, String email) {
		super();
		FName = fName;
		LName = lName;
		this.dob = dob;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		Email = email;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}
	
	public Date getDOB() {
		return dob;
	}
	
	public void setDOB(Date dob) {
		this.dob = dob;
	}

	public String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		this.address = address;
	}

	public String[] getPhone() {
		return phone;
	}

	public void setPhone(String[] phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	
	
	
}
