package org.tetrasoft.training.test;

import org.testng.annotations.Test;

public class TestNGDependencies {
	
	@Test(dependsOnMethods = {"test2","test3"})
	public void test1() {
		
		System.out.println("test1");
		
	}
	@Test
    void test2() {
		
		System.out.println("test2");
		
	}
	@Test
    void test3() {
		
		System.out.println("test2");
		
	}

}
