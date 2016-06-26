package OcGraduateSystemClasses;

import java.util.*;

/**
 * A list showing all the course a student has to take to graduate
 */
public class DegreePlan
{

	private ArrayList<DegreeRequirement> degreeReqs;
	/**
	 * short name of the degree plan
	 */
	private String code;
	/**
	 * the department for which the degree plan stands
	 */
	private String gradSchool;
	/**
	 * name of the degree plan
	 */
	private String name;

	
	public ArrayList<DegreeRequirement> getDegreeReqs() {
		return degreeReqs;
	}

	public void setDegreeReqs(ArrayList<DegreeRequirement> degreeReqs) {
		this.degreeReqs = degreeReqs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGradSchool() {
		return gradSchool;
	}

	public void setGradSchool(String gradSchool) {
		this.gradSchool = gradSchool;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * degree plan constructor
	 * @param code
	 * @param name
	 * @param gradSchool
	 */
	public DegreePlan(String code, String name, String gradschool) {
		if ( !code.isEmpty() && !name.isEmpty() && !gradschool.isEmpty()){
			setCode(code);
			setName(name);
			setGradSchool(gradschool);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * courses the student can take to complete the degree
	 */
	public Course numberCoursesNeeded() {
		// TODO - implement DegreePlan.numberCoursesNeeded
		throw new UnsupportedOperationException();
	}
	
	public void print(){
		// Print the course
		System.out.println(getCode() + " : " + getName() + " : " + getGradSchool());
	}

}