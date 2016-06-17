package OcGraduateSystemClasses;

import OcGraduateSystemClasses.Student;

/**
 * Represents a course the student can take
 */
public class StudentCourse
{
	private Student StudentID;
	private Course   courseCode;
	private Course courseName;
	private Semester  semesterName;
	private  String  grade;
	public Student getStudentID() {
		return StudentID;
	}
	public void setStudentID(Student ctudentID) {
		this.StudentID = ctudentID;
	}
	public Course getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(Course courseCode) {
		this.courseCode = courseCode;
	}
	public Course getCourseName() {
		return courseName;
	}
	public void setCourseName(Course courseName) {
		this.courseName = courseName;
	}
	public Semester getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(Semester semesterName) {
		this.semesterName = semesterName;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	public StudentCourse(Student ctudentID, Course courseCode, Course courseName, Semester semesterName, String grade) {
		this.StudentID = ctudentID;
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.semesterName = semesterName;
		this.grade = grade;
	}

	public void print(){
		System.out.println(StudentID + " : " + courseCode + " : " + courseName + " : " + semesterName + " : " + grade);
	}
}