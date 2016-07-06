package OcGraduateSystemClasses;

import java.util.ArrayList;

/**
 * Test object to test the goodness of a schedule
 */
public class ScheduleTester
{

	// ----------------- methods ------------------
	
	public void checkGraduateStudents(Schedule schedule, University university) {
		// create all needed variables	
		int numberGraduatingStudentsWithoutAllNeededCourses = 0;
		
		// get all graduate students
		ArrayList<Student> graduatingstudents = university.getGraduatingStudentsInDegreeForSemester(schedule.getDegree().getDegreeCode(), schedule.getSemester());
		// get all missing courses
		ArrayList<Course> missingCoursesToGraduate = new ArrayList<Course>();
		
		// add a boolean to test if the graduating student has all the courses needed
		boolean isMissingSomeCourses = false;
		
		// Loop through all graduating students and check if they have courses they need to graduate
		for ( Student gradStudent : graduatingstudents){
			
			// check for needed courses
			for( Course coursetotake : gradStudent.getCoursesNeedTotake()){
				if (!Section.sectionsContainCourse(schedule.getSections(), coursetotake)){
					
					// add the course the graduating student is missing in the generated schedule
					if ( !Course.containsCourse(missingCoursesToGraduate, coursetotake)){
						missingCoursesToGraduate.add(coursetotake);
					}
					
					isMissingSomeCourses = true;
				}
			}
			
			if ( isMissingSomeCourses){
				numberGraduatingStudentsWithoutAllNeededCourses ++;
			}
		}
		
		//  ------------------------ print test ----------------------
		System.out.println("Number of graduating students without all needed courses: " + numberGraduatingStudentsWithoutAllNeededCourses);
		
		// print missing courses
		System.out.println("Graduating students are missing these courses: ");
		
		if ( missingCoursesToGraduate.isEmpty()){
			System.out.println("0 Yaay!");
		}else{
			// Loop through the courses
			for ( Course missingCourse : missingCoursesToGraduate){
				System.out.printf("%-9s-%-46s : ",missingCourse.getCourseCode(),missingCourse.getCourseName()); 
				System.out.printf("This course is offered in %1s %n",missingCourse.isOfferedInSemesters_str());
			}
		}
	}
	
	// check graduate students for all degrees
	public void checkGraduateStudentsForAllDegree(ArrayList<Schedule> schedules, University university){
		if ( schedules != null && university != null){
			for ( Schedule schedule : schedules){
				System.out.println();
				System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
				System.out.println("--------------------------------------------------------------------------------");
				checkGraduateStudents(schedule, university);
			}
		}
	}
	
	// check the sections percentage full
	public void checkSectionsPercentageFull(Schedule scheduletocheck){
		// Loop through all the sections
		for ( Section section : scheduletocheck.getSections()){
			System.out.printf("%-9s-%-46s%2s : %-4.0f%% %n",section.getCourse().getCourseCode(),section.getCourse().getCourseName(),
					section.getSectionNumber(),section.percentageFull());
		}
	}
	
	public void checkSectionsPercentageFullForAllDegrees(ArrayList<Schedule> schedules){
		if ( schedules != null){
			for ( Schedule schedule : schedules){
				System.out.println();
				System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
				System.out.println("--------------------------------------------------------------------------------");
				checkSectionsPercentageFull(schedule);
			}
		}
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