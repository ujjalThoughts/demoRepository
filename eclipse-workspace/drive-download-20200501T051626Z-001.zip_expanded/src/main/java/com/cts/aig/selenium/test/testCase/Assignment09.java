package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cts.aig.selenium.test.actions.SelectDate;

public class Assignment09 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void captchaHandle(String URL, String browser) throws Exception {
	  super.testExecutor.openBrowser(URL, browser)
	  					.clickBy("xpath", "//button[@class='btn btn-primary']")
	  					.implicitWait(2000)
	  					.captureScreenshot("Before Selecting Date");
	  new SelectDate(testExecutor).goToDate("5", "August 2020");
	  super.testExecutor.implicitWait(2000)
	  					.clickBy("xpath", "//button[@class='btn btn-primary']")
	  					.captureScreenshot("After Selecting date");
  }
}
