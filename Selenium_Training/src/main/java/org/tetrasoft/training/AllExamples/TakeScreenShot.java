package org.tetrasoft.training.AllExamples;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenShot {

	@Test
	public void takeScreenshot() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\Chrome91\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("https://demoqa.com");

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src,
				new File("C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Screenshots\\sample.png"));
		
		driver.close();

	}

}
