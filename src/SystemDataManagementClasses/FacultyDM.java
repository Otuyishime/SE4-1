package SystemDataManagementClasses;

import OcGraduateSystemClasses.Faculty;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class FacultyDM {
	
	// Add a list of faculties
	ArrayList<Faculty> faculties = new ArrayList<Faculty>();
	
	public void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String fac_firstName = file.get(headers[0]);
					String fac_LastName = file.get(headers[1]);
					String gradSchl = file.get(headers[2]);
					String degree = file.get(headers[3]);
					String title = file.get(headers[4]);
					String daysToTeach = file.get(headers[5]);
					String maxLoadFall = file.get(headers[6]);
					String maxLoadSpring = file.get(headers[7]);
					String maxLoadSummer = file.get(headers[8]);
					
					
					// perform program logic here
					System.out.println(fac_firstName + " : " + fac_LastName + " : " + gradSchl + " : " + degree + " : " + 
									title + " : " + daysToTeach + " : " + maxLoadFall + " : " + maxLoadSpring + " : " + maxLoadSummer);
					
					// Create a temporary faculty
					/*Faculty faculty = new Faculty(fac_firstName, fac_LastName, gradSchl, degree, title, 
							Integer.parseInt(maxLoadFall), Integer.parseInt(maxLoadSpring), Integer.parseInt(maxLoadSummer));*/
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
}
