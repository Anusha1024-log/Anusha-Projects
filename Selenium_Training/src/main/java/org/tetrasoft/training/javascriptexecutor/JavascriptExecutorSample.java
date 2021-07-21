package org.tetrasoft.training.javascriptexecutor;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavascriptExecutorSample {

	
	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anusha\\Desktop\\Selenium_Training\\Selenium_Training\\Drivers\\Chrome91\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v3/index.php");
		
		driver.findElement(By.name("uid")).sendKeys("mngr338024");
		driver.findElement(By.name("password")).sendKeys("ajamEbY");
		
		WebElement button = driver.findElement(By.name("btnLogin"));
		
		flash(button, driver);//heighlight the button
		
		drawBorder(button, driver);//draw border
		
		//take screenshot
		//File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyDirectory(src, new File("C:/Users/Anusha/Desktop/Selenium_Training/Selenium_Training/Screenshots/element.png"));
		
		//alert
		//generatealert(driver,"This is bug with button");
		
		//refresh by using selenium
		driver.navigate().refresh();
		
		//resfesh by using javascript
		refreshBrowse(driver);
		
		//click
		clickElementByJS(button, driver);
		
		
	}
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgColor = element.getCssValue("backgroundColor");
		for(int i=0;i<10;i++) {
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgColor,element,driver);
		}
	}
	public static void changeColor(String color,WebElement element, WebDriver driver ) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		try {
			Thread.sleep(20);
		}catch(Exception e) {
			
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void generatealert(String message, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);

		//js.executeScript("alert('"+message+"')");)
	}
	public static void clickElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}
	public static void refreshBrowse(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
		
	}
}
