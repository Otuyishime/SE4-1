package Windows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import OcGraduateSystemClasses.University;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class StudentCourseDataFileImportJDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnImport;
	private JLabel lblImportStudentCourse;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			StudentCourseDataFileImportJDialog dialog = new StudentCourseDataFileImportJDialog(currentFrame,university );
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param university 
	 * @param currentFrame 
	 */
	public StudentCourseDataFileImportJDialog(JFrame currentFrame, University university) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btnImport = new JButton("IMPORT");
		}
		{
			lblImportStudentCourse = new JLabel("IMPORT STUDENT COURSE DATA");
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(105, Short.MAX_VALUE)
					.addComponent(lblImportStudentCourse)
					.addGap(130))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(168)
					.addComponent(btnImport)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblImportStudentCourse)
					.addGap(18)
					.addComponent(btnImport)
					.addContainerGap(155, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
