package org.tetrasoft.training.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tetrasoft.training.pageobjects.GoogleSearchPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchPageTest {

	private static WebDriver driver = null;

	public static void main(String[] args) {
		googleSearchTest();
	}

	public static void googleSearchTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("http://www.google.com");

		GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects(driver);

		searchPageObj.setTextInSearchBox("Automation step by step");
		searchPageObj.clickSearchButton();

		driver.close();

		System.out.println("Test Completed Successfully");
	}

}
