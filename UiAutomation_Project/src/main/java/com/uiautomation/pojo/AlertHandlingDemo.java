package com.uiautomation.pojo;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.text.NumberFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;

public class AlertHandlingDemo {
	
	static Logger log= Logger.getLogger(AlertHandlingDemo.class);
	
	public AlertHandlingDemo() {
		
	}
	

	public static void main(String[] args) throws InterruptedException {
		
		   System.setProperty("webdriver.chrome.driver","C:\\Users\\Anusha\\eclipse-workspace\\UiAutomation_Project\\Drivers\\chromedriver.exe");
		   WebDriver driver = new ChromeDriver();
		   
		   
		   driver.get("https://demoqa.com/alerts");
		   driver.manage().window().maximize();
		   
		  // This step will result in an alert on screen
		   WebElement element = driver.findElement(By.id("promtButton"));
		   ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		   
		   Alert promptAlert  = driver.switchTo().alert();
		   String alertText = promptAlert.getText();
		   System.out.println("Alert text is " + alertText);
		   log.info("Alert handling");
		   
		  //Send some text to the alert
		   promptAlert.sendKeys("Test User");
		   promptAlert.accept();
		  }
	
	public static boolean selectByVisibleValue(WebDriver driver, By locator, String value) {   

		boolean flag = false;
		log.info("selectByVisibleValue is Initiated");           

		try{ 
		   Select select = new Select(driver.findElement(locator));
			select.selectByValue(value);
			flag=true;
			log.info("selectByVisibleValue functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("selectByVisibleValue is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean selectByVisibleText(WebDriver driver, By locator, String value) {   

		boolean flag = false;
		log.info("selectByVisibleText is Initiated");           

		try{ 
		   Select select = new Select(driver.findElement(locator));
			select.selectByVisibleText(value);
			flag=true;
			log.info("selectByVisibleText functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("selectByVisibleText is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean selectByIndex(WebDriver driver, By locator, int index) {   

		boolean flag = false;
		log.info("selectByIndex is Initiated");           

		try{ 
		   Select select = new Select(driver.findElement(locator));
			select.selectByIndex(index);
			flag=true;
			log.info("selectByIndex functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("selectByIndex is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static double getNumberInstance(WebDriver driver, String locator) {           
        double m,m1, r = 0;
        int rowcount = 1;
		try{         
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(locator);
			locator = num.toString();
            m = Double.parseDouble(locator);
			return m;
			
		}
		catch(Exception Ex) {
			for (int i = 1; i < rowcount; i++) 
			{ 
			String max = driver.findElement(By.xpath("html/body/div[1]/div[3]/div/table/tbody/tr[" + (i + 1) + "]/td[4]")) .getText();
			m1 = getNumberInstance(driver, max);
			if (m1 > r)
			{ 
			r = m1; 
			} 

			} 
			System.out.println("Maximum current price is : " + r);
			log.info("getNumberInstance has exception could be due to loctor issue please check");
			return 0;
		}
		  
		
		
	}
	  


}