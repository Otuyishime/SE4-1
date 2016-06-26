package SystemDataManagementClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;

public class StudentCourseDM {

	private ArrayList<StudentCourse> StudentCourseData;

	public StudentCourseDM(CsvReader fileName){
		StudentCourseData =  new ArrayList<StudentCourse>();	
		readFile(fileName);

	}

	public ArrayList<StudentCourse> getStudentCourseData() {
		return StudentCourseData;
	}

	public void setStudentCourseData(ArrayList<StudentCourse> studentCourseData) {
		StudentCourseData = studentCourseData;
	}

	public void readFile(CsvReader file)
	{
		try {
			if (file != null){

				while (file.readRecord()){
					String studentId = file.get(0);
					String courseCode = file.get(1);
					String courseName = file.get(2);
					String semesterOfCourseTaken = file.get(3);
					String coursegrade = file.get(4);

					// test print
					//System.out.println(studentId + " : " + courseCode + " : " + courseName + " : " + semesterOfCourseTaken + " : " + coursegrade);
					
					// create a temporary student course
					StudentCourse temp_studentcourse = new StudentCourse(studentId, courseCode, courseName, semesterOfCourseTaken, coursegrade);
					
					// add student course to the list of student courses
					getStudentCourseData().add(temp_studentcourse);
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

	// Return the student courses taken by the student with ID
	public ArrayList<StudentCourse> getStudentCoursesDataWithStudentID(String StudentID){
		ArrayList<StudentCourse> diseredStudentCourseData = new ArrayList<StudentCourse>();
		
		for(StudentCourse studentcourse: StudentCourseData){
			if ( studentcourse.getStudentID().equals(StudentID)){
				diseredStudentCourseData.add(studentcourse);
			}
		}

		return diseredStudentCourseData;
	}
	
	// load the student courses with their respective courses
	public boolean loadCourses(CourseDM courses){
		
		for(StudentCourse studentcourse: StudentCourseData){
			for(Course course: courses.getCourses()){
				if ( studentcourse.getCourseCode().equals(course.getCourseCode())){
					studentcourse.setCourse(course);
				}
			}
		}
		
		return false;
	}
	
	// load the student courses with their respective semester
	public boolean loadSemester(SemesterDM semesters){

		for(StudentCourse studentcourse: StudentCourseData){
			for(Semester semester: semesters.getSemesterData()){
				if ( studentcourse.getSemesterName().equals(semester.getName())){
					studentcourse.setSemester(semester);
				}
			}
		}

		return false;
	}
}
