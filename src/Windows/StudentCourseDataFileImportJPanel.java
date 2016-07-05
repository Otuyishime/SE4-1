package Windows;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import OcGraduateSystemClasses.University;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;

public class StudentCourseDataFileImportJPanel extends JPanel {
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
						  
						  
						  
					  }catch (Exception error){
						  error.printStackTrace();
						  
					  }
					  
				  }
				
				
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("IMPORT STUDENT COURSE DATA CSV FILE");
		
		JProgressBar progressBar = new JProgressBar();
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
							.addGap(153)
							.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnImportStudentCourseDataButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(266, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}
}
