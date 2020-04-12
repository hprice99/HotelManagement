package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import controller.CurrentUser;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Welcome extends JPanel {

	private String FName = CurrentUser.getFName();
	
	/**
	 * Create the panel.
	 */
	public Welcome(LoggedInView liv) {
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome " + FName + ". You have successfully logged-in.");
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcome.setBounds(12, 13, 386, 16);
		add(lblWelcome);
		
		JButton btnBook = new JButton("Book a room");
		btnBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				liv.setTab(1);
			}
		});
		btnBook.setBounds(40, 177, 150, 25);
		add(btnBook);
		
	}
}

