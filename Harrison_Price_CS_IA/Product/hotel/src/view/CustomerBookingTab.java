package view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import controller.CurrentUser;
import controller.Validate;
import model.Customer;

public class CustomerBookingTab extends JPanel {
	private JTextField txtCost;
	private double cost;
	private JTextField txtCustomer;

	/**
	 * Create the panel.
	 * @param user 
	 */
	public CustomerBookingTab(Customer c) {		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 212, 0};
		gridBagLayout.rowHeights = new int[]{0, 27, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblInstruction = new JLabel("Use the form below to book a room");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblInstruction = new GridBagConstraints();
		gbc_lblInstruction.anchor = GridBagConstraints.WEST;
		gbc_lblInstruction.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstruction.gridx = 0;
		gbc_lblInstruction.gridy = 0;
		gbc_lblInstruction.gridwidth = 2;
		add(lblInstruction, gbc_lblInstruction);
		
		
		JLabel lblBookedTo = new JLabel("Booked to");
		GridBagConstraints gbc_lblBookedTo = new GridBagConstraints();
		gbc_lblBookedTo.anchor = GridBagConstraints.EAST;
		gbc_lblBookedTo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookedTo.gridx = 0;
		gbc_lblBookedTo.gridy = 2;
		add(lblBookedTo, gbc_lblBookedTo);
		
		txtCustomer = new JTextField(c.getFName() + " " + c.getLName());
		txtCustomer.setEditable(false);
		GridBagConstraints gbc_txtCustomer = new GridBagConstraints();
		gbc_txtCustomer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCustomer.insets = new Insets(0, 0, 5, 0);
		gbc_txtCustomer.gridx = 1;
		gbc_txtCustomer.gridy = 2;
		add(txtCustomer, gbc_txtCustomer);
		txtCustomer.setColumns(10);
		
		JLabel lblCheckIn = new JLabel("Check-in date");
		GridBagConstraints gbc_lblCheckIn = new GridBagConstraints();
		gbc_lblCheckIn.anchor = GridBagConstraints.WEST;
		gbc_lblCheckIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckIn.gridx = 0;
		gbc_lblCheckIn.gridy = 3;
		add(lblCheckIn, gbc_lblCheckIn);
		
		JDateChooser dteCheckIn = new JDateChooser();
		// Set today's date to the minimum date available
		dteCheckIn.setMinSelectableDate(new Date());
		dteCheckIn.getCalendarButton().setMinimumSize(new Dimension(30, 17));
		dteCheckIn.getCalendarButton().setMaximumSize(new Dimension(30, 17));
		dteCheckIn.getCalendarButton().setSize(new Dimension(70, 20));
		GridBagConstraints gbc_dteCheckIn = new GridBagConstraints();
		gbc_dteCheckIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_dteCheckIn.insets = new Insets(0, 0, 5, 0);
		gbc_dteCheckIn.gridx = 1;
		gbc_dteCheckIn.gridy = 3;
		add(dteCheckIn, gbc_dteCheckIn);
		
		JLabel lblCheckOut = new JLabel("Check-out date");
		GridBagConstraints gbc_lblCheckOut = new GridBagConstraints();
		gbc_lblCheckOut.anchor = GridBagConstraints.WEST;
		gbc_lblCheckOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckOut.gridx = 0;
		gbc_lblCheckOut.gridy = 4;
		add(lblCheckOut, gbc_lblCheckOut);
		
		JDateChooser dteCheckOut = new JDateChooser();
		// Set minimum selectable date to today
		dteCheckOut.setMinSelectableDate(new Date());
		dteCheckOut.getCalendarButton().setMaximumSize(new Dimension(25, 17));
		dteCheckOut.getCalendarButton().setMinimumSize(new Dimension(25, 17));
		GridBagConstraints gbc_dteCheckOut = new GridBagConstraints();
		gbc_dteCheckOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_dteCheckOut.insets = new Insets(0, 0, 5, 0);
		gbc_dteCheckOut.gridx = 1;
		gbc_dteCheckOut.gridy = 4;
		add(dteCheckOut, gbc_dteCheckOut);
		
		JLabel lblRoomType = new JLabel("Room type");
		GridBagConstraints gbc_lblRoomType = new GridBagConstraints();
		gbc_lblRoomType.gridheight = 2;
		gbc_lblRoomType.anchor = GridBagConstraints.WEST;
		gbc_lblRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType.gridx = 0;
		gbc_lblRoomType.gridy = 5;
		add(lblRoomType, gbc_lblRoomType);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnDeluxe = new JRadioButton("Deluxe");
		rdbtnDeluxe.setActionCommand("Deluxe");
		rdbtnDeluxe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Dates for booking
				Date checkIn = dteCheckIn.getDate();
				
				Date checkOut = dteCheckOut.getDate();
				
				// Construct validate class
				Validate v = new Validate(checkIn, checkOut);
				
				// Set the estimated cost
				cost = v.estimateCost("Deluxe");
				
				// Show the cost
				txtCost.setText(String.valueOf(cost));
			}
		});	
		
		JRadioButton rdbtnBasic = new JRadioButton("Basic");
		rdbtnBasic.setActionCommand("Basic");
		rdbtnBasic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// Dates for booking
				Date checkIn = dteCheckIn.getDate();
				
				Date checkOut = dteCheckOut.getDate();
				
				// Construct the validate class
				Validate v = new Validate(checkIn, checkOut);
				
				// Set the estimated cost
				cost = v.estimateCost("Basic");
				
				// Show the cost
				txtCost.setText(String.valueOf(cost));
			}
		});
		GridBagConstraints gbc_rdbtnBasic = new GridBagConstraints();
		gbc_rdbtnBasic.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBasic.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnBasic.gridx = 1;
		gbc_rdbtnBasic.gridy = 5;
		add(rdbtnBasic, gbc_rdbtnBasic);
		group.add(rdbtnBasic);
		GridBagConstraints gbc_rdbtnDeluxe = new GridBagConstraints();
		gbc_rdbtnDeluxe.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDeluxe.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDeluxe.gridx = 1;
		gbc_rdbtnDeluxe.gridy = 6;
		add(rdbtnDeluxe, gbc_rdbtnDeluxe);
		group.add(rdbtnDeluxe);
		
		JLabel lblCost = new JLabel("Estimated cost");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.EAST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 7;
		add(lblCost, gbc_lblCost);
		
		txtCost = new JTextField();
		txtCost.setEditable(false);
		GridBagConstraints gbc_txtCost = new GridBagConstraints();
		gbc_txtCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCost.insets = new Insets(0, 0, 5, 0);
		gbc_txtCost.gridx = 1;
		gbc_txtCost.gridy = 7;
		add(txtCost, gbc_txtCost);
		txtCost.setColumns(10);
		
		JButton btnBook = new JButton("Book");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Dates for booking
				Date checkIn = dteCheckIn.getDate();
				
				Date checkOut = dteCheckOut.getDate();
				
				boolean basic = rdbtnBasic.isSelected();
				boolean deluxe = rdbtnDeluxe.isSelected();
				
				String type = null;
				
				// Selecting the room type
				if(basic){
					Validate v = new Validate(c, checkIn, checkOut, "Basic");
					boolean error = v.validateBookingDate();
					// Only check the rooms if the dates are valid
					if(!error){
						v.checkRoomAvailability();
					} else{
						JOptionPane.showMessageDialog(null, "The dates you entered are not valid. Make sure the check-in date is before the check-out date and the check-out date is after today.", "Invalid dates", JOptionPane.ERROR_MESSAGE);
					}
				} else if(deluxe){
					Validate v = new Validate(c, checkIn, checkOut, "Deluxe");
					boolean error = v.validateBookingDate();
					// Only check the rooms if the dates are valid
					if(!error){
						v.checkRoomAvailability();
					} else{
						JOptionPane.showMessageDialog(null, "The dates you entered are not valid. Make sure the check-in date is before the check-out date and the check-out date is after today.", "Invalid dates", JOptionPane.ERROR_MESSAGE);
					}
				} else{
					JOptionPane.showMessageDialog(null, "Please make a selection.", "No selection", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		GridBagConstraints gbc_btnBook = new GridBagConstraints();
		gbc_btnBook.insets = new Insets(0, 0, 5, 0);
		gbc_btnBook.anchor = GridBagConstraints.WEST;
		gbc_btnBook.gridx = 1;
		gbc_btnBook.gridy = 8;
		add(btnBook, gbc_btnBook);

	}

}
