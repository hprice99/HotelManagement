package model;

import model.*;
import java.util.Date;

public class Booking extends Date implements java.io.Serializable{
	// Collected from form
	private Customer customer;
	private Room room;
	private Date checkIn;
	private Date checkOut;
	
	// Calculated using other variables
	private double price;

	private int nights;
	
	private static final long serialVersionUID = 1L;
	
	public Booking(Customer customer, Room room, Date checkIn,
			Date checkOut, double price) {
		super();
		this.customer = customer;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.price = price;
	}
	
	// Use the check-in and check-out dates to get the number of nights of stay
	public void setNights(int nights){
		this.nights = nights;
	}
	
	public int getNights(){
		return nights;
	}
	
	// Use the room's price and the calculated number of nights to set the total cost
	public void setPrice(double price){
		this.price = price;
	}

	@Override
	public String toString() {
		return "Booking [customer=" + customer + ", room=" + room + ", checkIn=" + checkIn + ", checkOut=" + checkOut
				+ ", price=" + price + ", nights=" + nights + "]";
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getPrice() {
		return price;
	}
	
}
