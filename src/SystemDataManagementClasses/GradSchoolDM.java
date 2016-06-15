package SystemDataManagementClasses;

import OcGraduateSystemClasses.GradSchool;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;


public class GradSchoolDM {
	
	ArrayList<GradSchool> gradSchools = new ArrayList<GradSchool>();
	
	public void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String gradSchl_Abbr = file.get(headers[0]);
					String gradSchl_Name = file.get(headers[1]);
					
					// perform program logic here
					System.out.println(gradSchl_Abbr + " : " + gradSchl_Name);
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
	public boolean updateRecord(CsvReader file, GradSchool record){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean writeRecord(CsvReader file, GradSchool record){
		// TODO Auto-generated method stub
		return false;
	}
}
