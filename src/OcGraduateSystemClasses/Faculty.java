package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents the person who teaches a particular course
 */
public class Faculty
{
	private String firstName;
	
	private String lastName;
	
	private String gradSchool;

	private String degree;
	
	private String title;
	
	private String teachingDays;
	
	// -------------------- Lists -----------------------
	private ArrayList<FacultyLoad> facultyLoads;
	
	private ArrayList<Course> courses;
	
	public String getFirstName() {
		return firstName;
	}

	// -------------------- Accessors -----------------------
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

	private ArrayList<FacultyLoad> getFacultyLoads() {
		return facultyLoads;
	}

	private void setFacultyLoads(ArrayList<FacultyLoad> facultyLoads) {
		this.facultyLoads = facultyLoads;
	}

	public String getTeachingDays() {
		return teachingDays;
	}

	public void setTeachingDays(String teachingDays) {
		this.teachingDays = teachingDays;
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	// ---------------------- Methods -------------------------
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
			setTeachingDays(teachdays);
			setFacultyLoads(arrayList);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}
	
	public void addCourseCanTeach(Course course) {
		if ( course != null){
			getCourses().add(course);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}
	
	public ArrayList<Course> getCoursesCanTeach() {
		if ( getCourses() != null){
			return getCourses();
		}
		else{
			return null;
		}
	}
	
	public boolean canTeachFall(){
		if ( getFacultyLoads().get(0).getHours() > 0){
			return true;
		}
		return false;
	}
	
	public boolean canTeachSpring(){
		if ( getFacultyLoads().get(1).getHours() > 0){
			return true;
		}
		return false;
	}
	
	public boolean canTeachSummer(){
		if ( getFacultyLoads().get(2).getHours() > 0){
			return true;
		}
		return false;
	}
	
	public int getFallLoad(){
		if ( getFacultyLoads().get(0).getHours() > 0){
			return getFacultyLoads().get(0).getHours();
		}
		return 0;
	}
	
	public int getSpringLoad(){
		if ( getFacultyLoads().get(1).getHours() > 0){
			return getFacultyLoads().get(1).getHours();
		}
		return 0;
	}

	public int getSummerLoad(){
		if ( getFacultyLoads().get(2).getHours() > 0){
			return getFacultyLoads().get(2).getHours();
		}
		return 0;
	}
	
	public void print(){
		// Print the course
		System.out.println(firstName + " : " + lastName + " : " + gradSchool + " : " + degree + " : " + title + " : " + 
		teachingDays + " : " + getFallLoad() + " : " + getSpringLoad() + " : " + getSummerLoad());
	}
}