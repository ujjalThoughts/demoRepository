package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment01 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void browserInitialization(String URL, String browser) {
	  super.testExecutor.openBrowser(URL, browser).captureScreenshot(browser);
  }
}
