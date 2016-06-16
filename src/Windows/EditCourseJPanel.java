package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditCourseJPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public EditCourseJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Edit information about a course");
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
		
		// Update button - it updates an edited course info from the editing page
		JButton btn_updateEditedCourse = new JButton("Update");
		btn_updateEditedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get new info from text fields, and update a current course to save updated info
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_updateEditedCourse.setBounds(172, 340, 100, 30);
		add(btn_updateEditedCourse);
		
		// Cancel button - it cancels the action of editing a course 
		// and goes back to the course list page
		JButton btn_cancelEditedCourse = new JButton("Cancel");
		btn_cancelEditedCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelEditedCourse.setBounds(306, 340, 100, 30);
		add(btn_cancelEditedCourse);


	}

}
