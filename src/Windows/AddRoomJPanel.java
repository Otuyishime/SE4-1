package Windows;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddRoomJPanel extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddRoomJPanel(JFrame currentFrame) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblCreateAndAdd = new JLabel("Create and Add a New Room");
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
		
		// Add button - it adds a new Room from the creation page
		JButton btn_addNewRoom = new JButton("Add");
		btn_addNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Get info from text fields, Create a new Room and add it to the list of Rooms 
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RoomListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_addNewRoom.setBounds(172, 340, 100, 30);
		add(btn_addNewRoom);
		
		// Cancel button - it cancels the action of creating a new Room 
		// and goes back to the Room list page
		JButton btn_cancelNewRoom = new JButton("Cancel");
		btn_cancelNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// Nothing to do here - just go back to the Room list page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RoomListJPanel(currentFrame));
				currentFrame.revalidate();	
			}
		});
		btn_cancelNewRoom.setBounds(306, 340, 100, 30);
		add(btn_cancelNewRoom);


	}

}
