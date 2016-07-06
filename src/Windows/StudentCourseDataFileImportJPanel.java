package Windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;
import OcGraduateSystemClasses.University;
import SystemDataManagementClasses.UniversityDM;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.csvreader.CsvReader;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class StudentCourseDataFileImportJPanel extends JPanel {
	static UniversityDM universityDM;
	//static University universitydata;

	private DefaultListModel <StudentCourse> listModel_student;
	private JList<StudentCourse> list_student;
	private JScrollPane studentLoadScrollPane;

	private JButton btnImportStudentCourseDataButton;
	private JFileChooser fileChooser;
	private File file; // file url directory
	int returnVal;

	/**
	 * Create the panel.
	 * @param university 
	 * @param currentFrame 
	 */
	public StudentCourseDataFileImportJPanel(JFrame currentFrame, University university) {
		 
		fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter( "CSV files (*csv)", "csv");
		fileChooser.setFileFilter(filter);
		
		btnImportStudentCourseDataButton = new JButton("IMPORT");
		
		btnImportStudentCourseDataButton.setBounds(250, 150, 250, 25);
		
		btnImportStudentCourseDataButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  returnVal = fileChooser.showOpenDialog(null);
				  if(returnVal == JFileChooser.APPROVE_OPTION){
					  
					  file =fileChooser.getSelectedFile();
					  
					 
					  System.out.println(file.toString());
					  //Read the uploaded file!
					  
					  try{
						  if (file != null){
							  JOptionPane.showMessageDialog(StudentCourseDataFileImportJPanel.this,
			                          " ! You have successfully uploaded Students Course Data csv file.",
			                            "Upload file",
			                            JOptionPane.INFORMATION_MESSAGE);
							  
							   
							   
							   // String studentsfilelocation = file.toString();
							    //universityDM.importStudentCourses(file.toString());
							    
								listModel_student = new DefaultListModel<>();
								for (Student student : university.getStudents())
									for ( StudentCourse studentCourse: student.getStudentcoursesTaken())

							    listModel_student.addElement(studentCourse);
								list_student = new JList<StudentCourse >(listModel_student);
								studentLoadScrollPane.setViewportView(list_student);
							  
							  
						  }
						  
					  }catch (NullPointerException err){
						  
						  System.out.println("There is some null pointer");
						  err.printStackTrace();
					  }catch (Exception error){
						  error.printStackTrace();
					  }
					  
				  }
				
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("IMPORT STUDENT COURSE DATA CSV FILE");
		
		 studentLoadScrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addComponent(btnImportStudentCourseDataButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addComponent(studentLoadScrollPane, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnImportStudentCourseDataButton)
					.addGap(18)
					.addComponent(studentLoadScrollPane, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
		);
	
		setLayout(groupLayout);

	}
}
