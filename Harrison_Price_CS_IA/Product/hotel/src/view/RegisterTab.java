package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JCheckBox;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

import controller.Validate;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Dimension;
import com.toedter.calendar.JDateChooser;

public class RegisterTab extends JPanel {
	private JTextField txtUsername;
	private JPasswordField pswConfirm;
	private JPasswordField pswPassword;
	private JTextField txtEmail;
	private JTextField txtPhoneNo;
	private JTextField txtPCode;
	private JTextField txtSuburb;
	private JTextField txtAdd2;
	private JTextField txtAdd1;
	private JTextField txtLName;
	private JTextField txtFName;
	
	
	// Arrays for each of the combo boxes
	private String[] addressType = {"Home", "Work"};
	private String[] state = {"QLD", "NSW", "VIC", "TAS", "SA", "WA", "NT", "ACT"};
	private String[] phoneType = {"Home", "Mobile", "Work"};

	/**
	 * Create the panel.
	 * @param m 
	 */
	public RegisterTab(Main m) {
		setMaximumSize(new Dimension(300, 500));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{154, 161, 0};
		gridBagLayout.rowHeights = new int[]{80, 30, 30, 34, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label = new JLabel("<html><body width='280px'>Welcome to Riverside Resorts. Please complete the following registration form to create an account.</body></html>");
		label.setMaximumSize(new Dimension(250, 32));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		gbc_label.gridwidth = 2;
		add(label, gbc_label);
		
		JLabel lblFName = new JLabel("<html>First name <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblFName = new GridBagConstraints();
		gbc_lblFName.fill = GridBagConstraints.BOTH;
		gbc_lblFName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFName.gridx = 0;
		gbc_lblFName.gridy = 1;
		add(lblFName, gbc_lblFName);
		
		txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.anchor = GridBagConstraints.WEST;
		gbc_txtFName.fill = GridBagConstraints.VERTICAL;
		gbc_txtFName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFName.gridx = 1;
		gbc_txtFName.gridy = 1;
		add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLName = new JLabel("<html>Surname <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.fill = GridBagConstraints.BOTH;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 0;
		gbc_lblLName.gridy = 2;
		add(lblLName, gbc_lblLName);
		
		txtLName = new JTextField();
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.anchor = GridBagConstraints.WEST;
		gbc_txtLName.fill = GridBagConstraints.VERTICAL;
		gbc_txtLName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLName.gridx = 1;
		gbc_txtLName.gridy = 2;
		add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel lbldateOfBirth = new JLabel("<html>Date of birth <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lbldateOfBirth = new GridBagConstraints();
		gbc_lbldateOfBirth.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbldateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lbldateOfBirth.gridx = 0;
		gbc_lbldateOfBirth.gridy = 3;
		add(lbldateOfBirth, gbc_lbldateOfBirth);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.VERTICAL;
		gbc_dateChooser.anchor = GridBagConstraints.WEST;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 3;
		add(dateChooser, gbc_dateChooser);
		
		JLabel lblAddType = new JLabel("<html>Address type <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblAddType = new GridBagConstraints();
		gbc_lblAddType.fill = GridBagConstraints.BOTH;
		gbc_lblAddType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddType.gridx = 0;
		gbc_lblAddType.gridy = 4;
		add(lblAddType, gbc_lblAddType);
		
		JComboBox cmbAddType = new JComboBox(addressType);
		GridBagConstraints gbc_cmbAddType = new GridBagConstraints();
		gbc_cmbAddType.anchor = GridBagConstraints.WEST;
		gbc_cmbAddType.fill = GridBagConstraints.VERTICAL;
		gbc_cmbAddType.insets = new Insets(0, 0, 5, 0);
		gbc_cmbAddType.gridx = 1;
		gbc_cmbAddType.gridy = 4;
		add(cmbAddType, gbc_cmbAddType);
		
		JLabel lblAdd1 = new JLabel("<html>Address Line 1 <font color=\"red\">*</font></html");
		GridBagConstraints gbc_lblAdd1 = new GridBagConstraints();
		gbc_lblAdd1.fill = GridBagConstraints.BOTH;
		gbc_lblAdd1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd1.gridx = 0;
		gbc_lblAdd1.gridy = 5;
		add(lblAdd1, gbc_lblAdd1);
		
		txtAdd1 = new JTextField();
		GridBagConstraints gbc_txtAdd1 = new GridBagConstraints();
		gbc_txtAdd1.anchor = GridBagConstraints.WEST;
		gbc_txtAdd1.fill = GridBagConstraints.VERTICAL;
		gbc_txtAdd1.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd1.gridx = 1;
		gbc_txtAdd1.gridy = 5;
		add(txtAdd1, gbc_txtAdd1);
		txtAdd1.setColumns(10);
		
		JLabel lblAdd2 = new JLabel("Address Line 2");
		GridBagConstraints gbc_lblAdd2 = new GridBagConstraints();
		gbc_lblAdd2.fill = GridBagConstraints.BOTH;
		gbc_lblAdd2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd2.gridx = 0;
		gbc_lblAdd2.gridy = 6;
		add(lblAdd2, gbc_lblAdd2);
		
		txtAdd2 = new JTextField();
		GridBagConstraints gbc_txtAdd2 = new GridBagConstraints();
		gbc_txtAdd2.anchor = GridBagConstraints.WEST;
		gbc_txtAdd2.fill = GridBagConstraints.VERTICAL;
		gbc_txtAdd2.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd2.gridx = 1;
		gbc_txtAdd2.gridy = 6;
		add(txtAdd2, gbc_txtAdd2);
		txtAdd2.setColumns(10);
		
		JLabel lblSuburb = new JLabel("<html>Suburb <font color=\"red\">* </font></html>");
		GridBagConstraints gbc_lblSuburb = new GridBagConstraints();
		gbc_lblSuburb.fill = GridBagConstraints.BOTH;
		gbc_lblSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuburb.gridx = 0;
		gbc_lblSuburb.gridy = 7;
		add(lblSuburb, gbc_lblSuburb);
		
		txtSuburb = new JTextField();
		GridBagConstraints gbc_txtSuburb = new GridBagConstraints();
		gbc_txtSuburb.anchor = GridBagConstraints.WEST;
		gbc_txtSuburb.fill = GridBagConstraints.VERTICAL;
		gbc_txtSuburb.insets = new Insets(0, 0, 5, 0);
		gbc_txtSuburb.gridx = 1;
		gbc_txtSuburb.gridy = 7;
		add(txtSuburb, gbc_txtSuburb);
		txtSuburb.setColumns(10);
		
		JLabel lblPCode = new JLabel("<html>Post code <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblPCode = new GridBagConstraints();
		gbc_lblPCode.fill = GridBagConstraints.BOTH;
		gbc_lblPCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPCode.gridx = 0;
		gbc_lblPCode.gridy = 8;
		add(lblPCode, gbc_lblPCode);
		
		txtPCode = new JTextField();
		GridBagConstraints gbc_txtPCode = new GridBagConstraints();
		gbc_txtPCode.anchor = GridBagConstraints.WEST;
		gbc_txtPCode.fill = GridBagConstraints.VERTICAL;
		gbc_txtPCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPCode.gridx = 1;
		gbc_txtPCode.gridy = 8;
		add(txtPCode, gbc_txtPCode);
		txtPCode.setColumns(10);
		
		JLabel lblState = new JLabel("<html>State <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.fill = GridBagConstraints.BOTH;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 9;
		add(lblState, gbc_lblState);
		
		JComboBox cmbState = new JComboBox(state);
		GridBagConstraints gbc_cmbState = new GridBagConstraints();
		gbc_cmbState.anchor = GridBagConstraints.WEST;
		gbc_cmbState.fill = GridBagConstraints.VERTICAL;
		gbc_cmbState.insets = new Insets(0, 0, 5, 0);
		gbc_cmbState.gridx = 1;
		gbc_cmbState.gridy = 9;
		add(cmbState, gbc_cmbState);
		
		JLabel lblPhoneType = new JLabel("<html>Phone type <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblPhoneType = new GridBagConstraints();
		gbc_lblPhoneType.fill = GridBagConstraints.BOTH;
		gbc_lblPhoneType.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneType.gridx = 0;
		gbc_lblPhoneType.gridy = 10;
		add(lblPhoneType, gbc_lblPhoneType);
		
		JComboBox cmbPhoneType = new JComboBox(phoneType);
		GridBagConstraints gbc_cmbPhoneType = new GridBagConstraints();
		gbc_cmbPhoneType.anchor = GridBagConstraints.WEST;
		gbc_cmbPhoneType.fill = GridBagConstraints.VERTICAL;
		gbc_cmbPhoneType.insets = new Insets(0, 0, 5, 0);
		gbc_cmbPhoneType.gridx = 1;
		gbc_cmbPhoneType.gridy = 10;
		add(cmbPhoneType, gbc_cmbPhoneType);
		
		JLabel lblPhone = new JLabel("<html>Phone number <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 0;
		gbc_lblPhone.gridy = 11;
		add(lblPhone, gbc_lblPhone);
		
		txtPhoneNo = new JTextField();
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.anchor = GridBagConstraints.WEST;
		gbc_txtPhoneNo.fill = GridBagConstraints.VERTICAL;
		gbc_txtPhoneNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 11;
		add(txtPhoneNo, gbc_txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("<html>Email address <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 12;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.WEST;
		gbc_txtEmail.fill = GridBagConstraints.VERTICAL;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 12;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("<html>Username <font color=\"red\">*</font)<html>");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.BOTH;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 13;
		add(lblUsername, gbc_lblUsername);
		
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.WEST;
		gbc_txtUsername.fill = GridBagConstraints.VERTICAL;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 13;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("<html>Password <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 14;
		add(lblPassword, gbc_lblPassword);
		
		pswPassword = new JPasswordField();
		GridBagConstraints gbc_pswPassword = new GridBagConstraints();
		gbc_pswPassword.anchor = GridBagConstraints.WEST;
		gbc_pswPassword.fill = GridBagConstraints.VERTICAL;
		gbc_pswPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pswPassword.gridx = 1;
		gbc_pswPassword.gridy = 14;
		add(pswPassword, gbc_pswPassword);
		pswPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("<html>Confirm password <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.fill = GridBagConstraints.BOTH;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 0;
		gbc_lblConfirmPassword.gridy = 15;
		add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		pswConfirm = new JPasswordField();
		GridBagConstraints gbc_pswConfirm = new GridBagConstraints();
		gbc_pswConfirm.anchor = GridBagConstraints.WEST;
		gbc_pswConfirm.fill = GridBagConstraints.VERTICAL;
		gbc_pswConfirm.insets = new Insets(0, 0, 5, 0);
		gbc_pswConfirm.gridx = 1;
		gbc_pswConfirm.gridy = 15;
		add(pswConfirm, gbc_pswConfirm);
		pswConfirm.setColumns(10);
		
// --------------------------------------------------------------------------------------------------------------------------
		
		JCheckBox chckbxTerms = new JCheckBox("<html>I agree to the terms and conditions <font color=\"red\">*</font></html>");
		chckbxTerms.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_chckbxTerms = new GridBagConstraints();
		gbc_chckbxTerms.fill = GridBagConstraints.BOTH;
		gbc_chckbxTerms.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxTerms.gridx = 0;
		gbc_chckbxTerms.gridy = 16;
		gbc_chckbxTerms.gridwidth = 2;
		add(chckbxTerms, gbc_chckbxTerms);
		
		JLabel label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 16;
		add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.fill = GridBagConstraints.BOTH;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 17;
		add(label_3, gbc_label_3);
		

		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Collect the data from the text boxes
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				Date dob = dateChooser.getDate();
				
				String addressType = cmbAddType.getSelectedItem().toString();
				String add1 = txtAdd1.getText();
				String add2 = txtAdd2.getText();
				String suburb = txtSuburb.getText();
				String pCode = txtPCode.getText();
				String state = cmbState.getSelectedItem().toString();
				String[] address = {addressType, add1, add2, suburb, pCode, state};
				String phoneType = cmbPhoneType.getSelectedItem().toString();
				String phoneNumber = txtPhoneNo.getText();
				String[] phone = {phoneType, phoneNumber};
				
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				
				// Get the password (as an array)
				char[] password = pswPassword.getPassword();
				char[] confirmPassword = pswConfirm.getPassword();
								
				// Check if the user accepts the terms and conditions
				boolean terms = chckbxTerms.isSelected();
				
				// Create an instance of the validate class
				new Validate(fName, lName, dob, address, phone, username, password, confirmPassword, email, terms, m);
				
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.anchor = GridBagConstraints.WEST;
		gbc_btnRegister.gridx = 1;
		gbc_btnRegister.gridy = 17;
		add(btnRegister, gbc_btnRegister);

	}
	
}
