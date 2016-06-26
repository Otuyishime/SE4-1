package OcGraduateSystemClasses;

import java.util.ArrayList;

public class Degree {
	
	
	private String DegreeCode;
	private String GradSchool;
	private String DegreeName;
	private int Forecast;
	
	private ArrayList<DegreeRequirement> degreePlanReqs;
	
	public ArrayList<DegreeRequirement> getDegreePlanReqs() {
		return degreePlanReqs;
	}

	public void setDegreePlanReqs(ArrayList<DegreeRequirement> degreePlanReqs) {
		this.degreePlanReqs = degreePlanReqs;
	}
	
	public void AddDegreePlanReqs(DegreeRequirement degreePlanReq) {
		getDegreePlanReqs().add(degreePlanReq);
	}

	public Degree(String degreeCode, String gradSchool, String degreeName, int forecast) {
		DegreeCode = degreeCode;
		GradSchool = gradSchool;
		DegreeName = degreeName;
		Forecast = forecast;
	}
	
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
