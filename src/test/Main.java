package test;
import OcGraduateSystemClasses.*;
import SystemDataManagementClasses.*;
import Windows.*;
import com.csvreader.CsvReader;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CsvReader file;
			System.out.println(" ---------------------- University -------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataUniversityName.csv");
			UniversityDM univ = new UniversityDM(file);
			System.out.println();
			
			System.out.println(" ---------------------- Grad Schools --------------------");
			file = new CsvReader("src/Data/TestDataGradSchools.csv");
			GradSchoolDM gradSchl = new GradSchoolDM();
			gradSchl.readFile(file);
			System.out.println();
			
			System.out.println(" ---------------------- Semesters --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataSemesters.csv");
			SemesterDM sem = new SemesterDM(file);
			System.out.println(sem.getSemesterData().size());
			System.out.println();
			
			System.out.println(" ---------------------- Faculty --------------------");
			file = new CsvReader("src/Data/TestDataFaculty.csv");
			FacultyDM faculty = new FacultyDM(file);
			System.out.println();
			
			System.out.println(" ---------------------- Courses--------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataCourses.csv");
			CourseDM courses = new CourseDM(file);
			courses.loadFaculty(faculty);
			System.out.println(courses.getCourses().get(5).getFaculties().get(0).getLastName());
			System.out.println();
			
			System.out.println(" ---------------------- Degrees --------------------");
			file = new CsvReader("src/Data/TestDataDegrees.csv");
			DegreePlanDM degrees = new DegreePlanDM();
			degrees.readFile(file);
			System.out.println();
			
			System.out.println(" ---------------------- Degree Requirements--------------------");
			file = new CsvReader("src/Data/TestDataDegreePlanReq.csv");
			DegreePlanReqDM degreeReq = new DegreePlanReqDM();
			degreeReq.readFile(file);
			System.out.println();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
