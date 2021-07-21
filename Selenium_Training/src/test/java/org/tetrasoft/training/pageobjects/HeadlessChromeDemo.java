package org.tetrasoft.training.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChromeDemo {
	
	public static void main(String[] args) {
		test();
	}
	
	
	public static void test() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\Chrome91\\chromedriver.exe");
		
ChromeOptions options = new ChromeOptions();
		
		options.addArguments("headless");
		options.addArguments("window-size=1280,800");
		
		
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.get("http:www.google.com");
		System.out.println(driver.getTitle());
		 driver.findElement(By.name("q")).sendKeys("Automation");
		driver.findElement(By.name("btnK")).submit();
		
		driver.close();
		
		System.out.println("completed");
		
	}

}
