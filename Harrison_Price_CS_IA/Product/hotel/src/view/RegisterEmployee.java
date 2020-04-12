package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import controller.Validate;
import controller.ValidateEmployee;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class RegisterEmployee extends JPanel {
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtAdd1;
	private JTextField txtAdd2;
	private JTextField txtSuburb;
	private JTextField txtPCode;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JPasswordField pswPassword;
	private JPasswordField pswConfirm;
	
	// Arrays to be put into combo boxes
	private String[] state = {"QLD", "NSW", "VIC", "TAS", "SA", "WA", "NT", "ACT"};
	private String[] department = {"Reception", "Dining", "Cleaning", "Management"};
	private String[] role = {"Manager", "Cleaner", "Reception clerk", "Chef", "General manager"};

	/**
	 * Create the panel.
	 */
	public RegisterEmployee() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblInstructions = new JLabel("Please use the form below to register a new employee.");
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.gridwidth = 2;
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 0;
		add(lblInstructions, gbc_lblInstructions);
		
		JLabel lblfirstName = new JLabel("<html>First name <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblfirstName = new GridBagConstraints();
		gbc_lblfirstName.fill = GridBagConstraints.BOTH;
		gbc_lblfirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblfirstName.gridx = 0;
		gbc_lblfirstName.gridy = 1;
		add(lblfirstName, gbc_lblfirstName);
		
		txtFName = new JTextField();
		GridBagConstraints gbc_txtFName = new GridBagConstraints();
		gbc_txtFName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtFName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFName.gridx = 1;
		gbc_txtFName.gridy = 1;
		add(txtFName, gbc_txtFName);
		txtFName.setColumns(10);
		
		JLabel lblsurname = new JLabel("<html>Surname <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblsurname = new GridBagConstraints();
		gbc_lblsurname.fill = GridBagConstraints.BOTH;
		gbc_lblsurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblsurname.gridx = 0;
		gbc_lblsurname.gridy = 2;
		add(lblsurname, gbc_lblsurname);
		
		txtLName = new JTextField();
		GridBagConstraints gbc_txtLName = new GridBagConstraints();
		gbc_txtLName.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtLName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLName.gridx = 1;
		gbc_txtLName.gridy = 2;
		add(txtLName, gbc_txtLName);
		txtLName.setColumns(10);
		
		JLabel lblDateOfBirth = new JLabel("<html>Date of birth <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblDateOfBirth = new GridBagConstraints();
		gbc_lblDateOfBirth.fill = GridBagConstraints.BOTH;
		gbc_lblDateOfBirth.insets = new Insets(0, 0, 5, 5);
		gbc_lblDateOfBirth.gridx = 0;
		gbc_lblDateOfBirth.gridy = 3;
		add(lblDateOfBirth, gbc_lblDateOfBirth);
		
		JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.anchor = GridBagConstraints.WEST;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.VERTICAL;
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 3;
		add(dateChooser, gbc_dateChooser);
		
		JLabel lblAddress = new JLabel("<html>Address line 1 <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.BOTH;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 0;
		gbc_lblAddress.gridy = 4;
		add(lblAddress, gbc_lblAddress);
		
		txtAdd1 = new JTextField();
		GridBagConstraints gbc_txtAdd1 = new GridBagConstraints();
		gbc_txtAdd1.anchor = GridBagConstraints.WEST;
		gbc_txtAdd1.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd1.gridx = 1;
		gbc_txtAdd1.gridy = 4;
		add(txtAdd1, gbc_txtAdd1);
		txtAdd1.setColumns(10);
		
		JLabel lblAddressLine = new JLabel("Address line 2");
		GridBagConstraints gbc_lblAddressLine = new GridBagConstraints();
		gbc_lblAddressLine.fill = GridBagConstraints.BOTH;
		gbc_lblAddressLine.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddressLine.gridx = 0;
		gbc_lblAddressLine.gridy = 5;
		add(lblAddressLine, gbc_lblAddressLine);
		
		txtAdd2 = new JTextField();
		GridBagConstraints gbc_txtAdd2 = new GridBagConstraints();
		gbc_txtAdd2.anchor = GridBagConstraints.WEST;
		gbc_txtAdd2.insets = new Insets(0, 0, 5, 0);
		gbc_txtAdd2.gridx = 1;
		gbc_txtAdd2.gridy = 5;
		add(txtAdd2, gbc_txtAdd2);
		txtAdd2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("<html>Suburb <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 6;
		add(lblNewLabel, gbc_lblNewLabel);
		
		txtSuburb = new JTextField();
		GridBagConstraints gbc_txtSuburb = new GridBagConstraints();
		gbc_txtSuburb.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtSuburb.insets = new Insets(0, 0, 5, 0);
		gbc_txtSuburb.gridx = 1;
		gbc_txtSuburb.gridy = 6;
		add(txtSuburb, gbc_txtSuburb);
		txtSuburb.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Post code <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 7;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtPCode = new JTextField();
		GridBagConstraints gbc_txtPCode = new GridBagConstraints();
		gbc_txtPCode.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPCode.insets = new Insets(0, 0, 5, 0);
		gbc_txtPCode.gridx = 1;
		gbc_txtPCode.gridy = 7;
		add(txtPCode, gbc_txtPCode);
		txtPCode.setColumns(10);
		
		JLabel lblState = new JLabel("<html>State <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblState = new GridBagConstraints();
		gbc_lblState.fill = GridBagConstraints.BOTH;
		gbc_lblState.insets = new Insets(0, 0, 5, 5);
		gbc_lblState.gridx = 0;
		gbc_lblState.gridy = 8;
		add(lblState, gbc_lblState);
		
		JComboBox cmbState = new JComboBox(state);
		GridBagConstraints gbc_cmbState = new GridBagConstraints();
		gbc_cmbState.anchor = GridBagConstraints.WEST;
		gbc_cmbState.insets = new Insets(0, 0, 5, 0);
		gbc_cmbState.gridx = 1;
		gbc_cmbState.gridy = 8;
		add(cmbState, gbc_cmbState);
		
		JLabel lblMobilePhoneNumber = new JLabel("<html>Mobile phone number <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblMobilePhoneNumber = new GridBagConstraints();
		gbc_lblMobilePhoneNumber.fill = GridBagConstraints.BOTH;
		gbc_lblMobilePhoneNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblMobilePhoneNumber.gridx = 0;
		gbc_lblMobilePhoneNumber.gridy = 9;
		add(lblMobilePhoneNumber, gbc_lblMobilePhoneNumber);
		
		txtPhoneNo = new JTextField();
		GridBagConstraints gbc_txtPhoneNo = new GridBagConstraints();
		gbc_txtPhoneNo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtPhoneNo.insets = new Insets(0, 0, 5, 0);
		gbc_txtPhoneNo.gridx = 1;
		gbc_txtPhoneNo.gridy = 9;
		add(txtPhoneNo, gbc_txtPhoneNo);
		txtPhoneNo.setColumns(10);
		
		JLabel lblEmail = new JLabel("<html>Email <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 10;
		add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 10;
		add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Username <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 11;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.anchor = GridBagConstraints.WEST;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 11;
		add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("<html>Password <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 12;
		add(lblPassword, gbc_lblPassword);
		
		pswPassword = new JPasswordField();
		GridBagConstraints gbc_pswPassword = new GridBagConstraints();
		gbc_pswPassword.anchor = GridBagConstraints.WEST;
		gbc_pswPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pswPassword.gridx = 1;
		gbc_pswPassword.gridy = 12;
		add(pswPassword, gbc_pswPassword);
		pswPassword.setColumns(10);
		
		JLabel lblConfirmPassword = new JLabel("<html>Confirm password <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblConfirmPassword = new GridBagConstraints();
		gbc_lblConfirmPassword.fill = GridBagConstraints.BOTH;
		gbc_lblConfirmPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirmPassword.gridx = 0;
		gbc_lblConfirmPassword.gridy = 13;
		add(lblConfirmPassword, gbc_lblConfirmPassword);
		
		pswConfirm = new JPasswordField();
		GridBagConstraints gbc_pswConfirm = new GridBagConstraints();
		gbc_pswConfirm.anchor = GridBagConstraints.WEST;
		gbc_pswConfirm.insets = new Insets(0, 0, 5, 0);
		gbc_pswConfirm.gridx = 1;
		gbc_pswConfirm.gridy = 13;
		add(pswConfirm, gbc_pswConfirm);
		pswConfirm.setColumns(10);
		
		JLabel lblDepartment = new JLabel("<html>Department <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.fill = GridBagConstraints.BOTH;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 0;
		gbc_lblDepartment.gridy = 14;
		add(lblDepartment, gbc_lblDepartment);
		
		JComboBox cmbDepartment = new JComboBox(department);
		GridBagConstraints gbc_cmbDepartment = new GridBagConstraints();
		gbc_cmbDepartment.anchor = GridBagConstraints.WEST;
		gbc_cmbDepartment.insets = new Insets(0, 0, 5, 0);
		gbc_cmbDepartment.gridx = 1;
		gbc_cmbDepartment.gridy = 14;
		add(cmbDepartment, gbc_cmbDepartment);
		
		JLabel lblRole = new JLabel("<html>Role <font color=\"red\">*</font></html>");
		GridBagConstraints gbc_lblRole = new GridBagConstraints();
		gbc_lblRole.fill = GridBagConstraints.BOTH;
		gbc_lblRole.insets = new Insets(0, 0, 5, 5);
		gbc_lblRole.gridx = 0;
		gbc_lblRole.gridy = 15;
		add(lblRole, gbc_lblRole);
		
		JComboBox cmbRole = new JComboBox(role);
		GridBagConstraints gbc_cmbRole = new GridBagConstraints();
		gbc_cmbRole.insets = new Insets(0, 0, 5, 0);
		gbc_cmbRole.anchor = GridBagConstraints.WEST;
		gbc_cmbRole.gridx = 1;
		gbc_cmbRole.gridy = 15;
		add(cmbRole, gbc_cmbRole);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// Collect the data from the text boxes
				String fName = txtFName.getText();
				String lName = txtLName.getText();
				Date dob = dateChooser.getDate();
				
				String addressType = "Home";
				String add1 = txtAdd1.getText();
				String add2 = txtAdd2.getText();
				String suburb = txtSuburb.getText();
				String pCode = txtPCode.getText();
				String state = cmbState.getSelectedItem().toString();
				String[] address = {addressType, add1, add2, suburb, pCode, state};
				String phoneType = "Mobile";
				String phoneNumber = txtPhoneNo.getText();
				String[] phone = {phoneType, phoneNumber};
				
				String username = txtUsername.getText();
				String email = txtEmail.getText();
				
				// Get the password (as an array)
				char[] password = pswPassword.getPassword();
				char[] confirmPassword = pswConfirm.getPassword();
				
				String department = cmbDepartment.getSelectedItem().toString();
				String role = cmbRole.getSelectedItem().toString();
				
				System.out.println(dob.toString());
				
				ValidateEmployee v = new ValidateEmployee(fName, lName, dob, address, phone, username, password, confirmPassword, email, department, role);
			}
		});
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.gridx = 1;
		gbc_btnRegister.gridy = 16;
		add(btnRegister, gbc_btnRegister);

	}

}
