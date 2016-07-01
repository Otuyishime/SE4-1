package Windows;


import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultListModel;
// import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.DegreeRequirement;
import OcGraduateSystemClasses.University;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class AddDegreePlanJPanel extends JPanel {
	
	JScrollPane scrollpane_degree_reqs;
	DefaultListModel <DegreeRequirement> listModel_degree_reqs;
	JList list_degree_reqs;
	
	JScrollPane scrollpane_courses;
	DefaultListModel <Course> listModel_courses;
	JList list_courses;
	
	JScrollPane scrollpane_selected;
	DefaultListModel <Course> listModel_selected;
	JList list_courses_selected;
	private ArrayList<Course> selected_courses;
	
	private ArrayList<DegreeRequirement> degreeRequirements;
	
	private JTextField textField_code;
	private JTextField textField_grad_school;
	private JTextField textField_name;
	private JTextField textField_forecast;

	private JTextField textField_degree_req_code;
	private JTextField textField_degree_req_hours;
	private JTextField textField_degree_req_type;
	private JTextArea textArea_degree_req_description;
	JScrollPane scrollpane_description;
	private JButton btnAdd_course_to_degree_req;
	private JButton btnRemove_course_from_degree_req;
	private JLabel lblCoursesToChoose;
	private JLabel lblSelectedCourses;
	private JButton btnAdd_degree_req;
	private JButton btnCancel_degree_req;
	private JLabel lblDegreeRequirements;
	private JButton btnRemove_degree_req;
	
	private JButton btn_addNewDegree;
	
	private boolean code_ok;
	private boolean gradSchool_ok;
	private boolean name_ok;
	private boolean forecast_ok;
	private boolean req_ok;
	
	private boolean description_ok;
	private boolean hours_ok;
	private boolean type_ok;
	private boolean courses_ok;
	
	
	/**
	 * Create the panel.
	 */
	public AddDegreePlanJPanel(JFrame currentFrame, University university) {
		
		code_ok = gradSchool_ok = name_ok = forecast_ok = req_ok = false;	
		description_ok = hours_ok = type_ok = courses_ok = false;
		selected_courses = new ArrayList<Course>();
		degreeRequirements = new ArrayList<DegreeRequirement>();
		
		setBounds(new Rectangle(0, 0, 800, 750));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Degree Plan");
		lblCreateAndAdd.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCreateAndAdd.setBounds(100, 10, 300, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Code:");
		lblName.setBounds(100, 50, 85, 25);
		add(lblName);
		
		textField_code = new JTextField();
		textField_code.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				String value = textField_code.getText();
				textField_degree_req_code.setText(value);
				if ((value.replace(" ", "").compareTo("") == 0))
					code_ok = false;
				else
					code_ok = true;
		
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
			}
		});
		textField_code.setToolTipText("");
		textField_code.setBounds(200, 50, 250, 25);
		add(textField_code);
		textField_code.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Grad School:");
		lblNewLabel.setBounds(100, 80, 85, 25);
		add(lblNewLabel);
		
		textField_grad_school = new JTextField();
		textField_grad_school.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textField_grad_school.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					gradSchool_ok = false;
				else
					gradSchool_ok = true;
		
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
			}
		});
		textField_grad_school.setBounds(200, 80, 250, 25);
		add(textField_grad_school);
		textField_grad_school.setColumns(10);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(100, 110, 85, 25);
		add(lblName_1);
		
		textField_name = new JTextField();
		textField_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textField_name.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					name_ok = false;
				else
					name_ok = true;
		
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
			}
		});
		textField_name.setBounds(200, 110, 250, 25);
		add(textField_name);
		textField_name.setColumns(10);
		
		JLabel lblForecast = new JLabel("Forecast:");
		lblForecast.setBounds(100, 140, 85, 25);
		add(lblForecast);
		
		textField_forecast = new JTextField();
		textField_forecast.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textField_forecast.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					forecast_ok = false;
				else
				{
					try
					 {
						 Integer.parseInt(value);
						 forecast_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 forecast_ok = false;
					 }
				}
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
			}
		});
		textField_forecast.setBounds(200, 140, 250, 25);
		add(textField_forecast);
		textField_forecast.setColumns(10);
		
		lblDegreeRequirements = new JLabel("Degree Requirements:");
		lblDegreeRequirements.setBounds(462, 54, 150, 25);
		add(lblDegreeRequirements);
		
		listModel_degree_reqs= new DefaultListModel<>();
		for (DegreeRequirement degreeReq  : degreeRequirements)
			listModel_degree_reqs.addElement(degreeReq);
		list_degree_reqs = new JList(listModel_degree_reqs);
		
		list_degree_reqs.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				// allow view, edit and delete only when there is a selected item
				if (list_degree_reqs.getSelectedValue() != null)
				{
					btnRemove_degree_req.setEnabled(true);
				}
				else
				{
					btnRemove_degree_req.setEnabled(false);
				}
			}
		});
		scrollpane_degree_reqs = new JScrollPane(list_degree_reqs);
		scrollpane_degree_reqs.setBounds(610, 54, 150, 120);
		add(scrollpane_degree_reqs);
		
		btnRemove_degree_req = new JButton("Remove");
		btnRemove_degree_req.setEnabled(false);
		btnRemove_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreeRequirement selectedDegreeReq = (DegreeRequirement) list_degree_reqs.getSelectedValue();	
				
				degreeRequirements.remove(selectedDegreeReq);
				listModel_degree_reqs.removeElement(selectedDegreeReq);
				
				// check the size of degreeRequirements
				if (degreeRequirements.size() == 0)
					req_ok = false;
				else
					req_ok = true;
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
			}
		});
		btnRemove_degree_req.setBounds(764, 49, 80, 25);
		add(btnRemove_degree_req);
		
		// Add button - it adds a new DegreePlan from the creation page
		btn_addNewDegree = new JButton("Add");
		btn_addNewDegree.setEnabled(false);
		btn_addNewDegree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new DegreePlan and add it to the list of DegreePlans 
				String degreeCode = textField_code.getText();
				String gradSchool = textField_grad_school.getText();
				String degreeName = textField_name.getText();
				int forecast = Integer.parseInt(textField_forecast.getText());
				
				Degree degree = new Degree(degreeCode, gradSchool,degreeName, forecast);
				degree.setDegreeRequirements(degreeRequirements);
				
				university.addDegree(degree);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewDegree.setBounds(50, 592, 100, 30);
		add(btn_addNewDegree);
		
		// Cancel button - it cancels the action of creating a new DegreePlan 
		// and goes back to the DegreePlan list page
		JButton btn_cancelNewDegreePlan = new JButton("Cancel");
		btn_cancelNewDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the DegreePlan list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewDegreePlan.setBounds(214, 592, 100, 30);
		add(btn_cancelNewDegreePlan);
		
		
		JLabel lblAddDegreeRequirements = new JLabel("Add Degree Requirements:");
		lblAddDegreeRequirements.setBounds(50, 190, 180, 25);
		add(lblAddDegreeRequirements);
		
		JLabel lblDegreeCode = new JLabel("Degree Code:");
		lblDegreeCode.setBounds(50, 250, 100, 25);
		add(lblDegreeCode);
		
		textField_degree_req_code = new JTextField();
		textField_degree_req_code.setEditable(false);
		textField_degree_req_code.setBounds(150, 250, 200, 25);
		add(textField_degree_req_code);
		textField_degree_req_code.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 290, 100, 25);
		add(lblDescription);
		
		textArea_degree_req_description = new JTextArea();
		textArea_degree_req_description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textArea_degree_req_description.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					description_ok = false;
				else
					description_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btnAdd_degree_req.setEnabled(true);
				else
					btnAdd_degree_req.setEnabled(false);
			}
		});
		textArea_degree_req_description.setLineWrap(true);
		textArea_degree_req_description.setRows(2);	
		textArea_degree_req_description.setWrapStyleWord(true);
		scrollpane_description = new JScrollPane(textArea_degree_req_description);
		scrollpane_description.setSize(200, 60);
		scrollpane_description.setLocation(150, 290);
		add(scrollpane_description);
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setBounds(50, 360, 100, 25);
		add(lblHours);
		
		textField_degree_req_hours = new JTextField();
		textField_degree_req_hours.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textField_degree_req_hours.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					hours_ok = false;
				else
				{
					try
					 {
						 Integer.parseInt(value);
						 hours_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 hours_ok = false;
					 }
				}
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btnAdd_degree_req.setEnabled(true);
				else
					btnAdd_degree_req.setEnabled(false);
			}
		});
		textField_degree_req_hours.setBounds(150, 360, 200, 25);
		add(textField_degree_req_hours);
		textField_degree_req_hours.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(50, 390, 100, 25);
		add(lblType);
		
		textField_degree_req_type = new JTextField();
		textField_degree_req_type.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String value = textField_degree_req_type.getText();
				if ((value.replace(" ", "").compareTo("") == 0))
					type_ok = false;
				else
					type_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btnAdd_degree_req.setEnabled(true);
				else
					btnAdd_degree_req.setEnabled(false);
			}
		});
		textField_degree_req_type.setBounds(150, 390, 200, 25);
		add(textField_degree_req_type);
		textField_degree_req_type.setColumns(10);

		// get the list of courses and create a list model for them 
		// the JList needs to be added to the scroll pane to give it the scrolling ability
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
		scrollpane_courses.setBounds(370, 250, 200, 250);
		add(scrollpane_courses);
		
		listModel_selected = new DefaultListModel<>();
		for (Course course : selected_courses)
			listModel_selected.addElement(course);
	
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
		scrollpane_selected.setBounds(620, 250, 200, 250);
		add(scrollpane_selected);
		
		btnAdd_course_to_degree_req = new JButton("Add");
		btnAdd_course_to_degree_req.setEnabled(false);
		btnAdd_course_to_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// get the selected course and add it to the appropriate place
				Course selectedCourse = (Course) list_courses.getSelectedValue();	
				selected_courses.add(selectedCourse);
				System.out.println("Added course -- " + selectedCourse.getCourseName() + " -- " + selected_courses.size() );
				listModel_selected.addElement(selectedCourse);	
				
				if (selected_courses.size() == 0)
					courses_ok = false;
				else
					courses_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btnAdd_degree_req.setEnabled(true);
				else
					btnAdd_degree_req.setEnabled(false);
			}
		});
		btnAdd_course_to_degree_req.setBounds(565, 251, 50, 25);
		add(btnAdd_course_to_degree_req);
		
		btnRemove_course_from_degree_req = new JButton("Remove");
		btnRemove_course_from_degree_req.setEnabled(false);
		btnRemove_course_from_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Course selectedCourse = (Course) list_courses_selected.getSelectedValue();	
				selected_courses.remove(selectedCourse);
				System.out.println("Removed course -- " + selectedCourse.getCourseName() + " -- " + selected_courses.size() );
				listModel_selected.removeElement(selectedCourse);
				
				if (selected_courses.size() == 0)
					courses_ok = false;
				else
					courses_ok = true;
		
				// enable the add button
				if (description_ok & hours_ok & type_ok & courses_ok)
					btnAdd_degree_req.setEnabled(true);
				else
					btnAdd_degree_req.setEnabled(false);
			}
		});
		btnRemove_course_from_degree_req.setBounds(817, 249, 80, 25);
		add(btnRemove_course_from_degree_req);
		
		lblCoursesToChoose = new JLabel("Courses to choose from:");
		lblCoursesToChoose.setBounds(370, 222, 180, 25);
		add(lblCoursesToChoose);
		
		lblSelectedCourses = new JLabel("Selected Courses:");
		lblSelectedCourses.setBounds(620, 226, 150, 25);
		add(lblSelectedCourses);
		
		btnAdd_degree_req = new JButton("Add Degree Requirement");
		btnAdd_degree_req.setEnabled(false);
		btnAdd_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// read degree req data
				String code = textField_degree_req_code.getText();
				String description = textArea_degree_req_description.getText();
				int hours = Integer.parseInt(textField_degree_req_hours.getText());
				String type = textField_degree_req_type.getText();
				
				DegreeRequirement degree_req = new DegreeRequirement(type, description, hours, code);
				degree_req.setCourses(selected_courses);
				
				degreeRequirements.add(degree_req);
				listModel_degree_reqs.addElement(degree_req);
				
				// check the size of degreeRequirements
				if (degreeRequirements.size() == 0)
					req_ok = false;
				else
					req_ok = true;
				// enable the add button
				if (code_ok & gradSchool_ok & name_ok & forecast_ok & req_ok)
					btn_addNewDegree.setEnabled(true);
				else
					btn_addNewDegree.setEnabled(false);
				
				// clear everything
				//textField_degree_req_code.setText("");
				textArea_degree_req_description.setText("");
				textField_degree_req_hours.setText("");
				textField_degree_req_type.setText("");
				
				selected_courses.clear();
				listModel_selected.clear();
				
				btnAdd_degree_req.setEnabled(false);
			}
		});
		btnAdd_degree_req.setBounds(50, 471, 200, 25);
		add(btnAdd_degree_req);
		
		btnCancel_degree_req = new JButton("Clear");
		btnCancel_degree_req.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// clear everything
				//textField_degree_req_code.setText("");
				textArea_degree_req_description.setText("");
				textField_degree_req_hours.setText("");
				textField_degree_req_type.setText("");
				
				selected_courses.clear();
				listModel_selected.clear();
				
				btnAdd_degree_req.setEnabled(false);
			}
		});
		btnCancel_degree_req.setBounds(252, 471, 80, 25);
		add(btnCancel_degree_req);
	}
}
