package OcGraduateSystemClasses;

import java.util.ArrayList;

/**
 * a division of class offered in a particular semester
 */
public class Section
{
	private Course course;
	
	private Faculty faculty;
	
	private int sectionNumber;
	
	private Room room;
	
	private Semester semester;
	
	private int sectionCap;
	
	private String academicLevel;
	
	private String sectionStatus;
	
	// ---------------- Accessors -----------------
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	public void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public int getSectionCap() {
		return sectionCap;
	}

	public void setSectionCap(int sectionCap) {
		this.sectionCap = sectionCap;
	}

	public String getAcademicLevel() {
		return academicLevel;
	}

	public void setAcademicLevel(String academicLevel) {
		this.academicLevel = academicLevel;
	}

	public String getSectionStatus() {
		return sectionStatus;
	}

	public void setSectionStatus(String sectionStatus) {
		this.sectionStatus = sectionStatus;
	}

	// -------------------- Methods --------------------
	public Section(int sectionnumber, Course course, Faculty sectionFaculty, String academiclevel, Semester semester, String sectionstatus, Room sectionroom) {
		
		if (course != null && !academiclevel.isEmpty() && semester != null && !sectionstatus.isEmpty()){
			this.setSectionNumber(sectionnumber);
			
			this.setCourse(course);
			this.setFaculty(sectionFaculty);
			this.setAcademicLevel(academiclevel);
			this.setSemester(semester);
			
			this.setSectionStatus(sectionstatus);
			this.setRoom(sectionroom);
			this.setSectionCap(course.getCourseCap());
		}
	}
	
	public static boolean containsCourse(ArrayList<Section> listOfSections, Course course){
		for ( Section section: listOfSections){
			if ( section.getCourse().getCourseCode().equals(course.getCourseCode())){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Section [course= " + course.getCourseName() + " faculty=" + faculty.getFirstName() + ", sectionNumber= 0" + sectionNumber + ", room=" + room.getRoomNumber() + ", semester="
				+ semester.getName() + ", sectionCap=" + sectionCap
				+ ", academicLevel=" + academicLevel + ", sectionStatus=" + sectionStatus + "]";
	}
}