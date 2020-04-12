package view;

import javax.swing.JPanel;

import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controller.LogInControl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LogInTab extends JPanel {
	private JTextField txtUsername;
	private JPasswordField pswPassword;

	/**
	 * Create the panel.
	 * @param main 
	 */
	public LogInTab(Main main) {
		setLayout(null);
		
		// Use <html> to make the text overflow to the next line
		JLabel lblWelcome = new JLabel("<html>Welcome to the Riverside Resorts booking application. Please log-in or register below. </html>");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcome.setBounds(12, 25, 226, 58);
		add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 121, 71, 16);
		add(lblUsername);
		
		txtUsername = new JTextField();
		
		// Allow user to press enter to submit details
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String username = txtUsername.getText();
					char[] password = pswPassword.getPassword();
					
					new LogInControl(username, password, main);
				}
			}
		});
		txtUsername.setBounds(95, 118, 116, 22);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 156, 71, 16);
		add(lblPassword);
		
		pswPassword = new JPasswordField();
		pswPassword.addKeyListener(new KeyAdapter() {
			// Allow user to press enter to submit details
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String username = txtUsername.getText();
					char[] password = pswPassword.getPassword();
					
					new LogInControl(username, password, main);
				}
			}
		});
		pswPassword.setBounds(95, 153, 116, 22);
		add(pswPassword);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = txtUsername.getText();
				char[] password = pswPassword.getPassword();
				
				new LogInControl(username, password, main);
			}
		});
		btnLogin.setBounds(114, 190, 97, 25);
		add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Set the selected tab to the register tab when register button is clicked						
				main.setTab(1);
			}
		});
		btnRegister.setBounds(5, 190, 97, 25);
		add(btnRegister);

	}
	
	// Constructor for log-in pop-up
	public LogInTab(LoggedInView liv, controller.CustomerSearch cs){
		JFrame frame = new JFrame("Authenticate log-in");
		frame.setBounds(100, 100, 250, 300);
		setLayout(null);
		
		// Use <html> to make the text overflow to the next line
		JLabel lblWelcome = new JLabel("<html>Please enter your credentials again to delete the account.</html>");
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcome.setBounds(12, 25, 226, 58);
		add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(12, 121, 71, 16);
		add(lblUsername);
		
		txtUsername = new JTextField();
		
		// Allow user to press enter to submit details
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String username = txtUsername.getText();
					char[] password = pswPassword.getPassword();
					
					cs.deleteAccount(username, password);
				}
			}
		});
		txtUsername.setBounds(95, 118, 116, 22);
		add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(12, 156, 71, 16);
		add(lblPassword);
		
		pswPassword = new JPasswordField();
		pswPassword.addKeyListener(new KeyAdapter() {
			// Allow user to press enter to submit details
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String username = txtUsername.getText();
					char[] password = pswPassword.getPassword();
					
					cs.deleteAccount(username, password);
				}
			}
		});
		pswPassword.setBounds(95, 153, 116, 22);
		add(pswPassword);
		
		JButton btnLogin = new JButton("Log-in");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Get the values from the text fields
				String username = txtUsername.getText();
				char[] password = pswPassword.getPassword();
				
				// Pass the username and password of the admin to the deleteAccount method to authenticate the admin account
				cs.deleteAccount(username, password);
			}
		});
		btnLogin.setBounds(114, 190, 97, 25);
		add(btnLogin);
		frame.add(this);
		frame.setVisible(true);
	}
	
	public JTextField getUserField(){
		return txtUsername;
	}
}
