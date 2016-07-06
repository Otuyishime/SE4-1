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
<<<<<<< HEAD
			
			// Import Students and student courses
			String studentsfilelocation = "src/Data/STU.DUMP.csv";
			String studentcoursesfilelocation = "src/Data/STC.DUMP.csv";
			
			universityDM.importStudents(studentsfilelocation);
			universityDM.importStudentCourses(studentcoursesfilelocation);
			
			
			// test print
//			for( StudentCourse stdCrse : university.getStudentcourses()){
//				System.out.println(stdCrse);
//			}
			
		//	System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");
			
=======

			// Import Students and student courses 
			String studentsfilelocation = "src/Data/STU.DUMP.csv";		
			String studentcoursesfilelocation = "/Users/gustavemugabo/Downloads/TestData/STC.DUMP.CSV";

			universityDM.importStudentCourses(studentcoursesfilelocation);
			universityDM.importStudents(studentsfilelocation);

			//	System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");

>>>>>>> ec46592b3010d2aa22e57599fd16a237254436a1
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



					SystemJFrame frame = new SystemJFrame(university);
					
					// Create the login Screen				
					System.out.println(frame.getLoginDialog().isSucceeded());


					// ---- testing semester ------
<<<<<<< HEAD
					//Semester sem = new Semester("2017SP"); 
				
					ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", university.getSemesters().get(15));
=======
					Semester sem = new Semester("2017SP"); 

					ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", university.getSemesters().get(0));
>>>>>>> ec46592b3010d2aa22e57599fd16a237254436a1
					System.out.println(" SCHEDULE ");
					for (Schedule schedule : schedules ){
						ArrayList<Section> sections = schedule.getSections();
						System.out.println();

						if ((schedule.getDegree().getDegreeCode()).compareTo("MSCS.SFTW.ENG") == 0)
						{
							System.out.println(" " +  schedule.getDegree().getDegreeCode() + " - " + schedule.getDegree().getDegreeName());
							System.out.println("----------------------------------------------------------------------------------------");
							for (Section section : sections){
								System.out.println(section);
							}
						}
					}
<<<<<<< HEAD
//		
//					ScheduleTester testschedule = new ScheduleTester();
//					System.out.println();
//					System.out.println(" PERCENTAGES ");
//					testschedule.checkSectionsPercentageFullForAllDegrees(schedules);
//					System.out.println();
//					System.out.println("GRADUATING STUDENTS:");
//					testschedule.checkGraduateStudentsForAllDegree(schedules, university);
					
//					SystemJFrame frame = new SystemJFrame(university);
//					frame.setVisible(true);
					
//					for ( Degree degree : university.getDegrees()){
//						System.out.println(degree);
//					}
					
=======

					ScheduleTester testschedule = new ScheduleTester();
					System.out.println();
					System.out.println(" PERCENTAGES ");
					testschedule.checkSectionsPercentageFullForAllDegrees(schedules);
					System.out.println();
					System.out.println("GRADUATING STUDENTS:");
					testschedule.checkGraduateStudentsForAllDegree(schedules, university);

				

					//frame.setVisible(true);



>>>>>>> ec46592b3010d2aa22e57599fd16a237254436a1
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
