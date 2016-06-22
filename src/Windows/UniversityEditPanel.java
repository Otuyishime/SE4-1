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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UniversityEditPanel extends JPanel {
	
	private JLabel lblEditUniversityInformation;
	private JLabel lblName;
	private JTextField txt_universityName;
	private JLabel lblAbbreviation;
	private JTextField text_abbreviation;
	private String newAbbreviation;
	private String newName;
	private JButton btn_saveUniversityEdit;
	private JButton btn_cancelUniversityEdit;

	/**
	 * Create the panel.
	 */
	public UniversityEditPanel(JFrame currentFrame, University university) {
		setBounds(new Rectangle(0, 0, 700, 600));
		setLayout(null);
		
		lblEditUniversityInformation = new JLabel("Edit University Information");
		lblEditUniversityInformation.setBounds(new Rectangle(200, 50, 300, 30));
		lblEditUniversityInformation.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(lblEditUniversityInformation);
		
		// label and text field for university name
		lblName = new JLabel("Name:");
		lblName.setBounds(new Rectangle(150, 150, 100, 25));
		add(lblName);
		
		newAbbreviation = university.getName();
		newName = university.getAbbreviation();
		txt_universityName = new JTextField();
		// if a key is released, check if the name field something typed in it
		// and respond accordingly
		txt_universityName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				newAbbreviation = text_abbreviation.getText();
				newName = txt_universityName.getText();
				if ((newName.replace(" ", "").compareTo("") == 0) || ((newAbbreviation.replace(" ", "").compareTo("") == 0)))
					btn_saveUniversityEdit.setEnabled(false);
				else
					btn_saveUniversityEdit.setEnabled(true);
			}
		});
		txt_universityName.setText(university.getName());
		txt_universityName.setBounds(250, 150, 250, 25);
		add(txt_universityName);
		txt_universityName.setColumns(10);
		
		// label and text field for university abbreviation
		lblAbbreviation = new JLabel("Abbreviation");
		lblAbbreviation.setBounds(150, 200, 100, 25);
		add(lblAbbreviation);
		
		text_abbreviation = new JTextField(university.getAbbreviation());
		// if a key is released, check if the name abbreviation field something typed in it
		// and respond accordingly
		text_abbreviation.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				newAbbreviation = text_abbreviation.getText();
				newName = txt_universityName.getText();
				if ((newName.replace(" ", "").compareTo("") == 0) || ((newAbbreviation.replace(" ", "").compareTo("") == 0)))
					btn_saveUniversityEdit.setEnabled(false);
				else
					btn_saveUniversityEdit.setEnabled(true);
			}
		});
		text_abbreviation.setBounds(250, 200, 130, 25);
		add(text_abbreviation);
		text_abbreviation.setColumns(10);
		
		// Save button - it saves the edited university information
		btn_saveUniversityEdit = new JButton("Save");
		btn_saveUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO - get the new name and code and save it
				// add error handling - when the field is left empty
				university.setName(newName);
				university.setAbbreviation(newAbbreviation);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_saveUniversityEdit.setBounds(204, 300, 100, 30);
		add(btn_saveUniversityEdit);
		
		// Cancel button - it cancels the editing mode of the university information
		btn_cancelUniversityEdit = new JButton("Cancel");
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
