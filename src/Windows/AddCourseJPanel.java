package Windows;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCourseJPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddCourseJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Course");
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
		
		// Add button - it adds a new course from the creation page
		JButton btn_addNewCourse = new JButton("Add");
		btn_addNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new course and add it to the list of courses 
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_addNewCourse.setBounds(172, 340, 100, 30);
		add(btn_addNewCourse);
		
		// Cancel button - it cancels the action of creating a new course 
		// and goes back to the course list page
		JButton btn_cancelNewCourse = new JButton("Cancel");
		btn_cancelNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewCourse.setBounds(306, 340, 100, 30);
		add(btn_cancelNewCourse);
	}
}
