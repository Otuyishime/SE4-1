package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditDegreePlanJPanel extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public EditDegreePlanJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Edit information about a Degree Plan");
		lblCreateAndAdd.setBounds(245, 56, 250, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(172, 121, 61, 16);
		add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(245, 116, 200, 26);
		add(textField);
		textField.setColumns(10);
		
		// Update button - it updates an edited DegreePlan info from the editing page
		JButton btn_updateEditedDegreePlan = new JButton("Update");
		btn_updateEditedDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get new info from text fields, and update a current DegreePlan to save updated info
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_updateEditedDegreePlan.setBounds(172, 340, 100, 30);
		add(btn_updateEditedDegreePlan);
		
		// Cancel button - it cancels the action of editing a DegreePlan 
		// and goes back to the DegreePlan list page
		JButton btn_cancelEditedDegreePlan = new JButton("Cancel");
		btn_cancelEditedDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the DegreePlan list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelEditedDegreePlan.setBounds(306, 340, 100, 30);
		add(btn_cancelEditedDegreePlan);


	}

}
