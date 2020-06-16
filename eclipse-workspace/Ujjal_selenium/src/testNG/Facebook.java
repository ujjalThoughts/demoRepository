package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Facebook {
	
	public WebDriver driver;
	
	  @BeforeTest(description="For Launching the browser and disabling notifications")
	  public void launchingBrowser() {
		  
		  System.out.println("**********Launching Firefox Browser***********");
		  
		  FirefoxOptions options = new FirefoxOptions();
		  options.setProfile(new FirefoxProfile());
		  options.addPreference("dom.webnotifications.enabled", false);
		  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\firefoxdriver_v0.23\\\\geckodriver.exe");
		  driver=new FirefoxDriver(options);
		  driver.get("https://www.facebook.com/login/");
		  System.out.println("**********Browser Launched and login page opened*************");
	  }
	  @Test(priority=1,description="For Verifying Home Page")
	public void verifyHomePage(){
		  
		  System.out.println("For Verifying Home Page");
		  String ExpectedlResult="Log in to Facebook | Facebook";
		  String ActualResult=driver.getTitle();
		
		  Assert.assertEquals(ActualResult, ExpectedlResult);
		  System.out.println("********Home Page Verified************");
		
	}
	  
	  @Test(priority=2,description="For testing the login functionality")
	  public void signIn() {
	System.out.println("******************Trying to Login*************");	  
	driver.findElement(By.id("email")).sendKeys("sujjal.saha4@gmail.com");
	driver.findElement(By.id("pass")).sendKeys("ujjalmona");
	driver.findElement(By.id("loginbutton")).click();
	System.out.println("************Logged in***************");
	  }
	  
	  @Test(priority=3,description="To search MyProfile")
	  public void SearchandSelect() {
		  
		  System.out.println("**********Searching My Profile************");
		  driver.findElement(By.className("_1frb")).sendKeys("Ujjal Saha");
		  //driver.findElement(By.xpath("//html//body//div[1]//div[2]//div//div[1]//div//div//div//div[1]//div[2]//div//form//button")).click();
		  driver.findElement(By.className("_585_")).click();
		  System.out.println("********** My Profile searched and selected************");
	  }
	  
	  @AfterTest
	  public void terminate() {
		  
		 driver.quit();
		  System.out.println("***********CLosing the Opertion************* ");
	  }


}
