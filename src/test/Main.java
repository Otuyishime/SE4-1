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
			String studentcoursesfilelocation = "src/Data/STC.DUMP.CSV";

			universityDM.importStudentCourses(studentcoursesfilelocation);
			universityDM.importStudents(studentsfilelocation);

			// System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");

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
					
					/*
					Semester sem = new Semester("2017SP"); 

					ArrayList<Schedule> schedules = university.generateScheduleForDegreesInSemester("Schedules", university.getSemesters().get(0));
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

					ScheduleTester testschedule = new ScheduleTester();
					System.out.println();
					System.out.println(" PERCENTAGES ");
					testschedule.checkSectionsPercentageFullForAllDegrees(schedules);
					System.out.println();
					System.out.println("GRADUATING STUDENTS:");
					testschedule.checkGraduateStudentsForAllDegree(schedules, university);
					*/

<<<<<<< HEAD
					if(frame.getLoginDialog().isSucceeded()){
						frame.setVisible(true);
						frame.setVisible(true);
						System.out.println("U can start the main frame");

					} else{
						System.out.println("U can NOT start the main frame");

					}
					
					
=======
				

					//frame.setVisible(true);


>>>>>>> ec46592b3010d2aa22e57599fd16a237254436a1

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
