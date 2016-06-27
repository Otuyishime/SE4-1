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
	
	
	ArrayList<Section> section;

	
	public ArrayList<Section> generateSections(Semester term){

		
		for (Student stud : students){
			
			
			 String degreeCode = stud.getDegreeCode();
			 switch(degreeCode){
			 
			 case "MSCS.SFTW.ENG":
					ArrayList<Course> requiredCoursesList = stud.getRequiredCoursesNeedToTake();
					   for (Course course:requiredCoursesList){
						    
						   if (course.isAvalaible(term)){
							   
							   
							   
						   }
						   
						   
						   
					   }
			  
			 
			 }
		}
		
//		String studentID;
//		int numberOfStudent = 0;
//
//		for (Student stud: students){
//			studentID= stud.getStudentId();
//			for(int i=0; i < degreerequirements.size();i++)
//				if (stud.getDegree().getDegreeCode().equals(degreerequirements.get(i).getDegreeCode())){
//					String caseOfdegreeplan =(degreerequirements.get(i).getDegreeCode()).toString();
//
//					switch(caseOfdegreeplan) {
//
//					case "MSCS.SFTW.ENG":
//						//do {
//
//							ArrayList<Course> requiredCoursesList = returnCourseList("Required","MSCS.SFTW.ENG");
//
//							for( Course course : requiredCoursesList){
//
//								if (isAvailableInThisTerm(term,course)){
//
//									Section tempSectionOfRequired = new Section(course.getCourseCode(),course.
//											getDescription(),course.getFaculties().get(0).getFirstName(),term.getName(),"MSCS.SFTW.ENG");
//									
//									if (tempSectionOfRequired !=null){
//										
//									
//								//	section.add(tempSectionOfRequired);  
//									}
//								
//								}
//
//							}
//
//
//
//
////						}while( !hasPassed(studentID,degreerequirements.get(i).getCourses().
////								get(i).getCourseCode()));
//						break;
//
//					}
//
//				}// end of if statement 
//			
//
//		}// end of student for loop

		return section;
	}// End of generate schedule method

	static  boolean hasPassed(String id, String course){

		for (StudentCourse studentCourse:studentcourses ){
			if(studentCourse.getStudentID().equals(id) && studentCourse.getCourseCode().
					equals(course))
			{

				return true;

			}

		}
		return false;
	}// end of the method

	static boolean hasTakenPrequesite(int id, String course){


		return false;	
	}



	static ArrayList <Course> returnCourseList(String  type, String degreeCode ){

		ArrayList<Course> courseCodes = null;
		for (int i = 0; i < degreerequirements.size();i++){

			if (degreerequirements.get(i).getDegreeRequirementsType().equals(type) && degreerequirements.get(i).getDegreeCode().toString().equals(degreeCode)){
				courseCodes= degreerequirements.get(i).getCourses();

			}

		}

		return courseCodes;		

	}


	static boolean isAvailableInThisTerm (Semester semesterName, Course couseCode){

		String semesterSuffix = semesterName.getName().substring(4, 6);

		switch(semesterSuffix){

		case "SP":
			if(couseCode.isOfferedSpring())


			{
				for(Faculty fac:couseCode.getFaculties() )  { 

					if( fac.getSpringLoad()>0){


						return true;
					}
				}
			}
			break;

		case "FA":  

			if(couseCode.isOfferedFall()){

				for(Faculty fac:couseCode.getFaculties() )  { 

					if( fac.getFallLoad()>0){


						return true;
					}
				}
			}
			break;


		case "SU":   
			if(couseCode.isOfferedSummer()){


				for(Faculty fac:couseCode.getFaculties() )  { 

					if( fac.getSummerLoad()>0){


						return true;
					}
				}
			}
			break;

		}
		return false;
	}

	public void generateSchedule(ArrayList<Section> section){
		int count =0;

		for (Section sec: section){

			switch(sec.getCourse().toString()){

			case "CMSC 5623":
				count++;
				if (count ==25)
				{
					System.out.println(sec.getCourse()+"   |  "+sec.getCoursedescription()+"  | "+sec.getFacultyName()+" |  "+sec.getSemesterName()); 

				}
				break;

			case "CMSC 5633":
				count++;
				if (count ==25)
				{
					System.out.println(sec.getCourse()+"   |  "+sec.getCoursedescription()+"  | "+sec.getFacultyName()+" |  "+sec.getSemesterName()); 

				}
				break;
			case "CMSC 5733":
				count++;
				if (count ==25)
				{
					System.out.println(sec.getCourse()+"   |  "+sec.getCoursedescription()+"  | "+sec.getFacultyName()+" |  "+sec.getSemesterName()); 

				}
				break;

			case "CMSC 5743":
				count++;
				if (count ==25)
				{
					System.out.println(sec.getCourse()+"   |  "+sec.getCoursedescription()+"  | "+sec.getFacultyName()+" |  "+sec.getSemesterName()); 

				}
				break;
			default: break;
			}
		}


	}

	
	
	
	
}