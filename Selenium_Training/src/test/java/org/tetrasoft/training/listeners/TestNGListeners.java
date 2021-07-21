package org.tetrasoft.training.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println("***Test statrted***"+result.getName());
	}
    public void onTestSuccess(ITestResult result) {
    	System.out.println("***Test is successful***"+result.getName());
	}
    public void onTestFailure(ITestResult result) {
    	System.out.println("***Test is failed***"+result.getName());
	}
    public void onSkipped(ITestResult result) {
    	System.out.println("***Test is skipped***"+result.getName());
	}
    
    public void onFinish(ITestContext context) {
    	System.out.println("***Test is completed***"+context.getName());
	}
}
