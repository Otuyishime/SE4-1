package OcGraduateSystemClasses;

import java.util.*;

import com.csvreader.*;

// -------------- WORK ON IMPORT FILES ( STUDENTS AND STUDENT COURSES ) ---------
// YOU NEED TO MOVE THE CSV IMPORTS OF THE TWO FILES FROM UNIVERSITYDM TO HERE

public class ImportFile
{

	private ArrayList<Student> students;
	
	private ArrayList<StudentCourse> studentCourses;
	
	public ArrayList<Student> getStudents() {
		return students;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}

	public ArrayList<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(ArrayList<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	public void ImportStudentFile(CsvReader studentsfile) {
		
	}

	public void ImportStudentCourses(CsvReader studentcoursesfile) {
		
	}

	/**
	 * default constructor
	 */
	public ImportFile() {
		
		students = new ArrayList<Student>();
		studentCourses = new ArrayList<StudentCourse>();
	}

}