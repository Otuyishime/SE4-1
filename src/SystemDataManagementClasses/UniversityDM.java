package SystemDataManagementClasses;

import OcGraduateSystemClasses.University;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class UniversityDM {
	
	public void readFile(CsvReader file){
		// create all universities
		ArrayList<University> universities = new ArrayList<University>();
		
		try {
			
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String univ_Name = file.get(headers[0]);
					String univ_ID = file.get(headers[1]);
					
					// perform program logic here
					System.out.println(univ_Name + " : " + univ_ID);
					
					// Create a university object
					University temp_Univ = new University(univ_Name, univ_ID);
					universities.add(temp_Univ);
				}
				// close the file after read completion
				file.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int findRecord(CsvReader file, String key){
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int deleteRecord(CsvReader file, String Key){
		
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean updateRecord(CsvReader file, University record){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean writeRecord(CsvReader file, University record){
		// TODO Auto-generated method stub
		return false;
	}
}
