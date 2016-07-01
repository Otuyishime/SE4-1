package SystemDataManagementClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;

public class StudentDM {
	
	private ArrayList<Student> StudentData;

	public ArrayList<Student> getStudentData() {
		return StudentData;
	}
	public void setStudentData(ArrayList<Student> studentData) {
		this.StudentData = studentData;
	}

	//  Constructor
	public StudentDM(CsvReader fileName){

		StudentData =  new ArrayList<Student>();	
		readFile(fileName);
	}

	public void readFile(CsvReader file){
		try {
			if (file != null){
				while (file.readRecord())
				{
					String studentId = file.get(0);
					String   degreeCodeFetched  = file.get(1);
					String  graduatiomSemester = file.get(2);
					
					// test print
					//System.out.println(studentId + " : " + degreeCodeFetched + " : " + graduatiomSemester);
					
					if (degreeCodeFetched.equals("MSE.ENGMGT") || degreeCodeFetched.equals("MSE.ECE")){
						// We omit these two degrees
						
					}else{
						// create a temporary student
						Student temp_student = new Student(studentId, degreeCodeFetched, graduatiomSemester);
						// add the temporary student to the list of students
						getStudentData().add(temp_student);
					}
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
	
	// get the Student with a Student ID
	public Student getStudentWithID(String  StudentId){
		
	    for(Student Student: getStudentData()){
	    	if (Student.getStudentId().equals(StudentId)){
	    		return Student;
	    	} 	
	    }
	    
		return null;
	}
	
	// load the student with their respective graduation semesters
	public boolean loadGraduationSemesters(SemesterDM semesters){

		for(Student student: getStudentData()){
			for(Semester semester: semesters.getSemesterData()){
				if ( student.getGraduationsemesterName().equals(semester.getName())){
					student.setGraduationsemester(semester);
				}
			}
		}

		return false;
	}
	
	// load the student with their respective graduation semesters
	public boolean loadStudentDegrees(DegreeDM degrees){

		for(Student student: getStudentData()){
			for(Degree degree: degrees.getDegreeData()){
				if ( student.getDegreeCode().equals(degree.getDegreeCode())){
					student.setDegree(degree);
				}
			}
		}

		return false;
	}
	
	// load the student with their respective course taken
	public boolean loadCourseTaken(StudentCourseDM coursestaken){

		for(Student student: getStudentData()){
			for(StudentCourse course: coursestaken.getStudentCourseData()){
				if ( student.getStudentId().equals(course.getStudentID())){
					student.addStudentcourses(course);
				}
			}
		}

		return false;
	}
}
