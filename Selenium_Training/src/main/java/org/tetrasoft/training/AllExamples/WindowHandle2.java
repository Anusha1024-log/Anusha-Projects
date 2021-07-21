package org.tetrasoft.training.AllExamples;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle2 {
	
	public static void main(String args[]) throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\845368\\eclipse-workspace\\JavaPrograms\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.in/2017/07/multiple-window-examples.html");
		
		String parent = driver.getWindowHandle();
		
		System.out.println("parent window id is: "+parent);
		
		driver.findElement(By.xpath("//a[contains(@href, 'http://www.google.com')]")).click();
		
		Set<String> allWindows = driver.getWindowHandles();
		
		int count = allWindows.size();
		
		System.out.println("Total windows "+count);
		
		for(String child: allWindows)
		{
			if(!parent.equalsIgnoreCase(child))
			{
				driver.switchTo().window(child);
				
				driver.findElement(By.name("q")).sendKeys("selenium WebDriver");
				
				//By.tagName("frames")
				
				Thread.sleep(3000);
				
				driver.close();
				
			}
			
		}
		
		driver.switchTo().window(parent);

	}
}
