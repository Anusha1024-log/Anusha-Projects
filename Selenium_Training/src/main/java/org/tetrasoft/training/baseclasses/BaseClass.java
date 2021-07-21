package org.tetrasoft.training.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   try {
		//Launch the browser
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/Drivers/Chrome91/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver",path+"/Drivers/geckodriver.exe");
		//System.setProperty("webdriver.ie.driver",path+"/Drivers/IEDriverServer.exe");

		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		//driver = new InternetExplorerDriver();
		driver.get("https://www.tetrasoft.us");
		driver.manage().window().maximize();
		 	
		String title = driver.getTitle();
		if(title.equals("test")) {
		System.out.println("Application is not launched");
		
		}
		else {
			System.out.println("Application is Launched Successfully");
		}
		System.out.println("Page title is :"+title);
		
		driver.quit();
	   }
	   catch (Exception e) {
			System.out.println("The failure reason is:"+e.getMessage());
		}
	}
	public void launchIEDriver(String ciedriver)
	{
	try {
		//Launch the application
		System.setProperty("webdriver.ie.driver", "./Drivers/IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get(ciedriver);
		driver.manage().window().maximize();
		
		
	} catch (Exception e) {
		System.out.println("The failure reason is:"+e.getMessage());
	}
	}
	
	
	public void launchChromeDriver(String autURL)
	{
	try {
		//Launch the application
		System.setProperty("webdriver.chrome.driver", "./Drivers/Chrome91/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(autURL);
		driver.manage().window().maximize();
		
		
		
	} catch (Exception e) {
		System.out.println("The failure reason is:"+e.getMessage());
	}
	}
	
	public void closeChromeDriver()
	{
		driver.quit();
	}

}
