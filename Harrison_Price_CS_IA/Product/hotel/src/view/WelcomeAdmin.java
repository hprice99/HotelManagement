package view;

import javax.swing.JPanel;

import controller.CurrentUser;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

public class WelcomeAdmin extends JPanel {
	
	private String FName = CurrentUser.getFName();

	/**
	 * Create the panel.
	 * @param bookings 
	 */
	public WelcomeAdmin(int bookings) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{211, 0};
		gridBagLayout.rowHeights = new int[]{49, 16, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		JLabel lblWelcome = new JLabel("Welcome " + FName +". There are " + bookings + " check-ins today.");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.anchor = GridBagConstraints.WEST;
		gbc_lblWelcome.gridx = 0;
		gbc_lblWelcome.gridy = 0;
		add(lblWelcome, gbc_lblWelcome);

	}

}
