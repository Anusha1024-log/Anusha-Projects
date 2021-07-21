package org.tetrasoft.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_GoogleSearch {
	
	public static void main(String[] args) {
		googleSearch();
	}
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		WebElement name=driver.findElement(By.name("q"));
		name.sendKeys("Automation step by step");
		
		name.submit();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}

}
