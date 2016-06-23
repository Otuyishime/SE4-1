package SystemDataManagementClasses;
import OcGraduateSystemClasses.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class UniversityDM {
	University university;
	
	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public UniversityDM(CsvReader file) {
		super();
		readFile(file);
		
		// load all the data
		loadData(getUniversity());
	}

	public void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String univ_Name = file.get(headers[0]);
					String univ_ID = file.get(headers[1]);
					
					// perform program logic here
					/*System.out.println(univ_Name + " : " + univ_ID);*/
					
					// Create a university object
					university = new University(univ_Name, univ_ID);
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
	
	private void loadData(University university){
		try {
			CsvReader file;
			
			file = new CsvReader("src/Data/TestDataGradSchools.csv");
			GradSchoolDM gradSchl = new GradSchoolDM(file);
			university.setGradSchools(gradSchl.getGradSchools());
			
			file = new CsvReader("src/Data/TestDataSemesters.csv");
			SemesterDM sem = new SemesterDM(file);
			university.setSemesters(sem.getSemesterData());
			
			file = new CsvReader("src/Data/TestDataFaculty.csv");
			FacultyDM faculty = new FacultyDM(file);
			university.setFaculties(faculty.getFaculties());
			
			file = new CsvReader("src/Data/TestDataCourses.csv");
			CourseDM courses = new CourseDM(file);
			courses.loadFaculty(faculty);
			university.setCourses(courses.getCourses());
			
			file = new CsvReader("src/Data/TestDataDegrees.csv");
			DegreeDM degrees = new DegreeDM(file);
			university.setDegrees(degrees.getDegreeData());
			
			file = new CsvReader("src/Data/TestDataDegreePlanReq.csv");
			DegreePlanReqDM degreeReqs = new DegreePlanReqDM(file);
			degreeReqs.loadCourses(courses);
			university.setDegreerequirements(degreeReqs.getDegree_Requirements());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
