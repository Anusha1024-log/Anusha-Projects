package org.tetrasoft.training.AllExamples;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {
	
	
	
	SoftAssert soft = new SoftAssert();
	
	@Test
	public void test1() {
		
		//HardAssertion;HardValidatin if assertion failed immediatly test case is marked as failed and terminated
		//SoftAssertion:SoftValidation if assertion failed will not marked as failed and testcase will executed
		//so in soft assertion we will use assertAll() then testcase is failed
		
		System.out.println("Open browser");
		//Assert.assertEquals(true, true);
		
		System.out.println("Enter username");
		System.out.println("Enter password");
		System.out.println("click on sign in");
		//Assert.assertEquals(true, true);//hard assert
		
		
		System.out.println("Homepage");
		
		//Hard assert this is not correct when home page is opned titile missing in case we will use soft assertion
		//Assert.assertEquals(true, false);//hard assert
		soft.assertEquals(true, false,"Home page title is missing");//soft assertion(Failed then stored in one object)
		
		
		System.out.println("open random page");
		System.out.println("Logout");
		soft.assertEquals(true, false,"Unable to click");//soft assertion
		
		soft.assertAll();//check for the errors and marked failed
	}

}
