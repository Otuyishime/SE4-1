package Windows;

import java.awt.Font;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.University;

public class FacultyListJPanel extends JPanel {
	
	private JButton btn_facultyListToMain;
	
	// for Faculty
	private JScrollPane scrollpane_faculty;
	private DefaultListModel <Faculty> listModel_faculty;
	private JList list_faculty;
	
	private JButton btn_createNewFaculty;
	private JButton btn_editFacultyInfo;
	private JButton btn_deleteFaculty;
	/**
	 * Create the panel.
	 */
	public FacultyListJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblListOfAvailable = new JLabel("List of Available Faculty");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(100, 20, 300, 25);
		add(lblListOfAvailable);

		listModel_faculty = new DefaultListModel<>();
		for (Faculty faculty : university.getFaculties())
			listModel_faculty.addElement(faculty);
		
		list_faculty = new JList(listModel_faculty);
		list_faculty.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				
				if (list_faculty.getSelectedValue() != null)
				{
					btn_editFacultyInfo.setEnabled(true);
					btn_deleteFaculty.setEnabled(true);
				}
				else
				{
					btn_editFacultyInfo.setEnabled(false);
					btn_deleteFaculty.setEnabled(false);
				}
			}
		});
		scrollpane_faculty = new JScrollPane(list_faculty);
		scrollpane_faculty.setBounds(100, 50, 300, 500);
		add(scrollpane_faculty);
		
		
		// Add button - it leads to a new Faculty creation Faculty
		btn_createNewFaculty = new JButton("Add");
		btn_createNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddFacultyJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_createNewFaculty.setBounds(500, 50, 100, 30);
		add(btn_createNewFaculty);
		
		// Edit button - it takes you to a Faculty edit page
		btn_editFacultyInfo = new JButton("Edit");
		btn_editFacultyInfo.setEnabled(false);
		btn_editFacultyInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected Faculty and pass its information to the edit page
				Faculty selectedFaculty = (Faculty) list_faculty.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditFacultyJPanel(currentFrame, university, selectedFaculty));
				currentFrame.revalidate();	
			}
		});
		btn_editFacultyInfo.setBounds(500, 100, 100, 30);
		add(btn_editFacultyInfo);
		
		// Delete button - it deletes the selected Faculty from the list
		btn_deleteFaculty = new JButton("Delete");
		btn_deleteFaculty.setEnabled(false);
		btn_deleteFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected Faculty and deleted if from the list
				
				Faculty selectedFaculty = (Faculty) list_faculty.getSelectedValue();
				university.removeFaculty(selectedFaculty);
				listModel_faculty.removeElement(selectedFaculty);
			}
		});
		btn_deleteFaculty.setBounds(500, 150, 100, 30);
		add(btn_deleteFaculty);
		
		// Back button from the list of Faculty back to main
		btn_facultyListToMain = new JButton("< Back");
		btn_facultyListToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_facultyListToMain.setBounds(500, 200, 100, 30);
		add(btn_facultyListToMain);
	}

}
