package Windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.University;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class FacultyLoadReportJPanel extends JPanel 
{
	private DefaultListModel <String> listModel_facultyLoad;
	private JList list_faculty;
	private JScrollPane facultyLoadScrollPane;




	/**
	 * Create the panel.
	 * @param university 
	 * @param currentFrame 
	 */
	public FacultyLoadReportJPanel(JFrame currentFrame, University university) {
		
		JLabel lblReportFacultyLoad = new JLabel("REPORT: Faculty Load ");
		
		 facultyLoadScrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addComponent(facultyLoadScrollPane, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(129)
							.addComponent(lblReportFacultyLoad, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(53)
					.addComponent(lblReportFacultyLoad)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(facultyLoadScrollPane, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		listModel_facultyLoad = new DefaultListModel<>();
		for (Faculty faculty : university.getFaculties())
			listModel_facultyLoad.addElement(faculty.getFacultyLoads_str());
		list_faculty = new JList<String >(listModel_facultyLoad);
		facultyLoadScrollPane.setViewportView(list_faculty);
		setLayout(groupLayout);

	}
}
