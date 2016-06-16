package Windows;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class MainJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainJPanel() {
		setBounds(new Rectangle(0, 0, 700, 600));
		setLayout(null);
		
		JLabel lblGraduateSchool = new JLabel("Graduate School's Course Scheduling Sysytem");
		lblGraduateSchool.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblGraduateSchool.setBounds(122, 305, 500, 30);
		add(lblGraduateSchool);
		
		JLabel lbluniversityName = new JLabel("(University Name)");
		lbluniversityName.setBounds(268, 132, 116, 30);
		add(lbluniversityName);

	}
}
