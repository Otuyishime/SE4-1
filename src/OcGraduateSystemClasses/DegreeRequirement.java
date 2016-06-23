package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents a degree requirement
 */
public class DegreeRequirement
{
	
	private String degreeCode;
	
	public String getDegreeCode() {
		return degreeCode;
	}

	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	
	/**
	 * keep the list of courses
	 */
	private ArrayList<String> courseCodes;

	public ArrayList<String> getCourseCodes() {
		return courseCodes;
	}

	public void setCourseCodes(ArrayList<String> courseCodes) {
		this.courseCodes = courseCodes;
	}

	/**
	 * Keep a list of references to courses needed in the degree requirements
	 */
	private ArrayList<Course> courses;
	/**
	 * description of the requirements
	 */
	private String description;
	/**
	 * number of required hours to complete the degree
	 */
	private int hours;
	/**
	 * define the type of degree requirements
	 */
	private String degreeRequirementsType;
	
	/* Add all getters and setters*/
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public void addCourses(Course course){
		if (course != null){
			System.out.println(course);
			getCourses().add(course);
		}
		else{
			System.out.println("The course was not added to the degree requirement courses");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getDegreeRequirementsType() {
		return degreeRequirementsType;
	}

	public void setDegreeRequirementsType(String degreeRequirementsType) {
		this.degreeRequirementsType = degreeRequirementsType;
	}
	
	/**
	 * Constructor
	 * @param description and type must be non-empty strings
	 */
	public DegreeRequirement(String type, String description) {
		// set the description and the type
		if ( !type.isEmpty() && !description.isEmpty()){
			setDescription(description);
			setDegreeRequirementsType(type);
			
			// create the course list
			courses = new ArrayList<Course>();
		}
		else{
			System.out.println("Can't initialize the degree requirements");
		}
	}

	public DegreeRequirement(String type, String description, int hours, String degreecode) {
		// set the description and the type
		if (( !type.isEmpty() && !description.isEmpty() && !degreecode.isEmpty()) && hours > 0){
			setDescription(description);
			setDegreeRequirementsType(type);
			setHours(hours);
			setDegreeCode(degreecode);
			
			// create the course list
			courses = new ArrayList<Course>();
		}
		else{
			System.out.println("Can't initialize the degree requirements");
		}
	}
	
	public DegreeRequirement(String type, String description, int hours, String degreecode, ArrayList<String> courses) {
		// set the description and the type
		if (( !type.isEmpty() && !description.isEmpty() && !degreecode.isEmpty() && !courses.isEmpty()) && hours > 0){
			setDescription(description);
			setDegreeRequirementsType(type);
			setHours(hours);
			setDegreeCode(degreecode);
			setCourseCodes(courses);
		}
		else{
			System.out.println("Can't initialize the degree requirements");
		}
	}
	
	
	
	public void print(){
		// Print the course
		System.out.print(degreeCode);
		
		//degree.print();
	}
}