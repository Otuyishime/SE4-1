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
	
	private ArrayList<StudentCourse> studentcourses;
	
	private ArrayList<Faculty> faculties;
	
	private ArrayList<Room> rooms;
	
	private ArrayList<DegreeRequirement> degreerequirements;
	
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

	
	// Courses
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}
	
	public void removeCourse(Course course)
	{
		this.courses.remove(course);
	}
	
	public void addCourse(Course course)
	{
		this.courses.add(course);
	}
<<<<<<< HEAD
	
	// Faculty
	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}
	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}
	public void removeFaculty(Faculty faculty)
	{
		this.faculties.remove(faculty);
	}
	public void addFaculty(Faculty faculty)
	{
		this.faculties.add(faculty);
	}
	
=======
>>>>>>> dc7ff61e694e3bcf9699433e56c7785764b1b2ea
	
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

<<<<<<< HEAD
=======
	public ArrayList<StudentCourse> getStudentcourses() {
		return studentcourses;
	}

	public void setStudentcourses(ArrayList<StudentCourse> studentcourses) {
		this.studentcourses = studentcourses;
	}

	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}

>>>>>>> dc7ff61e694e3bcf9699433e56c7785764b1b2ea
	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<DegreeRequirement> getDegreerequirements() {
		return degreerequirements;
	}

	public void setDegreerequirements(ArrayList<DegreeRequirement> degreerequirements) {
		this.degreerequirements = degreerequirements;
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
	
	public void print(){
		// Print the course
		System.out.println(name + " : " + abbreviation);
	}
	
	public void printData(){
		for ( int i = 0; i < gradSchools.size(); i++){
			gradSchools.get(i).print();
		}
		
		System.out.println();
		
		for ( int i = 0; i < semesters.size(); i++){
			semesters.get(i).print();
		}
		
		System.out.println();
		
		for ( int i = 0; i < courses.size(); i++){
			courses.get(i).print();
		}
		
		System.out.println();
		for ( int i = 0; i < degrees.size(); i++){
			degrees.get(i).print();
		}
		System.out.println();
		
		for ( int i = 0; i < getStudents().size(); i++){
			getStudents().get(i).print();
		}
		System.out.println();
		
		for ( int i = 0; i < getStudentcourses().size(); i++){
			getStudentcourses().get(i).print();
		}
		System.out.println();
		
		for ( int i = 0; i < faculties.size(); i++){
			faculties.get(i).print();
		}
		System.out.println();
		
		for ( int i = 0; i < degreerequirements.size(); i++){
			degreerequirements.get(i).print();
		}
	}
}