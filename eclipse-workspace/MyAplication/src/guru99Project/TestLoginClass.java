package guru99Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
public class TestLoginClass{
	public static WebDriver driver;
	 @BeforeTest
	 public void Login()
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(01, TimeUnit.SECONDS);
		 driver.get("http://www.demo.guru99.com/V4/index.php");
	 }
	 
	 
	@Test(priority=0)
	public void testLoginObject()
	{	
		LoginUtility utilityObj=new LoginUtility();
		LoginPage loginPageObj = new LoginPage(driver);
		utilityObj.loginToGuru99("mngr184703","hujYpyj",driver);
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("Guru99 Bank Manager HomePage" , driver.getTitle());
		
	}

	@AfterTest
	 public void stopTest()
	 {
		driver.quit(); 
	 }
}


