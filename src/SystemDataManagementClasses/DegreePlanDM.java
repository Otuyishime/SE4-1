package SystemDataManagementClasses;

import OcGraduateSystemClasses.DegreePlan;
import OcGraduateSystemClasses.University;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class DegreePlanDM {
	public void readFile(CsvReader file){
		
		ArrayList<DegreePlan> degreePlans = new ArrayList<DegreePlan>();
		
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String degree_Code = file.get(headers[0]);
					String grad_Schl = file.get(headers[1]);
					String degree_Name = file.get(headers[2]);
					String forecast = file.get(headers[3]);
					
					// perform program logic here
					System.out.println(degree_Code + " : " + grad_Schl + " : " + degree_Name + " : " + forecast);
					
					// Create a degree object
					DegreePlan degree = new DegreePlan(degree_Code, degree_Name, grad_Schl);
					degreePlans.add(degree);
				}
				// close the file after read completion
				file.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
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
	public boolean updateRecord(CsvReader file, DegreePlan record){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean writeRecord(CsvReader file, DegreePlan record){
		// TODO Auto-generated method stub
		return false;
	}
}
