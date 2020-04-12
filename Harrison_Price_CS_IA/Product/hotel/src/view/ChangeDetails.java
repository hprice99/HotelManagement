package view;

import javax.swing.JPanel;


import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;

import controller.CurrentUser;
import controller.ValidateDetailChange;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ChangeDetails extends JPanel {
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtAdd1;
	private JTextField txtAdd2;
	private JTextField txtSuburb;
	private JTextField txtPCode;
	private String[] addressTypeList = {"Home", "Work"};
	private String[] stateList = {"QLD", "NSW", "VIC", "TAS", "SA", "WA", "NT", "ACT"};
	private String[] phoneTypeList = {"Home", "Mobile", "Work"};
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JPasswordField pswCurrentPWord;
	private JPasswordField pswNewPWord;
	private JPasswordField pswConfirm;
	private JTextField txtDOB;

	// CustomerSearch object needed to retain index from previous search
	private controller.CustomerSearch cs;
	
	public ChangeDetails(){
		// Details of current customer
		String FName = CurrentUser.getFName();
		String LName = CurrentUser.getLName();
		
		// Java util library date type
		java.util.Date dob = CurrentUser.getDob();
		
		String email = CurrentUser.getEmail();
		String username = CurrentUser.getUsername();
		String password = CurrentUser.getPassword();
		
		String department = CurrentUser.getDepartment();
		String role = CurrentUser.getRole();
		
		String[] address = CurrentUser.getAddress();
		// Separated address variables
		String addType = address[0];
		String add1 = address[1];
		String add2 = address[2];
		String suburb = address[3];
		String pCode = address[4];
		String state = address[5];
		
		String[] phone = CurrentUser.getPhone();
		String phoneType = phone[0];
		String phoneNo = phone[1];
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 157, 0};
		gridBagLayout.rowHeights = new int[]{16, 22, 22, 0, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDescription = new JLabel("<html>Use this form to edit your details</html>");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescription.gridwidth = 2;
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 0;
		add(lblDescription, gbc_lblDescription);
		
		JLabel lblFName = new JLabel("First name");
		GridBagConstraints gbc_lblFName = new GridBagConstraints();
		gbc_lblFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFName.gridx = 0;
		gbc_lblFName.gridy = 1;
		add(lblFName, gbc_lblFName);
		
		txtFName = new JTextField(FName);
		txtFName.setEditable(false);
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtFName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFName.gridx = 1;
		gbc_txtFName.gridy = 1;
		add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLName = new JLabel("Surname");
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 0;
		gbc_lblLName.gridy = 2;
		add(lblLName, gbc_lblLName);
		
		txtLName = new JTextField(LName);
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtLName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLName.gridx = 1;
		gbc_txtLName.gridy = 2;
		add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.anchor = GridBagConstraints.WEST;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 0;
		gbc_lblDateOfBirth.gridy = 3;
		add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		txtDOB = new JTextField(dob.toString());
		txtDOB.setEditable(false);
		GridBagConstraints gbc_txtDOB = new GridBagConstraints();
		gbc_txtDOB.anchor = GridBagConstraints.WEST;
		gbc_txtDOB.insets = new Insets(0, 0, 5, 0);
		gbc_txtDOB.gridx = 1;
		gbc_txtDOB.gridy = 3;
		add(txtDOB, gbc_txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblAddType = new JLabel("Address Type");
		GridBagConstraints gbc_lblAddType = new GridBagConstraints();
		gbc_lblAddType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddType.gridx = 0;
		gbc_lblAddType.gridy = 4;
		add(lblAddType, gbc_lblAddType);
		
		JComboBox cmbAddType = new JComboBox(addressTypeList);
		GridBagConstraints gbc_cmbAddType = new GridBagConstraints();
		gbc_cmbAddType.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbAddType.insets = new Insets(0, 0, 5, 0);
		gbc_cmbAddType.gridx = 1;
		gbc_cmbAddType.gridy = 4;
		add(cmbAddType, gbc_cmbAddType);
		cmbAddType.setSelectedItem(addType);
		
		JLabel lblAdd1 = new JLabel("Address Line 1");
		GridBagConstraints gbc_lblAdd1 = new GridBagConstraints();
		gbc_lblAdd1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdd1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd1.gridx = 0;
		gbc_lblAdd1.gridy = 5;
		add(lblAdd1, gbc_lblAdd1);
		
		txtAdd1 = new JTextField(add1);
		GridBagConstraints gbc_txtAdd1 = new GridBagConstraints();
		gbc_txtAdd1.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtAdd1.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd1.gridx = 1;
		gbc_txtAdd1.gridy = 5;
		add(txtAdd1, gbc_txtAdd1);
		txtAdd1.setColumns(10);
		
		JLabel lblAdd2 = new JLabel("Address Line 2");
		GridBagConstraints gbc_lblAdd2 = new GridBagConstraints();
		gbc_lblAdd2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdd2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd2.gridx = 0;
		gbc_lblAdd2.gridy = 6;
		add(lblAdd2, gbc_lblAdd2);
		
		txtAdd2 = new JTextField(add2);
		GridBagConstraints gbc_txtAdd2 = new GridBagConstraints();
		gbc_txtAdd2.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtAdd2.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd2.gridx = 1;
		gbc_txtAdd2.gridy = 6;
		add(txtAdd2, gbc_txtAdd2);
		txtAdd2.setColumns(10);
		
		JLabel lblSuburb = new JLabel("Suburb");
		GridBagConstraints gbc_lblSuburb = new GridBagConstraints();
		gbc_lblSuburb.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuburb.gridx = 0;
		gbc_lblSuburb.gridy = 7;
		add(lblSuburb, gbc_lblSuburb);
		
		txtSuburb = new JTextField(suburb);
		GridBagConstraints gbc_txtSuburb = new GridBagConstraints();
		gbc_txtSuburb.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSuburb.insets = new Insets(0, 0, 5, 0);
		gbc_txtSuburb.gridx = 1;
		gbc_txtSuburb.gridy = 7;
		add(txtSuburb, gbc_txtSuburb);
		txtSuburb.setColumns(10);
		
		JLabel lblPCode = new JLabel("Post code");
		GridBagConstraints gbc_lblPCode = new GridBagConstraints();
		gbc_lblPCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPCode.gridx = 0;
		gbc_lblPCode.gridy = 8;
		add(lblPCode, gbc_lblPCode);
		
		txtPCode = new JTextField(pCode);
		GridBagConstraints gbc_txtPCode = new GridBagConstraints();
		gbc_txtPCode.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPCode.gridx = 1;
		gbc_txtPCode.gridy = 8;
		add(txtPCode, gbc_txtPCode);
		txtPCode.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 9;
		add(lblState, gbc_lblState);
		
		JComboBox cmbState = new JComboBox(stateList);
		GridBagConstraints gbc_cmbState = new GridBagConstraints();
		gbc_cmbState.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbState.insets = new Insets(0, 0, 5, 0);
		gbc_cmbState.gridx = 1;
		gbc_cmbState.gridy = 9;
		add(cmbState, gbc_cmbState);
		cmbState.setSelectedItem(state);
		
		JLabel lblPhoneType = new JLabel("Phone type");
		GridBagConstraints gbc_lblPhoneType = new GridBagConstraints();
		gbc_lblPhoneType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneType.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneType.gridx = 0;
		gbc_lblPhoneType.gridy = 10;
		add(lblPhoneType, gbc_lblPhoneType);
		
		JComboBox cmbPhoneType = new JComboBox(phoneTypeList);
		cmbPhoneType.setSelectedItem(phoneType);
		GridBagConstraints gbc_cmbPhoneType = new GridBagConstraints();
		gbc_cmbPhoneType.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbPhoneType.insets = new Insets(0, 0, 5, 0);
		gbc_cmbPhoneType.gridx = 1;
		gbc_cmbPhoneType.gridy = 10;
		add(cmbPhoneType, gbc_cmbPhoneType);
		
		JLabel lblPhoneNo = new JLabel("Phone number");
		GridBagConstraints gbc_lblPhoneNo = new GridBagConstraints();
		gbc_lblPhoneNo.anchor = GridBagConstraints.NORTH;
		gbc_lblPhoneNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNo.gridx = 0;
		gbc_lblPhoneNo.gridy = 11;
		add(lblPhoneNo, gbc_lblPhoneNo);
		
		txtPhoneNo = new JTextField(phoneNo);
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPhoneNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 11;
		add(txtPhoneNo, gbc_txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.NORTH;
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 12;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField(email);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 12;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 13;
		add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField(username);
		txtUsername.setEditable(false);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 13;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblCurrentPassword = new JLabel("Current password");
		GridBagConstraints gbc_lblCurrentPassword = new GridBagConstraints();
		gbc_lblCurrentPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCurrentPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentPassword.gridx = 0;
		gbc_lblCurrentPassword.gridy = 14;
		add(lblCurrentPassword, gbc_lblCurrentPassword);
		
		pswCurrentPWord = new JPasswordField();
		GridBagConstraints gbc_pswCurrentPWord = new GridBagConstraints();
		gbc_pswCurrentPWord.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswCurrentPWord.insets = new Insets(0, 0, 5, 0);
		gbc_pswCurrentPWord.gridx = 1;
		gbc_pswCurrentPWord.gridy = 14;
		add(pswCurrentPWord, gbc_pswCurrentPWord);
		pswCurrentPWord.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New password");
		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
		gbc_lblNewPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPassword.gridx = 0;
		gbc_lblNewPassword.gridy = 15;
		add(lblNewPassword, gbc_lblNewPassword);
		
		pswNewPWord = new JPasswordField();
		GridBagConstraints gbc_pswNewPWord = new GridBagConstraints();
		gbc_pswNewPWord.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswNewPWord.insets = new Insets(0, 0, 5, 0);
		gbc_pswNewPWord.gridx = 1;
		gbc_pswNewPWord.gridy = 15;
		add(pswNewPWord, gbc_pswNewPWord);
		pswNewPWord.setColumns(10);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm new password");
		GridBagConstraints gbc_lblConfirmNewPassword = new GridBagConstraints();
		gbc_lblConfirmNewPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConfirmNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmNewPassword.gridx = 0;
		gbc_lblConfirmNewPassword.gridy = 16;
		add(lblConfirmNewPassword, gbc_lblConfirmNewPassword);
		
		pswConfirm = new JPasswordField();
		GridBagConstraints gbc_pswConfirm = new GridBagConstraints();
		gbc_pswConfirm.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswConfirm.insets = new Insets(0, 0, 5, 0);
		gbc_pswConfirm.gridx = 1;
		gbc_pswConfirm.gridy = 16;
		add(pswConfirm, gbc_pswConfirm);
		pswConfirm.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String FName = txtFName.getText();
				String lName = txtLName.getText();
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
				
				char[] currentPassword = pswCurrentPWord.getPassword();
				char[] newPassword = pswNewPWord.getPassword();
				char[] confirmNewPassword = pswConfirm.getPassword();
				
				new ValidateDetailChange(FName, lName, address, phone, username, email, currentPassword, newPassword, confirmNewPassword);
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 17;
		add(btnSubmit, gbc_btnSubmit);
		
	
	}
	
	// Constructor for admins who edit customer details
	public ChangeDetails(String FName, String LName, java.util.Date dob, String[] address,
			String[] phone, String username,
			String email, LoggedInView liv){
		String addType = address[0];
		String add1 = address[1];
		String add2 = address[2];
		String suburb = address[3];
		String pCode = address[4];
		String state = address[5];
		
		String phoneType = phone[0];
		String phoneNo = phone[1];

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{139, 157, 0, 0};
		gridBagLayout.rowHeights = new int[]{16, 22, 22, 0, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 25, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblDescription = new JLabel("<html>Use this form to edit your details</html>");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.fill = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridwidth = 2;
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 0;
		add(lblDescription, gbc_lblDescription);
		
		JLabel lblFName = new JLabel("First name");
		GridBagConstraints gbc_lblFName = new GridBagConstraints();
		gbc_lblFName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFName.gridx = 0;
		gbc_lblFName.gridy = 1;
		add(lblFName, gbc_lblFName);
		
		txtFName = new JTextField(FName);
		txtFName.setEditable(false);
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtFName.insets = new Insets(0, 0, 5, 5);
		gbc_txtFName.gridx = 1;
		gbc_txtFName.gridy = 1;
		add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblLName = new JLabel("Surname");
		GridBagConstraints gbc_lblLName = new GridBagConstraints();
		gbc_lblLName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblLName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLName.gridx = 0;
		gbc_lblLName.gridy = 2;
		add(lblLName, gbc_lblLName);
		
		txtLName = new JTextField(LName);
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtLName.insets = new Insets(0, 0, 5, 5);
		gbc_txtLName.gridx = 1;
		gbc_txtLName.gridy = 2;
		add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth");
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.anchor = GridBagConstraints.WEST;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 0;
		gbc_lblDateOfBirth.gridy = 3;
		add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		txtDOB = new JTextField(dob.toString());
		txtDOB.setEditable(false);
		GridBagConstraints gbc_txtDOB = new GridBagConstraints();
		gbc_txtDOB.anchor = GridBagConstraints.WEST;
		gbc_txtDOB.insets = new Insets(0, 0, 5, 5);
		gbc_txtDOB.gridx = 1;
		gbc_txtDOB.gridy = 3;
		add(txtDOB, gbc_txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblAddType = new JLabel("Address Type");
		GridBagConstraints gbc_lblAddType = new GridBagConstraints();
		gbc_lblAddType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddType.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddType.gridx = 0;
		gbc_lblAddType.gridy = 4;
		add(lblAddType, gbc_lblAddType);
		
		JComboBox cmbAddType = new JComboBox(addressTypeList);
		GridBagConstraints gbc_cmbAddType = new GridBagConstraints();
		gbc_cmbAddType.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbAddType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbAddType.gridx = 1;
		gbc_cmbAddType.gridy = 4;
		add(cmbAddType, gbc_cmbAddType);
		cmbAddType.setSelectedItem(addType);
		
		JLabel lblAdd1 = new JLabel("Address Line 1");
		GridBagConstraints gbc_lblAdd1 = new GridBagConstraints();
		gbc_lblAdd1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdd1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd1.gridx = 0;
		gbc_lblAdd1.gridy = 5;
		add(lblAdd1, gbc_lblAdd1);
		
		txtAdd1 = new JTextField(add1);
		GridBagConstraints gbc_txtAdd1 = new GridBagConstraints();
		gbc_txtAdd1.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtAdd1.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdd1.gridx = 1;
		gbc_txtAdd1.gridy = 5;
		add(txtAdd1, gbc_txtAdd1);
		txtAdd1.setColumns(10);
		
		JLabel lblAdd2 = new JLabel("Address Line 2");
		GridBagConstraints gbc_lblAdd2 = new GridBagConstraints();
		gbc_lblAdd2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAdd2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdd2.gridx = 0;
		gbc_lblAdd2.gridy = 6;
		add(lblAdd2, gbc_lblAdd2);
		
		txtAdd2 = new JTextField(add2);
		GridBagConstraints gbc_txtAdd2 = new GridBagConstraints();
		gbc_txtAdd2.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtAdd2.insets = new Insets(0, 0, 5, 5);
		gbc_txtAdd2.gridx = 1;
		gbc_txtAdd2.gridy = 6;
		add(txtAdd2, gbc_txtAdd2);
		txtAdd2.setColumns(10);
		
		JLabel lblSuburb = new JLabel("Suburb");
		GridBagConstraints gbc_lblSuburb = new GridBagConstraints();
		gbc_lblSuburb.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_lblSuburb.gridx = 0;
		gbc_lblSuburb.gridy = 7;
		add(lblSuburb, gbc_lblSuburb);
		
		txtSuburb = new JTextField(suburb);
		GridBagConstraints gbc_txtSuburb = new GridBagConstraints();
		gbc_txtSuburb.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSuburb.insets = new Insets(0, 0, 5, 5);
		gbc_txtSuburb.gridx = 1;
		gbc_txtSuburb.gridy = 7;
		add(txtSuburb, gbc_txtSuburb);
		txtSuburb.setColumns(10);
		
		JLabel lblPCode = new JLabel("Post code");
		GridBagConstraints gbc_lblPCode = new GridBagConstraints();
		gbc_lblPCode.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPCode.insets = new Insets(0, 0, 5, 5);
		gbc_lblPCode.gridx = 0;
		gbc_lblPCode.gridy = 8;
		add(lblPCode, gbc_lblPCode);
		
		txtPCode = new JTextField(pCode);
		GridBagConstraints gbc_txtPCode = new GridBagConstraints();
		gbc_txtPCode.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPCode.insets = new Insets(0, 0, 5, 5);
		gbc_txtPCode.gridx = 1;
		gbc_txtPCode.gridy = 8;
		add(txtPCode, gbc_txtPCode);
		txtPCode.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 9;
		add(lblState, gbc_lblState);
		
		JComboBox cmbState = new JComboBox(stateList);
		GridBagConstraints gbc_cmbState = new GridBagConstraints();
		gbc_cmbState.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbState.insets = new Insets(0, 0, 5, 5);
		gbc_cmbState.gridx = 1;
		gbc_cmbState.gridy = 9;
		add(cmbState, gbc_cmbState);
		cmbState.setSelectedItem(state);
		
		JLabel lblPhoneType = new JLabel("Phone type");
		GridBagConstraints gbc_lblPhoneType = new GridBagConstraints();
		gbc_lblPhoneType.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneType.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneType.gridx = 0;
		gbc_lblPhoneType.gridy = 10;
		add(lblPhoneType, gbc_lblPhoneType);
		
		JComboBox cmbPhoneType = new JComboBox(phoneTypeList);
		cmbPhoneType.setSelectedItem(phoneType);
		GridBagConstraints gbc_cmbPhoneType = new GridBagConstraints();
		gbc_cmbPhoneType.anchor = GridBagConstraints.NORTHWEST;
		gbc_cmbPhoneType.insets = new Insets(0, 0, 5, 5);
		gbc_cmbPhoneType.gridx = 1;
		gbc_cmbPhoneType.gridy = 10;
		add(cmbPhoneType, gbc_cmbPhoneType);
		
		JLabel lblPhoneNo = new JLabel("Phone number");
		GridBagConstraints gbc_lblPhoneNo = new GridBagConstraints();
		gbc_lblPhoneNo.anchor = GridBagConstraints.NORTH;
		gbc_lblPhoneNo.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneNo.gridx = 0;
		gbc_lblPhoneNo.gridy = 11;
		add(lblPhoneNo, gbc_lblPhoneNo);
		
		txtPhoneNo = new JTextField(phoneNo);
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPhoneNo.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 11;
		add(txtPhoneNo, gbc_txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.NORTH;
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 12;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField(email);
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 12;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 13;
		add(lblUsername, gbc_lblUsername);
		
		txtUsername = new JTextField(username);
		txtUsername.setEditable(false);
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 13;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblCurrentPassword = new JLabel("Current password");
		GridBagConstraints gbc_lblCurrentPassword = new GridBagConstraints();
		gbc_lblCurrentPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCurrentPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblCurrentPassword.gridx = 0;
		gbc_lblCurrentPassword.gridy = 14;
		add(lblCurrentPassword, gbc_lblCurrentPassword);
		
		pswCurrentPWord = new JPasswordField();
		GridBagConstraints gbc_pswCurrentPWord = new GridBagConstraints();
		gbc_pswCurrentPWord.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswCurrentPWord.insets = new Insets(0, 0, 5, 5);
		gbc_pswCurrentPWord.gridx = 1;
		gbc_pswCurrentPWord.gridy = 14;
		add(pswCurrentPWord, gbc_pswCurrentPWord);
		pswCurrentPWord.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New password");
		GridBagConstraints gbc_lblNewPassword = new GridBagConstraints();
		gbc_lblNewPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewPassword.gridx = 0;
		gbc_lblNewPassword.gridy = 15;
		add(lblNewPassword, gbc_lblNewPassword);
		
		pswNewPWord = new JPasswordField();
		GridBagConstraints gbc_pswNewPWord = new GridBagConstraints();
		gbc_pswNewPWord.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswNewPWord.insets = new Insets(0, 0, 5, 5);
		gbc_pswNewPWord.gridx = 1;
		gbc_pswNewPWord.gridy = 15;
		add(pswNewPWord, gbc_pswNewPWord);
		pswNewPWord.setColumns(10);
		
		JLabel lblConfirmNewPassword = new JLabel("Confirm new password");
		GridBagConstraints gbc_lblConfirmNewPassword = new GridBagConstraints();
		gbc_lblConfirmNewPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblConfirmNewPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmNewPassword.gridx = 0;
		gbc_lblConfirmNewPassword.gridy = 16;
		add(lblConfirmNewPassword, gbc_lblConfirmNewPassword);
		
		pswConfirm = new JPasswordField();
		GridBagConstraints gbc_pswConfirm = new GridBagConstraints();
		gbc_pswConfirm.anchor = GridBagConstraints.NORTHWEST;
		gbc_pswConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_pswConfirm.gridx = 1;
		gbc_pswConfirm.gridy = 16;
		add(pswConfirm, gbc_pswConfirm);
		pswConfirm.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String FName = txtFName.getText();
				String lName = txtLName.getText();
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
				
				char[] currentPassword = pswCurrentPWord.getPassword();
				char[] newPassword = pswNewPWord.getPassword();
				char[] confirmNewPassword = pswConfirm.getPassword();
				
				new ValidateDetailChange(FName, lName, address, phone, username, email, currentPassword, newPassword, confirmNewPassword);
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 17;
		add(btnSubmit, gbc_btnSubmit);
		
		JButton btnDelete = new JButton("Delete account");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogInTab lit = new LogInTab(liv, cs);
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 17;
		add(btnDelete, gbc_btnDelete);
	}
	
	
	// Set the instance of the CustomerSearch object so that the variables are carried over
	public void setSearch(controller.CustomerSearch customerSearch){
		this.cs = customerSearch;
	}
}
