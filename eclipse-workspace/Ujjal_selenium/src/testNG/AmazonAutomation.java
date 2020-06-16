package testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class AmazonAutomation {
	
	
public WebDriver driver;
	
  @BeforeTest
  public void launchingBrowser() {
	  
	  System.out.println("**********Launching FireFox Browser***********");
	  FirefoxOptions options = new FirefoxOptions();
	  options.setProfile(new FirefoxProfile());
	  options.addPreference("dom.webnotifications.enabled", false);
	  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\firefoxdriver_v0.23\\\\geckodriver.exe");
	  driver=new FirefoxDriver(options);
	  
	  driver.get("https://www.amazon.in");
	  driver.manage().window().maximize();
	  System.out.println("===========Browser Launched=============");
  }
  @Test(priority=1,description="############ For Verifying Home Page ############")
public void verifyHomePage(){
	  
	  System.out.println("**************For Verifying Home Page*******************");
	  String ExpectedlResult="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	  String ActualResult=driver.getTitle();
	
	  Assert.assertEquals(ActualResult, ExpectedlResult);
	  System.out.println("======Home Page Verified=======");
	
}
  
  @Test(priority=2,description="############# For testing the login functionality ###############")
  public void signIn() {
System.out.println("***************Trying to Login*************");	  
driver.findElement(By.id("nav-link-yourAccount")).click();
driver.findElement(By.id("ap_email")).sendKeys("9875459655");;
driver.findElement(By.id("continue")).click();
driver.findElement(By.id("ap_password")).sendKeys("ujjal4792");
driver.findElement(By.id("signInSubmit")).click();
//driver.findElement(By.id("ap-account-fixup-phone-skip-link")).click();

//Check whether logged-in or not
String ExpectedlResult="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
String ActualResult=driver.getTitle();
System.out.println(ActualResult);
Assert.assertEquals(ActualResult, ExpectedlResult);
System.out.println("=============Logged in==============");
  }
  
  @Test(priority=3,description="########### For Searching and Selecting a product #############")
  public void SearchandSelect() {
	  
	  System.out.println("**********Searching and Selecting a product started************");
	//Selection of product to order	
		Actions ele = new Actions(driver);
		ele.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys(" books").perform();
		driver.findElement(By.xpath("//input[@class='nav-input']")).click();
		//driver.findElement(By.xpath("//*[contains(@class,'a-size-medium')]")).click();
		JavascriptExecutor scroll=(JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0, 2000)");
  }
  
  @AfterTest
  public void terminate() {
	  
	  //driver.close();
	  System.out.println("==========Operation Terminated==========");
  }

}
