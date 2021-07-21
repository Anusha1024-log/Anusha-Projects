package org.tetrasoft.training.javascriptexecutor;


import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.tetrasoft.training.baseclasses.BaseClass;

public class JunitSample extends BaseClass {
	

	@BeforeClass
	public static void setUpAnt() {
	BaseClass baseclass = new BaseClass();
    baseclass.launchChromeDriver("https://rahulshettyacademy.com/AutomationPractice/");
    System.out.println("Prerequisite");
	}
	@Test
	public void sampletest() {
		try {
			System.out.println("Start of Test");
			
		WebElement textBox = driver.findElement(By.id("name"));

		textBox.sendKeys("Anusha");

		WebElement alertBox = driver.findElement(By.id("alertbtn"));

		alertBox.click();
		
		String alerttext = driver.switchTo().alert().getText();
		
		System.out.println("Alert Text is :"+alerttext);

		driver.switchTo().alert().accept();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@AfterClass
	public static void tearDown() {
		System.out.println("teardown");
		driver.quit();
	}

}
