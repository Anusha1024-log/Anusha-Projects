package org.tetrasoft.training.test;

import org.junit.Ignore;
import org.testng.annotations.Test;

public class TestNGIngnoreDemo {
	
	// If we want to ignore all then put 2Ignore at the class level
	//If u want to ignore at package level then create same pachage with the name and check the java
	//creae pakage-info.java then it will create class then mension ingnore there
	
	@Test
	@Ignore ///Ignore test
	public void test1() {
		System.out.println("Test 1");
	}
	@Test
	public void test2() {
		System.out.println();
	}

}
