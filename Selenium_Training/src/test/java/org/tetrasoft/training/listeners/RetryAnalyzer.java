package org.tetrasoft.training.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	 private int retryCount = 0;
	  private static final int maxRetryCount = 3;
	  //It will retry our testcases 3 times as example
	 
	  @Override
	  public boolean retry(ITestResult result) {
	    if (retryCount < maxRetryCount) {
	      retryCount++;
	      return true;
	    }
	    return false;
	  }


}
