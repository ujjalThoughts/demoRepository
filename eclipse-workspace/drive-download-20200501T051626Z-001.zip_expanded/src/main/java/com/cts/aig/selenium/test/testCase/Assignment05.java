package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment05 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void handleInputField(String URL, String browser) {
	  String totalLink = super.testExecutor.openBrowser(URL, browser).getTotalLinks();
	  super.testExecutor.testNGReporterLog("Total Number of Link available in this page= "+totalLink+
			  ". Page Url: "+super.testExecutor.getDriver().getCurrentUrl());
  }
}
