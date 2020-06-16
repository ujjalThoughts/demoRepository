package webTableConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import library4Screenshot.Utility;

public class RedBus {

	public WebDriver driver;
	
	  @BeforeTest
	  public void launchingBrowser() {
		  
		  System.out.println("**********Launching Chrome Browser***********");
//		  FirefoxOptions options = new FirefoxOptions();
//		  options.setProfile(new FirefoxProfile());
//		  options.addPreference("dom.webnotifications.enabled", false);
//		  System.setProperty("webdriver.gecko.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\firefoxdriver_v0.23\\\\geckodriver.exe");
//		  driver=new FirefoxDriver(options);
		  
		  System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		  ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver= new ChromeDriver(options);
		  
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  driver.get("https://www.redbus.in/");
		  
		  driver.manage().window().maximize();
		  System.out.println("===========Browser Launched=============");
		  
	  }
	  
	  @Test(priority=1,description="############ For Verifying Home Page ############")
	  public void verifyHomePage(){
	  	  
	  	  System.out.println("**************For Verifying Home Page*******************");
	  	  String ExpectedlResult="Book Bus Travels, AC Volvo Bus, Hotels & Bus Hire - redBus";
	  	  String ActualResult=driver.getTitle();
	  	
	  	  Assert.assertEquals(ActualResult, ExpectedlResult);
	  	  System.out.println("======Home Page Verified=======");
	  	
	  }
	  
	  @Test(priority=2,description="############ Select Source and Destination and one DOJ ############")
	  public void selectDate() throws InterruptedException{
		  System.out.println(" *************Selecting destination******************* ");
		  
//		  Select fromDrpDwn=new Select(driver.findElement(By.id("src")));
//		  fromDrpDwn.deselectByVisibleText("Kolkata Airport");
		  
		  driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Airport, Kolkata");
		  
		  driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Durgapur (West Bengal)");
		  
		 
		  System.out.println("===============destination selected================");
		  
		  System.out.println(" *************Selecting Date of Journey******************* ");
		  driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
		  driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[6]/td[5]")).click();
		  System.out.println(" *************date selected******************* ");
	  }
		  
		  @Test(priority=3,description="############ Click Search button and verify result page ############")
		  public void clickSearch() {
			
			WebDriverWait wait=new WebDriverWait(driver,10);
			WebElement srcEnter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='src']")));
			srcEnter.click();
//		  driver.findElement(By.xpath("//input[@id='src']")).click();
			WebElement dstEnter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dest']")));
			dstEnter.click();
//		  driver.findElement(By.xpath("//input[@id='dest']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		  System.out.println(" *************Clicked Search Button and verified******************* ");
		  
		  
		  System.out.println("**************For Verifying Search Result Page*******************");
		  String ExpectedlResult="Search Bus Tickets";
	  	  String ActualResult=driver.getTitle();
	  	  Assert.assertEquals(ActualResult, ExpectedlResult);
	  	  
	  	
	  	System.out.println("**************VERIFIED*******************");
	  }
	  
		  @Test(priority=4,description="############ Select Filters and Go to details of bus ############")
		  public void selectOneBus()throws Exception {
		  
			  
//			  driver.findElement(By.xpath("//ul[@class='list-chkbox']//li[3]//label[1]")).click();
//			  driver.findElement(By.xpath("//ul[@class='list-chkbox']//li[1]//label[1]")).click();
			  JavascriptExecutor js=(JavascriptExecutor)driver;
			  js.executeScript("window.scrollBy(0,200)");
			  
		  }
		  
		  @AfterMethod
		  public void tearDown(ITestResult result)
		  {
			  if(ITestResult.FAILURE==result.getStatus()) 
			  {
				  Utility.captureScreenshot(driver, result.getName());
			  }
			 // driver.quit();
		  }
//	  @AfterTest
//	  public void terminate() throws InterruptedException {
//		  
//		  Thread.sleep(4000);
//		//driver.close();
//		
//		  System.out.println("==========Operation Terminated==========");
//	  }

}
