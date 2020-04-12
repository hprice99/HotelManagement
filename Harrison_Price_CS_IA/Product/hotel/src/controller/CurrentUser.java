package controller;

import model.Customer;

import java.util.Date;

import model.Admin;

public class CurrentUser {

	private static Customer c = new Customer();
	private static Admin a = new Admin();
	

	private static String FName;
	private static String LName;
	
	private static Date dob;
	
	private static String[] address;
	private static String[] phone;
	private static String username;
	private static String password;
	private static String email;
	
	private static String role;
	private static String department;
	
	private static boolean isCustomer;
	
	public CurrentUser(Customer test) {
		CurrentUser.c = test;
		
		FName = c.getFName();
		LName = c.getLName();
		dob = c.getDOB();
		address = c.getAddress();
		phone = c.getPhone();
		username = c.getUsername();
		password = c.getPassword();
		email = c.getEmail();
		
		
		isCustomer = true;
	}

	public CurrentUser(Admin test){
		CurrentUser.a = test;
		
		FName = a.getFName();
		LName = a.getLName();
		dob = a.getDOB();
		address = a.getAddress();
		phone = a.getPhone();
		username = a.getUsername();
		password = a.getPassword();
		email = a.getEmail();
		
		role = a.getRole();
		department = a.getDepartment();
		
		isCustomer = false;
	}

	public static boolean isCustomer() {
		return isCustomer;
	}

	public static void setCustomer(boolean isCustomer) {
		CurrentUser.isCustomer = isCustomer;
	}

	public static Customer getC() {
		return c;
	}


	public static Admin getA() {
		return a;
	}

	public static String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public static String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public static Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		CurrentUser.dob = dob;
	}

	public static String[] getAddress() {
		return address;
	}

	public void setAddress(String[] address) {
		CurrentUser.address = address;
	}

	public static String[] getPhone() {
		return phone;
	}

	public void setPhone(String[] phone) {
		CurrentUser.phone = phone;
	}

	public static String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		CurrentUser.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		CurrentUser.password = password;
	}

	public static String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		CurrentUser.email = email;
	}

	public static String getRole() {
		return role;
	}

	public void setRole(String role) {
		CurrentUser.role = role;
	}

	public static String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		CurrentUser.department = department;
	}
	
	
}
