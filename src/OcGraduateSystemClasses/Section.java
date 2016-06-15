package OcGraduateSystemClasses;

/**
 * a division of class offered in a particular semester
 */
public class Section
{

	private Course course;
	private Schedule secion;
	private Faculty faculty;
	/**
	 * represents the section number. This number is used to identify and differentiate sections
	 */
	private int sectionNumber;
	/**
	 * The room in which the class section will be taught
	 */
	private Room room;
	/**
	 * season( or period) in which the class section will be offered
	 */
	private Semester semester;
	/**
	 * students who are attending the section
	 */
	private Student students;

	/**
	 * Default Constructor
	 * @param number
	 * @param semester
	 */
	public Section(int number, Semester semester) {
		// TODO - implement Section.Section
		throw new UnsupportedOperationException();
	}

	/**
	 * adds the faculty who can teach the course
	 * @param faculty
	 */
	public void setCanTeachFaculty(Faculty faculty) {
		// TODO - implement Section.setCanTeachFaculty
		throw new UnsupportedOperationException();
	}

}