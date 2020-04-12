package controller;

import java.util.Date;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Admin;
import model.Booking;
import model.Customer;
import model.Lists;
import view.ChangeDetails;
import view.CustomerBookingTab;
import view.LoggedInView;

public class CustomerSearch {

	private String username;
	private LoggedInView liv;
	private LinkedList<Customer> lc = Lists.getCustomerList();
	private LinkedList<Booking> lb = Lists.getBookingList();
	private int customerIndex;
	
	
	// Constructor for getting the username of the desired user
	public CustomerSearch(LoggedInView loggedInView, String username){
		this.username = username;
		liv = loggedInView;
	}
	
	public CustomerSearch(LoggedInView liv) {
		this.liv = liv;
	}

	public void search(String type){
		// Variable used to tell if the account searched for exists
		boolean found = false;
		
		// Linear search through customer list
		for(int i = 0; i < lc.size(); i = i + 1){
			Customer user = lc.get(i);
			String un = user.getUsername();
			
				// If a customer is found, create the JPanel to change their details
				if(username.equals(un)){
					// The user has been found in the list
					found = true; 
					if(type.equals("edit")){
						String fName = user.getFName();
						String lName = user.getLName();
						Date dob = user.getDOB();
						String[] address = user.getAddress();
						String[] phone = user.getPhone();
						String email = user.getEmail();
						
						this.customerIndex = lc.indexOf(user);
						System.out.println(user.toString());
						
						ChangeDetails c = new ChangeDetails(fName, lName, dob, address, phone, username, email, liv);
						c.setSearch(this);
						liv.editCustomer(c);
						break;
					} else if(type.equals("book")){
						CustomerBookingTab bt = new CustomerBookingTab(user);
						liv.book(bt);
					}
				}
		} 
		if(!found){
			// Show an error dialog if the customer does not exist in the linked list
			JOptionPane.showMessageDialog(null, "The user " + username + " has not been found", "Customer not found", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void deleteAccount(String user, char[] pword){
		String password = new String(pword);
		
		System.out.println("The index is " + customerIndex);
		
		// Variables for authenticating the admin account
		Admin a = CurrentUser.getA();
		String un = a.getUsername(); 
		String pw = a.getPassword();
		
		
		Customer c = lc.get(customerIndex);
		
		if(user.equals(un) && password.equals(pw)){
			Deserialize ds = new Deserialize();
			// Delete all bookings associated with the user
			for(int j = 0; j < lb.size(); j = j + 1){
				Booking b = lb.get(j);
				
				if(b.getCustomer().equals(c)){
					b.getRoom().setBooked(false);
					lb.remove(j);
					new Serialize(lb, "booking.ser");
					ds.DeserializeList("booking.ser");
				}
			}
			
			JOptionPane.showMessageDialog(null, "Deleted user " + c.getFName());
			lc.remove(customerIndex);
			new Serialize(lc, "customers.ser");
			ds.DeserializeList("customers.ser");
			
			}
	}
}
