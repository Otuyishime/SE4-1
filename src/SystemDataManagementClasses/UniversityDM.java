package SystemDataManagementClasses;
import OcGraduateSystemClasses.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.CsvReader;
import java.util.*;

public class UniversityDM {
	// add all data management classes necessary
	GradSchoolDM gradSchl;
	SemesterDM semesters;
	FacultyDM faculties;
	CourseDM courses;
	DegreePlanReqDM degreeReqs;
	DegreeDM degrees;
	StudentCourseDM studentcourses;
	StudentDM students;
	RoomDM rooms;
	
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
					
					// test print
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
			gradSchl = new GradSchoolDM(file);
			university.setGradSchools(gradSchl.getGradSchools());
			
			file = new CsvReader("src/Data/TestDataSemesters.csv");
			semesters = new SemesterDM(file);
			university.setSemesters(semesters.getSemesterData());
			
			file = new CsvReader("src/Data/TestDataFaculty.csv");
			faculties = new FacultyDM(file);
			university.setFaculties(faculties.getFaculties());
			
			file = new CsvReader("src/Data/TestDataCourses.csv");
			courses = new CourseDM(file);
			courses.loadFaculty(faculties);
			university.setCourses(courses.getCourses());
			faculties.loadCoursesForFaculties(courses);
			
			file = new CsvReader("src/Data/TestDataDegreePlanReq.csv");
			degreeReqs = new DegreePlanReqDM(file);
			degreeReqs.loadCourses(courses);
			university.setDegreerequirements(degreeReqs.getDegree_Requirements());

			file = new CsvReader("src/Data/TestDataDegrees.csv");
			degrees = new DegreeDM(file);
			degrees.loadDegreeRequirements(degreeReqs);
			university.setDegrees(degrees.getDegreeData());
			
			// add rooms
			rooms = new RoomDM();
			university.setRooms(rooms.getRooms());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean importStudents(String studentFileLocation){
		if ( !studentFileLocation.isEmpty()){
			try {
				
				CsvReader file = new CsvReader(studentFileLocation);
				students = new StudentDM(file);
				students.loadGraduationSemesters(semesters);
				students.loadStudentDegrees(degrees);
				
				university.setStudents(students.getStudentData());
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public boolean importStudentCourses(String studentCoursesFileLocation){
		if ( !studentCoursesFileLocation.isEmpty()){
			try {
				
				CsvReader file = new CsvReader(studentCoursesFileLocation);
				studentcourses = new StudentCourseDM(file);
				studentcourses.loadCourses(courses);
				studentcourses.loadSemester(semesters);
				university.setStudentcourses(studentcourses.getStudentCourseData());
				students.loadCourseTaken(studentcourses);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
