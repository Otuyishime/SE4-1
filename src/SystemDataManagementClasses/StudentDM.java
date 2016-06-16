package SystemDataManagementClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.csvreader.CsvReader;

import OcGraduateSystemClasses.Degree;
import OcGraduateSystemClasses.Semester;
import OcGraduateSystemClasses.Student;

public class StudentDM {
	
	private ArrayList<Student> StudentData;
	
	public ArrayList<Student> getStudentData() {
		return StudentData;
	}

	public void setStudentData(ArrayList<Student> StudentData) {
		this.StudentData = StudentData;
	}

	public StudentDM(CsvReader fileName){
		
		StudentData =  new ArrayList<Student>();	
		readFile(fileName);
	}
	
	// Return the Student whenever you have the Student nbame
	public Student returnTheStudentGivenTheStudentName(int  StudentId){
		Student DiseredStudent = null;
	    for(Student Student: StudentData){
	    	if (Student.getStudentId() ==(StudentId)){
	    		DiseredStudent = Student;
	    	} 	
	    }
		return DiseredStudent;
	}
	
	public void readFile(CsvReader file){
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				file = new CsvReader("/Users/olivier.tuyishime/Google Drive/Summer project I/Test Data/TestData/TestDataCourses.csv");

				DegreeDM degreeData =  new DegreeDM(file);
				SemesterDM semesterData = new SemesterDM(file);
				Degree StudentDegree= null;
				Semester  semesterloaded =null;
				while (file.readRecord())
				{
					int studentId = Integer.parseInt(file.get(headers[0]));
					
					String   degreeCodeFetched  = file.get(headers[1]);
					
					
					for (int i = 0; i < degreeData.getNumberofDegreeImported(); i ++){
						if(degreeData.returnTheDegreeGivenThedegreeCode(degreeCodeFetched).getDegreeCode().equals(degreeCodeFetched)){
							StudentDegree =degreeData.returnTheDegreeGivenThedegreeCode(degreeCodeFetched);
						}
					}
					String  graduatiomSemester = file.get(headers[2]);
					
					for (int i = 0; i < semesterData.getNumberofSemesterDataImported(); i ++){
					    if(semesterData.returnTheSemesterGivenTheSemesterName(graduatiomSemester).getName().equals(graduatiomSemester)){
					    	semesterloaded =semesterData.returnTheSemesterGivenTheSemesterName(graduatiomSemester);
					    }
					//System.out.println(semName + " : " + semStartDateString + " : " + semEndDateString);
		 			
					// Construct the  Student object based on the imported data.
					Student Student  =  new Student  (studentId,StudentDegree,semesterloaded);
					StudentData.add(Student);
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
