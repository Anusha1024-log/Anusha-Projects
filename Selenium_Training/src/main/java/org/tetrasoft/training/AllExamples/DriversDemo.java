package org.tetrasoft.training.AllExamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriversDemo {
	
	public static void main(String[] args){
		
	String systemPath=System.getProperty("user.dir");
	//System.setProperty("webdriver.gecko.driver", systemPath+"/Drivers/geckodriver.exe");	
	//WebDriver driver = new FirefoxDriver();
	
	System.setProperty("webdriver.chrome.driver", systemPath+"/Drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	//System.setProperty("webdriver.ie.driver", systemPath+"/Drivers/IEDriverServer.exe");
	//WebDriver driver = new InternetExplorerDriver();
	driver.get("https://www.google.com");
	
	}
}
