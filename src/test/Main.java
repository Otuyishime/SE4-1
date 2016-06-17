package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;
import com.csvreader.CsvReader;

import java.awt.EventQueue;
import java.io.*;

public class Main {
	// create a university 
	static UniversityDM univ ;
	
	public static void loadUniversitymain() {
		try {
			CsvReader file;
			System.out.println(" ---------------------- University -------------------");
<<<<<<< HEAD
			// file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataUniversityName.csv");
			file = new CsvReader("src/Data/TestDataUniversityName.csv");
			UniversityDM univ = new UniversityDM(file);
			System.out.println();
			
			System.out.println("...Done printing out imported infomation...");
			
=======
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataUniversityName.csv");
			univ = new UniversityDM(file);
>>>>>>> 076802ce7d0da8a429195be4060f2680888065ca
			
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
					
					SystemJFrame frame = new SystemJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
