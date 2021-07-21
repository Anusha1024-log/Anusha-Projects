package com.uiautomation.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.uiautomation.config.BaseClass;
import com.uiautomation.pojo.LoginPage;

import junit.framework.Assert;


public class TC_Login_1 extends BaseClass
{
	
 	@Test
 public void loginTest() throws IOException 
 {
	
	 
	 logger.info("URL is open");
	 
	 LoginPage lp=new LoginPage(driver);
	 lp.setUserName(userName);
	 logger.info("Enter User name");
	 
	 lp.setPassword(password);
	 logger.info("Enter Password");
	 
	 lp.clickSubmit();
	 
	 if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
		 Assert.assertTrue(true);
		 logger.info("Login test passed");
	 }
	 else {
		 captureScreen(driver, "loginTest");
		 Assert.assertTrue(false);
		 logger.info("Login test Failed");
	 }
 }

}
