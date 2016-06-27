package Windows;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.University;

import javax.swing.JButton;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class AddDegreeRequirementJPanel extends JPanel {
	
	JScrollPane scrollpane_courses;
	DefaultListModel <Course> listModel_courses;
	JList list_courses;
	
	JScrollPane scrollpane_selected;
	DefaultListModel <Course> listModel_selected;
	JList list_courses_selected;
	
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public AddDegreeRequirementJPanel(JFrame currentFrame, University university, Degree currentDegree) {
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Add Info for Required Courses - Category 1");
		lblCreateAndAdd.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCreateAndAdd.setBounds(50, 10, 400, 30);
		add(lblCreateAndAdd);
		
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
					
				}
				else
				{
				
				}
			}
		});
		scrollpane_courses = new JScrollPane(list_courses);
		scrollpane_courses.setBounds(50, 280, 200, 250);
		add(scrollpane_courses);
		
		listModel_selected = new DefaultListModel<>();
		for (Course course : university.getCourses())
			listModel_selected.addElement(course);
		list_courses_selected = new JList(listModel_selected);
		list_courses_selected.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				// allow view, edit and delete only when there is a selected item
				if (list_courses_selected.getSelectedValue() != null)
				{
					
				}
				else
				{
				
				}
			}
		});
		scrollpane_selected = new JScrollPane(list_courses_selected);
		scrollpane_selected.setBounds(350, 280, 200, 250);
		add(scrollpane_selected);
		
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(50, 562, 117, 29);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(196, 562, 117, 29);
		add(btnCancel);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(251, 299, 70, 25);
		add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.setBounds(555, 297, 80, 25);
		add(btnRemove);
		
		JLabel lblDegreeCode = new JLabel("Degree Code:");
		lblDegreeCode.setBounds(50, 60, 100, 25);
		add(lblDegreeCode);
		
		textField = new JTextField();
		textField.setBounds(146, 60, 130, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 90, 100, 25);
		add(lblDescription);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 90, 300, 25);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setBounds(50, 120, 100, 25);
		add(lblHours);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 120, 130, 25);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblType = new JLabel("Type:");
		lblType.setBounds(50, 150, 100, 25);
		add(lblType);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 150, 130, 25);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSelectAndAdd = new JLabel("Select and add courses ");
		lblSelectAndAdd.setBounds(50, 200, 200, 25);
		add(lblSelectAndAdd);
		
		JLabel lblCoursesToSelect = new JLabel("Courses to select from:");
		lblCoursesToSelect.setBounds(50, 240, 200, 25);
		add(lblCoursesToSelect);
		
		JLabel lblSlectedCourses = new JLabel("Slected Courses:");
		lblSlectedCourses.setBounds(362, 240, 200, 25);
		add(lblSlectedCourses);

	}
}
