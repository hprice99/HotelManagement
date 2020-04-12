package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.regex.*;

import javax.swing.JOptionPane;

import view.*;
import model.Lists;
import model.Room;
import model.Booking;
import model.Customer;

public class Validate {
	
	// Protected variables so that the subclasses can access the variables
	protected String fName;
	protected String lName;
	protected Date dob;
	protected Date rawDOB;
	protected String[] address;
	protected String[] phone;
	protected String username;
	protected String password;
	protected String confirmPassword;
	protected String email;
	
	// Boolean for whether the terms have been accepted
	private boolean terms;
	
	// Used to call methods in the main class that are used for error messages
	private Main m;
	
	// Instanciate the list object
	// Protected to allow for inheritance
	protected Lists l = new Lists();
	
	// Booking variables
	private Customer c = new Customer();
	private String type;
	private Date checkIn;
	private Date checkOut;
	private Booking b;
	
	// Constructor for validating booking
	public Validate(Customer c, Date checkIn, Date checkOut, String type){
		this.c = c;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.type = type;
	}
	
	// Constructor for estimated cost
	public Validate(Date checkIn, Date checkOut){
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	// Constructor that accepts the inputed data from Register.java
	public Validate(String fName, String lName, Date dob, String[] address, String[] phone, String username, char[] password,
			 char[] confirmPassword, String email, boolean terms, Main m) {
		super();
		
		// Set variables as those sent through
		this.fName = fName;
		this.lName = lName;
		rawDOB = dob;
		this.address = address;
		this.phone = phone;
		this.username = username;
		
		// Convert the passwords to strings before putting in list
		this.password = new String(password);
		this.confirmPassword = new String(confirmPassword);
		this.email = email;
		this.terms = terms;
		
		// Set main object
		this.m = m;
		
		// Call validation of terms
		validateTerms();
	}
	

	// Only for the subclass to inherit
	public Validate(String fName, String lName, String[] address,
			String[] phone, String username,
			String email) {
		
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.email = email;
	}

	// Only continue validation if the terms and conditions have been accepted
	void validateTerms(){
		if(terms){
			validateFName();
		}
		
		else{
			// Prompt the user to accept the terms 
			m.acceptTerms();
		}
	}
	
	 void validateFName(){
		// Use regex to check that name only has alphabetical characters
		if(Pattern.matches("[a-zA-Z]+", fName)){
			validateLName();
		}
		
		else {
			// Show an error message
			m.invalidDetails("First name");
		}
	}
	
	 void validateLName(){
		if(Pattern.matches("[a-zA-Z]+", lName)){
			// Use regex to check that name only has alphabetical characters
			
			validateDOB();
		}
		else {
			// Show an error message
			m.invalidDetails("Surname");
		}
	}
	 
	 void validateDOB() {
		 Calendar validDOB = Calendar.getInstance();
		 
		 // 18 years before today
		 validDOB.add(Calendar.YEAR, -18);
		 
		 // Set a calendar with the date of birth selected by the user so that it can be validated
		 Calendar DOB = Calendar.getInstance();
		 DOB.setTime(rawDOB);
		 
		 if(DOB.before(validDOB)){
			validateAddress();
		 }
		 else{
			 m.invalidDetails("Birth date");
		 }
	 }
	 
	 void validateAddress(){
		// Make sure the required address fields are completed
		
		if(address[0] != null && address[1] != null && address[3]!= null && Pattern.matches("[0-9]+", address[4]) && address[4].length() == 4){
			// Make sure all address fields have values
			formatPhone();
		}
		else {
			// Show an error message
			m.invalidDetails("Address");
		} 
	}
	
	 void formatPhone(){
		
		// Delete any non-alphanumeric character ("(", ")", "-", etc) 
		phone[1] = phone[1].replaceAll("[^0-9]", "");
		
		validatePhone();
	}

	 void validatePhone(){
		
		// Make sure the phone is 10 digits (including area code)
		
		if(phone[1].length() == 10){
			validateUsername();
		}
		
		else {
			// Show an error message
			m.invalidDetails("Phone");
		}
	}
	
	 void validateUsername(){
		
		 // Set linked list
		 LinkedList<Customer> lc = Lists.getCustomerList();
		
		 // Set size to be used for search
		 int size = lc.size();
		
		 // Only check username if it has been entered
		 if(username != null){
			 // Boolean variable used to check if username is not available
			 boolean taken = false;
			
			 Customer test = new Customer();
			
			 // Search through customer list to check for username clashes
			 for(int i = 1; size > i; i++){
				 test = (Customer) lc.get(i);
				 String testUser = test.getUsername();
				
				
				 // If the username has been taken, break out of the loop
				 if(username.equals(testUser)){
					 taken = true;
					
					 // Alert the user that their username is not available
					 m.usernameTaken(username);
					 break;
				}
			} 
			
			// If statement is used so that validateEmail only occurs once when outside for loop
			if(!taken){
				validateEmail();
			}
			
		} else {
			// Tell user to create a username
			m.invalidDetails("Username");
		}
	

		
		
	}
	
	 void validateEmail(){
		// Use regex to validate the email address
		if(Pattern.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", email)){
			validatePassword();
		}
		
		
		else {
			// Send an error message
			m.invalidDetails("Email");
		}
	}

	 void validatePassword(){
		
		// Password must be 8 characters or more
		if(password.length() > 7){
			
			// Check if the passwords are the same
			if(confirmPassword.equals(password)){
				
				// Make a new customer object
				Customer c = new Customer();
				c.setFName(fName);
				c.setLName(lName);
				
				// TODO Format date of birth to be dd/MM/yyyy
				SimpleDateFormat dobFormat = new SimpleDateFormat("dd/MM/yyyy");
				
				// Format the dates
				String x = dobFormat.format(rawDOB);
				try {
					dob = dobFormat.parse(x);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				c.setDOB(dob);
				c.setAddress(address);
				c.setPhone(phone);
				c.setUsername(username);
				c.setEmail(email);
				c.setPassword(password);
				
				
				// Add the customer to the list
				l.addCustomer(c);
				
				// Print the new customer
				System.out.println(c);
				
				// Show a dialog box to confirm registration
				JOptionPane.showMessageDialog(null, "Successfully registered.");
				
				// Deserialize list after registration
				l.deserializeCustomers();
			} else{
				// Show an error message
				m.invalidDetails("Password");
			}
		}
		
		
		else {
			// Show an error message
			m.invalidDetails("Password");
		}
		
	}
	 
	public double estimateCost(String type){
		double cost = 0;
		this.type = type;
		
		try{
			long diff = checkOut.getTime() - checkIn.getTime();
			
			long days = diff / (24*60*60*1000);
			
			System.out.println(days);
			
			if(type.equals("Basic")){
				cost = days * 115;
			} else if(type.equals("Deluxe")){
				cost = days * 260;
			}
			
			// Only display costs that are valid
			if(cost > 0){
				return cost;
			} else{
				return 0;
			}
		} catch(NullPointerException e){
			return 0;
		}
		
	}
	
	public boolean validateBookingDate(){
		 if(checkIn.before(checkOut)){
			 java.util.Date today = Calendar.getInstance().getTime();
			 if(today.before(checkOut) && !today.after(checkIn)){
				// No error
				return false;
			 }
			 // An error has occurred with the dates
			 return true;
		 }
		 else{
			 return true;
		 }
	 }
	 
	public void checkRoomAvailability(){
		 // Initialise the linked lists
		 LinkedList<Room> rl = Lists.getRoomList();
		 LinkedList<Booking> bl = Lists.getBookingList();
		 
		 LinkedList<Room> t = new LinkedList<Room>();
		 // Create new linked list of only the rooms wanted
		 for(int i = 0; i < rl.size(); i = i + 1){
			 Room r = (Room)rl.get(i);
			 String roomType = r.getType();
			 
			 if(roomType.equals(type)){
				 t.add(r);
			 }
		}
		 
		// Boolean used to tell if there is a single room available
		boolean available = false;
	
		// Find a room that is not booked at any time in the future
		for(int j = 0; j < t.size(); j = j + 1){
			Room room = t.get(j);
			boolean booked = room.isBooked();
			
			if(!booked){		
				// A room is available
				available = true;
				
				// Calculate the number of nights the customer is staying for
				int nights = (int)(checkOut.getTime() - checkIn.getTime()) / (1000*60*60*24);
				double price = room.getPrice() * nights;
				b = new Booking(c, room, checkIn, checkOut, price);
				b.setNights(nights);
				
				
				// The room is booked
				room.setBooked(true);
				rl.set(j, room);
				
				l.addBooking(b);
				
				Serialize s = new Serialize(rl, "room.ser");
				
				System.out.println(room.toString());
				
				// Confirmation frame variables
				String fName = c.getFName();
				String lName = c.getLName();
				
				// Initialise confirmation frame
				BookingConfirmation bc = new BookingConfirmation(checkIn, checkOut, type, price, fName, lName);
				bc.setVisible(true);
				
				break;
				}
			}
		if(!available){
			// Boolean used to tell if a room has been booked
			boolean booked = false;
			LinkedList<Booking> checkBookings = new LinkedList<Booking>();
			
			// Find a room that is available for the time period specified
			for(int k = 0; k < bl.size(); k = k + 1){
				Booking x = bl.get(k);
				
				// Add any bookings with the same room type to the checkBookings linked list
				if(x.getRoom().getType().equals(type)){
					checkBookings.add(x);
				}
				
			}
			
			// Search through the list to find a room available in the time given
			for(int y = 0; y < checkBookings.size(); y = y + 1){
				Date ci = checkBookings.get(y).getCheckIn();
				Date co = checkBookings.get(y).getCheckOut();
				Room roomCheck = checkBookings.get(y).getRoom();
				
				int index = 0;
				
				// Find the index of roomCheck in the room linked list
				for(int z = 0; z < rl.size(); z = z + 1){
					Room indexRoom = rl.get(z);
					
					if(roomCheck.equals(indexRoom)){
						index = z;
					}
				}
				
				// Not overlapping time period condition
				if(!(checkIn.before(co) && checkOut.after(ci))){
					int nights = (int)(checkOut.getTime() - checkIn.getTime()) / (1000*60*60*24);
					double price = roomCheck.getPrice() * nights;
					b = new Booking(c, roomCheck, checkIn, checkOut, price);
					b.setNights(nights);
					
					
					// The room is booked
					roomCheck.setBooked(true);
					rl.set(index, roomCheck);
					
					l.addBooking(b);
					
					Serialize s = new Serialize(rl, "room.ser");
					
					System.out.println(roomCheck.toString());
					
					// Confirmation frame variables
					String fName = c.getFName();
					String lName = c.getLName();
					
					// Initialise confirmation frame
					BookingConfirmation bc = new BookingConfirmation(checkIn, checkOut, type, price, fName, lName);
					bc.setVisible(true);
					
					break;
				}
			}
			
			if(!booked){
				JOptionPane.showMessageDialog(null, "Sorry, there are no " + type + " rooms available.", "Rooms unavailable", JOptionPane.ERROR_MESSAGE);
			}	
		}
	}
}