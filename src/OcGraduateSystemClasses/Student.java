package OcGraduateSystemClasses;

import java.util.*;

/**
 * represents the person studying at the university in the graduate school
 */
public class Student
{
	private String studentId;
	private String degreeCode;
	private Degree degree;
	
	private String GraduationsemesterName;
	private Semester Graduationsemester;
	
	private ArrayList<StudentCourse> studentcoursesTaken;
	
	
	// ------------- Accessors ----------------
	public String getStudentId() {
		return studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getDegreeCode() {
		return degreeCode;
	}
	
	private void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}
	
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getGraduationsemesterName() {
		return GraduationsemesterName;
	}

	private void setGraduationsemesterName(String graduationsemesterName) {
		GraduationsemesterName = graduationsemesterName;
	}

	public Semester getGraduationsemester() {
		return Graduationsemester;
	}

	public void setGraduationsemester(Semester graduationsemester) {
		Graduationsemester = graduationsemester;
	}

	public ArrayList<StudentCourse> getStudentcoursesTaken() {
		return studentcoursesTaken;
	}

	public void setStudentcourses(ArrayList<StudentCourse> studentcourses) {
		this.studentcoursesTaken = studentcourses;
	}
	
	// ------------- Methods ----------------
	public Student(String studentId, String degreeCode, String semesterName) {
		this.studentId = studentId;
		setDegreeCode(degreeCode);
		setGraduationsemesterName(semesterName);
		
		// create student courses list
		studentcoursesTaken = new ArrayList<StudentCourse>();
	}
	
	public void addStudentcourses(StudentCourse studentcourse) {
		if ( studentcourse != null){
			this.getStudentcoursesTaken().add(studentcourse);
		}
	}
	
	public ArrayList<Course> getRequiredCoursesTaken(){
		ArrayList<Course> requiredcoursestaken = new ArrayList<Course>();
		
		if ( this.getDegree() != null && !this.getStudentcoursesTaken().isEmpty()){
			
			for ( DegreeRequirement degreeReq: this.getDegree().getDegreeRequirements()){
				if ( degreeReq.getDegreeRequirementsType().equals("Required")){
					
					for ( Course reqcourse:degreeReq.getCourses()){
						for ( StudentCourse stdcourse:getStudentcoursesTaken()){
							if ( reqcourse.getCourseCode().equals(stdcourse.getCourseCode())){
								
								requiredcoursestaken.add(reqcourse);
							}
						}
					}
				}
			}
		}
		
		return requiredcoursestaken;
	}
	
	public ArrayList<Course> getElectiveCoursesTaken(){
		ArrayList<Course> electivecoursestaken = new ArrayList<Course>();

		if ( this.getDegree() != null && !this.getStudentcoursesTaken().isEmpty()){

			for ( DegreeRequirement degreeReq: this.getDegree().getDegreeRequirements()){
				if ( degreeReq.getDegreeRequirementsType().equals("Elective")){

					for ( Course reqcourse:degreeReq.getCourses()){
						for ( StudentCourse stdcourse:getStudentcoursesTaken()){
							if ( reqcourse.getCourseCode().equals(stdcourse.getCourseCode())){

								electivecoursestaken.add(reqcourse);
							}
						}
					}
				}
			}
		}

		return electivecoursestaken;
	}
	
	public int getRequiredHoursNeeded(){
		int numReqHrs = 0;
		
		for ( DegreeRequirement degreereqtomeet: this.getDegree().getDegreeRequirements()){
			if ( degreereqtomeet.getDegreeRequirementsType().equals("Required") ){
				for ( Course coursetotake: degreereqtomeet.getCourses()){
					numReqHrs += coursetotake.getCreditHours();
				}
			}
		}
		
		return numReqHrs;
	}
	
	public int getElectiveHoursNeeded(){
		int numElectiveHrs = 0;
		
		for ( DegreeRequirement degreereqtomeet: this.getDegree().getDegreeRequirements()){
			if ( degreereqtomeet.getDegreeRequirementsType().equals("Elective") ){
				for ( Course coursetotake: degreereqtomeet.getCourses()){
					numElectiveHrs += coursetotake.getCreditHours();
				}
			}
		}
		
		return numElectiveHrs;
	}
	
	public ArrayList<Course> getRequiredCoursesNeedToTake(){
		ArrayList<Course> coursesrquiredneedtotake = new ArrayList<Course>();
		// Get the number of hours taken by the student
		int requiredHrsTaken = getRequiredCoursesTaken().size() * 3;
	
		if ( this.getDegree() == null){
			System.out.println("null");
		}
		for ( DegreeRequirement degreereqtomeet: this.getDegree().getDegreeRequirements()){
			
			// check if the requirement is required and if the student didn't complete his/her required courses
			if ( degreereqtomeet.getDegreeRequirementsType().equals("Required") && this.getRequiredHoursNeeded() > requiredHrsTaken){

				for ( Course coursetotake: degreereqtomeet.getCourses()){
					if ( !containsCourse(getRequiredCoursesTaken(), coursetotake)){
						coursesrquiredneedtotake.add(coursetotake);
					}
				}
			}
		}

		return coursesrquiredneedtotake;
	}
	
	public ArrayList<Course> getElectiveCoursesNeedToTake(){
		ArrayList<Course> courseselectiveneedtotake = new ArrayList<Course>();
		// Get the number of hours taken by the student
		int electiveHrs = getElectiveCoursesTaken().size() * 3;
		
		for ( DegreeRequirement degreereqtomeet: this.getDegree().getDegreeRequirements()){
			
			// check if the requirement is the elective and if the student didn't complete his/her elective courses
			if ( degreereqtomeet.getDegreeRequirementsType().equals("Elective") && degreereqtomeet.getHours() > electiveHrs){
				
				for ( Course coursetotake: degreereqtomeet.getCourses()){
					if ( !containsCourse(getElectiveCoursesTaken(), coursetotake)){
						courseselectiveneedtotake.add(coursetotake);
					}
				}
			}
		}
		
		return courseselectiveneedtotake;
	}
	
	private boolean haspassedCourse(Course course){
		for ( StudentCourse stdCourse : this.getStudentcoursesTaken()){
			if ( stdCourse.getCourse().getCourseCode().equals(course.getCourseCode())){
				if ( stdCourse.getGrade().equals("F") || stdCourse.getGrade().equals("I")){
					return false;
				}
			}
		}
		return true;
	}
	
	private ArrayList<Course> getCoursesNeedToRetake(){
		
		ArrayList<Course> coursesToRetake = new ArrayList<Course>();
		for ( StudentCourse stdCourse : this.getStudentcoursesTaken()){
				if ( stdCourse.getGrade().equals("F") || stdCourse.getGrade().equals("I")){
					coursesToRetake.add(stdCourse.getCourse());
				}
		}
		
		return coursesToRetake;
	}
	
	public void print(){
		// Print the course
		System.out.println(studentId + " : " + degreeCode);
	}
	
	public void printCoursesTaken(){
		for ( StudentCourse studentcourse: getStudentcoursesTaken()){
			studentcourse.getCourse().print();
		}
	}
	
	public void printReqCoursesTaken(){
		for ( Course course: getRequiredCoursesTaken()){
			course.print();
		}
	}
	
	public void printReqCoursesToTake(){
		for ( Course course: getRequiredCoursesNeedToTake()){
			course.print();
		}
	}
	
	// ------------ Helper method -------------
	private boolean containsCourse(ArrayList<Course> list, Course course){
		for ( Course listCourse: list){
			if ( listCourse.getCourseCode().equals(course.getCourseCode())){
				return true;
			}
		}
		return false;
	}
}