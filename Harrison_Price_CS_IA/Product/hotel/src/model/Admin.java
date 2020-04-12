package model;

import java.util.Arrays;
import java.util.Date;

import model.User;

public class Admin extends User implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String role;
	private String department;
	

	

	@Override
	public String toString() {
		return "Admin [role=" + role + ", department=" + department + ", FName=" + FName + ", LName=" + LName + ", dob="
				+ dob + ", address=" + Arrays.toString(address) + ", phone=" + Arrays.toString(phone) + ", username="
				+ username + ", password=" + password + ", Email=" + Email + "]";
	}

	public Admin(String fName, String lName, Date dob, String[] address, String[] phone,
			String username, String password, String email, String role, String department){
		
		super(fName, lName, dob, address, phone, username, password, email);
		
		this.role = role;
		this.department = department;
	}

	public Admin() {
		super();
	}


	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
