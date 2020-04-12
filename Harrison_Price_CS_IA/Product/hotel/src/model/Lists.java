package model;

import java.util.LinkedList;
import model.*;

import controller.Deserialize;
import controller.Serialize;

public class Lists {
	
	private static LinkedList<Customer> lc = new LinkedList<Customer>();
	private static LinkedList<Admin> la = new LinkedList<Admin>();
	private static LinkedList<Room> lr = new LinkedList<Room>();
	private static LinkedList<Booking> lb = new LinkedList<Booking>();
	
	private static int cListSize;
	private static int aListSize;
	private static int rListSize;
	private static int bListSize;
	
	public Lists(){
		
	}
	
	// ----------------------------------------------------------
	// Customer linked list
	public void deserializeCustomers(){
		//new User();
		Deserialize ds = new Deserialize();
		lc = ds.DeserializeList("customers.ser");
		System.out.println(lc.toString());
		
		setCListSize();
	}
	
	public void addCustomer(Customer c){
		// Add the customer to the list
		lc.add(c);
		
		// Show the list
		System.out.print(lc.toString() + "\n");
		
		new Serialize(lc, "customers.ser");
	}
	
	public static LinkedList<Customer> getCustomerList(){
		return lc;
	}
	
	private static void setCListSize(){
		cListSize = lc.size();
		System.out.println(cListSize);
	}
	
	public static int getCListSize(){
		System.out.println("The list has " + cListSize + " users");
		return cListSize;
	}
	
	// ----------------------------------------------------------
	// Admin linked list
	public void deserializeAdmin(){
		Deserialize ds = new Deserialize();
		la = ds.DeserializeList("admin.ser");
		System.out.println(la.toString());
		
		setAListSize();
	}
	
	public void addAdmin(Admin a){
		// Add the customer to the list
				la.add(a);
				
				// Show the list
				System.out.print(la.toString() + "\n");
				
				new Serialize(la, "admin.ser");
	}
	
	public static LinkedList<Admin> getAdminList(){
		return la;
	}
	
	private static void setAListSize(){
		aListSize = la.size();
		System.out.println(aListSize);
	}
	
	public static int getAListSize(){
		System.out.println("The list has " + aListSize + " admin users");
		return aListSize;
	}
	
	// ----------------------------------------------------------
	// Room linked list
	public void deserializeRoom(){
		Deserialize ds = new Deserialize();
		lr = ds.DeserializeList("room.ser");
		System.out.println(lr.toString());
		
		setRListSize();
	}
	
	public void addRoom(Room r){
		// Add the customer to the list
		lr.add(r);
		
		// Show the list
		System.out.print(lr.toString() + "\n");
		
		new Serialize(lr, "room.ser");
	}
	
	public static LinkedList<Room> getRoomList(){
		return lr;
	}
	
	private static void setRListSize(){
		rListSize = lr.size();
		System.out.println(rListSize);
	}
	
	public static int getRListSize(){
		System.out.println("The list has " + rListSize + " rooms");
		return rListSize;
	}
	
	// ----------------------------------------------------------
	// Booking linked list
	public void deserializeBooking(){
		new User();
		Deserialize ds = new Deserialize();
		lb = ds.DeserializeList("booking.ser");
		System.out.println(lb.toString());
		
		setBListSize();
	}
	
	public void addBooking(Booking b){
		// Add the customer to the list
		lb.add(b);
		
		// Show the list
		System.out.print(lb.toString() + "\n");
		
		new Serialize(lb, "booking.ser");
	}
	
	public static LinkedList<Booking> getBookingList(){
		return lb;
	}
	
	private static void setBListSize(){
		bListSize = lb.size();
		System.out.println(bListSize);
	}
	
	public static int getBListSize(){
		System.out.println("The list has " + bListSize + " users");
		return bListSize;
	}
	
	
	
	
}
