package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import com.toedter.calendar.JDateChooser;

import controller.BookingSearch;
import model.Booking;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class BookingTable extends JPanel {
	private JTable tableBookings;

	/**
	 * Create the panel.
	 * @param lb 
	 */
	public BookingTable() {
		setLayout(null);
		
		JLabel lblInstruction = new JLabel("<html>Here is a list of today's bookings. Use the date pickers below to refine your search.</html>");
		lblInstruction.setBounds(0, 0, 510, 40);
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(lblInstruction);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(0, 79, 30, 16);
		add(lblFrom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 126, 776, 439);
		add(scrollPane);
		
		// -------------------------------------------------------------------------------------------------------------------------
		// Header of each column
		String[] columnHeaders = {"Customer", "Room type", "Room number", "Check-in date", "Check-out date", "Nights", "Cost"};
		
		// Get today's date
		java.util.Date today = Calendar.getInstance().getTime();
		
		// Get today's date as a calendar so time can be added to it
		Calendar now = Calendar.getInstance();
		now.setTime(today);
		
		// By default sets the upper limit to 7 days after today
		Date nextWeek = new Date();
		now.add(Calendar.DATE, 7);
		nextWeek.setTime(now.getTime().getTime());
		
		// Construct the BookingSearch object
		BookingSearch bs = new BookingSearch();
		LinkedList<Booking> bookingList = bs.search(today, nextWeek);
		System.out.println(today.toString());
		System.out.println(nextWeek.toString());
		
		int numRows = bookingList.size();
		
		DefaultTableModel model = new DefaultTableModel(numRows, columnHeaders.length);
		model.setColumnIdentifiers(columnHeaders);
		
		// Create the table
		tableBookings = new JTable(model);
		scrollPane.setViewportView(tableBookings);
		tableBookings.setBackground(UIManager.getColor("Panel.background"));
		tableBookings.setEnabled(false);
		tableBookings.setRowSelectionAllowed(false);
		
		
		// Contents of the table
		DefaultTableModel tableModel = (DefaultTableModel) tableBookings.getModel();
		
		tableModel.setColumnIdentifiers(columnHeaders);
		
		// Clear table
		tableModel.getDataVector().removeAllElements();
		
		for(int i = 0; i < bookingList.size(); i = i + 1){
			Booking b = bookingList.get(i);
			
			String fName = b.getCustomer().getFName();
			String lName = b.getCustomer().getLName();
			
			// Variables to show in table
			String customer = fName + " " + lName;
			String roomType = b.getRoom().getType();
			int roomNum = b.getRoom().getNum();
			Date checkIn = b.getCheckIn();
			Date checkOut = b.getCheckOut();
			int nights = b.getNights();
			double cost = b.getPrice();
						
			tableModel.addRow(new Object[]{customer, roomType, roomNum, checkIn.toString(), checkOut.toString(), nights, cost});
		}
		tableBookings.validate();
		tableBookings.repaint();
		// -------------------------------------------------------------------------------------------------------------------------

		JDateChooser dateFrom = new JDateChooser();
		dateFrom.setBounds(35, 75, 210, 22);
		add(dateFrom);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(280, 79, 15, 16);
		add(lblTo);
		
		JDateChooser dateTo = new JDateChooser();
		dateTo.setBounds(300, 75, 210, 22);
		add(dateTo);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){	
				try{
					// Clear table
					tableModel.getDataVector().removeAllElements();
					
					System.out.println(tableModel.getRowCount());
			        
					// Dates used for searching
					Date from = dateFrom.getDate();
					Date to = dateTo.getDate();
					
					// Construct the BookingSearch object
					BookingSearch bs = new BookingSearch();
					LinkedList<Booking> bookingList = bs.search(from, to);
					
					
					for(int i = 0; i < bookingList.size(); i = i + 1){
						Booking b = bookingList.get(i);
						
						String fName = b.getCustomer().getFName();
						String lName = b.getCustomer().getLName();
						
						// Variables to show in table
						String customer = fName + " " + lName;
						String roomType = b.getRoom().getType();
						int roomNum = b.getRoom().getNum();
						Date checkIn = b.getCheckIn();
						Date checkOut = b.getCheckOut();
						int nights = b.getNights();
						double cost = b.getPrice();
									
						tableModel.addRow(new Object[]{customer, roomType, roomNum, checkIn.toString(), checkOut.toString(), nights, cost});
					}
					
					// Set the data to the result of the search
					tableBookings.setModel(tableModel);
					
					// Refresh the table
					tableBookings.validate();
					tableBookings.repaint();
				} catch(NullPointerException e){
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(515, 75, 99, 25);
		add(btnSearch);
		
		
	}
}
