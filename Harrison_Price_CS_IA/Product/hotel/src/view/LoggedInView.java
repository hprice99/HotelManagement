package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.CurrentUser;

import javax.swing.JTabbedPane;

public class LoggedInView extends JFrame {

	private JPanel contentPane;
	private boolean isCustomer = CurrentUser.isCustomer();
	
	// Panel and layout for add user card switcher
	private JPanel userContainer;
	private CardLayout cardOne = new CardLayout();
	
	// Panel and layout for the search container for editing accounts
	private JPanel searchContainer;
	private CardLayout cardTwo = new CardLayout();
	
	// Panel and layout for the search container for booking rooms
	private JPanel bookingContainer;
	private CardLayout cardThree = new CardLayout();

	private JTabbedPane tabbedPane;
	/**
	 * Create the frame.
	 * @param bookings 
	 */
	public LoggedInView(int bookings) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 12, 800, 575);
		
		if(isCustomer){
			// Initialise the panels
			JPanel welcome = new Welcome(this);
			
			JPanel changeDetails = new ChangeDetails();
			JScrollPane detailsScroll = new JScrollPane(changeDetails);
			
			JPanel customerBookRoom = new CustomerBookingTab(CurrentUser.getC());
			JScrollPane bookingScroll = new JScrollPane(customerBookRoom);
			
			// Pass this JFrame into logOut so that it can dispose of this instance
			JPanel logOut = new LogOut(this);
			
			// Add the panels to the tabbed pane
			tabbedPane.addTab("Welcome", welcome);
			tabbedPane.addTab("Book room", bookingScroll);
			tabbedPane.addTab("Change details", detailsScroll);
			tabbedPane.addTab("Log-out", logOut);
			contentPane.add(tabbedPane);
		} else{
			// Initialise the panels
			JPanel welcome = new WelcomeAdmin(bookings);
						
			JPanel changeDetails = new ChangeDetails();
			JScrollPane detailsScroll = new JScrollPane(changeDetails);
			
			// ----------------------------------------------------------------------
			// Create userContainer
			this.userContainer = new JPanel();
			userContainer.setLayout(cardOne);
			
			// Create instances of JPanels
			JPanel selectUserType = new SelectUserType(this);
			JPanel addCustomer = new RegisterTab(null);
			JPanel addAdmin = new RegisterEmployee();
			
			// Put the container in the card layout
			userContainer.add(selectUserType, "select");
			
			// Set the grid bag layout for the add customer panel
			GridBagLayout gridBagLayout = (GridBagLayout) addCustomer.getLayout();
			gridBagLayout.columnWidths = new int[]{0, 296};
			
			// Put the add customer panel in a scroll pane
			JScrollPane scrollPane = new JScrollPane(addCustomer);
			
			// Add panel into card layout
			userContainer.add(scrollPane, "customer");
			
			// Set the grid bag layout for the add admin panel
			GridBagLayout gbl = (GridBagLayout) addAdmin.getLayout();
			gridBagLayout.columnWidths = new int[]{0, 296};
			
			// Put add admin panel in scroll pane
			JScrollPane sp = new JScrollPane(addAdmin);
			
			// Add panel into card layout
			userContainer.add(sp, "admin");
			
			// Set default opening state
			cardOne.show(userContainer, "select");
			// ----------------------------------------------------------------------
			
			// ----------------------------------------------------------------------
			// Create the container for the search
			this.searchContainer = new JPanel();
			searchContainer.setLayout(cardTwo);
			
			// Create the search panel
			// Pass this object to the search panel so it can edit the current frame
			// Search panel for editing customer details
			JPanel search = new CustomerSearch(this, "edit");
			searchContainer.add(search, "search");
			
			cardTwo.show(searchContainer, "search");
			// ----------------------------------------------------------------------
			
			// ----------------------------------------------------------------------
			this.bookingContainer = new JPanel();
			bookingContainer.setLayout(cardThree);
			
			// Create the search panel
			// Will link to the booking screen
			JPanel searchForBooking = new CustomerSearch(this, "book");
			bookingContainer.add(searchForBooking, "search");
			
			cardThree.show(bookingContainer, "search");
			// ----------------------------------------------------------------------
			
			JPanel bookingTable = new BookingTable();
			
			// Pass this JFrame into logOut so that it can dispose of this instance
			JPanel logOut = new LogOut(this);
			
			tabbedPane.addTab("Welcome", welcome);
			tabbedPane.addTab("View bookings", bookingTable);
			tabbedPane.addTab("Book a room", bookingContainer);
			tabbedPane.addTab("Add user", userContainer);
			tabbedPane.addTab("Edit customer accounts", searchContainer);
			tabbedPane.addTab("Change Details", detailsScroll);
			tabbedPane.addTab("Log-out", logOut);
			contentPane.add(tabbedPane);
		}
	}
	
	// Method for admin editing customer details
	public void editCustomer(ChangeDetails c){
		searchContainer.add(c, "change");
		
		cardTwo.show(searchContainer, "change");
	}
	
	// Overloaded method for admin booking on behalf of customer
	public void book(CustomerBookingTab bt){
		bookingContainer.add(bt, "book");
		
		cardThree.show(bookingContainer, "book");
	}
	
	public void setTab(int tab){
		tabbedPane.setSelectedIndex(tab);
	}
	
	public void invalidPassword(){
		JOptionPane.showMessageDialog(contentPane, "Passwords do not match", "Passwords do no match", JOptionPane.ERROR_MESSAGE);
	}
	
	public void changePanel(String iden){
		cardOne.show(userContainer, iden);
	}
	
	public void registered(){
		JOptionPane.showMessageDialog(null, "Successfully registered.");
	}
	
	public void usernameTaken(String username){
		JOptionPane.showMessageDialog(contentPane, "Sorry. The username \"" + username + "\" is already taken.", "Username taken", JOptionPane.ERROR_MESSAGE);
	}
	
	// Tell user about the invalid details
	public void invalidDetails(String detail){
		JOptionPane.showMessageDialog(contentPane, detail + " is invalid.", "Incorrect " + detail, JOptionPane.ERROR_MESSAGE);
	}
			
}
