package model;

import java.util.Arrays;
import java.util.Date;

public class Customer extends User implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Customer(){
		super();
	}
	
	public Customer(String fName, String lName, Date dob, String[] address, String[] phone,
			String username, String password, String email) {
		
		super(fName, lName, dob, address, phone, username, password, email);
	}

	@Override
	public String toString() {
		return "Customer [FName=" + FName + ", LName=" + LName + ", dob=" + dob + ", address="
				+ Arrays.toString(address) + ", phone=" + Arrays.toString(phone) + ", username=" + username
				+ ", password=" + password + ", Email=" + Email + "]";
	}

	
	

}