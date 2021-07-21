package org.tetrasoft.training.AllExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetAllInputTags {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.iedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		WebElement name=driver.findElement(By.name("q"));
		name.sendKeys("Selenium automation");
		
		List<WebElement> listOfInput = driver.findElements(By.xpath("//input"));
		System.out.println("List of input is:"+listOfInput.size());
		
		
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.close();
        driver.quit();
        
	}

}
