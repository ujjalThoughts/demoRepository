package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment08 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void captchaHandle(String URL, String browser) throws Exception {
	  super.testExecutor.openBrowser(URL, browser)
	  					.goToIframe("xpath","//iframe[@role='presentation']")
	  					.clickBy("xpath", "//div[@role='presentation'][1]")
	  					.implicitWait(5000);
	  
	  super.testExecutor.getDriver().switchTo().defaultContent();
	  super.testExecutor.goToIframe("xpath","//iframe[@title='recaptcha challenge']");

	  if(super.testExecutor.isElementPresent("xpath","//div[@id='rc-imageselect']")) {
		  super.testExecutor.testNGReporterLog("Captcha could not be selected by webdriver!");
	  }else {
		  super.testExecutor.testNGReporterLog("Captcha has been selected by webdriver.");
	  }
	  
	  super.testExecutor.captureScreenshot("Select Captcha");
	
  }
}
