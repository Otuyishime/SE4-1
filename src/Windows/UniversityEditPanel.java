package Windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import OcGraduateSystemClasses.University;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UniversityEditPanel extends JPanel {
	private JTextField txt_universityName;
	private JTextField text_abbreviation;

	/**
	 * Create the panel.
	 */
	public UniversityEditPanel(JFrame currentFrame, University university) {
		setBounds(new Rectangle(0, 0, 700, 600));
		setLayout(null);
		
		JLabel lblEditUniversityInformation = new JLabel("Edit University Information");
		lblEditUniversityInformation.setBounds(new Rectangle(200, 50, 300, 30));
		lblEditUniversityInformation.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(lblEditUniversityInformation);
		
		// label and text field for university name
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(new Rectangle(150, 150, 100, 25));
		add(lblName);
		
		txt_universityName = new JTextField();
		txt_universityName.setText(university.getName());
		txt_universityName.setBounds(250, 150, 250, 25);
		add(txt_universityName);
		txt_universityName.setColumns(10);
		
		// label and text field for university abbreviation
		JLabel lblAbbreviation = new JLabel("Abbreviation");
		lblAbbreviation.setBounds(150, 200, 100, 25);
		add(lblAbbreviation);
		
		text_abbreviation = new JTextField(university.getAbbreviation());
		text_abbreviation.setBounds(250, 200, 130, 25);
		add(text_abbreviation);
		text_abbreviation.setColumns(10);
		
		// Save button - it saves the edited university information
		JButton btn_saveUniversityEdit = new JButton("Save");
		btn_saveUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - get the new name and code and save it
				// add error handling - when the field is left empty
				String newName = txt_universityName.getText();
				university.setName(newName);
				
				String newAbbreviation = text_abbreviation.getText();
				university.setAbbreviation(newAbbreviation);
				
				System.out.println("New name - " + newName);
				System.out.println("New abbr - " + newAbbreviation);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_saveUniversityEdit.setBounds(204, 300, 100, 30);
		add(btn_saveUniversityEdit);
		
		// Cancel button - it cancels the editing mode of the university information
		JButton btn_cancelUniversityEdit = new JButton("Cancel");
		btn_cancelUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelUniversityEdit.setBounds(316, 300, 100, 30);
		add(btn_cancelUniversityEdit);
	}
}
