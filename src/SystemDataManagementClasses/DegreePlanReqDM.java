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

	public DegreePlanReqDM() {
		super();
		degree_Requirements = new ArrayList<DegreeRequirement>();
	}
	
	public void readFile(CsvReader file){
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
					System.out.println(degree_Code + " : " + degree_desc + " : " + hours + " : " + type + " : " + courses);
					
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
}
