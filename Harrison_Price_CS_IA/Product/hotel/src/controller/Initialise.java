package controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import model.Admin;
import model.Booking;
import model.Customer;
import model.Lists;
import model.Room;
import view.Main;
import model.User;


public class Initialise {
	
	public static void main(String[] args){
		Lists l = new Lists();
		
		// Deserialise admin list
		// Deserialise admin list if it exists
		try{
			FileInputStream adminSer = new FileInputStream("admin.ser");
			l.deserializeAdmin();
		} 
		
		// Create a new file if it does not exist
		catch(FileNotFoundException e){
			System.out.println("Admin file not found");
			String[] address = {"Work", "16 Coronation Drive", "", "Milton", "4000", "QLD"};
			String[] phone = {"Work", "0732456975"};
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			String dateInString = "31-08-1982 00:00:00";
			Date dob = null;
			try {
				dob = sdf.parse(dateInString);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			Admin a = new Admin("Harrison", "Price", dob, address, phone, "hprice", "admin", "hprice@riverside.com", "Manager", "Reception");
			l.addAdmin(a);
			l.deserializeAdmin();
		}
		
		// Deserialise customer list
		// Deserialise customer list if it exists
		try{
				FileInputStream customerSer = new FileInputStream("customers.ser");
				l.deserializeCustomers();
			} 
		
		// Create a new file if it does not exist
		catch(FileNotFoundException e){
				System.out.println("Customer file not found");
				String[] address = {"Home", "18 Charlotte Street", "", "Brisbane", "4000", "QLD"};
				String[] phone = {"Work", "0712345678"};
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateInString = "31-08-1982 00:00:00";
				Date dob = null;
				try {
					dob = sdf.parse(dateInString);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Customer c = new Customer("Aeyohan", "Furtado", dob, address, phone, "afurt3", "password", "afurt3@eq.edu.au");
				l.addCustomer(c);
				l.deserializeCustomers();
			}
		 
		// Initialize the frame
		Main frame = new Main();
		frame.setVisible(true); 
		
	}
	
	public void initialiseRooms(){
		Lists l = new Lists();
		
		// Deserialise rooms list if it exists
		try{
			FileInputStream roomSer = new FileInputStream("room.ser");
			l.deserializeRoom();
		} 
		
		// Create a new file if it does not exist
		catch(FileNotFoundException e){
			System.out.println("Room list not found");
			
			int i;
			
			for(i = 1; i < 20; i++){
				Room r = new Room("Basic", 100 + i, 115.00);
				l.addRoom(r);
			}
			
			for(i = 1; i < 20; i++){
				Room r = new Room("Basic", 200 + i, 115.00);
				l.addRoom(r);
			}
			
			for(i = 1; i < 20; i++){
				Room r = new Room("Basic", 300 + i, 115.00);
				l.addRoom(r);
			}
			
			for(i = 1; i < 5; i++){
				Room r = new Room("Deluxe", 400 + i, 260.00);
				l.addRoom(r);
			}
			
			for(i = 1; i < 5; i++){
				Room r = new Room("Deluxe", 500 + i, 260.00);
				l.addRoom(r);
			}
			
			l.deserializeRoom();
		}
		
		// Deserialise booking list if it exists
		try{
				FileInputStream bookingSer = new FileInputStream("booking.ser");
				l.deserializeBooking();
			} 
		
		// Create a new file if it does not exist
		catch(FileNotFoundException e){
				System.out.println("Booking list not found");
				
				// Variables for booking
				Customer c = l.getCustomerList().get(0);
				Room r = l.getRoomList().get(0);
				// Set check-in
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateString1 = "19-08-2015 00:00:00";
				Date checkIn = null;
				try {
					checkIn  = sdf1.parse(dateString1);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				// Set check-out date
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				String dateString2 = "26-08-2015 00:00:00";
				Date checkOut = null;
				try {
					checkOut = sdf2.parse(dateString2);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Booking b = new Booking(c, r, checkIn, checkOut, 1928.0);
				l.addBooking(b);
				l.deserializeBooking();
			}
		
		// Search through the rooms and reset the booked variable if there is no-one staying in the room
		LinkedList<Room> lr = l.getRoomList();
		LinkedList<Booking> lb = l.getBookingList();
		
		LinkedList<Room> bookedRooms = new LinkedList<Room>();
		
		for(int j = 0; j < lb.size(); j = j + 1){
			// Add the booked rooms to the linked list
			Room r = lb.get(j).getRoom();
		}
		
		// Set today's date
		java.util.Date today = Calendar.getInstance().getTime();
		
		// Check each room
		for(int k = 0; k < bookedRooms.size(); k = k + 1){
			Booking b = lb.get(k);
			Room rm = b.getRoom();
			
			// Check if the booking occurred in the past
			Date checkOut = b.getCheckOut();
			if(checkOut.before(today)){
				// The room is not booked
				boolean booked = false;
				
				// Search through bookings again to check if the room is booked in the future
				for(int q = 0; q < lb.size(); q = q + 1){
					Room room = lb.get(q).getRoom();
					
					// If the room has been found twice, it is still booked
					if(rm.equals(room)){
						booked = true;
						break;
					}
				}
				// Set whether the room has been booked
				rm.setBooked(booked);
			}
		}
	}
	
}
