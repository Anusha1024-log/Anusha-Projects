package org.tetrasoft.training.AllExamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitDemo {

	public static void main(String[] args) {
		seleniumwaits();
	}

	public static void seleniumwaits() {

		String path = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\Chrome91\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// default time for pollling is 250ms
		// Implicit wait is for the entaire seesion of browser

		driver.get("https://www.google.com");

		WebElement name = driver.findElement(By.name("q"));

		WebDriverWait wait = new WebDriverWait(driver, 20);

		name.sendKeys("Automation step by step");

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcd")));

		WebElement name2 = driver.findElement(By.name("abcd"));

		name.submit();

		driver.quit();
	}

}
