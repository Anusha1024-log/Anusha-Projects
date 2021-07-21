package org.tetrasoft.training.AllExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tetrasoft.training.baseclasses.BaseClass;

public class AlertHandler extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BaseClass baseclass = new BaseClass();

			baseclass.launchChromeDriver("https://rahulshettyacademy.com/AutomationPractice/");

			WebElement textBox = driver.findElement(By.id("name"));

			textBox.sendKeys("Anusha");

			WebElement alertBox = driver.findElement(By.id("alertbtn"));

			alertBox.click();

			driver.switchTo().alert();
			String targetText = driver.switchTo().alert().getText();

			System.out.println("Alert text is: " + targetText);

			if (targetText.contains("Anusha")) {
				System.out.println("Test case is passed as message" + targetText + "contains expected result");
			} else {
				System.out.println("Test case is failed");
			}
			Thread.sleep(2000);

			driver.switchTo().alert().accept();

			Thread.sleep(3000);

			driver.switchTo().defaultContent();

			baseclass.closeChromeDriver();
		} catch (Exception e) {
			System.out.println("The failure reason is:" + e.getMessage());
		}

	}

}
