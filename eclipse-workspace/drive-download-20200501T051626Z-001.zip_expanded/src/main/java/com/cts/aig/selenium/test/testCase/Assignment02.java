package com.cts.aig.selenium.test.testCase;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment02 extends SuitClass{
  @Test
  @Parameters({"URL","browser"})
  public void invalidLogin(String URL, String browser) {
	  super.testExecutor.openBrowser(URL, browser);
	  
	  super.testExecutor.sendKeysBy("xpath", "//input[@id='user_login']", "test_user").sendKeysBy("id", "user_pass", "test_password")
	  .clickBy("name", "rememberme").captureScreenshot("BeforeLogIN").clickBy("xpath", "//input[@type='submit']");
	  
	  String actualMsg = super.testExecutor.getTextBy("xpath", "//div[@id='login_error']");
	  Assert.assertEquals(actualMsg, "ERROR: Invalid username. Lost your password?");
	  
	  String homePageTitle = super.testExecutor.getPageTitle();
	  System.out.println("Login Page Title:"+homePageTitle);
	  super.testExecutor.clickBy("xpath", "//a[contains(text(),'Lost your password?')]").waitForElementVisible("xpath","//input[@value='Get New Password']")
	  .captureScreenshot("AfterLogIN");
	  
	  Assert.assertNotEquals(super.testExecutor.getPageTitle(), homePageTitle);
	  System.out.println("Lost your password Page Title:"+super.testExecutor.getPageTitle());
  }
}
