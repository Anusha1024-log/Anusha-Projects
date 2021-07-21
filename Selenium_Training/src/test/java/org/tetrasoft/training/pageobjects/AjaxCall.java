package org.tetrasoft.training.pageobjects;

import org.openqa.selenium.WebElement;

public class AjaxCall {

	public void waitUntilElementDisplayed(WebElement we) {
		final long watch = System.currentTimeMillis();
		while ((System.currentTimeMillis() - watch) < 20000) // change it to a constant somewhere please{
			try {
				we.isDisplayed();
				return;
			} catch (Exception e) {
				System.out.println("waitUntilElementDisplayed exception is: " + e.toString());
			}
	}


}
