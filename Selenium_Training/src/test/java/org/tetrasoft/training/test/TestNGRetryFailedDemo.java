package org.tetrasoft.training.test;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.tetrasoft.training.listeners.RetryAnalyzer;

public class TestNGRetryFailedDemo {
	
	@Test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test
	public void test2() {
		System.out.println("Test 2");
		int i=1/0;
	}
	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test3() {
		System.out.println("Test 3");
		Assert.assertEquals(true, false);
	}


}
