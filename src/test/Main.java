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
			
			universityDM.importStudents(studentsfilelocation);
			universityDM.importStudentCourses(studentcoursesfilelocation);

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
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
