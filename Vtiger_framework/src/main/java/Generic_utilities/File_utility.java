package Generic_utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_utility {
	/**
	 * This method is used to read data from properties file(External resources)
	 * 
	 * @param key
	 * @return
	 * @throws Throwable
	 * @author Shaima
	 */

	public String getKeyAndValuePair(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		// Step2: create an object to properties class to load all the keys
		Properties pro = new Properties();
		pro.load(fis);
		// step3: read the value using get property()
		String value = pro.getProperty(key);
		return value;

	}
}
