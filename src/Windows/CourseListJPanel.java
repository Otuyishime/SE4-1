package Windows;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CourseListJPanel extends JPanel {
	private JButton btn_coursesListToMain;

	/**
	 * Create the panel.
	 */
	public CourseListJPanel(JFrame currentFrame) {
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblListOfAvailable = new JLabel("List of Available Courses");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(100, 20, 300, 25);
		add(lblListOfAvailable);
		
		JList list_courses = new JList();
		list_courses.setBounds(100, 50, 300, 500);
		add(list_courses);
		
		// Add button - it leads to a new course creation course
		JButton btn_createNewCourse = new JButton("Add");
		btn_createNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddCourseJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_createNewCourse.setBounds(500, 50, 100, 30);
		add(btn_createNewCourse);
		
		// Edit button - it takes you to a course edit page
		JButton btn_editCourseInfo = new JButton("Edit");
		btn_editCourseInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected course and pass its information to the edit page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditCourseJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_editCourseInfo.setBounds(500, 100, 100, 30);
		add(btn_editCourseInfo);
		
		// Delete button - it deletes the selected course from the list
		JButton btn_deleteCourse = new JButton("Delete");
		btn_deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected course and deleted if from the list
				
				// stay on the same page - refresh 
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_deleteCourse.setBounds(500, 150, 100, 30);
		add(btn_deleteCourse);
		
		// Back button from the list of courses back to main
		btn_coursesListToMain = new JButton("< Back");
		btn_coursesListToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel());
				currentFrame.revalidate();	
			}
		});
		btn_coursesListToMain.setBounds(500, 200, 100, 30);
		add(btn_coursesListToMain);

	}
}
