package OcGraduateSystemClasses;

import java.util.Date;

//import java.sql.Date;

/**
 * Represents the season in which classes are offered.
 * A semester also provides information about the start and the end of the learning season.
 */
public class Semester
{
	private String name;
	// We will need a date class to handle the dates
	private Date startDate;
	
	private Date endDate;

	// ---------------- Accessors ---------------
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	// ------------------- Methods -------------
	public Semester(String name, Date startDate, Date semEndDate) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = semEndDate;
	}
	
	public Semester(String name) {
		super();
		this.name = name;
	}
}