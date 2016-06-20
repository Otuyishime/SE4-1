package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import OcGraduateSystemClasses.University;

public class EditRoomJPanel extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public EditRoomJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Edit information about a Room");
		lblCreateAndAdd.setBounds(245, 56, 200, 30);
		add(lblCreateAndAdd);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(172, 121, 61, 16);
		add(lblName);
		
		textField = new JTextField();
		textField.setToolTipText("");
		textField.setBounds(245, 116, 200, 26);
		add(textField);
		textField.setColumns(10);
		
		// Update button - it updates an edited Room info from the editing page
		JButton btn_updateEditedRoom = new JButton("Update");
		btn_updateEditedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get new info from text fields, and update a current Room to save updated info
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RoomListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_updateEditedRoom.setBounds(172, 340, 100, 30);
		add(btn_updateEditedRoom);
		
		// Cancel button - it cancels the action of editing a Room 
		// and goes back to the Room list page
		JButton btn_cancelEditedRoom = new JButton("Cancel");
		btn_cancelEditedRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the Room list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RoomListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_cancelEditedRoom.setBounds(306, 340, 100, 30);
		add(btn_cancelEditedRoom);


	}

}
