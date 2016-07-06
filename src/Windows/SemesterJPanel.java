package Windows;

import java.awt.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.University;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class SemesterJPanel extends JPanel {
	
	JScrollPane scrollpane_semester;
	DefaultListModel <Semester> listModel_semester;
	JList jlist_semesters;
	JButton btnEdit;
	JButton btnDelete;
	private JLabel lblEditaddForm;
	private JLabel lblName;
	private JLabel lblStart;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public SemesterJPanel(JFrame currentFrame,University university) {
		
		setBounds(new Rectangle(0, 0, 800, 750));
		setLayout(null);
		
		// populate the semester list
		listModel_semester = new DefaultListModel<>();
		for (Semester semester : university.getSemesters())
			listModel_semester.addElement(semester);
		jlist_semesters = new JList(listModel_semester);		
		jlist_semesters.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				Semester current_semester = (Semester) jlist_semesters.getSelectedValue();
				System.out.println(current_semester);
				
				if (current_semester != null)
				{
					btnEdit.setEnabled(true);
					btnDelete.setEnabled(true);
				}
				else
				{
					btnEdit.setEnabled(false);
					btnDelete.setEnabled(false);
				}
			}
		});
		scrollpane_semester = new JScrollPane(jlist_semesters);
		scrollpane_semester.setBounds(44, 70, 196, 461);
		add(scrollpane_semester);
		
		JLabel lblListOfSemesters = new JLabel("List of Semesters");
		lblListOfSemesters.setBounds(45, 29, 155, 29);
		add(lblListOfSemesters);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(44, 547, 117, 29);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnEdit.setBounds(44, 577, 117, 29);
		add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setBounds(44, 608, 117, 29);
		add(btnDelete);
		
		JButton buttonBack = new JButton("< Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		buttonBack.setBounds(44, 639, 117, 29);
		add(buttonBack);
		
		lblEditaddForm = new JLabel("Edit/Add Form");
		lblEditaddForm.setBounds(483, 29, 144, 29);
		add(lblEditaddForm);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(383, 72, 61, 23);
		add(lblName);
		
		lblStart = new JLabel("Start");
		lblStart.setBounds(383, 121, 61, 29);
		add(lblStart);
		
		textField = new JTextField();
		textField.setBounds(456, 70, 130, 26);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDay = new JLabel("Day:");
		lblDay.setBounds(427, 127, 61, 23);
		add(lblDay);
		
		JLabel lblMonth = new JLabel("Month:");
		lblMonth.setBounds(427, 160, 61, 29);
		add(lblMonth);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setBounds(427, 201, 61, 29);
		add(lblYear);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(383, 255, 61, 29);
		add(lblEnd);
		
		JLabel lblDay_1 = new JLabel("Day:");
		lblDay_1.setBounds(427, 261, 61, 23);
		add(lblDay_1);
		
		JLabel lblMonth_1 = new JLabel("Month:");
		lblMonth_1.setBounds(427, 296, 61, 23);
		add(lblMonth_1);
		
		JLabel lblYear_1 = new JLabel("Year:");
		lblYear_1.setBounds(427, 338, 61, 29);
		add(lblYear_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(456, 122, 130, 26);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(480, 162, 130, 26);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(483, 202, 130, 26);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(483, 259, 130, 26);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(483, 294, 130, 26);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(483, 339, 130, 26);
		add(textField_6);
		textField_6.setColumns(10);
		

	}
}
