package OcGraduateSystemClasses;

import java.util.*;

/**
 * represents the person studying at the university in the graduate school
 */
public class Student
{

	private ArrayList<StudentCourse> courses;
	private DegreePlan degree;
	/**
	 * the identification number. It is used to identify a student.
	 */
	private int id;
	/**
	 * The name of the student
	 */
	private String name;

	/**
	 * Student object constructor
	 * @param id the id must be valid
	 */
	public Student(int id) {
		// TODO - implement Student.Student
		throw new UnsupportedOperationException();
	}

	/**
	 * Student object constructor
	 * @param id
	 * @param name
	 */
	public Student(int id, String name) {
		// TODO - implement Student.Student
		throw new UnsupportedOperationException();
	}

	/**
	 * Student object constructor
	 * @param student student must be a non-null object
	 */
	public Student(Student student) {
		// TODO - implement Student.Student
		throw new UnsupportedOperationException();
	}

	/**
	 * returns a list of all courses the student has to take
	 */
	public SemesterForecast getStudentCourses() {
		// TODO - implement Student.getStudentCourses
		throw new UnsupportedOperationException();
	}

	/**
	 * gets the student data from a file
	 */
	public void fetchStudentData() {
		// TODO - implement Student.fetchStudentData
		throw new UnsupportedOperationException();
	}

	/**
	 * returns all the courses the student has taken
	 */
	public Course getTakenCourses() {
		// TODO - implement Student.getTakenCourses
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the student's degree plan
	 */
	public DegreePlan getDegreePlan() {
		// TODO - implement Student.getDegreePlan
		throw new UnsupportedOperationException();
	}

}