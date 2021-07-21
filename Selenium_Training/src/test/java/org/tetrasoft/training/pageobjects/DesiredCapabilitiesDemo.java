package org.tetrasoft.training.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {
	public static void main(String[] args) {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectedModeSettings", true);
	
	System.setProperty("webdriver.ie.driver", "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\IEDriverServer.exe");
	
	WebDriver driver = new InternetExplorerDriver(caps);
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://www.google.com");
	driver.findElement(By.name("q")).sendKeys("abcd");
	driver.findElement(By.name("btnK")).submit();
	
	driver.quit();
	
	}
	
}
	
