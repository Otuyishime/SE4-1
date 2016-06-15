package OcGraduateSystemClasses;

import java.util.*;

/**
 * represents the person studying at the university in the graduate school
 */
public class Student
{
	private int studentId;
	private Degree degreeCode;
	 private Semester semesterName;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Degree getDegreeCode() {
		return degreeCode;
	}
	public void setDegreeCode(Degree degreeCode) {
		this.degreeCode = degreeCode;
	}
	public Semester getSemesterName() {
		return semesterName;
	}
	public void setSemesterName(Semester semesterName) {
		this.semesterName = semesterName;
	}
	
	public Student(int studentId, Degree degreeCode, Semester semesterName) {
		this.studentId = studentId;
		this.degreeCode = degreeCode;
		this.semesterName = semesterName;
	}
	 
	
	

}