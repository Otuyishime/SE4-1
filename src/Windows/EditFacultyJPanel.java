package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditFacultyJPanel extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public EditFacultyJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Edit information about a Faculty");
		lblCreateAndAdd.setBounds(245, 56, 210, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(172, 121, 61, 16);
		add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(245, 116, 200, 26);
		add(textField);
		textField.setColumns(10);
		
		// Update button - it updates an edited faculty info from the editing page
		JButton btn_updateEditedFaculty = new JButton("Update");
		btn_updateEditedFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get new info from text fields, and update a current faculty to save updated info
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_updateEditedFaculty.setBounds(172, 340, 100, 30);
		add(btn_updateEditedFaculty);
		
		// Cancel button - it cancels the action of editing a faculty 
		// and goes back to the faculty list page
		JButton btn_cancelEditedFaculty = new JButton("Cancel");
		btn_cancelEditedFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the faculty list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelEditedFaculty.setBounds(306, 340, 100, 30);
		add(btn_cancelEditedFaculty);

	}

}
