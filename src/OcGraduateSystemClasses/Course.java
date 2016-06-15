package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents a class the student can to take as he/she pursues his/her degree.
 */
public class Course
{

	private String prereq;
	
	private ArrayList<Course> prerequisites;
	
	private ArrayList<String> teachers;
	
	private Faculty faculty;
	
	private ArrayList<Section> sections;
	/**
	 * the name of the class
	 */
	private String courseName;
	
	private String courseCode;
	/**
	 * the semester in which the course is offered
	 */
	private String description;
	/**
	 * number of hours the course is offered in the week
	 */
	private int creditHours;
	/**
	 * number of students who can take the course
	 */
	private int courseCap;

	private boolean isOfferedFall;
	
	private boolean isOfferedSpring;
	
	private boolean isOfferedSummer;
	
	
	public ArrayList<String> getTeachers() {
		return teachers;
	}

	public void setTeachers(ArrayList<String> teacher) {
		this.teachers = teacher;
	}

	public String getPrereq() {
		return prereq;
	}

	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}

	public ArrayList<Course> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(ArrayList<Course> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public ArrayList<Section> getSections() {
		return sections;
	}

	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public int getCourseCap() {
		return courseCap;
	}

	public void setCourseCap(int classCap) {
		this.courseCap = classCap;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public boolean isOfferedFall() {
		return isOfferedFall;
	}

	public void setOfferedFall(boolean isOfferedFall) {
		this.isOfferedFall = isOfferedFall;
	}

	public boolean isOfferedSpring() {
		return isOfferedSpring;
	}

	public void setOfferedSpring(boolean isOfferedSpring) {
		this.isOfferedSpring = isOfferedSpring;
	}

	public boolean isOfferedSummer() {
		return isOfferedSummer;
	}

	public void setOfferedSummer(boolean isOfferedSummer) {
		this.isOfferedSummer = isOfferedSummer;
	}

	/**
	 * 
	 * @param name
	 * @param description
	 * @param credithours
	 */
	public Course(String code, String name, String description, 
			int credithours, int coursecap, 
			boolean isofferedfall,  boolean isofferedspring,  boolean isofferedsummer, 
			String prereq, ArrayList<String> teachers) {
		
		if ((!code.isEmpty() && !name.isEmpty() && !description.isEmpty() ) && credithours > 0){
			setCourseCode(code);
			setCourseName(name);
			setDescription(description);
			setCreditHours(credithours);
			setCourseCap(coursecap);
			setOfferedFall(isofferedfall);
			setOfferedSpring(isofferedspring);
			setOfferedSummer(isofferedsummer);
			setPrereq(prereq);
			setTeachers(teachers);
			
			// initialize prerequisites
			prerequisites = new ArrayList<Course>();
		}
		else{
			throw new UnsupportedOperationException();
		}
	}
	
	// add a prerequisite
	public boolean addPreRequisite(Course prereq){
		if (prereq != null){
			getPrerequisites().add(prereq);
			return true;
		}
		return false;
	}
	

}