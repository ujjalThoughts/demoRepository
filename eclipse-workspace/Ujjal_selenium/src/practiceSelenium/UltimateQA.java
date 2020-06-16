package practiceSelenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UltimateQA {
	public WebDriver driver;
	
	  @BeforeTest
	  public void launchingBrowser() {
		  
		  System.out.println("**********Launching Chrome Browser and go to Landing Page***********");
//FirefoxOptions options = new FirefoxOptions();
//options.setProfile(new FirefoxProfile());
//options.addPreference("dom.webnotifications.enabled", false);
//		  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\firefoxdriver_v0.23\\\\geckodriver.exe");
//		  driver=new FirefoxDriver(options);
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		  ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver= new ChromeDriver(options);
		  
		  driver.get("https://www.ultimateqa.com/automation/");
		  driver.manage().window().maximize();
		  System.out.println("===========Browser Launched=============");
	  }
	  @Test(priority=1,description="############ For Verifying Home Page ############")
	public void verifyHomePage(){
		  
		  System.out.println("**************For Verifying Home Page*******************");
		  String ExpectedlResult="Automation Practice - Ultimate QA";
		  String ActualResult=driver.getTitle();
		
		  Assert.assertEquals(ActualResult, ExpectedlResult);
		  
		  System.out.println("======Home Page Verified=======");
		
	}
	  
	  @Test(priority=2,description="############# For testing the login functionality ###############")
	  public void signIn() {
	System.out.println("***************Trying to Login*************");	 
	driver.findElement(By.xpath("//li[@id='menu-item-504']//a[contains(text(),'Courses')]")).click();//Click on the course menu
	driver.findElement(By.className("my-account")).click();//Click on the Signin Button
	driver.findElement(By.id("user_email")).sendKeys("sujjal.saha4@gmail.com");//Fill User Id 
	
	driver.findElement(By.id("user_password")).sendKeys("ujjal4792");//Fill Password
	driver.findElement(By.id("btn-signin")).click();
	//driver.findElement(By.id("ap-account-fixup-phone-skip-link")).click();

	//Check whether logged-in or not
	String ExpectedlResult="Ultimate QA";
	String ActualResult=driver.getTitle();
	System.out.println(ActualResult);
	Assert.assertEquals(ActualResult, ExpectedlResult);
	System.out.println("=============Successfully Logged in==============");
	  }
	  
	  @Test(priority=3,description="########### Go to one option #############")
	  public void SearchandSelect() {
		  
		  System.out.println("**********Go to Selenium Resources option************");
		//  driver.findElement(By.className("header-logo__image")).click();
		
		 WebElement qaBtn= driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/a/img"));//Click on the QA logo
		 JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click()", qaBtn);
		 
		 WebElement SlnmrsrcBtn= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]"));//Click on 
		 js.executeScript("arguments[0].click()", SlnmrsrcBtn);
//			JavascriptExecutor scroll=(JavascriptExecutor)driver;
//			scroll.executeScript("window.scrollBy(0, 2000)");
		 
		String expected="[LATEST] Best Resources to Learn Selenium Webdriver in 2018 - Ultimate QA";
		String Actual=driver.getTitle();
		
		 Assert.assertEquals(Actual, expected);
		 System.out.println("********** Selenium Resources Option reached************");
	  }
	  
	  @Test(priority=4,description="########### To Check Table of Contents  #############")
	  public void testContentsTableOption() {
		  JavascriptExecutor js=(JavascriptExecutor)driver;
		  js.executeScript("window.scrollBy(0,1000)");
	  }
	  
	  

	  @AfterTest
	  public void terminate() {
		  
		 //driver.close();
		  System.out.println("==========Operation Terminated==========");
	  }

	}
