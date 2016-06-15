package OcGraduateSystemClasses;

/**
 * The document showing the state of specific data in the system
 */
public class Report
{

	/**
	 * The name of the report. This name help identify a report
	 */
	private String reportTitle;
	/**
	 * Explanation on what information the report is showing
	 */
	private String reportDescription;

	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		// TODO - implement Report.setTitle
		throw new UnsupportedOperationException();
	}

	public String getTitle() {
		// TODO - implement Report.getTitle
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param descr
	 */
	public void setReportDescription(String descr) {
		this.reportDescription = descr;
	}

	public String getReportDescription() {
		return this.reportDescription;
	}

	public void printReport() {
		// TODO - implement Report.printReport
		throw new UnsupportedOperationException();
	}

	public void generateReport() {
		// TODO - implement Report.generateReport
		throw new UnsupportedOperationException();
	}

}