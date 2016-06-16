package SystemDataManagementClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Course;
import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.Student;
import OcGraduateSystemClasses.StudentCourse;

public class StundentCourseDM {
	
	

private ArrayList<StudentCourse> StudentCourseData;
	
	public StundentCourseDM(CsvReader fileName){
		StudentCourseData =  new ArrayList<StudentCourse>();	
		readFile(fileName);
		 
	}
	
	// Return the Semester whenever you have the semester Name
	
	public StudentCourse returnTheCourseDataGivenStudentID(int StudentID){
		StudentCourse diseredStudentCourseData = null;
	    for(StudentCourse studentcourse: StudentCourseData){
	    	if (studentcourse.getStudentID().getStudentId() == (StudentID)){
	    		diseredStudentCourseData = studentcourse;
	    	
	    	} 	
	    }
	   	
		return diseredStudentCourseData;
	}
	
 public int getNumberofStudentCourseDataImported(){
		 
		 return StudentCourseData.size();
	 }
	
	public void readFile(CsvReader file)
	{
		
		
		
		try {
			
			SemesterDM semesterData = new SemesterDM(file);
			StudentDM studentData = new StudentDM(file);
			CourseDM  courseData =  new CourseDM(file);

			Semester  semesterLoaded =null;
			Student studentLoaded = null;
			Course  courseLoaded = null;
			
			
			
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
		
				
				
				while (file.readRecord())
				{
					int studentId = Integer.parseInt(file.get(headers[0]));
					
					
					for (int i = 0; i < studentData.getNumberofStudentataImported(); i ++){
					    if(studentData.returnTheStudentGivenTheStudentName(studentId).getStudentId() == studentId){
					    	
					    	studentLoaded =studentData.returnTheStudentGivenTheStudentName(studentId);
					    }
					  }
					
					
					String   courseCode  = file.get(headers[1]);
					
					
					for (int i = 0; i <courseData.getNumberofCourseDataImported(); i ++){
					    if(courseData.getCourseWithCode(courseCode).getCourseCode().equals(courseCode)){
					    	
					    	courseLoaded = courseData.getCourseWithCode(courseCode);
					    }
					  }
				    	
			 
				   String  courseName = file.get(headers[2]);
				   
				   
				   
					String   courseSemester = file.get(headers[3]);
					
					for (int i = 0; i < semesterData.getNumberofSemesterDataImported(); i ++)
					
					{
					    if(semesterData.returnTheSemesterGivenTheSemesterName(courseSemester).getName().equals(courseSemester)){
					    	
					    	semesterLoaded =semesterData.returnTheSemesterGivenTheSemesterName(courseSemester);
					    }
						   String  gradeName = file.get(headers[4]);

					
					
					
					StudentCourse tempStudentCourse  =  new StudentCourse  (studentLoaded,courseLoaded,courseLoaded,semesterLoaded,gradeName);
					StudentCourseData.add(tempStudentCourse);
				}
				// close the file after read completion
				file.close();
			}
	 }

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	
	
	
	

}
