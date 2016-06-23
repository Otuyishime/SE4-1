package OcGraduateSystemClasses;

/**
 * The location in which classes are taught. This represents the physical building.
 */
public class Room
{

	private Section section;
	/**
	 * the building in which the room is located
	 */
	private String roombuilding;
	/**
	 * the room number to help identify and differentiate rooms
	 */
	private int roomNumber;
	/**
	 * maximum number of people that can use the room at the same time.
	 */
	private int capacity;
	
	private boolean available;

	/**
	 * 
	 * @param number
	 * @param building
	 */
	public Room(int room_number, String building) {
		// TODO - implement Room.Room
		if ( room_number > 0 && !building.isEmpty()){
			roomNumber = room_number;
			roombuilding = building;
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

}