package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class LogOut extends JPanel {

	/**
	 * Create the panel.
	 * @param loggedInView 
	 */
	public LogOut(final LoggedInView loggedInView) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{446, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to log-out?");
		lblAreYouSure.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAreYouSure = new GridBagConstraints();
		gbc_lblAreYouSure.anchor = GridBagConstraints.WEST;
		gbc_lblAreYouSure.insets = new Insets(0, 0, 5, 0);
		gbc_lblAreYouSure.gridx = 0;
		gbc_lblAreYouSure.gridy = 0;
		add(lblAreYouSure, gbc_lblAreYouSure);
		
		JButton btnLogOut = new JButton("Log-out");
		btnLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loggedInView.setVisible(false);
				loggedInView.dispose();
				
				JFrame main = new Main();
				main.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnLogOut = new GridBagConstraints();
		gbc_btnLogOut.anchor = GridBagConstraints.WEST;
		gbc_btnLogOut.gridx = 0;
		gbc_btnLogOut.gridy = 2;
		add(btnLogOut, gbc_btnLogOut);

	}
}
