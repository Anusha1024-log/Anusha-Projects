package org.tetrasoft.training.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
    
	static Properties prop = new Properties();
	static String path = System.getProperty("user.dir");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getProperties();
		setPropertioes();
		getProperties();

	}
    public static void getProperties() {
    	try {
    	
    	
    	InputStream input = new FileInputStream(path+"/src/test/java/org/tetrasoft/training/config/config.properties");
    	prop.load(input);
    	String browser = prop.getProperty("browser");
    	System.out.println("Browser name is :"+browser);
    	
    }catch(Exception e) {
    	System.out.println(e.getMessage());
    }
    	
    }
    public static void setPropertioes() {
    	try {
    	OutputStream output = new FileOutputStream(path+"/src/test/java/org/tetrasoft/training/config/config.properties");
    	prop.setProperty("browser", "firfox");
    	
    	prop.store(output, null);
    	
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    		
    	}
    }
}
