package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;
import com.csvreader.CsvReader;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			CsvReader file;
			System.out.println(" ---------------------- University -------------------");
			// file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataUniversityName.csv");
			file = new CsvReader("src/Data/TestDataUniversityName.csv");
			UniversityDM univ = new UniversityDM(file);
			System.out.println();
			
			System.out.println("...Done printing out imported infomation...");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
