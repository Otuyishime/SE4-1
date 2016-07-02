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
	
	private boolean teachingDays[];	
	
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

	public boolean[] getTeachingDays() {
		return teachingDays;
	}
	
	public String getTeachingDaysStr() {
		
		return "days";
	}

	public void setTeachingDays(String teachingdays) {
		// Initialize the array
		this.teachingDays = new boolean[teachingdays.length()];
		
		if ( !teachingdays.isEmpty()){
			// create a temporary char array holder
			String[] temp_chardays_array =  teachingdays.split("");
			
			for ( int i = 0; i < temp_chardays_array.length; i++ ){
				switch(temp_chardays_array[i]){
				case "M":
					this.teachingDays[i] = true;
					break;
				case "T":
					this.teachingDays[i] = true;
					break;
				case "W":
					this.teachingDays[i] = true;
					break;
				case "R":
					this.teachingDays[i] = true;
					break;
				case "F":
					this.teachingDays[i] = true;
					break;	
				}
			}
		}
	}
	
	public int getLoadForSemester(Semester semester){
		if ( semester != null ){
			String semesterNameAbbreviation = semester.getName().substring(4);
			
			switch (semesterNameAbbreviation){
			case "FA":
				return this.getFallLoad();
				
			case "SP":
				return this.getSpringLoad();
				
			case "SU":
				return this.getSummerLoad();
			default:
				return 0;
			}
		}
		return 0;
	}

	private ArrayList<FacultyLoad> getFacultyLoads() {
		return facultyLoads;
	}

	private void setFacultyLoads(ArrayList<FacultyLoad> facultyLoads) {
		this.facultyLoads = facultyLoads;
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
	
	public boolean canTeachInSemester(Semester semester){
		if ( semester != null ){
			String semesterNameAbbreviation = semester.getName().substring(4);
			
			switch (semesterNameAbbreviation){
			case "FA":
				return this.canTeachFall();
				
			case "SP":
				return this.canTeachSpring();
				
			case "SU":
				return this.canTeachSummer();
			default:
				return false;
			}
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
	
	public void setFallLoad(int load){
		if ( load >= 0){
			getFacultyLoads().get(0).setHours(load);
		}
	}
	
	public void setSpringLoad(int load){
		if ( load >= 0){
			getFacultyLoads().get(1).setHours(load);
		}
	}

	public void setSummerLoad(int load){
		if ( load >= 0){
			getFacultyLoads().get(2).setHours(load);
		}
	}
	
	public void print(){
		// Print the course
		System.out.println(firstName + " : " + lastName + " : " + gradSchool + " : " + degree + " : " + title + " : " + 
		teachingDays + " : " + getFallLoad() + " : " + getSpringLoad() + " : " + getSummerLoad());
	}

	@Override
	public String toString() {
		return (firstName + " : " + lastName );
	}
}