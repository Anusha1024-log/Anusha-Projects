package org.tetrasoft.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tetrasoft.training.pageobjects.GoogleSearchPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		googleSearch();
	}
	public static void googleSearch() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("http://www.google.com");
		
		GoogleSearchPage.textbox_search(driver).sendKeys("Automation step by step");
		
		GoogleSearchPage.button_search(driver).submit();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}


}
