package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;
import com.csvreader.CsvReader;

import java.awt.EventQueue;
import java.io.*;
import java.util.ArrayList;

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
			
			// Import Students and student courses
			String studentsfilelocation = "src/Data/STU.DUMP.csv";
			String studentcoursesfilelocation = "src/Data/STC.DUMP.csv";
			
			universityDM.importStudentCourses(studentcoursesfilelocation);
			universityDM.importStudents(studentsfilelocation);
			
			System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");
			university = universityDM.getUniversity();
			
			
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
					
//					for ( Course course : university.generateCoursesNeededByStudentsInDegree(university.getDegrees().get(0), university.getSemesters().get(1))){
//						course.print();
//						System.out.print("Number of Students who need the course: ");
//						System.out.println(university.getNumberStudentsNeedingCourse(university.getStudentsInDegree(university.getDegrees().get(0).getDegreeCode()), course));
//						System.out.println("professor load available: " + course.getFaculties().get(0).getSummerLoad());
//						System.out.println("=============================================================================================================");
//					}
//					System.out.println();
//					System.out.println("Total number of students to get the courses: " + university.getStudentsInDegree(university.getDegrees().get(0).getDegreeCode()).size());
					
					
//					ArrayList<Section> sections = university.generateSectionsFromNeededCourses(university.getDegrees().get(0), university.getSemesters().get(1));
//					System.out.println();
//					System.out.println("========================================================== SCHEDULE ================================================================");
//					for (Section section : sections){
//						System.out.println(section);
//					}
					
					Schedule schedule = university.generateSchedule("First Schedule", university.getDegrees().get(0), university.getSemesters().get(1), (float)(1));
					ScheduleTester testschedule = new ScheduleTester(schedule, university);
					testschedule.checkGraduateStudents();
					
					//System.out.println(university.generateSectionsFromNeededCourses(university.getDegrees().get(0), university.getSemesters().get(1), (float)(0.75)).size());
					
//					SystemJFrame frame = new SystemJFrame(university);
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
