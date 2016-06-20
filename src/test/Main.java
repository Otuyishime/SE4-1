package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;
import com.csvreader.CsvReader;

import java.awt.EventQueue;
import java.io.*;

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
			System.out.println("++++++++++++++++++++++++ PRINT FROM ALL OBJECTS ++++++++++++++++++++++++");
			university = universityDM.getUniversity();
			university.printData();
			
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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
