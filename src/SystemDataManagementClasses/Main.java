package SystemDataManagementClasses;
import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Semester;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CsvReader file;
			/*System.out.println(" ---------------------- University -------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataUniversityName.csv");
			UniversityDM univ = new UniversityDM();
			univ.readFile(file);
			System.out.println();*/
			
			/*System.out.println(" ---------------------- Semesters --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataSemesters.csv");
			SemesterDM sem = new SemesterDM(file);
			System.out.println(sem.getSemesterData().size());
			System.out.println();*/
			
			/*System.out.println(" ---------------------- Grad Schools --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataGradSchools.csv");
			GradSchoolDM gradSchl = new GradSchoolDM();
			gradSchl.readFile(file);
			System.out.println();*/
			
			System.out.println(" ---------------------- Faculty --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataFaculty.csv");
			FacultyDM faculty = new FacultyDM(file);
			System.out.println();
			
			System.out.println(" ---------------------- Courses--------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataCourses.csv");
			CourseDM courses = new CourseDM(file);
			
			courses.loadFaculty(faculty);
			System.out.println(courses.getCourses().get(0).getFaculty().getSpringLoad());
			
			System.out.println();
			
			/*System.out.println(" ---------------------- Degrees --------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataDegrees.csv");
			DegreePlanDM degrees = new DegreePlanDM();
			degrees.readFile(file);
			System.out.println();
			
			System.out.println(" ---------------------- Degree Requirements--------------------");
			file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataDegreePlanReq.csv");
			DegreePlanReqDM degreeReq = new DegreePlanReqDM();
			degreeReq.readFile(file);
			System.out.println();
			*/
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
