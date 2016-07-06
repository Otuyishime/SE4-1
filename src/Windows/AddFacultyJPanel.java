package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.FacultyLoad;
import OcGraduateSystemClasses.University;

import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AddFacultyJPanel extends JPanel {
	private JTextField textField_firstname;
	private JTextField textField_lastname;
	private JTextField textField_gradschool;
	private JTextField textField_degree;
	private JTextField textField_title;
	
	private JButton btn_addNewFaculty;
	
	private boolean first_ok;
	private boolean last_ok;
	private boolean gradschool_ok;
	private boolean degree_ok;
	private boolean title_ok;
	private boolean fallload_ok;
	private boolean springload_ok;
	private boolean summerload_ok;
	
	private String firstname;
	private String lastname;
	private String gradschool;
	private String degree;
	private String title;
	private String fallload;
	private String springload;
	private String summerload;
	private JTextField textField_fallload;
	private JTextField textField_springload;
	private JTextField textField_summerload;
	
	JScrollPane scrollpane_courses;
	DefaultListModel <Course> listModel_courses;
	JList list_courses;
	
	JScrollPane scrollpane_selected;
	DefaultListModel <Course> listModel_selected;
	JList list_courses_selected;
	private ArrayList<Course> selected_courses;
	
	JButton btnAdd_course_to_degree_req;
	JButton btnRemove_course_from_degree_req;

	/**
	 * Create the panel.
	 */
	public AddFacultyJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		selected_courses = new ArrayList<Course>();
		
		first_ok = last_ok = gradschool_ok = degree_ok = title_ok = fallload_ok = springload_ok = summerload_ok = false;
		firstname = lastname = gradschool = degree = title = "";
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Faculty");
		lblCreateAndAdd.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCreateAndAdd.setBounds(100, 50, 250, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(100, 120, 80, 25);
		add(lblName);
		
		textField_firstname = new JTextField();
		textField_firstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				firstname = textField_firstname.getText();
				if ((firstname.replace(" ", "").compareTo("") == 0))
					first_ok = false;
				else
					first_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_firstname.setToolTipText("");
		textField_firstname.setBounds(180, 120, 200, 25);
		add(textField_firstname);
		textField_firstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 150, 80, 25);
		add(lblLastName);
		
		textField_lastname = new JTextField();
		textField_lastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lastname = textField_lastname.getText();
				if ((lastname.replace(" ", "").compareTo("") == 0))
					last_ok = false;
				else
					last_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_lastname.setBounds(180, 150, 200, 25);
		add(textField_lastname);
		textField_lastname.setColumns(10);
		
		JLabel lblGradSchool = new JLabel("Grad School:");
		lblGradSchool.setBounds(100, 180, 80, 25);
		add(lblGradSchool);
		
		textField_gradschool = new JTextField();
		textField_gradschool.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				gradschool = textField_gradschool.getText();
				if ((gradschool.replace(" ", "").compareTo("") == 0))
					gradschool_ok = false;
				else
					gradschool_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_gradschool.setBounds(180, 180, 200, 25);
		add(textField_gradschool);
		textField_gradschool.setColumns(10);
		
		JLabel lblDegree = new JLabel("Degree:");
		lblDegree.setBounds(100, 210, 80, 25);
		add(lblDegree);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(100, 240, 80, 25);
		add(lblTitle);
		
		textField_degree = new JTextField();
		textField_degree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				degree = textField_degree.getText();
				if ((degree.replace(" ", "").compareTo("") == 0))
					degree_ok = false;
				else
					degree_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_degree.setBounds(180, 210, 200, 25);
		add(textField_degree);
		textField_degree.setColumns(10);
		
		textField_title = new JTextField();
		textField_title.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				title = textField_title.getText();
				if ((title.replace(" ", "").compareTo("") == 0))
					title_ok = false;
				else
					title_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_title.setBounds(180, 240, 200, 25);
		add(textField_title);
		textField_title.setColumns(10);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(180, 270, 100, 25);
		add(chckbxMonday);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(100, 270, 80, 25);
		add(lblDays);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(285, 270, 100, 25);
		add(chckbxTuesday);
		
		JCheckBox chckbxWednsday = new JCheckBox("Wednesday");
		chckbxWednsday.setBounds(390, 270, 110, 25);
		add(chckbxWednsday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(180, 300, 100, 25);
		add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(285, 300, 100, 25);
		add(chckbxFriday);
		
		// Add button - it adds a new faculty from the creation page
		btn_addNewFaculty = new JButton("Add");
		btn_addNewFaculty.setEnabled(false);
		btn_addNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new faculty and add it to the list of courses 
				
				firstname = textField_firstname.getText();
				lastname = textField_lastname.getText();
				gradschool = textField_gradschool.getText();
				degree = textField_degree.getText();
				title = textField_title.getText();
				int fall = Integer.parseInt(textField_fallload.getText());
				int spring =  Integer.parseInt(textField_springload.getText());
				int summer = Integer.parseInt(textField_summerload.getText());
				
				FacultyLoad fallLoad = new FacultyLoad(fall);
				FacultyLoad springLoad = new FacultyLoad(spring);
				FacultyLoad summerLoad = new FacultyLoad(summer);
				ArrayList<FacultyLoad> loads = new ArrayList<FacultyLoad>();
				loads.add(fallLoad);
				loads.add(springLoad);
				loads.add(summerLoad);
				Faculty newfaculty = new Faculty(firstname, lastname, gradschool, degree, title, "MTR", loads);
				newfaculty.setCourses(selected_courses);
				
				// TODO - get the real values of the days - please
				//String days = textField_degree.getText();
				//days = "MTR";
				
				// create a new faculty and add them to the existing list
				//Faculty newfaculty = new Faculty(firstname, lastname, gradschool, degree, title, days, fall , spring, summer);
				university.addFaculty(newfaculty);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewFaculty.setBounds(180, 498, 100, 30);
		add(btn_addNewFaculty);
		
		// Cancel button - it cancels the action of creating a new faculty 
		// and goes back to the faculty list page
		JButton btn_cancelNewFaculty = new JButton("Cancel");
		btn_cancelNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewFaculty.setBounds(296, 498, 100, 30);
		add(btn_cancelNewFaculty);
		
		JLabel lblLoads = new JLabel("Loads:");
		lblLoads.setBounds(100, 340, 80, 25);
		add(lblLoads);
		
		JLabel lblFall = new JLabel("Fall:");
		lblFall.setBounds(190, 340, 61, 25);
		add(lblFall);
		
		JLabel lblSpring = new JLabel("Spring:");
		lblSpring.setBounds(190, 370, 61, 25);
		add(lblSpring);
		
		JLabel lblSummer = new JLabel("Summer:");
		lblSummer.setBounds(190, 400, 61, 25);
		add(lblSummer);
		
		textField_fallload = new JTextField();
		textField_fallload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				fallload = textField_fallload.getText();
				if ((fallload.replace(" ", "").compareTo("") == 0))
					fallload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_fallload.getText());
						 fallload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 fallload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_fallload.setBounds(260, 340, 60, 25);
		add(textField_fallload);
		textField_fallload.setColumns(10);
		
		textField_springload = new JTextField();
		textField_springload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				springload = textField_springload.getText();
				if ((springload.replace(" ", "").compareTo("") == 0))
					springload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_springload.getText());
						 springload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 springload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_springload.setBounds(260, 370, 60, 25);
		add(textField_springload);
		textField_springload.setColumns(10);
		
		textField_summerload = new JTextField();
		textField_summerload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				summerload = textField_summerload.getText();
				if ((summerload.replace(" ", "").compareTo("") == 0))
					summerload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_summerload.getText());
						 summerload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 summerload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);	
			}
		});
		textField_summerload.setBounds(260, 399, 60, 25);
		add(textField_summerload);
		textField_summerload.setColumns(10);
		
		
		listModel_selected = new DefaultListModel<>();
		//System.out.println("size***** " + currentFaculty.getCourses().size());
		//for (Course course : currentFaculty.getCourses())
		//{
			//listModel_selected.addElement(course);
			//selected_courses.add(course);
		//}
		list_courses_selected = new JList(listModel_selected);
		list_courses_selected.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				// allow view, edit and delete only when there is a selected item
				if (list_courses_selected.getSelectedValue() != null)
				{
					btnRemove_course_from_degree_req.setEnabled(true);
				}
				else
				{
					btnRemove_course_from_degree_req.setEnabled(false);
				}
			}
		});
		scrollpane_selected = new JScrollPane(list_courses_selected);
		scrollpane_selected.setBounds(500, 120, 200, 105);
		add(scrollpane_selected);
		
		
		listModel_courses = new DefaultListModel<>();
		for (Course course : university.getCourses())
			listModel_courses.addElement(course);
		list_courses = new JList(listModel_courses);
		list_courses.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				// allow view, edit and delete only when there is a selected item
				if (list_courses.getSelectedValue() != null)
				{
					btnAdd_course_to_degree_req.setEnabled(true);
				}
				else
				{
					btnAdd_course_to_degree_req.setEnabled(false);
				}
			}
		});
		scrollpane_courses = new JScrollPane(list_courses);
		scrollpane_courses.setBounds(500, 250, 200, 250);
		add(scrollpane_courses);
		
		// JButton btnAdd_course_to_degree_req;
		btnAdd_course_to_degree_req = new JButton("Add");
		btnAdd_course_to_degree_req.setEnabled(false);
		btnAdd_course_to_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get the selected course and add it to the appropriate place
				Course selectedCourse = (Course) list_courses.getSelectedValue();	
				selected_courses.add(selectedCourse);
				System.out.println("Added course -- " + selectedCourse.getCourseName() + " -- " + selected_courses.size() );
				listModel_selected.addElement(selectedCourse);	
				
				/*
				if (selected_courses.size() == 0)
					courses_ok = false;
				else
					courses_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btn_update_degree_req.setEnabled(true);
				else
					btn_update_degree_req.setEnabled(false);
					*/
			}
		});
		btnAdd_course_to_degree_req.setBounds(703, 249, 50, 25);
		add(btnAdd_course_to_degree_req);
		
		// JButton btnRemove_course_from_degree_req;
		btnRemove_course_from_degree_req = new JButton("Remove");
		btnRemove_course_from_degree_req.setEnabled(false);
		btnRemove_course_from_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course selectedCourse = (Course) list_courses_selected.getSelectedValue();	
				selected_courses.remove(selectedCourse);
				System.out.println("Removed course -- " + selectedCourse.getCourseName() + " -- " + selected_courses.size() );
				listModel_selected.removeElement(selectedCourse);
				
				/*
				if (selected_courses.size() == 0)
					courses_ok = false;
				else
					courses_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btn_update_degree_req.setEnabled(true);
				else
					btn_update_degree_req.setEnabled(false);
					*/
			}
		});
		btnRemove_course_from_degree_req.setBounds(704, 121, 80, 25);
		add(btnRemove_course_from_degree_req);
	
	}
}
