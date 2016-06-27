package OcGraduateSystemClasses;

/**
 * a division of class offered in a particular semester
 */
public class Section
{

	private String courseCode;
	private String facultyName;
	private String  SemesterName;
	private String coursedescription;
	private String degreetype;
	public String getCourse() {
		return courseCode;
	}
	public void setCourse(String course) {
		this.courseCode = course;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getSemesterName() {
		return SemesterName;
	}
	public void setSemesterName(String semesterName) {
		SemesterName = semesterName;
	}
	public String getCoursedescription() {
		return coursedescription;
	}
	public void setCoursedescription(String coursedescription) {
		this.coursedescription = coursedescription;
	}
	public String getDegreetype() {
		return degreetype;
	}
	public void setDegreetype(String degreetype) {
		this.degreetype = degreetype;
	}
	
	
	
	public Section(String course,String coursedescription, String facultyName, String semesterName,
			String degreetype) {
		this.courseCode = course;
		this.coursedescription = coursedescription;
		this.facultyName = facultyName;
		SemesterName = semesterName;
		this.degreetype = degreetype;
	}
	
	
	
	
	
}