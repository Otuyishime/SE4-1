package OcGraduateSystemClasses;

import java.util.ArrayList;

public class Degree {
	
	
	private String DegreeCode;
	private String GradSchool;
	private String DegreeName;
	private int Forecast;
	
	private ArrayList<DegreeRequirement> degreeRequirements;
	
	public String getDegreeCode() {
		return DegreeCode;
	}
	public void setDegreeCode(String degreeCode) {
		DegreeCode = degreeCode;
	}
	public String getGradSchool() {
		return GradSchool;
	}
	public void setGradSchool(String gradSchool) {
		GradSchool = gradSchool;
	}
	public String getDegreeName() {
		return DegreeName;
	}
	public void setDegreeName(String degreeName) {
		DegreeName = degreeName;
	}
	public int getForecast() {
		return Forecast;
	}
	public void setForecast(int forecast) {
		Forecast = forecast;
	
	}
	
	public ArrayList<DegreeRequirement> getDegreeRequirements() {
		return degreeRequirements;
	}
	
	public void setDegreeRequirements(ArrayList<DegreeRequirement> degreeReqs) {
		this.degreeRequirements = degreeReqs;
	}
	
	public void addDegreeRequirements(DegreeRequirement degreereq) {
		if ( degreereq != null){
			getDegreeRequirements().add(degreereq);
		}
	}
	
	public Degree(String degreeCode, String gradSchool, String degreeName, int forecast) {
		DegreeCode = degreeCode;
		GradSchool = gradSchool;
		DegreeName = degreeName;
		Forecast = forecast;
		
		// create degree requirement list
		degreeRequirements = new ArrayList<DegreeRequirement>();
	}
	
	public void print(){
		System.out.print(DegreeCode + " : " + GradSchool + " : " + DegreeName + " : " + Forecast);
		System.out.println();
	}
	
	/*
	 * override a toString method
	 * this will help up be able to display what we want on the JList of this object
	 * instead of displaying this object's memory address
	 */
	
	@Override
	public String toString() {
	    return this.getDegreeName();
	}
	
	
}
