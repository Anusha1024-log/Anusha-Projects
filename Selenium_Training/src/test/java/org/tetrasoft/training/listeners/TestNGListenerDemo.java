package org.tetrasoft.training.listeners;

import org.junit.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(org.tetrasoft.training.listeners.TestNGListeners.class)
public class TestNGListenerDemo {
	
	@Test
	public void test1() {
		System.out.println("Iam in test1");
	}
	@Test
	public void test2() {
		System.out.println("Iam in test2");
		Assert.assertFalse(true);
	}

	@Test
	public void test3() {
		System.out.println("Iam in test3");
		throw new SkipException("skipped");
	}
}
