package utility;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class Utility {

	public String generalvalues(String colname) throws FileNotFoundException {
			
//		File file = new File("C:\\Selenium\\TechAviatorFrameworkDesign\\config.properties");
		
		String property = System.getProperty("config.properties");
		FileInputStream fis= new FileInputStream(property);
		
		Properties prop= new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Unable to Load the fis file");
		}
		
		String propertyvalue = prop.getProperty(colname);
		return propertyvalue;		
	}

}
