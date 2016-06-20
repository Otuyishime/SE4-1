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
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddDegreePlanJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Degree Plan");
		lblCreateAndAdd.setBounds(245, 56, 220, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(172, 121, 61, 16);
		add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(245, 116, 200, 26);
		add(textField);
		textField.setColumns(10);
		
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


	}

}
