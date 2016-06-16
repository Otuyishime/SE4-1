package SystemDataManagementClasses;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import com.csvreader.CsvReader;
import OcGraduateSystemClasses.Degree;

public class DegreeDM {	
 private ArrayList<Degree> degreeData;
	
	public DegreeDM(CsvReader fileName){
		degreeData =  new ArrayList<Degree>();	
		readFile(fileName);
		 
	}
	
	// Return the Semester whenever you have the semester Name
	
	public Degree returnTheDegreeGivenThedegreeCode(String degreeCode){
		Degree Disereddegree = null;
	    for(Degree degree: degreeData){
	    	if (degree.getDegreeCode().equals(degreeCode)){
	    		Disereddegree = degree;
	    	
	    	} 	
	    }
	    
	   
		
		return Disereddegree;
	}
	
 public int getNumberofDegreeImported(){
		 
		 return degreeData.size();
	 }
	
	public void readFile(CsvReader file)
	{
		try {
			if (file.readHeaders()){
				String headers[] = file.getHeaders();
				
				while (file.readRecord())
				{
					String DegreeCode = file.get(headers[0]);
					String  GradSchoolName  = file.get(headers[1]);
					String  DegreeName = file.get(headers[2]);
					int  Forecast = Integer.parseInt (file.get(headers[3]));

					
					// perform program logic here
		 			System.out.println(DegreeCode + " : " + GradSchoolName + " : " + DegreeName);
					
					
					// Construct the  semester object based on the imported data.
					Degree degree  =  new Degree  (DegreeCode,GradSchoolName,DegreeName,Forecast);
					degreeData.add(degree);
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
