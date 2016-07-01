package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OcGraduateSystemClasses.University;

public class AddDegreePlanJPanel extends JPanel {
	
	private JTextField textField_code;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public AddDegreePlanJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Degree Plan");
		lblCreateAndAdd.setBounds(245, 56, 220, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Code:");
		lblName.setBounds(100, 120, 85, 25);
		add(lblName);
		
		textField_code = new JTextField();
		textField_code.setToolTipText("");
		textField_code.setBounds(200, 120, 250, 25);
		add(textField_code);
		textField_code.setColumns(10);
		
		// Add button - it adds a new DegreePlan from the creation page
		JButton btn_addNewDegreePlan = new JButton("Add");
		btn_addNewDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new DegreePlan and add it to the list of DegreePlans 
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewDegreePlan.setBounds(172, 340, 100, 30);
		add(btn_addNewDegreePlan);
		
		// Cancel button - it cancels the action of creating a new DegreePlan 
		// and goes back to the DegreePlan list page
		JButton btn_cancelNewDegreePlan = new JButton("Cancel");
		btn_cancelNewDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the DegreePlan list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewDegreePlan.setBounds(306, 340, 100, 30);
		add(btn_cancelNewDegreePlan);
		
		JLabel lblNewLabel = new JLabel("Grad School:");
		lblNewLabel.setBounds(100, 150, 85, 25);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(200, 149, 250, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(100, 180, 85, 25);
		add(lblName_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(200, 180, 250, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblForecast = new JLabel("Forecast:");
		lblForecast.setBounds(100, 210, 85, 25);
		add(lblForecast);
		
		textField_2 = new JTextField();
		textField_2.setBounds(200, 210, 250, 25);
		add(textField_2);
		textField_2.setColumns(10);


	}
}
