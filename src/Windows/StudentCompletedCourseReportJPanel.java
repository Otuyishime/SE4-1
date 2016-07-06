package Windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;

import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;
import OcGraduateSystemClasses.University;

import javax.swing.JList;

public class StudentCompletedCourseReportJPanel extends JPanel {
	
	private DefaultListModel <StudentCourse> listModel_student;
	private JList list_student;
	private JScrollPane studentLoadScrollPane;

	/**
	 * Create the panel.
	 * @param university 
	 * @param currentFrame 
	 */
	public StudentCompletedCourseReportJPanel(JFrame currentFrame, University university) {
		
		JLabel lblReportStudentCourse = new JLabel("REPORT: STUDENT COURSE COMPLETENESS");
		
		studentLoadScrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(studentLoadScrollPane, GroupLayout.PREFERRED_SIZE, 820, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(97)
							.addComponent(lblReportStudentCourse)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(lblReportStudentCourse)
					.addGap(34)
					.addComponent(studentLoadScrollPane, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		listModel_student = new DefaultListModel<>();
		for (Student student : university.getStudents())
			for ( StudentCourse studentCourse: student.getStudentcoursesTaken())
			
		listModel_student.addElement(studentCourse);
		list_student = new JList<StudentCourse >(listModel_student);
		studentLoadScrollPane.setViewportView(list_student);
		setLayout(groupLayout);

	}

}
