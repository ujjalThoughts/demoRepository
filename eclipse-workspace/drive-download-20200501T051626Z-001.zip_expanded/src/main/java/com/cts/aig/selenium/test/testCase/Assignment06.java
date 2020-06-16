package com.cts.aig.selenium.test.testCase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment06 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void handleInputField(String URL, String browser) {
	  super.testExecutor.openBrowser(URL, browser);
	  String pageTitle = super.testExecutor.getPageTitle();
	  System.out.println(pageTitle);
	  
	  super.testExecutor.testNGReporterLog("Current page title: "+pageTitle)
	  					.captureScreenshot("Before Clicking Terms")
	  					.clickBy("xpath", "//a[contains(text(),'Terms')]")
	  					.switchToWindow(1)
	  					.waitForElementVisible("xpath", "//a[text()='Terms of Service']")
	  					.testNGReporterLog("Current page title: "+super.testExecutor.getPageTitle())
	  					.captureScreenshot("After Clicking Terms");
	  
	  System.out.println(super.testExecutor.getPageTitle());
	  Assert.assertNotEquals(pageTitle, super.testExecutor.getPageTitle());
  }
}
