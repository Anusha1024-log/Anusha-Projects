package org.tetrasoft.training.AllExamples;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitDemo {
	
	public static void main(String[] args) throws InterruptedException {
		test();
	}
	
	public static void test() throws InterruptedException {
	
	String path = System.getProperty("user.dir");

	System.setProperty("webdriver.chrome.driver", path + "\\Drivers\\Chrome91\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();
	
	driver.get("https://www.google.com");
	

	driver.findElement(By.name("q")).sendKeys("Abcd");

    driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
    
    //driver.findElement(By.linkText("ABCD (1999) - IMDb")).click();
    
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
    		.withTimeout(30, TimeUnit.SECONDS)
    		.pollingEvery(2, TimeUnit.SECONDS)
    		.ignoring(NoSuchElementException.class);
    
    WebElement element = wait.until(new Function<WebDriver, WebElement>() {
        public WebElement apply(WebDriver driver) {
          WebElement linkElement = driver.findElement(By.linkText("ABCD (1999) - IMDb"));
          if(linkElement.isEnabled())
        	  System.out.println("Element Found");
          return linkElement;
        }
      });
    element.click();

    
    Thread.sleep(2000);
    
    driver.quit();

	}


}
