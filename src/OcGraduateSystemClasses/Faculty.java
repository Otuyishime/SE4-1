package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents the person who teaches a particular course
 */
public class Faculty
{
	/**
	 * name of the faculty
	 */
	private String firstName;
	
	private String lastName;
	
	private String gradSchool;

	private String degree;
	/**
	 * title of the faculty ( e.g. Dr. or Mr. )
	 */
	private String title;
	/**
	 * hours the faculty can work per week in a semester
	 */
	private ArrayList<FacultyLoad> facultyLoads;
	/**
	 * Days in which the teacher member can teach
	 */
	private String teachingDays;
	/**
	 * semesters in which the faculty can teach
	 */
	private ArrayList<Semester> teachingSemesters;
	
	private ArrayList<Course> courses;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<FacultyLoad> getFacultyLoads() {
		return facultyLoads;
	}

	public void setFacultyLoads(ArrayList<FacultyLoad> facultyLoads) {
		this.facultyLoads = facultyLoads;
	}

	public String getTeachingDays() {
		return teachingDays;
	}

	public void setTeachingDays(String teachingDays) {
		this.teachingDays = teachingDays;
	}

	public ArrayList<Semester> getTeachingSemesters() {
		return teachingSemesters;
	}

	public void setTeachingSemesters(ArrayList<Semester> teachingSemesters) {
		this.teachingSemesters = teachingSemesters;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	/**
	 * 
	 * @param name
	 * @param degree
	 */
	public Faculty(String firstname, String lastname, String gradschool, String degree, String title, 
			String teachdays, ArrayList<FacultyLoad> arrayList) {
		if (!firstname.isEmpty() && !lastname.isEmpty() && !gradschool.isEmpty() && !degree.isEmpty() && 
				!title.isEmpty() && !teachdays.isEmpty() && arrayList != null){
			setFirstName(firstname);
			setLastName(lastname);
			setGradSchool(gradschool);
			setDegree(degree);
			setTitle(title);
			setFacultyLoads(arrayList);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}
	
	public Faculty(String firstname, String lastname, String degree, String title) {
		// TODO - implement Faculty.Faculty
		throw new UnsupportedOperationException();
	}

	/**
	 * add to the sections the faculty can teach
	 * @param schedule
	 */
	public void canTeachAddSection(Schedule schedule) {
		// TODO - implement Faculty.canTeachAddSection
		throw new UnsupportedOperationException();
	}

	/**
	 * Course the faculty can teach and the semester in which the faculty can teach it
	 * @param course
	 * @param semester
	 */
	public void canTeach(Course course, Semester semester) {
		// TODO - implement Faculty.canTeach
		throw new UnsupportedOperationException();
	}

	/**
	 * returns all sections the faculty can teach
	 */
	public void getSectionsCanTeach() {
		// TODO - implement Faculty.getSectionsCanTeach
		throw new UnsupportedOperationException();
	}

}