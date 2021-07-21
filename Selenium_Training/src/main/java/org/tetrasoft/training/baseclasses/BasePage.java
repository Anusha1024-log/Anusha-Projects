package org.tetrasoft.training.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends PageFactory {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	   @FindBy(xpath = "//li/a[text()='HOME']")
	   public WebElement homeLink;
	   
	   @FindBy(xpath = "//li/a[text()='ALL COURSES']")
	   public WebElement allCoursesLink;
	   
	   @FindBy(xpath = "//li/a[text()='SUPPORT']")
	   public WebElement supportLinkFindBy;
	   
	   public final String supportlink = "//li/a[text()='SUPPORT']";
	   
	   public WebElement returnLink(String controlText) {
		return allCoursesLink;
		   
	   }

}
