package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFrame;

import controller.CurrentUser;
import view.LoggedInView;
import view.Main;
import model.Admin;
import model.Booking;
import model.Customer;
import model.Lists;



public class LogInControl {
	
	// Variables for log-in
	private String username;
	private String password;
	
	// Linked lists for users
	private LinkedList<Customer> lc = Lists.getCustomerList();
	private LinkedList<Admin> la = Lists.getAdminList();

	// Size of lists to be used for searching user lists
	private int customerSize = Lists.getCListSize();
	private int adminSize = Lists.getAListSize();
	
	// Initialize the main class
	private Main main;
	
	private Initialise i = new Initialise();

	private Customer test = new Customer();
	private Admin testAdmin = new Admin();
	
	
	// Variable to set if the user is an admin account or a customer
	private boolean isAdmin;
	
	
	
	public LogInControl(String username, char[] password, Main main) {
		super();		
		
		this.username = username;
		this.password = new String(password);
		this.main = main;
		
		checkUsername();
	}
	
	private void checkUsername(){
			// By default, the customer is not found
			boolean customerExists = false;
			
			
			// Search through the customer list (linear search)
			for(int i = 0; i < customerSize; i = i+1){
				// Test customer used to check through the list
				test = (Customer) lc.get(i);
				String testUser = test.getUsername();
				
				// A customer with the username the same as the test is found
				if(username.equals(testUser)){
					// setCustomer(test);
					checkPassword(test);
					customerExists = true;
					
					// The user found is a customer, not an employee
					isAdmin = false;
					break;
				}
			
			}
			
			boolean adminExists = false;
			
			// The customer does not exist, therefore check through the admin list
			if(!customerExists){
				
				// Search the admin list (linear search)
				for(int i = 0; adminSize > i; i = i+1){
					testAdmin = (Admin)la.get(i);
					String adUser = testAdmin.getUsername();
				
					// If an admin account is found, break from the loop
					if(username.equals(adUser)){
						adminExists = true;
						isAdmin = true;
						// setAdmin(testAdmin);
						checkPassword(testAdmin);
						break;
					}
					
				}
			}
			
			// If the username is not in any list, show an error message
			if(!customerExists && !adminExists){
				main.invalidLogIn();
			}
	}
	

	private void checkPassword(Customer customer){
		
		// Set the test password
		String userPassword = customer.getPassword();
		
		// Set the variables if the password entered matches
		if(password.equals(userPassword)){
			CurrentUser c = new CurrentUser(customer);
			
			LinkedList<Booking> lb = Lists.getBookingList();
			
			// Initialise log-in pane
			LoggedInView l = new LoggedInView(0);
			l.setVisible(true);
			
			i.initialiseRooms();
			
			// Dispose log-in window
			main.setVisible(false);
			main.dispose();
		} else{
			main.invalidLogIn();
		}
	}
	
	private void checkPassword(Admin admin){
		String userPassword = admin.getPassword();
		
		if(password.equals(userPassword)){
			CurrentUser c = new CurrentUser(admin);
			LinkedList<Booking> lb = Lists.getBookingList();
			
			i.initialiseRooms();
			
			// Find bookings where the check-in date is today
			java.util.Date today = Calendar.getInstance().getTime();
			int bookings = 0;
			for(int i = 0; i < lb.size(); i = i + 1){
				Booking b = lb.get(i);
				Date checkIn = b.getCheckIn();
				if(checkIn.equals(today)){
					bookings = bookings + 1;
				}
			}
			
			// Initialise log-in pane
			LoggedInView l = new LoggedInView(bookings);
			l.setVisible(true);
			
			// Dispose log-in window
			main.setVisible(false);
			main.dispose();
		} else{
			main.invalidLogIn();
		}
	}
}
