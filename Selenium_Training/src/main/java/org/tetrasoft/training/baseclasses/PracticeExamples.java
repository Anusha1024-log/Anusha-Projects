package org.tetrasoft.training.baseclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "user.dir"+"/Drivers/Chrome91/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		WebElement checkBox = driver.findElement(By.name("checkBoxOption1"));
		WebElement dropDown = driver.findElement(By.name("dropdown-class-example"));
		WebElement droDown2 = driver.findElement(By.xpath("//option[@value='option2']"));
		WebElement radioButton = driver.findElement(By.cssSelector("//input[@value='radio2']"));
		WebElement textBox = driver.findElement(By.id("autocomplete"));
		WebElement windowValue = driver.findElement(By.id("openwindow"));
		
		
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.navigate().refresh();
		
		checkBox.click();
		
		textBox.sendKeys("india");
		textBox.clear();
		
		Select select = new Select(droDown2);
		select.selectByIndex(1);
		
		select.deselectAll();
		
		radioButton.click();
		
	}

}
