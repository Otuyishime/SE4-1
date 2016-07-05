package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;

import com.csvreader.CsvReader;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JDialog;

public class Main {	
	
	// TODO - we need to import and read the university name inside the UniversityDM
	// that way, we won't need to have the loadUniversitymain(). 
	// We will just create an instance of University and be done here. 
	
	static UniversityDM universityDM;
	static University university;
	public static void loadUniversitymain() {
		try {
			CsvReader file;
			file = new CsvReader("src/Data/TestDataUniversityName.csv");
			universityDM = new UniversityDM(file);
			university = universityDM.getUniversity();
			
			// Import Students and student courses
			String studentsfilelocation = "src/Data/STU.DUMP.csv";
			String studentcoursesfilelocation = "src/Data/STC.DUMP.csv";
			
			universityDM.importStudentCourses(studentcoursesfilelocation);
			universityDM.importStudents(studentsfilelocation);
			
		//	System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					// create university
					loadUniversitymain();
					
					// ---- testing semester ------
					Semester sem = new Semester("2017SP"); 
					
//					for ( Course course : university.generateCoursesNeededByStudentsInDegree(university.getDegrees().get(3), sem)){
//						course.print();
//						System.out.print("Number of Students who need the course: ");
//						System.out.println(university.getNumberStudentsNeedingCourse(university.getStudentsInDegree(university.getDegrees().get(3).getDegreeCode()), course));
//						System.out.println("professor load available: " + course.getFaculties().get(0).getFallLoad());
//						System.out.println("=============================================================================================================");
//					}
//					System.out.println();
//					System.out.println("Total number of students to get the courses: " + university.getStudentsInDegree(university.getDegrees().get(3).getDegreeCode()).size());
//					
//					
//					ArrayList<Section> sections = university.generateSectionsFromNeededCourses(university.getDegrees().get(3), university.getSemesters().get(2));
//					System.out.println();
//					System.out.println("========================================================== SCHEDULE ================================================================");
//					for (Section section : sections){
//						System.out.println(section);
//					}
					
//					Schedule schedule = university.generateSchedule("First Schedule", university.getDegrees().get(2), university.getSemesters().get(1), (float)(1));
//					ScheduleTester testschedule = new ScheduleTester(schedule, university);
//					testschedule.checkGraduateStudents();
					
//					System.out.println("Total number of graduating students in Soft Eng: " + 
//					university.getGraduatingStudentsInDegree(university.getDegrees().get(0).getDegreeCode()).size());
//					
//					for (Student student : university.getGraduatingStudentsInDegree(university.getDegrees().get(0).getDegreeCode())){
//						if ( student.getCoursesNeedTotake().isEmpty()){
//							System.out.println("none!!!");
//						}
//						for ( Course course : student.getCoursesNeedTotake()){
//							
//							System.out.println(course.getCourseName());
//						}
//						System.out.println();
//					}
					
//					System.out.println(university.generateSectionsFromNeededCourses(university.getDegrees().get(0), university.getSemesters().get(1), (float)(0.75)).size());
				
					
					//SystemJFrame frame = new SystemJFrame(university);
					//frame.setVisible(true);
					ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", university.getSemesters().get(1));
					System.out.println(" SCHEDULE ");
					for (Schedule schedule : schedules ){
						ArrayList<Section> sections = schedule.getSections();
						System.out.println();
						System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
						System.out.println("----------------------------------------------------------------------------------------");
						for (Section section : sections){
							System.out.println(section);
						}
					}
//					Schedule schedule = university.generateSchedule("First Schedule", university.getDegrees().get(0), sem);
//					
//					
//					
//					ScheduleTester testschedule = new ScheduleTester(schedule, university);
//					System.out.println();
//					System.out.println("Graduating students:");
//					testschedule.checkGraduateStudents();
//					
//					System.out.println(university.getDegrees().get(0).getDegreeCode());
//					System.out.println(university.getGraduatingStudentsInDegreeForSemester(university.getDegrees().get(0).getDegreeCode(), sem).size());
					
//					System.out.println();
//					System.out.println("Percentages: ");
//					testschedule.checkSectionsPercentageFull();
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}