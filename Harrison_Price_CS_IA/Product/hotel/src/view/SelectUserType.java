package view;

import view.WelcomeAdmin;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class SelectUserType extends JPanel {

	/**
	 * Create the panel.
	 */
	public SelectUserType(LoggedInView l) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{125, 125, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblinstruction = new JLabel("Please select the type of user you will register");
		lblinstruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblinstruction = new GridBagConstraints();
		gbc_lblinstruction.gridwidth = 2;
		gbc_lblinstruction.insets = new Insets(0, 0, 5, 5);
		gbc_lblinstruction.gridx = 0;
		gbc_lblinstruction.gridy = 0;
		add(lblinstruction, gbc_lblinstruction);
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				l.changePanel("customer");
			}
		});
		GridBagConstraints gbc_btnCustomer = new GridBagConstraints();
		gbc_btnCustomer.insets = new Insets(0, 0, 0, 5);
		gbc_btnCustomer.gridx = 0;
		gbc_btnCustomer.gridy = 2;
		add(btnCustomer, gbc_btnCustomer);
		
		JButton btnEmployee = new JButton("Employee");
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				l.changePanel("admin");
			}
		});
		GridBagConstraints gbc_btnEmployee = new GridBagConstraints();
		gbc_btnEmployee.gridx = 1;
		gbc_btnEmployee.gridy = 2;
		add(btnEmployee, gbc_btnEmployee);

	}

}
