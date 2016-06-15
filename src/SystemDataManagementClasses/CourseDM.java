



package SystemDataManagementClasses;
import OcGraduateSystemClasses.Course;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.csvreader.*;
import java.util.*;

public class CourseDM {
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public ArrayList<Course> getCourses() {
		if ( !courses.isEmpty()){
			return courses;
		}
		return null;
	}
	
	// Constructor
	public CourseDM(CsvReader file) {
		if ( file != null){
			readFile(file);
			
			for ( int i = 0; i < courses.size(); i++){
				if ( !courses.get(i).getPrereq().equals("none")){
					courses.get(i).addPreRequisite(getCourseWithCode(courses.get(i).getPrereq()));
				}
			}
		}
	}

	public void readFile(CsvReader file){
		
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String course_Code = file.get(headers[0]);
					String course_Name = file.get(headers[1]);
					String course_Desc = file.get(headers[2]);
					String course_Hrs = file.get(headers[3]);
					String course_Cap = file.get(headers[4]);
					String isOfferedFall = file.get(headers[5]);
					String isOfferedSpring = file.get(headers[6]);
					String isOfferedSummer = file.get(headers[7]);
					String course_Prereq = file.get(headers[8]);
					String teachers = file.get(headers[9]);
					
					// perform program logic here
					boolean offeredfall, offeredspring, offeredsummer;
					offeredfall = isOfferedFall.equals("Y") ? true: false;
					offeredspring = isOfferedSpring.equals("Y") ? true: false;
					offeredsummer = isOfferedSummer.equals("Y") ? true: false;
					
					// Create a temporary course
					Course tempcourse = new Course(course_Code, course_Name, course_Desc, 
							Integer.parseInt(course_Hrs), Integer.parseInt(course_Cap), 
							offeredfall, offeredspring, offeredsummer, 
							course_Prereq, new ArrayList<String>( Arrays.asList(teachers.split(","))));
					// Add course to the list
					courses.add(tempcourse);	
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
	
	public Course getCourseWithCode(String code){
		for ( int i = 0; i < courses.size(); i ++){
			if ( courses.get(i).getCourseCode().equals(code)){
				return courses.get(i);
			}
		}
		return null;
	}
	
	public Course getCourseWithName(String name){
		for ( int i = 0; i < courses.size(); i ++){
			if ( courses.get(i).getCourseName().equals(name)){
				return courses.get(i);
			}
		}
		return null;
	}
}
