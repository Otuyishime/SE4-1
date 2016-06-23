package SystemDataManagementClasses;
import OcGraduateSystemClasses.Room;

import java.util.*;

public class RoomDM {
	
	/* Add some random rooms:
	 * These rooms are going to be used to test the system
	 * =Note: These rooms should be read from a file =====*/
	
	// Add a list of rooms
	private ArrayList<Room> rooms;

	// add accessors
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	// Add a default constructor
	public RoomDM() {
		super();
		// TODO - Create a room list in order to maintain the rooms
		rooms = new ArrayList<Room>();
		loadRandomRooms();
	}
	
	private void loadRandomRooms(){
		getRooms().add(new Room(201, "PEC"));
		getRooms().add(new Room(202, "PEC"));
		getRooms().add(new Room(203, "PEC"));
		getRooms().add(new Room(204, "PEC"));
		getRooms().add(new Room(205, "PEC"));
		getRooms().add(new Room(206, "PEC"));
		getRooms().add(new Room(207, "PEC"));
		getRooms().add(new Room(208, "PEC"));
	}
	
}
