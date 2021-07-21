package org.tetrasoft.training.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Demo {

	static WebDriver driver;

	@BeforeTest
	public static void setUp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public static void googleSearch() {

		driver.get("http://www.google.com");

		WebElement name = driver.findElement(By.name("q"));
		name.sendKeys("Automation step by step");

		name.submit();
	}

	@AfterTest
	public void tearDown() {
		driver.close();

		System.out.println("Test Completed Successfully");

	}
}
