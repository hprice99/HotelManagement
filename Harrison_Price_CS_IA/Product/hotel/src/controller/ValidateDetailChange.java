package controller;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import model.Admin;
import model.Customer;
import model.Lists;
import view.LoggedInView;


public class ValidateDetailChange extends Validate{
	private String currentPassword;
	private String newPassword;
	private String confirmNewPassword;
	private Customer c;
	private Admin a;
	
	// The lists to modify
	LinkedList<Customer> lc = Lists.getCustomerList();
	LinkedList<Admin> la = Lists.getAdminList();
	
	
	// Index of the current user
	private int index;
	
	private boolean isCustomer;
	
	// JFrame for the Logged In View to be used to show error messages
	private LoggedInView liv = new LoggedInView(0);
	
	public ValidateDetailChange(String fName, String lName, String[] address, String[] phone, String username, String email, char[] currentPassword, char[] newPassword, char[] confirmNewPassword){
		
		// Set the variables for the Validate class so that the inherited methods can be used
		super(fName, lName, address, phone, username, email);
		
		// Set variables for changing password
		this.currentPassword = new String(currentPassword);
		this.newPassword = new String(newPassword);
		this.confirmNewPassword = new String(confirmNewPassword);
		
		
		// Get the Customer instance of the logged-in user
		isCustomer = CurrentUser.isCustomer();
		
		if(isCustomer){
			c = CurrentUser.getC();
			// Get where the current customer is stored in the linked list
			index = lc.indexOf(c);
		} else{
			a = CurrentUser.getA();
			
			// Get index of current admin account
			index = la.indexOf(a);
		}
		
		System.out.println(index);
		validateFName();
	}
	
	@Override void validateDOB(){
		validateAddress();
	}
	
	@Override void validateUsername(){
		validateCurrentPassword();
	}
	
	private void validateCurrentPassword(){
		String userPassword = c.getPassword();
		if(currentPassword.equals(userPassword)){
			validateNewPassword();
		} else{
			JOptionPane.showMessageDialog(null, "You must enter your current password to update your account.", "Please authenticate account", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void validateNewPassword(){
		if(newPassword.length() > 7){
			if(newPassword.equals(confirmNewPassword)){
				c.setPassword(newPassword);
			} 
			else{
				liv.invalidPassword();
			}
			
		}
		editDetails();
	}
	
	private void editDetails(){
		if(isCustomer){
			c.setFName(fName);
			c.setLName(lName);
			c.setAddress(address);
			c.setPhone(phone);
			c.setEmail(email);
			
			System.out.println("The customer is now " + c.toString());
			
			lc.set(index, c);
			
			System.out.println(lc.get(index).toString());
			
			new Serialize(lc, "customers.ser");
			
			JOptionPane.showMessageDialog(null, "Your details have been changed.");
		} else{
			a.setFName(fName);
			a.setLName(lName);
			a.setAddress(address);
			a.setPhone(phone);
			a.setEmail(email);
			
			System.out.println("The admin is now " + a.toString());
			
			la.set(index, a);
			
			System.out.println(la.get(index).toString());
			
			new Serialize(la, "admin.ser");
			JOptionPane.showMessageDialog(null, "Your details have been changed.");
		}
		
	}
}
