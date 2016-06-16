package OcGraduateSystemClasses;

import java.util.*;

/**
 * Represents the second academic level department in a higher learning institution.
 * In this case, it represents the graduate school department
 */
public class GradSchool
{
	/**
	 * the name of the graduate school department
	 */
	private String name;
	/**
	 * represents the short name of the graduate school department
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
	 * @param name The name must be a non-empty string
	 * @param abbreviation The abbreviation has to be a non-empty string
	 */
	public GradSchool(String name, String abbreviation) {
		if ( !name.isEmpty() && !abbreviation.isEmpty()){
			setName(name);
			setAbbreviation(abbreviation);
		}
		else{
			throw new UnsupportedOperationException();
		}
	}

}