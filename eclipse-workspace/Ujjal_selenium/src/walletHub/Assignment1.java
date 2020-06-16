package walletHub;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assignment1 {

	WebDriver driver;
	@BeforeTest
	public void browserSetUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@Parameters({"username","password"})
	@Test
	public void facebookLogin(String username,String password)
	{
		System.out.println("******************Give your credentials and Login**********************");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("@@@@@@@@@@@@@ Logged in @@@@@@@@@@@@@");
		
		System.out.println("**************For Verifying FB Home Page*******************");
	  	  String ExpectedlResult="(85) Facebook";
	  	  String ActualResult=driver.getTitle();
	  	
	  	  Assert.assertEquals(ActualResult, ExpectedlResult);
	  	  System.out.println("======Home Page Verified=======");
	}
	
	@Test
	public void fbStatus() throws InterruptedException
	{
		System.out.println("***********************Post HELLO WORLD********************");

		
		//Find the Status Text Area and enter the status message as Hello World
		WebElement TextArea = driver.findElement(By.name("xhpc_message"));
		Thread.sleep(2000);
		TextArea.click();
		TextArea.sendKeys("Hello World");
		
		//Click on the Post Button
		WebElement postButton= driver.findElement(By.xpath("//*[@data-testid='react-composer-post-button']"));
		postButton.click();
		
		System.out.println("@@@@@@@@@@@@@@@ Hello World posted @@@@@@@@@@@@@@@");

}
	@AfterTest
	public void sessionTerminate()
	{
		//driver.quit();
	}
}
