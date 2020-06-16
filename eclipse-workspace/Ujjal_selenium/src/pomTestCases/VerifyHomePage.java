package pomTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjectModel.HomePageClass;

public class VerifyHomePage {

	WebDriver driver;
	
	//HomePageClass testcase;
	
	
	@BeforeClass
	public void launchingBrowser() {
		  
		  System.out.println("**********Launching Firefox Browser***********");
		  
		  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\firefoxdriver_v0.23\\\\geckodriver.exe");
		  driver=new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get("https://www.facebook.com/login/");
		  System.out.println("**********Browser Launched and login page opened*************");
	  }


	@Test(priority=1,description="For Verifying Home Page")
	public void verifyHomePage(){
		  
		  System.out.println("**********For Verifying Home Page***********");
		  String ExpectedlResult="Log in to Facebook | Facebook";
		  String ActualResult=driver.getTitle();
		
		  Assert.assertEquals(ActualResult, ExpectedlResult);
		  System.out.println("********Home Page Verified************");
		
	}
	
	 @Test(priority=2,description="For testing the login functionality")
	  public void signIn() {
	System.out.println("******************Trying to Login*************");	  
	HomePageClass login= new HomePageClass(driver);
	login.typeUserNAme();
	login.typeUserPassword();
	login.ClickLoginButton();
	System.out.println("************Logged in***************");
	  }
	  
	
	  
	  @AfterTest
	  public void terminate() {
		  
		 driver.quit();
		  System.out.println("***********CLosing the Opertion************* ");
	  }
	
}
