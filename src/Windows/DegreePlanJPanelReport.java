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

import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.University;

import javax.swing.JList;

public class DegreePlanJPanelReport extends JPanel {
	
	private DefaultListModel <Degree> listModel_DegreePlan;
	private JList list_degree;
	private JButton btnGenerateReport;
	private JScrollPane degreeplanScrollPane;


	/**
	 * Create the panel.
	 * @param university 
	 * @param currentFrame 
	 */
	public DegreePlanJPanelReport(JFrame currentFrame, University university) {
		
		JButton btnGenerateReport = new JButton("Generate Report");
		
		JLabel lblReportDegreePlan = new JLabel("REPORT: DEGREE PLAN");
		
		 degreeplanScrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnGenerateReport)
								.addComponent(lblReportDegreePlan)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addComponent(degreeplanScrollPane, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(lblReportDegreePlan)
					.addGap(18)
					.addComponent(btnGenerateReport)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(degreeplanScrollPane, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		
		listModel_DegreePlan = new DefaultListModel<>();
		for (Degree degree : university.getDegrees())
			listModel_DegreePlan.addElement(degree);
		list_degree = new JList<Degree>(listModel_DegreePlan);
 
		degreeplanScrollPane.setViewportView(list_degree);
		setLayout(groupLayout);

	}

	

}
