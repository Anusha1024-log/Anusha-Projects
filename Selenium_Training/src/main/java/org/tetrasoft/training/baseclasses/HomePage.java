package org.tetrasoft.training.baseclasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageFactory {
	
	@FindBy(xpath = "//h1[text()='Complete Test Automation Bundle']")
	public WebElement bundleLable;
	
	@FindBy(xpath = "//h5[text()='Learn all Test Automation courses in one place']")
	public WebElement learnlable;
	
	@FindBy(xpath = "//button[text()='Enroll in bundle']")
	public WebElement button;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='TestNG  Bootcamp - Novice To Ninja'")
	public WebElement courseNameCompleteBootcamp;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='Mac Linux Command Line Basics'")
	public WebElement courseNameMacLinux;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='Rest API Automation With Rest Assured'")
	public WebElement courseNameRestAPI;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='Selenium WebDriver Advanced'")
	public WebElement courseNameSelenium;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='Selenium WebDriver With Python 3.x'")
	public WebElement courseNameSeleniumPython;
	
	@FindBy(xpath = "//div[@class='row zen-bundle-panel']//h5[text()='Selenium WebDriver With Java'")
	public WebElement courseNameSeleniumJava;
	

}
