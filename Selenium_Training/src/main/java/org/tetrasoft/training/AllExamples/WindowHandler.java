package org.tetrasoft.training.AllExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.tetrasoft.training.baseclasses.BaseClass;

public class WindowHandler extends BaseClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BaseClass baseclass = new BaseClass();

			baseclass.launchChromeDriver("https://rahulshettyacademy.com/AutomationPractice/");

			String parentHandle = driver.getWindowHandle();

			WebElement openWindow = driver.findElement(By.id("openwindow"));

			openWindow.click();
			for (String windowHandle : driver.getWindowHandles()) {
				driver.switchTo().window(windowHandle);
				System.out.println("window handle is :" + driver.switchTo().window(windowHandle).getTitle());
				if ((driver.switchTo().window(windowHandle).getTitle().equals(
						"QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy"))) {
					WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
					button.click();
					WebElement loginText = driver.findElement(By.xpath("//h1"));
					if (loginText.isDisplayed()) {
						System.out.println("Login page is opened");
					}
				}
			}
			driver.close();
			driver.switchTo().window(parentHandle);

			System.out.println("window handle is :" + driver.switchTo().window(parentHandle).getTitle());

			Thread.sleep(2000);

			baseclass.closeChromeDriver();

		} catch (Exception e) {
			System.out.println("The failure reason is:" + e.getMessage());
		}

	}

}
