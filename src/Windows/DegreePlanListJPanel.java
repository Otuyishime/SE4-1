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

// import com.sun.javafx.geom.transform.BaseTransform.Degree;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.University;
import OcGraduateSystemClasses.Degree;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class DegreePlanListJPanel extends JPanel {

	
	JScrollPane scrollpane;
	DefaultListModel <Degree> listModel;
	JList list_degreePlans;
	
	
	private JButton btn_createNewDegreePlan;
	private JButton btn_editDegreePlanInfo;
	private JButton btn_deleteDegreePlan;
	private JButton btn_DegreePlansListToMain;

	/**
	 * Create the panel.
	 */
	public DegreePlanListJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblListOfAvailable = new JLabel("List of Available Degrees");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(50, 20, 300, 25);
		add(lblListOfAvailable);
		
		// get the list of courses and create a list model for them 
		// the JList needs to be added to the scroll pane to give it the scrolling ability
		listModel = new DefaultListModel<>();
		for (Degree degree : university.getDegrees())
			listModel.addElement(degree);
		list_degreePlans = new JList(listModel);		
		list_degreePlans.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list_degreePlans.getSelectedValue() != null)
				{
					btn_editDegreePlanInfo.setEnabled(true);
					btn_deleteDegreePlan.setEnabled(true);
				}
				else{
					btn_editDegreePlanInfo.setEnabled(false);
					btn_deleteDegreePlan.setEnabled(false);
				}
			}
		});
		scrollpane = new JScrollPane(list_degreePlans);
		scrollpane.setBounds(50, 50, 400, 500);
		add(scrollpane);
		
		// Add button - it leads to a new DegreePlan creation DegreePlan
		btn_createNewDegreePlan = new JButton("Add");
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
		btn_editDegreePlanInfo = new JButton("Edit");
		btn_editDegreePlanInfo.setEnabled(false);
		btn_editDegreePlanInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected DegreePlan and pass its information to the edit page
				Degree selectedDegree = (Degree) list_degreePlans.getSelectedValue();
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditDegreePlanJPanel(currentFrame, university, selectedDegree));
				currentFrame.revalidate();	
			}
		});
		btn_editDegreePlanInfo.setBounds(500, 100, 100, 30);
		add(btn_editDegreePlanInfo);
		
		// Delete button - it deletes the selected DegreePlan from the list
		btn_deleteDegreePlan = new JButton("Delete");
		btn_deleteDegreePlan.setEnabled(false);
		btn_deleteDegreePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected Degree and deleted if from the list
				Degree selectedDegree = (Degree) list_degreePlans.getSelectedValue();
				university.removeDegree(selectedDegree);
				listModel.removeElement(selectedDegree);		
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
