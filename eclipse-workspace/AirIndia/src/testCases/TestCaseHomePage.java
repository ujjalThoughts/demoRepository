package testCases;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.HomePage;
import POM.LoginPage;
import utility.HomePageUtil;

public class TestCaseHomePage {
	static WebDriver driver;
	
	@BeforeTest
	 public void driverSetUp()
	 {
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\firefoxdriver_v0.23\\geckodriver.exe");
		 driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(01,TimeUnit.SECONDS);
		 driver.get("https://book.airindia.in/itd/itd/home");
		 try {
				Thread.sleep(5000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		 System.out.println(driver.getTitle());
		 Assert.assertEquals("AirIndia E-Commerce - Home page", driver.getTitle());

	 }
	
	@Test(priority=1)
	public void clickLogOn()
	{
		HomePage objLogon=PageFactory.initElements(driver,HomePage.class);
		objLogon.clickLogon();
	}
	@Test(priority=2)
	public void loginToSite()
	{
		LoginPage objLoginF=PageFactory.initElements(driver,LoginPage.class);
		objLoginF.setUserName("192154963");
		objLoginF.setPassword("Ujjal@4792");
		objLoginF.clickLogin();
	}
	@AfterTest
	public void TearDownTest()
	{
		driver.quit();
	}
}
