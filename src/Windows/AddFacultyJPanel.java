package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddFacultyJPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddFacultyJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Faculty");
		lblCreateAndAdd.setBounds(245, 56, 200, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(172, 121, 61, 16);
		add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(245, 116, 200, 26);
		add(textField);
		textField.setColumns(10);
		
		// Add button - it adds a new faculty from the creation page
		JButton btn_addNewFaculty = new JButton("Add");
		btn_addNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new faculty and add it to the list of courses 
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_addNewFaculty.setBounds(172, 340, 100, 30);
		add(btn_addNewFaculty);
		
		// Cancel button - it cancels the action of creating a new faculty 
		// and goes back to the faculty list page
		JButton btn_cancelNewFaculty = new JButton("Cancel");
		btn_cancelNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewFaculty.setBounds(306, 340, 100, 30);
		add(btn_cancelNewFaculty);

	}

}
