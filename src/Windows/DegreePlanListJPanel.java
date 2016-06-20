package Windows;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import OcGraduateSystemClasses.University;

public class DegreePlanListJPanel extends JPanel {
	
	private JButton btn_DegreePlansListToMain;

	/**
	 * Create the panel.
	 */
	public DegreePlanListJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblListOfAvailable = new JLabel("List of Available Degree Plans");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(100, 20, 300, 25);
		add(lblListOfAvailable);
		
		JList list_DegreePlans = new JList();
		list_DegreePlans.setBounds(100, 50, 300, 500);
		add(list_DegreePlans);
		
		// Add button - it leads to a new DegreePlan creation DegreePlan
		JButton btn_createNewDegreePlan = new JButton("Add");
		btn_createNewDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddDegreePlanJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_createNewDegreePlan.setBounds(500, 50, 100, 30);
		add(btn_createNewDegreePlan);
		
		// Edit button - it takes you to a DegreePlan edit page
		JButton btn_editDegreePlanInfo = new JButton("Edit");
		btn_editDegreePlanInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected DegreePlan and pass its information to the edit page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditDegreePlanJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_editDegreePlanInfo.setBounds(500, 100, 100, 30);
		add(btn_editDegreePlanInfo);
		
		// Delete button - it deletes the selected DegreePlan from the list
		JButton btn_deleteDegreePlan = new JButton("Delete");
		btn_deleteDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected DegreePlan and deleted if from the list
				
				// stay on the same page - refresh 
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new DegreePlanListJPanel(currentFrame, university ));
				currentFrame.revalidate();	
			}
		});
		btn_deleteDegreePlan.setBounds(500, 150, 100, 30);
		add(btn_deleteDegreePlan);
		
		// Back button from the list of DegreePlans back to main
		btn_DegreePlansListToMain = new JButton("< Back");
		btn_DegreePlansListToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_DegreePlansListToMain.setBounds(500, 200, 100, 30);
		add(btn_DegreePlansListToMain);


	}

}
