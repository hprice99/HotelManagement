package view;

import java.awt.BorderLayout;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import view.*;
import controller.Validate;
import java.awt.GridBagLayout;

public class Main extends JFrame {

	private JPanel contentPane;

	JTabbedPane tabbedPane;
	/**
	 * Create the frame.
	 */
	public Main(){
		
		setTitle("Riverside Resorts' booking client");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 431, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 13, 389, 477); 
		
		
		// ---------------------------------------------------------------------
		// Tabs to be inserted in the main JFrame
		JPanel login = new LogInTab(this);
		JPanel register = new RegisterTab(this);
		GridBagLayout gridBagLayout = (GridBagLayout) register.getLayout();
		gridBagLayout.columnWidths = new int[]{0, 296};
		
		// Put the register tab in a scroll pane
		JScrollPane scrollPane = new JScrollPane(register);
		// ---------------------------------------------------------------------
		
		tabbedPane.addTab("Log-in", login);
		tabbedPane.addTab("Register", scrollPane);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	
	// Tell user about the invalid details
	public void invalidDetails(String detail){
		// Provide further clarification for phone number
		if(detail.equals("Phone")){
			JOptionPane.showMessageDialog(contentPane, "The phone number you entered is not valid. Please include your area code in the phone number.", "Incorrect " + detail, JOptionPane.ERROR_MESSAGE);
		} else{
			JOptionPane.showMessageDialog(contentPane, detail + " is invalid.", "Incorrect " + detail, JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	// Make sure the user accepts the terms and conditions
	public void acceptTerms(){
		JOptionPane.showMessageDialog(contentPane, "Please check the terms and conditions box on the register page in order to create an account", "Please accept the terms", JOptionPane.ERROR_MESSAGE);
	}
	
	// Tell user that the username provided has already been registered
	public void usernameTaken(String username){
		JOptionPane.showMessageDialog(contentPane, "Sorry. The username \"" + username + "\" is already taken.", "Username taken", JOptionPane.ERROR_MESSAGE);
	}
	
	public void setTab(int tab){
		tabbedPane.setSelectedIndex(tab);
	}
	
	
	// Tell the user that their log-in details are incorrect
	public void invalidLogIn(){
		JOptionPane.showMessageDialog(contentPane, "These account details are incorrect.", "Invalid details.", JOptionPane.ERROR_MESSAGE);
	}
}
