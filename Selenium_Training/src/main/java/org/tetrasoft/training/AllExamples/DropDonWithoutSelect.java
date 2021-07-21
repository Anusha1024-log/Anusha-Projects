package org.tetrasoft.training.AllExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDonWithoutSelect {
	
	
	@Test
	public void dropDown() {
		
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"/Drivers/Chrome91/chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/register.php");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		List<WebElement> Alloptions =driver.findElements(By.xpath("//select[@name='country']//option"));
		System.out.println(Alloptions.size());
		
		for(int i=0;i<=Alloptions.size()-1;i++) {
			if(Alloptions.get(i).getText().contains("ANGOLA")) {
				Alloptions.get(i).click();
				break;
			}
		}
		
	}

}
