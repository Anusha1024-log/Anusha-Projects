package org.tetrasoft.training.AllExamples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.tetrasoft.training.baseclasses.BaseClass;

public class FramesExample extends BaseClass{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BaseClass baseclass = new BaseClass();

			baseclass.launchChromeDriver("https://rahulshettyacademy.com/AutomationPractice/");
			
			WebElement iFrame = driver.findElement(By.id("courses-iframe"));
			
			driver.switchTo().frame("courses-iframe");
			
			WebElement title = driver.findElement(By.xpath("//span[contains(text(),'Academy')]"));
			Boolean value =title.isDisplayed();
			if(value.equals(true)){
			 System.out.println("frame is displayed"); 
			}
			Thread.sleep(2000);

			baseclass.closeChromeDriver();

		} catch (Exception e) {
			System.out.println("The failure reason is:" + e.getMessage());
		}

	}


}
