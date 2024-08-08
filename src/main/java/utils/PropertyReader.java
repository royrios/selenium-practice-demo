package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	//Read the Properties file in the resources folder
	//Read Environment properties
	//PropertyReader instance and call readItem with String
	
	static Properties properties;
	
	public PropertyReader() {
		
		lodAllProperties();
	}
	
	
	public void lodAllProperties() {
		
		properties = new Properties();
		
		//read the  File test_config.properties
		
		try {
			
			String fileName = System.getProperty("user.dir")+"/src/main/resources/qa_config.properties";
			
			System.out.println(fileName);
			
			properties.load(new FileInputStream(fileName));
			
			}catch(IOException e){
			
					throw new RuntimeException("File properties not found");
			}
	}
	
	
	
	
	public static String readItem(String propertyName) {
		
		return properties.getProperty(propertyName);
		
	}
}
