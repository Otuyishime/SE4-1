package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.FacultyLoad;
import OcGraduateSystemClasses.University;

import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AddFacultyJPanel extends JPanel {
	private JTextField textField_firstname;
	private JTextField textField_lastname;
	private JTextField textField_gradschool;
	private JTextField textField_degree;
	private JTextField textField_title;
	
	private JButton btn_addNewFaculty;
	
	private boolean first_ok;
	private boolean last_ok;
	private boolean gradschool_ok;
	private boolean degree_ok;
	private boolean title_ok;
	private boolean fallload_ok;
	private boolean springload_ok;
	private boolean summerload_ok;
	
	private String firstname;
	private String lastname;
	private String gradschool;
	private String degree;
	private String title;
	private String fallload;
	private String springload;
	private String summerload;
	private JTextField textField_fallload;
	private JTextField textField_springload;
	private JTextField textField_summerload;

	/**
	 * Create the panel.
	 */
	public AddFacultyJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		first_ok = last_ok = gradschool_ok = degree_ok = title_ok = fallload_ok = springload_ok = summerload_ok = false;
		firstname = lastname = gradschool = degree = title = "";
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Faculty");
		lblCreateAndAdd.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblCreateAndAdd.setBounds(100, 50, 250, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setBounds(100, 120, 80, 25);
		add(lblName);
		
		textField_firstname = new JTextField();
		textField_firstname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				firstname = textField_firstname.getText();
				if ((firstname.replace(" ", "").compareTo("") == 0))
					first_ok = false;
				else
					first_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_firstname.setToolTipText("");
		textField_firstname.setBounds(180, 120, 200, 25);
		add(textField_firstname);
		textField_firstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(100, 150, 80, 25);
		add(lblLastName);
		
		textField_lastname = new JTextField();
		textField_lastname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				lastname = textField_lastname.getText();
				if ((lastname.replace(" ", "").compareTo("") == 0))
					last_ok = false;
				else
					last_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_lastname.setBounds(180, 150, 200, 25);
		add(textField_lastname);
		textField_lastname.setColumns(10);
		
		JLabel lblGradSchool = new JLabel("Grad School:");
		lblGradSchool.setBounds(100, 180, 80, 25);
		add(lblGradSchool);
		
		textField_gradschool = new JTextField();
		textField_gradschool.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				gradschool = textField_gradschool.getText();
				if ((gradschool.replace(" ", "").compareTo("") == 0))
					gradschool_ok = false;
				else
					gradschool_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_gradschool.setBounds(180, 180, 200, 25);
		add(textField_gradschool);
		textField_gradschool.setColumns(10);
		
		JLabel lblDegree = new JLabel("Degree:");
		lblDegree.setBounds(100, 210, 80, 25);
		add(lblDegree);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(100, 240, 80, 25);
		add(lblTitle);
		
		textField_degree = new JTextField();
		textField_degree.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				degree = textField_degree.getText();
				if ((degree.replace(" ", "").compareTo("") == 0))
					degree_ok = false;
				else
					degree_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_degree.setBounds(180, 210, 200, 25);
		add(textField_degree);
		textField_degree.setColumns(10);
		
		textField_title = new JTextField();
		textField_title.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				title = textField_title.getText();
				if ((title.replace(" ", "").compareTo("") == 0))
					title_ok = false;
				else
					title_ok = true;
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_title.setBounds(180, 240, 200, 25);
		add(textField_title);
		textField_title.setColumns(10);
		
		JCheckBox chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.setBounds(180, 270, 100, 25);
		add(chckbxMonday);
		
		JLabel lblDays = new JLabel("Days:");
		lblDays.setBounds(100, 270, 80, 25);
		add(lblDays);
		
		JCheckBox chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.setBounds(285, 270, 100, 25);
		add(chckbxTuesday);
		
		JCheckBox chckbxWednsday = new JCheckBox("Wednesday");
		chckbxWednsday.setBounds(390, 270, 110, 25);
		add(chckbxWednsday);
		
		JCheckBox chckbxThursday = new JCheckBox("Thursday");
		chckbxThursday.setBounds(180, 300, 100, 25);
		add(chckbxThursday);
		
		JCheckBox chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.setBounds(285, 300, 100, 25);
		add(chckbxFriday);
		
		// Add button - it adds a new faculty from the creation page
		btn_addNewFaculty = new JButton("Add");
		btn_addNewFaculty.setEnabled(false);
		btn_addNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new faculty and add it to the list of courses 
				
				firstname = textField_firstname.getText();
				lastname = textField_lastname.getText();
				gradschool = textField_gradschool.getText();
				degree = textField_degree.getText();
				title = textField_title.getText();
				int fall = Integer.parseInt(textField_fallload.getText());
				int spring =  Integer.parseInt(textField_springload.getText());
				int summer = Integer.parseInt(textField_summerload.getText());
				
				FacultyLoad fallLoad = new FacultyLoad(fall);
				FacultyLoad springLoad = new FacultyLoad(spring);
				FacultyLoad summerLoad = new FacultyLoad(summer);
				ArrayList<FacultyLoad> loads = new ArrayList<FacultyLoad>();
				loads.add(fallLoad);
				loads.add(springLoad);
				loads.add(summerLoad);
				Faculty newfaculty = new Faculty(firstname, lastname, gradschool, degree, title, "MTR", loads);
				
				// TODO - get the real values of the days - please
				//String days = textField_degree.getText();
				//days = "MTR";
				
				// create a new faculty and add them to the existing list
				//Faculty newfaculty = new Faculty(firstname, lastname, gradschool, degree, title, days, fall , spring, summer);
				university.addFaculty(newfaculty);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_addNewFaculty.setBounds(180, 498, 100, 30);
		add(btn_addNewFaculty);
		
		// Cancel button - it cancels the action of creating a new faculty 
		// and goes back to the faculty list page
		JButton btn_cancelNewFaculty = new JButton("Cancel");
		btn_cancelNewFaculty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the course list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new FacultyListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewFaculty.setBounds(296, 498, 100, 30);
		add(btn_cancelNewFaculty);
		
		JLabel lblLoads = new JLabel("Loads:");
		lblLoads.setBounds(100, 340, 80, 25);
		add(lblLoads);
		
		JLabel lblFall = new JLabel("Fall:");
		lblFall.setBounds(190, 340, 61, 25);
		add(lblFall);
		
		JLabel lblSpring = new JLabel("Spring:");
		lblSpring.setBounds(190, 370, 61, 25);
		add(lblSpring);
		
		JLabel lblSummer = new JLabel("Summer:");
		lblSummer.setBounds(190, 400, 61, 25);
		add(lblSummer);
		
		textField_fallload = new JTextField();
		textField_fallload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				fallload = textField_fallload.getText();
				if ((fallload.replace(" ", "").compareTo("") == 0))
					fallload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_fallload.getText());
						 fallload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 fallload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_fallload.setBounds(260, 340, 60, 25);
		add(textField_fallload);
		textField_fallload.setColumns(10);
		
		textField_springload = new JTextField();
		textField_springload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				springload = textField_springload.getText();
				if ((springload.replace(" ", "").compareTo("") == 0))
					springload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_springload.getText());
						 springload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 springload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);
			}
		});
		textField_springload.setBounds(260, 370, 60, 25);
		add(textField_springload);
		textField_springload.setColumns(10);
		
		textField_summerload = new JTextField();
		textField_summerload.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				summerload = textField_summerload.getText();
				if ((summerload.replace(" ", "").compareTo("") == 0))
					summerload_ok = false;
				else
				{
					 try
					 {
						 Integer.parseInt(textField_summerload.getText());
						 summerload_ok = true;
					 }
					 catch (NumberFormatException e1)
					 {
						 summerload_ok = false;
					 }
				}
		
				// enable the add button
				if (first_ok & last_ok & gradschool_ok & degree_ok & title_ok & fallload_ok & springload_ok & summerload_ok)
					btn_addNewFaculty.setEnabled(true);
				else
					btn_addNewFaculty.setEnabled(false);	
			}
		});
		textField_summerload.setBounds(260, 399, 60, 25);
		add(textField_summerload);
		textField_summerload.setColumns(10);
	}
}
