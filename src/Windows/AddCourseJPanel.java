package Windows;

import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.University;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;

//	TODO - need to add error handling 
// 	1. when fields are left unfilled
// 	2. when course hours and cap inputs are not integers
// 	3. when button are clicked with no selected course or faculty
// 	4. when the Add button is clicked with some missing information

// NOTE - fields are in order they appear on the panel

public class AddCourseJPanel extends JPanel {
	private JTextField textField_courseName;
	private JTextField textField_courseCode;
	private JTextField textField_courseHours;
	private JTextField textField_courseCap;
	private JTextArea textArea_courseDescription;
	
	private boolean fall, spring, summer;
	private ArrayList<Course> prereqs;
	private ArrayList<Faculty> faculties;
	
	// for courses
	JScrollPane scrollpane_courses;
	DefaultListModel <Course> listModel_courses;
	JList list_courses;
	
	// for Faculty
	JScrollPane scrollpane_faculty;
	DefaultListModel <Faculty> listModel_faculty;
	JList list_faculty;

	JScrollPane scrollpane_description;
	
	/**
	 * Create the panel.
	 */
	public AddCourseJPanel(JFrame currentFrame, University university) {
		fall = spring = summer = false;
		prereqs = new ArrayList<Course>();
		faculties = new ArrayList<Faculty>();
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		// title label
		JLabel lbl_title = new JLabel("Create and Add a New Course");
		lbl_title.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_title.setBounds(245, 10, 300, 30);
		add(lbl_title);
		
		// name field label
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 50, 50, 25);
		add(lblName);
		
		// name text field
		textField_courseName = new JTextField();
		textField_courseName.setToolTipText("");
		textField_courseName.setBounds(140, 50, 500, 25);
		add(textField_courseName);
		textField_courseName.setColumns(10);
				
		// course code label
		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(50, 80, 50, 25);
		add(lblCode);
		
		// course code text field
		textField_courseCode = new JTextField();
		textField_courseCode.setBounds(140, 79, 100, 25);
		add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		// course hours label
		JLabel lblCourseHours = new JLabel("Course Hours:");
		lblCourseHours.setBounds(245, 80, 100, 25);
		add(lblCourseHours);
		
		// course hours text field
		textField_courseHours = new JTextField();
		textField_courseHours.setBounds(340, 80, 50, 25);
		add(textField_courseHours);
		textField_courseHours.setColumns(10);
		
		//course cap label
		JLabel lblCourseCap = new JLabel("Course Cap:");
		lblCourseCap.setBounds(418, 80, 90, 25);
		add(lblCourseCap);
		
		// course cap text field
		textField_courseCap = new JTextField();
		textField_courseCap.setBounds(500, 80, 50, 25);
		add(textField_courseCap);
		textField_courseCap.setColumns(10);
		
		// course description label
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 110, 80, 25);
		add(lblDescription);
		
		// course description text area
		// NOTE - the text area is wrapped into a scroll pane to make sure we can scroll once
		// description gets too long
		textArea_courseDescription = new JTextArea();
		textArea_courseDescription.setLineWrap(true);
		textArea_courseDescription.setRows(2);	
		textArea_courseDescription.setWrapStyleWord(true);
		scrollpane_description = new JScrollPane(textArea_courseDescription);
		scrollpane_description.setSize(500, 60);
		scrollpane_description.setLocation(140, 110);
		add(scrollpane_description);
		
		// following are the checkboxes to determine if the course is offered in
		// fall, or spring, or summer 
		JLabel lblOffered = new JLabel("Offered:");
		lblOffered.setBounds(50, 190, 60, 25);
		add(lblOffered);
		
		// check box for fall
		JCheckBox chckbxFall = new JCheckBox("Fall");
		chckbxFall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxFall.isSelected())
					fall = true;
				else
					fall = false;
			}
		});
		chckbxFall.setBounds(140, 190, 100, 25);
		add(chckbxFall);
		
		// checkbox for spring
		JCheckBox chckbxSpring = new JCheckBox("Spring");
		chckbxSpring.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxSpring.isSelected())
					spring = true;
				else
					spring = false;
			}
		});
		chckbxSpring.setBounds(250, 190, 100, 25);
		add(chckbxSpring);
		
		// checkbox for summer
		JCheckBox chckbxSummer = new JCheckBox("Summer");
		chckbxSummer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxSummer.isSelected())
					summer = true;
				else
					summer = false;
			}
		});
		chckbxSummer.setBounds(360, 190, 100, 25);
		add(chckbxSummer);
		
		// provide a list of courses to choose from
		JLabel lblCoursesToChoose = new JLabel("Courses to choose from:");
		lblCoursesToChoose.setBounds(50, 230, 180, 25);
		add(lblCoursesToChoose);
		
		listModel_courses = new DefaultListModel<>();
		for (Course course : university.getCourses())
			listModel_courses.addElement(course);

		list_courses = new JList(listModel_courses);
		scrollpane_courses = new JScrollPane(list_courses);
		scrollpane_courses.setBounds(50, 260, 250, 230);
		add(scrollpane_courses);
		
		// provide a list of Faculty to choose from
		JLabel lblFacultyToChoose = new JLabel("Faculty to choose from:");
		lblFacultyToChoose.setBounds(370, 230, 180, 25);
		add(lblFacultyToChoose);
		
		listModel_faculty = new DefaultListModel<>();
		for (Faculty faculty : university.getFaculties())
			listModel_faculty.addElement(faculty);
		
		list_faculty = new JList(listModel_faculty);
		scrollpane_faculty = new JScrollPane(list_faculty);
		scrollpane_faculty.setBounds(370, 260, 250, 230);
		add(scrollpane_faculty);
		
		// labels for choosen courses
		JLabel lblChoosen = new JLabel("Choosen courses:");
		lblChoosen.setBounds(50, 500, 120, 25);
		add(lblChoosen);
		JLabel lbl_choosen_prereq = new JLabel("No prerequisite choosen yet!");
		lbl_choosen_prereq.setBounds(182, 500, 500, 25);
		add(lbl_choosen_prereq);
		
		// labels for selected faculty
		JLabel lblChoosenFaculty = new JLabel("Choosen faculty:");
		lblChoosenFaculty.setBounds(50, 525, 120, 25);
		add(lblChoosenFaculty);
		JLabel lbl_choosen_faculty = new JLabel("No faculty choosen yet!");
		lbl_choosen_faculty.setBounds(182, 525, 500, 25);
		add(lbl_choosen_faculty);
		
		// this button is for adding a course to a list of prereq
		// just select the course and hit this button to add it
		JButton btnAdd_course = new JButton("Add");
		btnAdd_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO - get the selected course and append it to the list of a course's prereq
				// and update the choosen courses placeholder
				Course selectedCourse = (Course) list_courses.getSelectedValue();
				prereqs.add(selectedCourse);
				
				if (prereqs.size() == 0)
					lbl_choosen_prereq.setText("No prerequisite choosen yet");
				else
				{
					lbl_choosen_prereq.setText("");
					for (Course course : prereqs)
						lbl_choosen_prereq.setText((lbl_choosen_prereq.getText() + course.getCourseCode() + " - "));		
				}
			}
		});
		btnAdd_course.setBounds(305, 260, 50, 30);
		add(btnAdd_course);
		
		// this button is for adding a faculty to a list of faculties
		// just select the faculty and hit this button to add it
		JButton btnAdd_faculty = new JButton("Add");
		btnAdd_faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - get the selected course and append it to the list of a course's faculties
				// and update the choosen faculty placeholder
				Faculty selectedFaculty = (Faculty) list_faculty.getSelectedValue();
				faculties.add(selectedFaculty);
				
				if (faculties.size() == 0)
					lbl_choosen_faculty.setText("No faculty choosen yet");
				else
				{
					lbl_choosen_faculty.setText("");
					for (Faculty faculty : faculties)
						lbl_choosen_faculty.setText((lbl_choosen_faculty.getText() + faculty.getLastName() + " - "));		
				}
			}
		});
		btnAdd_faculty.setBounds(625, 260, 50, 30);
		add(btnAdd_faculty);
		
		// Add button - it adds a new course from the creation page
		boolean completed = false; //this checks if the form is completed - TODO 
		JButton btn_addNewCourse = new JButton("Add");
		btn_addNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - add error handling
				// Get info from text fields, Create a new course and add it to the list of courses 
				String courseName = textField_courseName.getText();
				String courseCode = textField_courseCode.getText();
				int courseHours = Integer.parseInt(textField_courseHours.getText());
				int courseCap = Integer.parseInt(textField_courseCap.getText());
				String courseDecription = textArea_courseDescription.getText();
				
				System.out.println("\nAdding a course....");
				System.out.println("Course name: " + courseName);
				System.out.println("Course code: " + courseCode);
				System.out.println("Course hours: " + courseHours);
				System.out.println("Course cap: " + courseCap);
				System.out.println("Course Description: " + courseDecription);
				System.out.println("Fall: " + fall);
				System.out.println("Spring: " + spring);
				System.out.println("Summer: " + summer);	
				
				Course newCourse = new Course(courseCode, courseName, courseDecription, 
						courseHours, courseCap, 
						fall,  spring, summer, 
						prereqs, faculties);
				
				System.out.println("New Course Added");
				newCourse.print();
				
				university.addCourse(newCourse);	// add the new course to the list of courses
				
				// TODO - create a new course and add it to the list of existing courses
				// at this point, we have everything we need to cretae a new course and add
				// it to an existing list of courses - just need to talk to Olivier about the way
				// he implemented the course constructor. I have a list of prereq and a lit of faculty
				// who can teach the course, but it looks like the course constructor expects a 
				// a string of prereq??? and a list of teachers as strings nor faculty!!!!!
				
				// TODO - this is done only when the form is completely filled out.
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewCourse.setBounds(118, 570, 100, 30);
		add(btn_addNewCourse);
		
		// Cancel button - it cancels the action of creating a new course 
		// and goes back to the course list page
		JButton btn_cancelNewCourse = new JButton("Cancel");
		btn_cancelNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewCourse.setBounds(310, 570, 100, 30);
		add(btn_cancelNewCourse);
	}
}
