package controller;

import java.util.Date;
import java.util.LinkedList;

import model.Booking;
import model.Lists;
public class BookingSearch {
	
	// List of all bookings
	//Lists.deserializeBooking();
	private LinkedList<Booking> bl = Lists.getBookingList();
	private Lists list = new Lists();;
	
	
	// Linked list to include bookings in the desired range
	private LinkedList<Booking> range;
	
	public BookingSearch(){
		
	}
	
	public LinkedList<Booking> search(Date from, Date to){
		list.deserializeBooking();
		bl = list.getBookingList();
		range = new LinkedList<Booking>();
		for(int i = 0; i < bl.size(); i = i + 1){
			// Each booking in the list
			Booking b = bl.get(i);
			System.out.println(b);
			// Dates for each booking in the list
			Date ci = b.getCheckIn();
			
			// If the check-in date is out of the range selected, do not include it in the list
			if(ci.before(from) || ci.after(to)){
				System.out.println("No bookings in this range");
			} else{
				range.add(b);
			}
		}		
		System.out.println(range);
		if(range.size() == 0){
			System.out.println("No bookings");
		}
		
		return range;
	}
}
