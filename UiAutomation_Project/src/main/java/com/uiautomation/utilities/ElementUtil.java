package com.uiautomation.utilities;


import java.text.NumberFormat;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ElementUtil {

	static Logger log = Logger.getLogger(ElementUtil.class);

	private static WebDriver driver;

	public static boolean insertText(WebDriver driver, By locator, String value) {   

		boolean flag = false;
		log.info("insertText is Initiated");           

		try{         
			WebElement field = driver.findElement(locator);
			field.clear();      
			field.sendKeys(value);
			flag=true;
			log.info("insertText functions is executed with locator:"+locator+"Keys: "+value);
			return flag;
		}
		catch(Exception Ex) {
			log.info("insertText is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean toClick(WebDriver driver, By locator) {   

		boolean flag = false;
		log.info("toClick is Initiated");           

		try{         
			WebElement field = driver.findElement(locator);
			field.click();
			flag=true;
			log.info("toClick functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("toClick is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean isDisplayed(WebDriver driver, By locator) {   

		boolean flag = false;
		log.info("isDisplayed is Initiated");           

		try{         
			WebElement field = driver.findElement(locator);
			field.isDisplayed();
			flag=true;
			log.info("isDisplayed functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("isDisplayed is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	
	public static boolean selectDropDownValue(WebDriver driver, By locator, String type, String value) {
	    
		boolean flag = false;
		log.info("selectDropDownValue is Initiated");           

		try{
			Select select = new Select(driver.findElement(locator));
			switch(type) { 
			case "index":
				select.selectByIndex(Integer.parseInt(value));
				break;
			case "value":
				select.selectByValue(value);
				break;
			case "visibletext":
				select.selectByVisibleText(value);;
				break;
			
			default:
				System.out.println("please pass the correct criteria");
					break;
			}
			log.info("selectDropDownValue functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("selectDropDownValue is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean selectMultiDropDownValue(WebDriver driver, By locator,String type, String value1, String value2) {   

		boolean flag = false;
		log.info("selectMultiDropDownValue is Initiated");           

		try{         
			Select select = new Select(driver.findElement(locator));
			
			switch(type) { 
			case "index":
				select.selectByIndex(Integer.parseInt(value1));
				select.selectByIndex(Integer.parseInt(value2));
				break;
			case "value":
				select.selectByValue(value1);
				select.selectByValue(value2);
				break;
			case "visibletext":
				select.selectByVisibleText(value1);
				select.selectByVisibleText(value2);
				break;
			
			default:
				System.out.println("please pass the correct criteria");
					break;
			}
			log.info("selectMultiDropDownValue functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("selectMultiDropDownValue is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean isSelected(WebDriver driver, By locator) {
		boolean flag = false;
		log.info("isSelected is Initiated");           

		try{         
			WebElement field = driver.findElement(locator);
			field.isSelected();
			flag=true;
			log.info("isSelected functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("isSelected is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static boolean isEnabled(WebDriver driver, By locator) {
		boolean flag = false;
		log.info("isEnabled is Initiated");           

		try{         
			WebElement field = driver.findElement(locator);
			field.isEnabled();
			flag=true;
			log.info("isEnabled functions is executed:");
			return flag;
		}
		catch(Exception Ex) {
			log.info("isEnabled is has exception could be due to loctor issue please check");
			return flag; 
		}
	}
	public static int rowAndColCount(WebDriver driver, List<WebElement> locator) {
		log.info("rowAndColCount is Initiated");           
        int count=0;
		try{         
			List<WebElement> value = locator;
		    count =value.size();
			log.info("rowAndColCount functions is executed:");
			return count;
		}
		catch(Exception Ex) {
			log.info("rowAndColCount is has exception could be due to loctor issue please check");
			return 0;
		}
	} 
	public static double getNumberInstance(WebDriver driver, String locator) {           
        double m;
		try{         
			NumberFormat f = NumberFormat.getNumberInstance();
			Number num = f.parse(locator);
			locator = num.toString();
            m = Double.parseDouble(locator);
			return m;
		}
		catch(Exception Ex) {
			log.info("getNumberInstance has exception could be due to loctor issue please check");
			return 0;
		}
	} 
	
	
}