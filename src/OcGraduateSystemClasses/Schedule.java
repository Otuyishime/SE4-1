package OcGraduateSystemClasses;

import java.util.*;

/**
 * represents all classes and sections that is to be offered in a semester
 */
public class Schedule
{

	private Semester semester;
	
	private ArrayList<Section> sections;
	
	private Degree degree;
	
	private String title;
	
	public Semester getSemester() {
		return semester;
	}
	
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	
	public ArrayList<Section> getSections() {
		return sections;
	}
	
	public void setSections(ArrayList<Section> sections) {
		this.sections = sections;
	}
	
	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	

	public Schedule(String scheduletitle, ArrayList<Section> schedulesections, Degree scheduledegree, Semester schedulesemester){
		if ( !scheduletitle.isEmpty() && schedulesections != null && scheduledegree != null){
			this.setTitle(scheduletitle);
			this.setSections(schedulesections);
			this.setDegree(scheduledegree);
			this.setSemester(schedulesemester);
		}
	}

}