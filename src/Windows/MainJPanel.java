package Windows;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;

import OcGraduateSystemClasses.University;

import java.awt.Font;

public class MainJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainJPanel(University university) {
		setBounds(new Rectangle(0, 0, 700, 600));
		setLayout(null);
		
		JLabel lbluniversityName = new JLabel(university.getAbbreviation() + " - " + university.getName());
		lbluniversityName.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lbluniversityName.setBounds(120, 132, 500, 30);
		add(lbluniversityName);
		
		JLabel lblGraduateSchool = new JLabel("Graduate School's Course Scheduling Sysytem");
		lblGraduateSchool.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblGraduateSchool.setBounds(120, 305, 500, 30);
		add(lblGraduateSchool);
	}
}
