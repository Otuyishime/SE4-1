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
					System.out.println(univ_Name + " : " + univ_ID);
					
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
			System.out.println(" ---------------------- Grad Schools --------------------");
			file = new CsvReader("src/Data/TestDataGradSchools.csv");
			GradSchoolDM gradSchl = new GradSchoolDM(file);
			university.setGradSchools(gradSchl.getGradSchools());
			System.out.println();
			
			System.out.println(" ---------------------- Semesters --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataSemesters.csv");
			SemesterDM sem = new SemesterDM(file);
			university.setSemesters(sem.getSemesterData());
			System.out.println();
			
			System.out.println(" ---------------------- Faculty --------------------");
			file = new CsvReader("src/Data/TestDataFaculty.csv");
			FacultyDM faculty = new FacultyDM(file);
			university.setFaculties(faculty.getFaculties());
			System.out.println();
			
			System.out.println(" ---------------------- Courses--------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataCourses.csv");
			CourseDM courses = new CourseDM(file);
			courses.loadFaculty(faculty);
			university.setCourses(courses.getCourses());
			System.out.println();
			
			System.out.println(" ---------------------- Degrees --------------------");
			file = new CsvReader("src/Data/TestDataDegrees.csv");
			DegreePlanDM degrees = new DegreePlanDM(file);
			university.setDegreeplans(degrees.getDegreePlans());
			System.out.println();
			
			System.out.println(" ---------------------- Degree Requirements--------------------");
			file = new CsvReader("src/Data/TestDataDegreePlanReq.csv");
			DegreePlanReqDM degreeReq = new DegreePlanReqDM();
			degreeReq.readFile(file);
			university.setDegreerequirements(degreeReq.getDegree_Requirements());
			System.out.println();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
