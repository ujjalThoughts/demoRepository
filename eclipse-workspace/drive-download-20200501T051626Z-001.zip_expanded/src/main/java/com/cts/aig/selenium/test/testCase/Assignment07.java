package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment07 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void handleInputField(String URL, String browser) throws Exception {
	  super.testExecutor.openBrowser(URL, browser)
	  					.sendKeysByAction("id", "twotabsearchtextbox", "Hand Sanitizer")
	  					.captureScreenshot("Amazon Search")
	  					.clickByAction("xpath", "//input[@value='Go']")
	  					.implicitWait(5000)
	  					.captureScreenshot("Amazon Search Result");
	  
	  
  }
}
