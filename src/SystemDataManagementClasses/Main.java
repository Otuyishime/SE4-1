package SystemDataManagementClasses;
import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Semester;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CsvReader file;
			
			/*
			System.out.println(" ---------------------- University -------------------");
			file = new CsvReader("src/Data/TestDataUniversityName.csv");
			UniversityDM univ = new UniversityDM();
			univ.readFile(file);
			System.out.println();
			*/
			
			/*
			System.out.println(" ---------------------- Semesters --------------------");
			file = new CsvReader("src/Data/TestDataSemesters.csv");
			SemesterDM sem = new SemesterDM(file);
			System.out.println(sem.getSemesterData().size());
			System.out.println();
			*/
			
			/*
			System.out.println(" ---------------------- Grad Schools --------------------");
			file = new CsvReader("src/Data/TestDataGradSchools.csv");
			GradSchoolDM gradSchl = new GradSchoolDM();
			gradSchl.readFile(file);
			System.out.println();
			*/
			
			
			System.out.println(" ---------------------- Faculty --------------------");
			file = new CsvReader("src/Data/TestDataFaculty.csv");
			FacultyDM faculty = new FacultyDM(file);
			
			Semester sem = new Semester("2016SU");
			System.out.println(sem.getName());
			
			System.out.println(faculty.getFacultiesWhoCanTeachInSemester(sem).size());
			for ( int i = 0; i < faculty.getFacultiesWhoCanTeachInSemester(sem).size(); i++){
				System.out.print(faculty.getFacultiesWhoCanTeachInSemester(sem).get(i).getFirstName());
				System.out.print(" ");
				System.out.println(faculty.getFacultiesWhoCanTeachInSemester(sem).get(i).getLastName());
			}
			System.out.println();
			
			
			/*
			System.out.println(" ---------------------- Degrees --------------------");
			file = new CsvReader("src/Data/TestDataDegrees.csv");
			DegreePlanDM degrees = new DegreePlanDM();
			degrees.readFile(file);
			System.out.println();
			*/
			
			/*
			System.out.println(" ---------------------- Degree Requirements--------------------");
			file = new CsvReader("src/Data/TestDataDegreePlanReq.csv");
			DegreePlanReqDM degreeReq = new DegreePlanReqDM();
			degreeReq.readFile(file);
			System.out.println();
			*/
			
			/*
			System.out.println(" ---------------------- Courses--------------------");
			// file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataCourses.csv");
			file = new CsvReader("src/Data/TestDataCourses.csv");
			CourseDM courses = new CourseDM(file);
			System.out.println(courses.getCourses().get(0).getPrerequisites().get(0).getCourseName());
			*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
