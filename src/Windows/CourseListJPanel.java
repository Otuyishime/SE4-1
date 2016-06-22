package Windows;

import java.awt.*;
import javax.swing.*;
import com.csvreader.CsvReader;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;

import java.awt.Font;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

//	TODO - need to add error handling 
// 	1. cancel selection - if needed!

public class CourseListJPanel extends JPanel {
	
	JScrollPane scrollpane;
	DefaultListModel <Course> listModel;
	JList list_courses;
	JLabel lblListOfAvailable;
	JButton btn_addNewCourse;
	JButton btn_viewCourseDetails;
	JButton btn_editCourseInfo;
	JButton btn_deleteCourse;
	JButton btn_coursesListToMain;
	
	/**
	 * Create the panel.
	 */
	public CourseListJPanel(JFrame currentFrame, University university) {
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		// title label
		lblListOfAvailable = new JLabel("List of Available Courses");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(50, 20, 300, 25);
		add(lblListOfAvailable);
		
		// Add button - it leads to a new course creation page
		btn_addNewCourse = new JButton("Add");
		btn_addNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddCourseJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewCourse.setBounds(500, 50, 100, 30);
		add(btn_addNewCourse);
		
		// View button - it lets you view details about a selected course
		btn_viewCourseDetails = new JButton("View");
		btn_viewCourseDetails.setEnabled(false);
		btn_viewCourseDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - get the selected course and send it to the view JPanel
				// the work here is done, we have a selected course, just need to work on the edit page	
				Course selectedCourse = (Course) list_courses.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseDetailsJPanel(currentFrame, selectedCourse, university));
				currentFrame.revalidate();	
			}
		});
		btn_viewCourseDetails.setBounds(500, 100, 100, 30);
		add(btn_viewCourseDetails);
		
		// Edit button - it takes you to a course edit page
		btn_editCourseInfo = new JButton("Edit");
		btn_editCourseInfo.setEnabled(false);
		btn_editCourseInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected course and pass its information to the edit page
				// this is partially done - just need to add more fields on the edit page
				// it is going to look exactly like the add course page with pre-filled fields
				
				Course selectedCourse = (Course) list_courses.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditCourseJPanel(currentFrame, university, selectedCourse));
				currentFrame.revalidate();	
			}
		});
		btn_editCourseInfo.setBounds(500, 150, 100, 30);
		add(btn_editCourseInfo);
		
		// Delete button - it deletes the selected course from the list
		btn_deleteCourse = new JButton("Delete");
		btn_deleteCourse.setEnabled(false);
		btn_deleteCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - almost done - just add error handling code
				// get the selected course and deleted if from the list
				
				Course selectedCourse = (Course) list_courses.getSelectedValue();
				university.removeCourse(selectedCourse);
				listModel.removeElement(selectedCourse);	
			}
		});
		
		btn_deleteCourse.setBounds(500, 200, 100, 30);
		add(btn_deleteCourse);
		
		// Back button from the list of courses back to main
		btn_coursesListToMain = new JButton("< Back");
		btn_coursesListToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_coursesListToMain.setBounds(500, 250, 100, 30);
		add(btn_coursesListToMain);	
		
		// get the list of courses and create a list model for them 
		// the JList needs to be added to the scroll pane to give it the scrolling ability
		listModel = new DefaultListModel<>();
		for (Course course : university.getCourses())
			listModel.addElement(course);
		list_courses = new JList(listModel);
		list_courses.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				// allow view, edit and delete only when there is a selected item
				if (list_courses.getSelectedValue() != null)
				{
					btn_viewCourseDetails.setEnabled(true);
					btn_editCourseInfo.setEnabled(true);
					btn_deleteCourse.setEnabled(true);
					
				}
				else
				{
					btn_viewCourseDetails.setEnabled(false);
					btn_editCourseInfo.setEnabled(false);
					btn_deleteCourse.setEnabled(false);
				}
			}
		});
		
		scrollpane = new JScrollPane(list_courses);
		scrollpane.setBounds(50, 50, 400, 500);
		add(scrollpane);
	}
}
