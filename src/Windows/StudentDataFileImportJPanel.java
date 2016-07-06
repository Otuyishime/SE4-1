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
import javax.swing.filechooser.FileNameExtensionFilter;

import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;
import OcGraduateSystemClasses.University;
import SystemDataManagementClasses.UniversityDM;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class StudentDataFileImportJPanel extends JPanel {
	
	static UniversityDM universityDM;
	//static University universitydata;
	private DefaultListModel <Student> listModel_student;
	private JList<Student> list_student;
	private JScrollPane studentDataScrollPane;
	
	private JButton btnImportStudentCourseDataButton;
	private JFileChooser fileChooser;
	private File file; // file url directory
	int returnVal;

	/**
	 * Create the panel.
	 * @param university 
	 * @param currentFrame 
	 */
	public StudentDataFileImportJPanel(JFrame currentFrame, University university) {
		 
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
					  if(file !=null){
						  
						  JOptionPane.showMessageDialog(StudentDataFileImportJPanel.this,
		                          " ! You have successfully uploaded student data csv file.",
		                            "Upload file",
		                            JOptionPane.INFORMATION_MESSAGE);
						  
					  }
					  System.out.println(file.toString());
					  //Read the uploaded file!
					  
					  try{
						  
						  if (file != null){
							  JOptionPane.showMessageDialog(StudentDataFileImportJPanel.this,
			                          " ! You have successfully uploaded Students  Data csv file.",
			                            "Upload file",
			                            JOptionPane.INFORMATION_MESSAGE);
							   
							    //universityDM.importStudents(file.toString());
							    
								listModel_student = new DefaultListModel<>();
								for (Student student : university.getStudents())

							    listModel_student.addElement(student);
								list_student = new JList<Student >(listModel_student);
								studentDataScrollPane.setViewportView(list_student);
							  
							  
						  }    
						  
						  
					  }catch (Exception error){
						  error.printStackTrace();
						  
					  }
					  
				  }
				
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("IMPORT STUDENT  DATA CSV FILE");
		
		 studentDataScrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(173)
							.addComponent(btnImportStudentCourseDataButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addComponent(studentDataScrollPane, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(71, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnImportStudentCourseDataButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(studentDataScrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		
		setLayout(groupLayout);

	}
}
