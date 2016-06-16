package Windows;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UniversityEditPanel extends JPanel {
	private JTextField txt_universityName;

	/**
	 * Create the panel.
	 */
	public UniversityEditPanel(JFrame currentFrame) {
		setBounds(new Rectangle(0, 0, 700, 600));
		
		setLayout(null);

		
		JLabel lblEditUniversityInformation = new JLabel("Edit University Information");
		lblEditUniversityInformation.setBounds(new Rectangle(200, 50, 300, 30));
		lblEditUniversityInformation.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(lblEditUniversityInformation);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(new Rectangle(150, 150, 50, 25));
		add(lblName);
		
		txt_universityName = new JTextField();
		txt_universityName.setText("Oklahoma Chrisrian University");
		txt_universityName.setBounds(200, 150, 250, 25);
		add(txt_universityName);
		txt_universityName.setColumns(10);
		
		// Save button - it saves the edited university information
		JButton btn_saveUniversityEdit = new JButton("Save");
		btn_saveUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel());
				currentFrame.revalidate();	
			}
		});
		btn_saveUniversityEdit.setBounds(204, 222, 100, 30);
		add(btn_saveUniversityEdit);
		
		// Cancel button - it cancels the editing mode of the university information
		JButton btn_cancelUniversityEdit = new JButton("Cancel");
		btn_cancelUniversityEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel());
				currentFrame.revalidate();	
			}
		});
		btn_cancelUniversityEdit.setBounds(316, 222, 100, 30);
		add(btn_cancelUniversityEdit);

	}
}
