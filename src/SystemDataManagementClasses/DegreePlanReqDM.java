package SystemDataManagementClasses;
import OcGraduateSystemClasses.DegreeRequirement;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.*;
import java.util.*
;

public class DegreePlanReqDM {
	ArrayList<DegreeRequirement> degree_Requirements;

	public ArrayList<DegreeRequirement> getDegree_Requirements() {
		return degree_Requirements;
	}

	public void setDegree_Requirements(ArrayList<DegreeRequirement> degree_Requirements) {
		this.degree_Requirements = degree_Requirements;
	}

	public DegreePlanReqDM(CsvReader file) {
		super();
		if ( file != null){
			degree_Requirements = new ArrayList<DegreeRequirement>();
			readFile(file);
		}	
	}

	private void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();

				while (file.readRecord())
				{
					String degree_Code = file.get(headers[0]);
					String degree_desc = file.get(headers[1]);
					String hours = file.get(headers[2]);
					String type = file.get(headers[3]);
					String courses = file.get(headers[4]);

					// perform program logic here
					/*System.out.println(degree_Code + " : " + degree_desc + " : " + hours + " : " + type + " : " + courses);*/

					// split the courses to get the course codes
					if ( !courses.isEmpty()){

						// Make a list of courses by splitting the read courses 
						ArrayList<String> coursecodes = new ArrayList<String>( Arrays.asList(courses.split(",")));

						// Create a temporary degree requirement object holder
						DegreeRequirement tempDegreeRequirements = new DegreeRequirement(type, degree_desc, 
								Integer.parseInt(hours), degree_Code, coursecodes);
						if (tempDegreeRequirements != null){
							degree_Requirements.add(tempDegreeRequirements);
						}
					}
					else{
						// Create a temporary degree requirement object holder
						DegreeRequirement tempDegreeRequirements = new DegreeRequirement(type, degree_desc, 
								Integer.parseInt(hours), degree_Code);
						if (tempDegreeRequirements != null){
							degree_Requirements.add(tempDegreeRequirements);
						}
					}
				}
				// close the file after read completion
				file.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<DegreeRequirement> getDegreeRequirementByDegreeName(String degree_name){
		// add list to return
		ArrayList<DegreeRequirement> degreeReqs = new ArrayList<DegreeRequirement>();

		if (!degree_name.isEmpty() && !getDegree_Requirements().isEmpty()){
			for (int i = 0; i < getDegree_Requirements().size(); i++ ){
				if ( getDegree_Requirements().get(i).getDegreeCode().equals(degree_name)){
					degreeReqs.add(getDegree_Requirements().get(i));
				}
			}
		}
		return degreeReqs;
	}
	public boolean loadCourses(CourseDM courses){
		if ( courses != null){
			for ( int i = 0; i < getDegree_Requirements().size(); i++){
				for ( int j = 0; j < getDegree_Requirements().get(i).getCourseCodes().size(); j++){

					getDegree_Requirements().get(i).addCourse(courses.getCourseWithCode(getDegree_Requirements().get(i).getCourseCodes().get(j)));
				}
			}
		}else{
			throw new UnsupportedOperationException();
		}
		return false;
	}
}
