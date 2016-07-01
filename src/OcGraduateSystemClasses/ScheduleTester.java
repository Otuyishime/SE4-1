package OcGraduateSystemClasses;

import java.util.ArrayList;

/**
 * Test object to test the goodness of a schedule
 */
public class ScheduleTester
{

	private Schedule schedule;
	
	private University university;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	// ----------------- methods -------------------
	public ScheduleTester(Schedule schedule, University university) {
		if ( schedule != null && university != null ){
			this.setSchedule(schedule);
			this.setUniversity(university);
		}
	}

	
	public void checkGraduateStudents() {
		// create all needed variables	
		int numberGraduatingStudentsWithoutAllNeededCourses = 0;
		
		// get all graduate students
		ArrayList<Student> graduatingstudents = this.getUniversity().getGraduatingStudentsInDegree(this.getSchedule().getDegree().getDegreeCode());
		
		// Loop through all graduating students and check if they have courses they need to graduate
		for ( Student gradStudent : graduatingstudents){
			
			// check for needed courses
			for( Course coursetotake : gradStudent.getCoursesNeedTotake()){
				if (!Section.containsCourse(this.getSchedule().getSections(), coursetotake)){
					numberGraduatingStudentsWithoutAllNeededCourses ++;
				}
			}
		}
		
		// print test
		System.out.println("Number of graduating students without all needed courses: " + numberGraduatingStudentsWithoutAllNeededCourses);
	}

	/**
	 * returns all future students who will benefit from the schedule
	 */
	public void getStudentForeCast() {
		
	}

	public void calculateNumStudents() {
		
	}

	/**
	 * returns the number of students who can get their required courses
	 */
	public int calcNumStudentsWithRequiredCourses() {
		return 0;
	}

	/**
	 * returns the percentage of all students who can get in their required courses
	 */
	public float calcPercentageStudentsWithRequiredCourses() {
		return 0;
	}

	/**
	 * returns the number of students who can not get into their required courses
	 */
	public int calcNumStudentsWithoutRequiredCourses() {
		return 0;
	}

	/**
	 * returns the number of courses
	 */
	public int calcNumCourses() {
		
		return 0;
	}

	public void calcNumSectionsWithTolerance() {
		
	}

	/**
	 * returns the number of students above the cap
	 */
	public int calcNumSectionsAboveCap() {
		return 0;
	}

	/**
	 * returns the percentage of students above the cap
	 */
	public float calcPercentageSectionsAboveCap() {
		return 0;
	}

	/**
	 * returns the number of sections below
	 */
	public int calcNumSectionsBelowPercentage() {
		return 0;
	}

	public void calcPercentageSectionsBelowPercentage() {
		
	}

}