package Windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.University;

import java.awt.Font;

public class CourseDetailsJPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public CourseDetailsJPanel(JFrame currentFrame, Course currentCourse, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		JLabel lbl_title = new JLabel("Course Details - " + currentCourse.getCourseName());
		lbl_title.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_title.setBounds(50, 56, 500, 30);
		add(lbl_title);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 121, 61, 16);
		add(lblName);
		
		// Back button - it takes you back to the course list view
		JButton btn_backToCourseList = new JButton("< Back");
		btn_backToCourseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame, university));
				currentFrame.revalidate();					
			}
		});
		btn_backToCourseList.setBounds(50, 500, 117, 30);
		add(btn_backToCourseList);
		
		
		JLabel lbl_courseName = new JLabel(currentCourse.getCourseCode() + " - " + currentCourse.getCourseName());
		lbl_courseName.setBounds(100, 121, 400, 16);
		add(lbl_courseName);
	}
}
