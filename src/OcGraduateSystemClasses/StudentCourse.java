package OcGraduateSystemClasses;

import OcGraduateSystemClasses.Student;

/**
 * Represents a course the student can take
 */
public class StudentCourse
{
	private String StudentID;
	
	private String  courseCode;
	private String courseName;
	private Course  course;
	
	private String  semesterName;
	private Semester semester;
	
	private String  grade;
	
	
	// --------- Accessors -----------
	public String getStudentID() {
		return StudentID;
	}
	
	public void setStudentID(String ctudentID) {
		this.StudentID = ctudentID;
	}
	
	public String getCourseCode() {
		return courseCode;
	}

	private void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	private void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public String getSemesterName() {
		return semesterName;
	}
	
	private void setSemesterName(String semesterName) {
		this.semesterName = semesterName;
	}
	
	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	// --------- Methods -----------
	public StudentCourse(String studentID, String courseCode, String courseName, String semesterName, String grade) {
		this.setStudentID(studentID);
		this.setCourseCode(courseCode);
		this.setCourseName(courseName);
		this.setSemesterName(semesterName);
		this.setGrade(grade);
	}

	public void print(){
		System.out.println(StudentID + " : " + courseCode + " : " + courseName + " : " + semesterName + " : " + grade);
	}
}