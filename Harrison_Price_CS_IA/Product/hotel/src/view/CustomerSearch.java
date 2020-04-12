package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.Font;

public class CustomerSearch extends JPanel {
	private JTextField txtUser;

	/**
	 * Create the panel.
	 * @param loggedInView 
	 */
	public CustomerSearch(LoggedInView loggedInView, String type) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{190, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblUseTheBox = new JLabel("Enter a customer's username below to search for their account.");
		lblUseTheBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblUseTheBox = new GridBagConstraints();
		gbc_lblUseTheBox.gridwidth = 2;
		gbc_lblUseTheBox.anchor = GridBagConstraints.WEST;
		gbc_lblUseTheBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblUseTheBox.gridx = 0;
		gbc_lblUseTheBox.gridy = 0;
		add(lblUseTheBox, gbc_lblUseTheBox);
		
		txtUser = new JTextField();
		txtUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					String username = txtUser.getText();
					controller.CustomerSearch cs = new controller.CustomerSearch(loggedInView, username);
					cs.search(type);
				}
			}
		});
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.insets = new Insets(0, 0, 0, 5);
		gbc_txtUser.gridx = 0;
		gbc_txtUser.gridy = 2;
		add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = txtUser.getText();
				controller.CustomerSearch cs = new controller.CustomerSearch(loggedInView, username);
				cs.search(type);
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.anchor = GridBagConstraints.WEST;
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 2;
		add(btnSearch, gbc_btnSearch);

	}

}
