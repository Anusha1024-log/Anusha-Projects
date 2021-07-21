package org.tetrasoft.training.listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(org.tetrasoft.training.listeners.TestNGListeners.class)
public class TestNGListenerDemo2 {
	
	@Test
	public void test4() {
		System.out.println("Iam in test1");
	}
	@Test
	public void test5() {
		System.out.println("Iam in test2");
	
	}

	@Test
	public void test6() {
		System.out.println("Iam in test3");
	}
}
