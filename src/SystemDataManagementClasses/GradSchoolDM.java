package SystemDataManagementClasses;

import OcGraduateSystemClasses.GradSchool;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;


public class GradSchoolDM {
	
	ArrayList<GradSchool> gradSchools;
	
	public ArrayList<GradSchool> getGradSchools() {
		return gradSchools;
	}

	public void setGradSchools(ArrayList<GradSchool> gradSchools) {
		this.gradSchools = gradSchools;
	}

	public GradSchoolDM(CsvReader file) {
		super();
		gradSchools = new ArrayList<GradSchool>();
		readFile(file);
	}


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
					// create a temporary grad school
					GradSchool gradschool = new GradSchool(gradSchl_Name,gradSchl_Abbr);
					getGradSchools().add(gradschool);
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
