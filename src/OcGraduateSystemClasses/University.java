package OcGraduateSystemClasses;

import java.util.*;

/**
 * This class represents an institution for higher learning.
 * This occupies the highest level of hierarchy
 */
public class University
{

	private ArrayList<Semester> semesters;
	private ArrayList<GradSchool> gradSchools;
	private ArrayList<Course> courses;
	/**
	 * Name of the institution
	 */
	private String name;
	/**
	 * Short name of the institution name
	 */
	private String abbreviation;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	/**
	 * Object Constructor
	 * @param name The name has to be a non-empty string
	 */
	
	public University(String name) {
		if (!name.isEmpty()){
			setName(name);
		}
		else{
			System.out.println("university was not created!");
		}
	}

	/**
	 * Object Constructor
	 * @param name The name has to be a non-empty string
	 * @param abbreviation the abbreviation has to be a non-empty string
	 */
	public University(String name, String abbreviation) {
		if (!name.isEmpty() && !abbreviation.isEmpty()){
			setName(name);
			setAbbreviation(abbreviation);
		}
		else{
			System.out.println("university was not created!");
		}
	}

}