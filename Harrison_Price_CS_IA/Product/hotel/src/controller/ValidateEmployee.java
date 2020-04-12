package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import model.Admin;
import model.Customer;
import model.Lists;
import view.LoggedInView;

public class ValidateEmployee extends Validate{
	
	private LoggedInView liv = new LoggedInView(0);
	private String department;
	private String role;

	public ValidateEmployee(String fName, String lName, Date dob, String[] address, String[] phone, String username,
			char[] password, char[] confirmPassword, String email, String department, String role) {
		super(fName, lName, dob, address, phone, username, password, confirmPassword, email, true, null);
		this.role = role;
		this.department = department;
	}
	
	@Override
	void validateUsername(){
		
		// Set linked list
		LinkedList<Admin> la = Lists.getAdminList();
		
		// Set size to be used for search
		int size = la.size();
		
		// Only check username if it has been entered
		if(username != null){
			// Boolean variable used to check if username is not available
			boolean taken = false;
			
			Admin test = new Admin();
			
			// Search through customer list to check for username clashes
			for(int i = 1; size > i; i++){
				test = (Admin) la.get(i);
				String testUser = test.getUsername();
				
				
				// If the username has been taken, alert the user and break out of the loop
				if(username.equals(testUser)){
					taken = true;
					liv.usernameTaken(username);
					break;
				}
			}
			
			// If statement is used so that validateEmail only occurs once when outside for loop
			if(!taken){
				validateEmail();
			}
			
		} else {
			// Tell user to create a username
			liv.invalidDetails("Username");
			System.out.println("Need a username");
		}
	}
	
	@Override
	void validatePassword(){
		// Password must be 8 characters or more
				if(password.length() > 7){
					
					// Check if the passwords are the same
					if(confirmPassword.equals(password)){
						
						// Make a new customer object
						Admin a = new Admin();
						a.setFName(fName);
						a.setLName(lName);
						
						// TODO Format date of birth to be dd/MM/yyyy
						SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
						
						String x = dobFormat.format(rawDOB);
						try {
							dob = dobFormat.parse(x);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						a.setDOB(dob);
						a.setAddress(address);
						a.setPhone(phone);
						a.setUsername(username);
						a.setEmail(email);
						a.setPassword(password);
						a.setDepartment(department);
						a.setRole(role);
						
						// Add the admin to the list
						l.addAdmin(a);
						
						// Print the new admin
						System.out.println(a);
						
						// Show a dialog box to confirm registration
						liv.registered();
						
						// Deserialize list after registration
						l.deserializeAdmin();
					} else{
						// Show an error message
						liv.invalidDetails("Password");
					}
				}
		}
}
