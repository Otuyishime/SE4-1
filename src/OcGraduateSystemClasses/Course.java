package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents a class the student can to take as he/she pursues his/her degree.
 */
public class Course
{
	private String courseName;
	
	private String courseCode;
	
	private String description;
	
	private int creditHours;
	
	private int courseCap;
	
	private String prereq;

	private boolean isOfferedFall;
	
	private boolean isOfferedSpring;
	
	private boolean isOfferedSummer;
	
	// ------------------- Lists -------------------------
	private ArrayList<Course> prerequisites;
	
	private ArrayList<String> teachers;
	
	private ArrayList<Section> sections;
	
	private ArrayList<Faculty> faculties;
	
	// -------------------- Accessors ---------------------
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

	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}

	// ------------------- Methods ----------------------
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
			// initialize faculties:faculties
			faculties = new ArrayList<Faculty>();
		}
		else{
			throw new UnsupportedOperationException();
		}
	}
	
	public Course(String code, String name, String description, 
			int credithours, int coursecap, 
			boolean isofferedfall,  boolean isofferedspring,  boolean isofferedsummer, 
			ArrayList<Course> prereqs, ArrayList<Faculty> teachers) {
		
		if ((!code.isEmpty() && !name.isEmpty() && !description.isEmpty() ) && credithours > 0){
			setCourseCode(code);
			setCourseName(name);
			setDescription(description);
			setCreditHours(credithours);
			setCourseCap(coursecap);
			setOfferedFall(isofferedfall);
			setOfferedSpring(isofferedspring);
			setOfferedSummer(isofferedsummer);
			setPrerequisites(prereqs);
			setFaculties(teachers);
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
	
	// add a faculty
	public boolean addFaculty(Faculty faculty){
		if (faculty != null){
			getFaculties().add(faculty);
			return true;
		}
		return false;
	}
	
	// print course
	public void print(){
		// Print the course
		System.out.println("Printing a course with following info: \n" + getCourseCode() + " : " + getCourseName() + " : "
		+ getCreditHours() + " : " + getCourseCap() + " : " + isOfferedFall() + " : " + isOfferedSpring() + " : " + 
		isOfferedSummer() + " : "+ print_prereqs() + " : "+ print_faculties() );
	}
	
	public String print_prereqs()
	{
		String result = " <";
		if (this.prerequisites.size() == 0)
			return "No Prereqs";
		
		for (Course course : prerequisites)
			result += course.getCourseCode() + ", ";
		
		return result+= ">";
	}
	
	public String print_faculties()
	{
		String result = " <";
		if (this.faculties.size() == 0)
			return "No Faculty";
		
		for (Faculty faculty : faculties)
			result += faculty.getLastName() + ", ";
		
		return result+= ">";
	}
	
	
	/*
	 * override a toString method
	 * this will help up be able to display what we want on the JList of this object
	 * instead of displaying this object's memory address
	 */
	
	@Override
	public String toString() {
	    return this.courseName;
	}
	
	public boolean isAvalaible(Semester semester){
		
		
		String semesterSuffix = semester.getName().substring(4, 6);
		
		

		switch(semesterSuffix){

		case "SP":
			if(isOfferedSpring())


			{
				for(Faculty fac:getFaculties() )  { 

					if( fac.getSpringLoad()>0){


						return true;
					}
				}
			}
			break;

		case "FA":  

			if(isOfferedFall()){

				for(Faculty fac:getFaculties() )  { 

					if( fac.getFallLoad()>0){


						return true;
					}
				}
			}
			break;


		case "SU":   
			if(isOfferedSummer()){


				for(Faculty fac:getFaculties() )  { 

					if( fac.getSummerLoad()>0){


						return true;
					}
				}
			}
			break;

		}
		return false;
	}
}