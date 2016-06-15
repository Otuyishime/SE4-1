package OcGraduateSystemClasses;

/**
 * Represents the number of hours the faculty can teach
 */
public class FacultyLoad
{

	private Faculty faculty;
	private Semester semester;
	/**
	 * Number of hours the faculty can teach
	 */
	private int hours;
	
	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getHours() {
		return hours;
	}
 //  Test git
	public void setHours(int hours) {
		this.hours = hours;
	}

	public FacultyLoad() {
		// TODO - implement FacultyLoad.FacultyLoad
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param faculty
	 * @param semester
	 */
	public FacultyLoad(Faculty faculty, Semester semester, int hours) {
		throw new UnsupportedOperationException();
	}

	/**
	 * returns the number of hours the faculty can teach in a semester
	 * @param semester
	 */
	public int getLoad(Semester semester) {
		// TODO - implement FacultyLoad.getLoad
		throw new UnsupportedOperationException();
	}

}