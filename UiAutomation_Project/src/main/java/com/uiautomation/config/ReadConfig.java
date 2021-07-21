package com.uiautomation.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadConfig {
	
	Properties pro;
	Logger logger;
	
	public ReadConfig() {
		 File src =new File("./Configuration/config.properties");
		 
		 try {
			 FileInputStream fis= new FileInputStream(src);
			 pro=new Properties();
			 pro.load(fis); 
		 }catch(Exception e) {
			 logger.info("Exception is" +e.getMessage());
		 }
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String userName=pro.getProperty("username");
		return userName;
	}
	
	public String getPassword() {
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath() {
		String chromePath=pro.getProperty("chromepath");
		return chromePath;
	}
	
	public String getIEPath() {
		String iePath=pro.getProperty("iepath");
		return iePath;
	}
	
	public String getFirefoxPath() {
		String fireFoxPath=pro.getProperty("firefoxpath");
		return fireFoxPath;
	}

}
