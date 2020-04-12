package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Date;

import javax.swing.JTextField;

public class BookingConfirmation extends JFrame {

	private JPanel contentPane;
	private JTextField txtCheckIn;
	private JTextField txtCheckOut;
	private JTextField txtRoomType;
	private JTextField txtCost;
	private JTextField txtCustomer;
	
	/**
	 * Create the frame.
	 * @param checkOut 
	 * @param checkIn 
	 * @param price 
	 * @param fName 
	 * @param fName2 
	 */
	public BookingConfirmation(Date checkIn, Date checkOut, String type, double price, String fName, String lName) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 172, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblBooked = new JLabel("Your room has been booked");
		lblBooked.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblBooked = new GridBagConstraints();
		gbc_lblBooked.anchor = GridBagConstraints.WEST;
		gbc_lblBooked.gridwidth = 2;
		gbc_lblBooked.insets = new Insets(0, 0, 5, 0);
		gbc_lblBooked.gridx = 0;
		gbc_lblBooked.gridy = 0;
		contentPane.add(lblBooked, gbc_lblBooked);
		
		JLabel lblCheckIn = new JLabel("Check-in date");
		GridBagConstraints gbc_lblCheckIn = new GridBagConstraints();
		gbc_lblCheckIn.anchor = GridBagConstraints.WEST;
		gbc_lblCheckIn.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckIn.gridx = 0;
		gbc_lblCheckIn.gridy = 1;
		contentPane.add(lblCheckIn, gbc_lblCheckIn);
		
		txtCheckIn = new JTextField(checkIn.toString());
		txtCheckIn.setEditable(false);
		GridBagConstraints gbc_txtCheckIn = new GridBagConstraints();
		gbc_txtCheckIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCheckIn.insets = new Insets(0, 0, 5, 0);
		gbc_txtCheckIn.gridx = 1;
		gbc_txtCheckIn.gridy = 1;
		contentPane.add(txtCheckIn, gbc_txtCheckIn);
		txtCheckIn.setColumns(10);
		
		JLabel lblCheckOut = new JLabel("Check-out date");
		GridBagConstraints gbc_lblCheckOut = new GridBagConstraints();
		gbc_lblCheckOut.anchor = GridBagConstraints.EAST;
		gbc_lblCheckOut.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckOut.gridx = 0;
		gbc_lblCheckOut.gridy = 2;
		contentPane.add(lblCheckOut, gbc_lblCheckOut);
		
		txtCheckOut = new JTextField(checkOut.toString());
		txtCheckOut.setEditable(false);
		GridBagConstraints gbc_txtCheckOut = new GridBagConstraints();
		gbc_txtCheckOut.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCheckOut.insets = new Insets(0, 0, 5, 0);
		gbc_txtCheckOut.gridx = 1;
		gbc_txtCheckOut.gridy = 2;
		contentPane.add(txtCheckOut, gbc_txtCheckOut);
		txtCheckOut.setColumns(10);
		
		JLabel lblRoomType = new JLabel("Room type");
		GridBagConstraints gbc_lblRoomType = new GridBagConstraints();
		gbc_lblRoomType.anchor = GridBagConstraints.WEST;
		gbc_lblRoomType.insets = new Insets(0, 0, 5, 5);
		gbc_lblRoomType.gridx = 0;
		gbc_lblRoomType.gridy = 3;
		contentPane.add(lblRoomType, gbc_lblRoomType);
		
		txtRoomType = new JTextField(type);
		txtRoomType.setEditable(false);
		GridBagConstraints gbc_txtRoomType = new GridBagConstraints();
		gbc_txtRoomType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRoomType.anchor = GridBagConstraints.NORTH;
		gbc_txtRoomType.insets = new Insets(0, 0, 5, 0);
		gbc_txtRoomType.gridx = 1;
		gbc_txtRoomType.gridy = 3;
		contentPane.add(txtRoomType, gbc_txtRoomType);
		txtRoomType.setColumns(10);
		
		JLabel lblCost = new JLabel("Estimated cost");
		GridBagConstraints gbc_lblCost = new GridBagConstraints();
		gbc_lblCost.anchor = GridBagConstraints.WEST;
		gbc_lblCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblCost.gridx = 0;
		gbc_lblCost.gridy = 4;
		contentPane.add(lblCost, gbc_lblCost);
		
		txtCost = new JTextField(String.valueOf(price));
		txtCost.setEditable(false);
		GridBagConstraints gbc_txtCost = new GridBagConstraints();
		gbc_txtCost.anchor = GridBagConstraints.WEST;
		gbc_txtCost.insets = new Insets(0, 0, 5, 0);
		gbc_txtCost.gridx = 1;
		gbc_txtCost.gridy = 4;
		contentPane.add(txtCost, gbc_txtCost);
		txtCost.setColumns(10);
		
		JLabel lblBookedTo = new JLabel("Booked to");
		GridBagConstraints gbc_lblBookedTo = new GridBagConstraints();
		gbc_lblBookedTo.anchor = GridBagConstraints.EAST;
		gbc_lblBookedTo.insets = new Insets(0, 0, 0, 5);
		gbc_lblBookedTo.gridx = 0;
		gbc_lblBookedTo.gridy = 6;
		contentPane.add(lblBookedTo, gbc_lblBookedTo);
		
		txtCustomer = new JTextField(fName + " " + lName);
		txtCustomer.setEditable(false);
		GridBagConstraints gbc_txtCustomer = new GridBagConstraints();
		gbc_txtCustomer.fill = GridBagConstraints.BOTH;
		gbc_txtCustomer.gridx = 1;
		gbc_txtCustomer.gridy = 6;
		contentPane.add(txtCustomer, gbc_txtCustomer);
		txtCustomer.setColumns(10);
	}

}
