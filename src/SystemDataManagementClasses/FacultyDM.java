package SystemDataManagementClasses;

import OcGraduateSystemClasses.Faculty;
import OcGraduateSystemClasses.FacultyLoad;
import OcGraduateSystemClasses.Semester;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class FacultyDM {
	
	// Add a list of faculties
	private ArrayList<Faculty> faculties = new ArrayList<Faculty>();
	
	public ArrayList<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.faculties = faculties;
	}
	
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
					
					// create a temp faculty load list
					ArrayList<FacultyLoad> loads = new ArrayList<FacultyLoad>();
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadFall)));
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadSpring)));
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadSummer)));
					
					// Create a temporary faculty
					Faculty faculty = new Faculty(fac_firstName, fac_LastName, gradSchl, degree, title, daysToTeach, loads);
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
	
	public ArrayList<Faculty> getFacultiesWhoCanTeachInSemester(Semester sem){
		ArrayList<Faculty> facultyList;
		
		if (sem != null){
			for ( int i = 0; i < faculties.size(); i++){
			}
		}
		return null;
	}
}
