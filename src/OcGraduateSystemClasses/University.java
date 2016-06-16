package OcGraduateSystemClasses;

import java.util.*;

/**
 * This class represents an institution for higher learning.
 * This occupies the highest level of hierarchy
 */
public class University
{
	private String name;
	
	private String abbreviation;

	// --------------- Lists ------------------
	private ArrayList<GradSchool> gradSchools;
	
	private ArrayList<Semester> semesters;
	
	private ArrayList<Course> courses;
	
	private ArrayList<Degree> degrees;
	
	private ArrayList<DegreePlan> degreeplans;
	
	private ArrayList<Student> students;
	
	private ArrayList<Faculty> faculties;
	
	private ArrayList<Room> rooms;
	
	// -------------- Accessors ---------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public ArrayList<GradSchool> getGradSchools() {
		return gradSchools;
	}

	public void setGradSchools(ArrayList<GradSchool> gradSchools) {
		this.gradSchools = gradSchools;
	}

	public ArrayList<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(ArrayList<Semester> semesters) {
		this.semesters = semesters;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public ArrayList<Degree> getDegrees() {
		return degrees;
	}

	public void setDegrees(ArrayList<Degree> degrees) {
		this.degrees = degrees;
	}

	public ArrayList<DegreePlan> getDegreeplans() {
		return degreeplans;
	}

	public void setDegreeplans(ArrayList<DegreePlan> degreeplans) {
		this.degreeplans = degreeplans;
	}

	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	/**
	 * Object Constructor
	 * @param name The name has to be a non-empty string
	 */
	
	public University(String name) {
		if (!name.isEmpty()){
			setName(name);
		}
		else{
			System.out.println("university was not created!");
		}
	}

	/**
	 * Object Constructor
	 * @param name The name has to be a non-empty string
	 * @param abbreviation the abbreviation has to be a non-empty string
	 */
	public University(String name, String abbreviation) {
		if (!name.isEmpty() && !abbreviation.isEmpty()){
			setName(name);
			setAbbreviation(abbreviation);
		}
		else{
			System.out.println("university was not created!");
		}
	}
}