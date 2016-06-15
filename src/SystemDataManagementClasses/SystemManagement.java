package SystemDataManagementClasses;
import com.csvreader.*;
import java.util.*;

public interface SystemManagement<Type> {
	/**
	 * 
	 * @return
	 * @throws Exception 
	 */
	void readFile(CsvReader file) throws Exception;
	
	/**
	 * 
	 * @return
	 */
	int findRecord(CsvReader file, String key);
	
	/**
	 * 
	 * @return
	 */
	int deleteRecord(CsvReader file, String Key);
	
	/**
	 * 
	 * @return
	 */
	boolean updateRecord(CsvReader file, Type record);
	
	/**
	 * 
	 * @return
	 */
	boolean writeRecord(CsvReader file, Type record);
}
