package org.tetrasoft.training.AllExamples;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleWindowHandles {
	
	
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\Chrome91\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://naukri.com/");
		
		String parent = driver.getWindowHandle();///first window
		
		System.out.println("parent window id is: "+parent);
		
		Set<String> allWindows = driver.getWindowHandles();//all windows
		
		ArrayList<String> tabs = new ArrayList(allWindows);
		
		driver.switchTo().window(tabs.get(3));
		
		driver.close();
		
		driver.switchTo().window(tabs.get(2));
		
		driver.close();
		
		driver.switchTo().window(tabs.get(1));
		
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
		
		System.out.println("Parent window title is "+driver.getTitle());
	}


}
