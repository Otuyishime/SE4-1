package OcGraduateSystemClasses;

import java.util.*;

/**
 * This class represents an institution for higher learning.
 * This occupies the highest level of hierarchy
 */



/* Add a helper class to help order courses according 
 * to the number of students who need the course*/
class ScheduleCourse implements Comparable<ScheduleCourse>{
	
	int numberOfStudentsNeedingThecourse;
	
	Course course;
	
	public ScheduleCourse(int numstudents, Course coursetotake){
		numberOfStudentsNeedingThecourse = numstudents;
		course = coursetotake;
	}
	
	@Override
	public int compareTo(ScheduleCourse anotherClass) {
		return this.numberOfStudentsNeedingThecourse - anotherClass.numberOfStudentsNeedingThecourse;
	}
}

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
	
	private static ArrayList<StudentCourse> studentcourses;
	
	
	private ArrayList<Faculty> faculties;
	
	private ArrayList<Room> rooms;
	
	private static ArrayList<DegreeRequirement> degreerequirements;
	
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
	
	public ArrayList<Degree> getDegrees() {
		return degrees;
	}
	
	public void addDegree(Degree degree)
	{
		this.degrees.add(degree);
	}
	public void removeDegree(Degree degree)
	{
		this.degrees.remove(degree);
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
	
	public ArrayList<StudentCourse> getStudentcourses() {
		return studentcourses;
	}

	public void setStudentcourses(ArrayList<StudentCourse> studentcourses) {
		this.studentcourses = studentcourses;
	}
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
	
	/*************************************SCHEDULE CODE***********************************/
	public ArrayList<Course> generateCoursesNeededByStudentsInDegree(Degree degree, Semester semester){
		// Create the list of sections to return
		ArrayList<Course> courses = new ArrayList<Course>();
		
		// Create a priority queue of schedule courses
		PriorityQueue<ScheduleCourse> scheduleCourses = new PriorityQueue<ScheduleCourse>();
		
		for ( Student student : getStudentsInDegree(degree.getDegreeCode())){
			// get all the course needed by the student
			for ( Course course : student.getCoursesNeedTotake()){
				
				// make a temporary schedule course
				ScheduleCourse schCourse = new ScheduleCourse( getNumberStudentsNeedingCourse(getStudentsInDegree(degree.getDegreeCode()),course), course);
				
				// add schedule course to the list if it is not already on list
				if ( !containsCourseInScheduleCourses(new ArrayList(scheduleCourses), schCourse) && schCourse.course.isOfferedInSemester(semester)){
					scheduleCourses.add(schCourse);
				}
			}
		}
		
		// convert schedule courses back to courses
		for( ScheduleCourse schcourse : scheduleCourses){
			courses.add(schcourse.course);
		}
		
		return courses;
	}
	
	public ArrayList<Section> generateSectionsFromNeededCourses(Degree degree, Semester semester){
		// Create the list of sections to return
		ArrayList<Section> sections = new ArrayList<Section>();
		
		if ( degree != null && semester != null){
			
			System.out.println("in degree and sem ...!!!");
			
			// create a list of needed courses
			ArrayList<Course> neededCourses = generateCoursesNeededByStudentsInDegree(degree, semester);
			
			// generate sections
			for ( Course neededcourse : neededCourses){
				
				System.out.println("in needecourse ...!!!");
				
				// Loop through all the faculties who can teach
				
				ArrayList<Faculty> courseFaculties = neededcourse.getFaculties();	// get all the faculties for the course
				if ( courseFaculties != null ){
					
					System.out.println("in course faculty ...!!!");
					// Loop through all faculties
					
					// get the number of all students who need to take the course
					// include also the number of forecast students
					int numberOfStudentsNeedingTheCourses = getNumberStudentsNeedingCourse(getStudentsInDegree(degree.getDegreeCode()), neededcourse) + degree.getForecast();
					
					System.out.println("in numberOfStudentsNeedingTheCourses: " + numberOfStudentsNeedingTheCourses);
					
					System.out.println(neededcourse.getCourseName());
					
					// get the possible number of sections needed
					// add 0.5 to round the numbers
					
					System.out.println("num section: " + (((float)numberOfStudentsNeedingTheCourses) / 
							(int)(((float)neededcourse.getCourseCap()))));
					
					int possibleNumberOfSections = Math.round((((float)numberOfStudentsNeedingTheCourses) / 
							(int)(((float)neededcourse.getCourseCap()))) + (float)(0.5));
					
					System.out.println("in possibleNumberOfSections: " + possibleNumberOfSections);
					/*
					 * Generate the sections using the possible number of sections
					 * - Use the number of sections to loop through the faculties and determine who can teach each section
					 * - Distribute equally all the sections in case the course has more than one teacher. The distribution will prevent 
					 *   the overload of sections to one teacher while there are other teacher who can teach the course as well.
					 * */
					
					// use a counter to count to know when to stop looping
					int loopSectionsGenerationAndAssignment = 1;
					int loopFaculties  = 1;
					int limitFaculties = 1;
					
					while ( possibleNumberOfSections >= loopSectionsGenerationAndAssignment){
						for ( Faculty coursefaculty : courseFaculties ){
							if ( coursefaculty.canTeachInSemester(semester) && possibleNumberOfSections >= loopSectionsGenerationAndAssignment ){	// check if the faculty can teach for the semester
								
								// Make sure the section assignment does not go over the faculty's semester load
								if ((coursefaculty.getLoadForSemester(semester) / loopFaculties) >= neededcourse.getCreditHours()){
									
									// Make sure the section has the maximum temporary students in it
									if ( (numberOfStudentsNeedingTheCourses - (neededcourse.getCourseCap() * loopSectionsGenerationAndAssignment)) >= 0){
										// Create a section and add it to the list
										Section tempSection = new Section( loopSectionsGenerationAndAssignment, neededcourse, coursefaculty, 
																		   "graduate", semester, "open",neededcourse.getCourseCap(),
																		   this.getRooms().get(0));
										sections.add(tempSection);
									}
									else {
										
										int limitsection = loopSectionsGenerationAndAssignment - 1;	// needed to get the correct number of temporary students
										// Create a section and add it to the list
										Section tempSection = new Section( loopSectionsGenerationAndAssignment, neededcourse, coursefaculty, 
																		   "graduate", semester, "open",
																		   (numberOfStudentsNeedingTheCourses - (neededcourse.getCourseCap() * limitsection)),
																		   this.getRooms().get(0));
										sections.add(tempSection);
									}
								}
							}
							// update the section counter
							if ( limitFaculties == courseFaculties.size()){
								loopFaculties++;
							}
							limitFaculties++;
							loopSectionsGenerationAndAssignment++;
						}
						
						// update the section counter
						loopSectionsGenerationAndAssignment++;
						System.out.println("in while!!!");
					}
				}
				
			}
		}
		
		return sections;
	}
	
	public Schedule generateSchedule(String scheduletitle, Degree scheduledegree, Semester schedulesemester, float sectionThresholdPercentage){
		// create a temporary schedule to return
		Schedule temp_schedule = new Schedule(scheduletitle, generateSectionsFromNeededCourses(scheduledegree, schedulesemester), scheduledegree, schedulesemester);
		
		return temp_schedule;
	}
	
	/*************************************************************************************/
	
	// ------------ Helper methods --------------
	public ArrayList<Student> getStudentsInDegree(String degreeCode){
		// create a list of students to return
		ArrayList<Student> stdsInDegree = new ArrayList<Student>();
		
		for ( Student std : this.getStudents()){
			if ( std.getDegreeCode().equals(degreeCode)){
				stdsInDegree.add(std);
			}
		}
		
		return stdsInDegree;
	}
	
	public ArrayList<Student> getGraduatingStudentsInDegree(String degreeCode){
		// create a list of graduating students to return
		ArrayList<Student> gradStdsInDegree = new ArrayList<Student>();
		
		for ( Student student : this.getStudentsInDegree(degreeCode)){
			if ( student.isGraduatingStudent()){
				gradStdsInDegree.add(student);
			}
		}
		
		return gradStdsInDegree;
	}
	
	public int getNumberStudentsNeedingCourse(ArrayList<Student> listStudents, Course course){
		// create a counter to count the number of students who need the course
		int counter = 0;
		if ( listStudents != null && course != null ){
			for ( Student student : listStudents){
				if ( Course.containsCourse(student.getRequiredCoursesNeedToTake(), course)){
					counter++;
				}
				if ( Course.containsCourse(student.getElectiveCoursesNeedToTake(), course)){
					counter++;
				}
			}
		}
	
		return counter;
	}
	
	private boolean containsCourseInScheduleCourses(ArrayList<ScheduleCourse> list, ScheduleCourse schcourse){
		for ( ScheduleCourse listCourse: list){
			if ( listCourse.course.getCourseCode().equals(schcourse.course.getCourseCode())){
				return true;
			}
		}
		return false;
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
