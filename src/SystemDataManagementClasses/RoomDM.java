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
		// TODO Auto-generated constructor stub
	}
	
}
