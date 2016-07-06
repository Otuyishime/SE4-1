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
			
			// test print
//			for( StudentCourse stdCrse : university.getStudentcourses()){
//				System.out.println(stdCrse);
//			}
			
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
				
					ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", sem);
//					System.out.println(" SCHEDULE ");
//					for (Schedule schedule : schedules ){
//						ArrayList<Section> sections = schedule.getSections();
//						System.out.println();
//						System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
//						System.out.println("----------------------------------------------------------------------------------------");
//						for (Section section : sections){
//							System.out.println(section);
//						}
//					}
		
//					ScheduleTester testschedule = new ScheduleTester();
//					System.out.println();
//					System.out.println(" PERCENTAGES ");
//					testschedule.checkSectionsPercentageFullForAllDegrees(schedules);
//					System.out.println();
//					System.out.println("GRADUATING STUDENTS:");
//					testschedule.checkGraduateStudentsForAllDegree(schedules, university);
					
//					SystemJFrame frame = new SystemJFrame(university);
//					frame.setVisible(true);
					
					for ( Degree degree : university.getDegrees()){
						System.out.println(degree);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}