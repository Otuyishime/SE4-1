package OcGraduateSystemClasses;

/**
 * The location in which classes are taught. This represents the physical building.
 */
public class Room
{

	private Section section;
	
	private String roombuilding;
	
	private int roomNumber;
	
	private boolean available;

	// ------------ Accessors ---------------
	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public String getRoombuilding() {
		return roombuilding;
	}

	public void setRoombuilding(String roombuilding) {
		this.roombuilding = roombuilding;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	// ------------------- Methods -----------------
	public Room(int room_number, String building) {
		if ( room_number > 0 && !building.isEmpty()){
			setRoomNumber( room_number);
			setRoombuilding( building);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public String toString() {
		return "Room [section=" + section + ", roombuilding=" + roombuilding + ", roomNumber=" + roomNumber + "]";
	}
	
	

}