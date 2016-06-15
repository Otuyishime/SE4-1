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
	private ArrayList<Faculty> facultyData = new ArrayList<Faculty>();
	
	public ArrayList<Faculty> getFaculties() {
		return facultyData;
	}

	public void setFaculties(ArrayList<Faculty> faculties) {
		this.facultyData = faculties;
	}

	public FacultyDM(CsvReader file) {
		super();
		if ( file != null){
			readFile(file);
		}
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
					
					/*System.out.println(fac_firstName + " : " + fac_LastName + " : " + gradSchl + " : " + degree + " : " + 
					title + " : " + daysToTeach + " : " + maxLoadFall + " : " + maxLoadSpring + " : " + maxLoadSummer);*/
					
					// Extract data
					// create a temporary faculty load list
					ArrayList<FacultyLoad> loads = new ArrayList<FacultyLoad>();
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadFall)));
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadSpring)));
					loads.add(new FacultyLoad(Integer.parseInt(maxLoadSummer)));
					
					// Create a temporary faculty
					Faculty faculty = new Faculty(fac_firstName, fac_LastName, gradSchl, degree, title, daysToTeach, loads);
					
					// add the faculty to the list
					facultyData.add(faculty);
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
	
	public ArrayList<Faculty> getFacultiesWhoCanTeachInSemester(Semester semester){
		
		ArrayList<Faculty> facultyList = new ArrayList<Faculty>();;	// We will return this list
		
		if (semester != null){
			// Split the semester name to get the abbreviated name
			String temp_chrs[] = semester.getName().split("");
			String temp_AbbrevName = (temp_chrs[temp_chrs.length - 2] + temp_chrs[temp_chrs.length - 1]);
			
			for ( int i = 0; i < facultyData.size(); i++){
				if ( temp_AbbrevName.equals("FA") && facultyData.get(i).canTeachFall()){
					facultyList.add(facultyData.get(i));
				}
				
				if ( temp_AbbrevName.equals("SP") && facultyData.get(i).canTeachSpring()){
					facultyList.add(facultyData.get(i));
				}
				
				if ( temp_AbbrevName.equals("SU") && facultyData.get(i).canTeachSummer()){
					facultyList.add(facultyData.get(i));
				}
			}
		}
		return facultyList;
	}
}
