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

public class RoomListJPanel extends JPanel {
	private JButton btn_RoomsListToMain;

	/**
	 * Create the panel.
	 */
	public RoomListJPanel(JFrame currentFrame, University university) {
		
		setBounds(new Rectangle(0, 0, 700, 650));
		setLayout(null);
		
		JLabel lblListOfAvailable = new JLabel("List of Available Rooms");
		lblListOfAvailable.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblListOfAvailable.setBounds(100, 20, 300, 25);
		add(lblListOfAvailable);
		
		JList list_Rooms = new JList();
		list_Rooms.setBounds(100, 50, 300, 500);
		add(list_Rooms);
		
		// Add button - it leads to a new Room creation Room
		JButton btn_createNewRoom = new JButton("Add");
		btn_createNewRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddRoomJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_createNewRoom.setBounds(500, 50, 100, 30);
		add(btn_createNewRoom);
		
		// Edit button - it takes you to a Room edit page
		JButton btn_editRoomInfo = new JButton("Edit");
		btn_editRoomInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected Room and pass its information to the edit page
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EditRoomJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_editRoomInfo.setBounds(500, 100, 100, 30);
		add(btn_editRoomInfo);
		
		// Delete button - it deletes the selected Room from the list
		JButton btn_deleteRoom = new JButton("Delete");
		btn_deleteRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// TODO
				// get the selected Room and deleted if from the list
				
				// stay on the same page - refresh 
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RoomListJPanel(currentFrame, university));
				currentFrame.revalidate();	
			}
		});
		btn_deleteRoom.setBounds(500, 150, 100, 30);
		add(btn_deleteRoom);
		
		// Back button from the list of Rooms back to main
		btn_RoomsListToMain = new JButton("< Back");
		btn_RoomsListToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new MainJPanel(university));
				currentFrame.revalidate();	
			}
		});
		btn_RoomsListToMain.setBounds(500, 200, 100, 30);
		add(btn_RoomsListToMain);


	}

}
