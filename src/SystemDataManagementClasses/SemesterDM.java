package SystemDataManagementClasses;

import OcGraduateSystemClasses.Semester;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.csvreader.CsvReader;
import java.util.*;

public class SemesterDM {
	
	private ArrayList<Semester> semesterData;
	
	public ArrayList<Semester> getSemesterData() {
		return semesterData;
	}

	public void setSemesterData(ArrayList<Semester> semesterData) {
		this.semesterData = semesterData;
	}

	public SemesterDM(CsvReader fileName){
		semesterData =  new ArrayList<Semester>();	
		readFile(fileName);
	}
	
	public int getNumberofSemesterDataImported(){
		return semesterData.size();
	}
	
	// Return the Semester whenever you have the semester nbame
	public Semester returnTheSemesterGivenTheSemesterName(String semesterName){
		Semester DiseredSemester = null;
	    for(Semester semester: semesterData){
	    	if (semester.getName().equals(semesterName)){
	    		DiseredSemester = semester;
	    	} 	
	    }
		return DiseredSemester;
	}
	
	public void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String semName = file.get(headers[0]);
					String  semStartDateString  = file.get(headers[1]);
					Date semStartDate = new SimpleDateFormat("mm/dd/yyyy").parse(semStartDateString);
					String  semEndDateString = file.get(headers[2]);
					Date semEndDate = new SimpleDateFormat("mm/dd/yyyy").parse(semEndDateString);
					
		 			//System.out.println(semName + " : " + semStartDateString + " : " + semEndDateString);
		 			
					// Construct the  semester object based on the imported data.
					Semester semester  =  new Semester  (semName,semStartDate,semEndDate);
					semesterData.add(semester);
				}
				// close the file after read completion
				file.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch( ParseException e){
			e.printStackTrace();
		}
	}
}
