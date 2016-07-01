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

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class AddCourseJPanel extends JPanel {
	
	private JTextField textField_courseName;
	private JTextField textField_courseCode;
	private JTextField textField_courseHours;
	private JTextField textField_courseCap;
	private JScrollPane scrollpane_description;
	private JTextArea textArea_courseDescription;
	
	private boolean fall, spring, summer;
	
	private ArrayList<Course> prereqs;
	private JScrollPane scrollpane_selected_courses;
	private DefaultListModel <Course> listModel_selected_courses;
	private JList list_courses_selected;
	private JButton btn_remove_prereq;
	
	private JScrollPane scrollpane_courses;
	private DefaultListModel <Course> listModel_courses;
	private JList list_courses;
	private JButton btnAdd_course;
	
	private JScrollPane scrollpane_selected_faculties;
	private DefaultListModel <Faculty> listModel_selected_faculties;
	private JList list_faculties_selected;
	private ArrayList<Faculty> selected_faculties;
	private JButton btn_remove_faculty;
	
	private JScrollPane scrollpane_faculty;
	private DefaultListModel <Faculty> listModel_faculty;
	private JList list_faculty;
	private JButton btnAdd_faculty;
	
	private boolean name_ok;
	private boolean code_ok;
	private boolean hours_ok;
	private boolean cap_ok;
	private boolean description_ok;
	
	private String courseName;
	private String courseCode;
	private String courseHours;
	private String courseCap;
	private String courseDescription;
	
	private JButton btn_addNewCourse;
	
	
	
	/**
	 * Create the panel.
	 */
	public AddCourseJPanel(JFrame currentFrame, University university) {
		
		// initialization
		fall = spring = summer = false;
		prereqs = new ArrayList<Course>();
		name_ok = false;
		code_ok = false;
		hours_ok = false;
		cap_ok = false;
		description_ok = false;
		courseName = "";
		courseCode = "";
		courseHours = "";
		courseCap = "";
		courseDescription = "";
		
		selected_faculties = new ArrayList<Faculty>();
		
		// set the JPanel bounds
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lbl_title = new JLabel("Create and Add a New Course");
		lbl_title.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lbl_title.setBounds(245, 10, 300, 30);
		add(lbl_title);
		
		// course name
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 50, 50, 25);
		add(lblName);
		textField_courseName = new JTextField();
		textField_courseName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				courseName = textField_courseName.getText();
				if ((courseName.replace(" ", "").compareTo("") == 0))
					name_ok = false;
				else
					name_ok = true;
				if (name_ok & code_ok & hours_ok & cap_ok & description_ok)
					btn_addNewCourse.setEnabled(true);
				else
					btn_addNewCourse.setEnabled(false);
			}
		});
		textField_courseName.setToolTipText("");
		textField_courseName.setBounds(140, 50, 500, 25);
		add(textField_courseName);
		textField_courseName.setColumns(10);
			
		
		// course code
		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(50, 80, 50, 25);
		add(lblCode);
		textField_courseCode = new JTextField();
		textField_courseCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				courseCode = textField_courseCode.getText();
				if ((courseCode.replace(" ", "").compareTo("") == 0))
					code_ok = false;
				else
					code_ok = true;
				if (name_ok & code_ok & hours_ok & cap_ok & description_ok)
					btn_addNewCourse.setEnabled(true);
				else
					btn_addNewCourse.setEnabled(false);
			}
		});
		textField_courseCode.setBounds(140, 79, 100, 25);
		add(textField_courseCode);
		textField_courseCode.setColumns(10);
		
		
		// course hours
		JLabel lblCourseHours = new JLabel("Course Hours:");
		lblCourseHours.setBounds(245, 80, 100, 25);
		add(lblCourseHours);
		textField_courseHours = new JTextField();
		textField_courseHours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				courseHours = textField_courseHours.getText();
				if ((courseHours.replace(" ", "").compareTo("") == 0))
					hours_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_courseHours.getText());
						 hours_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 hours_ok = false;
					 }
				}
				if (name_ok & code_ok & hours_ok & cap_ok & description_ok)
					btn_addNewCourse.setEnabled(true);
				else
					btn_addNewCourse.setEnabled(false);
			}
		});
		textField_courseHours.setBounds(340, 80, 50, 25);
		add(textField_courseHours);
		textField_courseHours.setColumns(10);
		
		//course cap
		JLabel lblCourseCap = new JLabel("Course Cap:");
		lblCourseCap.setBounds(418, 80, 90, 25);
		add(lblCourseCap);
		textField_courseCap = new JTextField();
		textField_courseCap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				courseCap = textField_courseCap.getText();
				if ((courseCap.replace(" ", "").compareTo("") == 0))
					cap_ok = false;
				else
				{
					try
					 {
						 Integer.parseInt(textField_courseCap.getText());
						 cap_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 cap_ok = false;
					 }
				}
				if (name_ok & code_ok & hours_ok & cap_ok & description_ok)
					btn_addNewCourse.setEnabled(true);
				else
					btn_addNewCourse.setEnabled(false);
			}
		});
		textField_courseCap.setBounds(500, 80, 50, 25);
		add(textField_courseCap);
		textField_courseCap.setColumns(10);
		
		// course description
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 110, 80, 25);
		add(lblDescription);
		textArea_courseDescription = new JTextArea();
		textArea_courseDescription.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				courseDescription = textArea_courseDescription.getText();
				if ((courseDescription.replace(" ", "").compareTo("") == 0))
					description_ok = false;
				else
					description_ok = true;
				if (name_ok & code_ok & hours_ok & cap_ok & description_ok)
					btn_addNewCourse.setEnabled(true);
				else
					btn_addNewCourse.setEnabled(false);
			}
		});
		textArea_courseDescription.setLineWrap(true);
		textArea_courseDescription.setRows(2);	
		textArea_courseDescription.setWrapStyleWord(true);
		scrollpane_description = new JScrollPane(textArea_courseDescription);
		scrollpane_description.setSize(500, 60);
		scrollpane_description.setLocation(140, 110);
		add(scrollpane_description);
		
		// check boxes
		JLabel lblOffered = new JLabel("Offered:");
		lblOffered.setBounds(50, 180, 60, 25);
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
		chckbxFall.setBounds(140, 180, 100, 25);
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
		chckbxSpring.setBounds(250, 180, 100, 25);
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
		chckbxSummer.setBounds(360, 180, 100, 25);
		add(chckbxSummer);
		
		// list of prereqs
		listModel_selected_courses = new DefaultListModel<>();
		for (Course course : prereqs)
			listModel_selected_courses.addElement(course);
		list_courses_selected = new JList(listModel_selected_courses);
		list_courses_selected.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_courses_selected.getSelectedValue() != null)
					btn_remove_prereq.setEnabled(true);
				else
					btn_remove_prereq.setEnabled(false);
			}
		});
		scrollpane_selected_courses = new JScrollPane(list_courses_selected);
		scrollpane_selected_courses.setBounds(50, 230, 250, 106);
		add(scrollpane_selected_courses);
		
		// remove a prereq button
		btn_remove_prereq = new JButton("Remove");
		btn_remove_prereq.setEnabled(false);
		btn_remove_prereq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course selectedCourse = (Course) list_courses_selected.getSelectedValue();	
				prereqs.remove(selectedCourse);
				//System.out.println("Removed course -- " + selectedCourse.getCourseName() + " -- " + selected_courses.size() );
				listModel_selected_courses.removeElement(selectedCourse);
			}
		});
		btn_remove_prereq.setBounds(227, 335, 85, 25);
		add(btn_remove_prereq);
		
		// list of courses to choose from
		JLabel lblCoursesToChoose = new JLabel("Courses to choose from:");
		lblCoursesToChoose.setBounds(50, 376, 180, 25);
		add(lblCoursesToChoose);
		
		listModel_courses = new DefaultListModel<>();
		for (Course course : university.getCourses())
			listModel_courses.addElement(course);

		list_courses = new JList(listModel_courses);
		list_courses.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_courses.getSelectedValue() != null)
					btnAdd_course.setEnabled(true);
				else
					btnAdd_course.setEnabled(false);
			}
		});
		scrollpane_courses = new JScrollPane(list_courses);
		scrollpane_courses.setBounds(50, 400, 250, 200);
		add(scrollpane_courses);
		
		// add button
		btnAdd_course = new JButton("Add");
		btnAdd_course.setEnabled(false);
		btnAdd_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course selectedCourse = (Course) list_courses.getSelectedValue();
				prereqs.add(selectedCourse);
				listModel_selected_courses.addElement(selectedCourse);
			}
		});
		btnAdd_course.setBounds(237, 374, 63, 30);
		add(btnAdd_course);
		
		// list of faculty
		listModel_selected_faculties = new DefaultListModel<>();
		for (Faculty faculty : selected_faculties)
			listModel_selected_faculties.addElement(faculty);
	
		list_faculties_selected = new JList(listModel_selected_faculties);
		list_faculties_selected.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_faculties_selected.getSelectedValue() != null)
					btn_remove_faculty.setEnabled(true);
				else
					btn_remove_faculty.setEnabled(false);
			}
		});
		scrollpane_selected_faculties = new JScrollPane(list_faculties_selected);
		scrollpane_selected_faculties.setBounds(400, 230, 250, 106);
		add(scrollpane_selected_faculties);
		
		// button to remove faculty
		btn_remove_faculty = new JButton("Remove");
		btn_remove_faculty.setEnabled(false);
		btn_remove_faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Faculty selectedFaculty = (Faculty) list_faculties_selected.getSelectedValue();	
				selected_faculties.remove(selectedFaculty);
				listModel_selected_faculties.removeElement(selectedFaculty);
			}
		});
		btn_remove_faculty.setBounds(547, 333, 117, 29);
		add(btn_remove_faculty);

		// list of faculty to chose from
		JLabel lblFacultyToChoose = new JLabel("Faculty to choose from:");
		lblFacultyToChoose.setBounds(400, 376, 180, 25);
		add(lblFacultyToChoose);
		
		listModel_faculty = new DefaultListModel<>();
		for (Faculty faculty : university.getFaculties())
			listModel_faculty.addElement(faculty);
		
		list_faculty = new JList(listModel_faculty);
		list_faculty.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_faculty.getSelectedValue() != null)
					btnAdd_faculty.setEnabled(true);
				else
					btnAdd_faculty.setEnabled(false);
			}
		});
		scrollpane_faculty = new JScrollPane(list_faculty);
		scrollpane_faculty.setBounds(400, 400, 250, 200);
		add(scrollpane_faculty);
		
		// button to add faculty
		btnAdd_faculty = new JButton("Add");
		btnAdd_faculty.setEnabled(false);
		btnAdd_faculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Faculty selectedFaculty = (Faculty) list_faculty.getSelectedValue();
				selected_faculties.add(selectedFaculty);
				listModel_selected_faculties.addElement(selectedFaculty);	
			}
		});
		btnAdd_faculty.setBounds(600, 374, 50, 30);
		add(btnAdd_faculty);
		
		// Add button - it adds a new course from the creation page
		boolean completed = false; 
		btn_addNewCourse = new JButton("Add");
		btn_addNewCourse.setEnabled(false);
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
						prereqs, selected_faculties);
				
				System.out.println("New Course Added");
				newCourse.print();
				
				university.addCourse(newCourse);	// add the new course to the list of courses
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewCourse.setBounds(245, 614, 100, 30);
		add(btn_addNewCourse);
		
		// Cancel button - it cancels the action of creating a new course 
		// and goes back to the course list page
		JButton btn_cancelNewCourse = new JButton("Cancel");
		btn_cancelNewCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CourseListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewCourse.setBounds(349, 614, 100, 30);
		add(btn_cancelNewCourse);	
	}
}
