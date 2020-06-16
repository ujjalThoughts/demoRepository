package mmtBooking;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MMTbooking {

	WebDriver driver;
	@BeforeTest
	public void browserSetup(){
		System.out.println("**********Launching Firefox Browser***********");
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notification");
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(02,TimeUnit.SECONDS);
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday",driver.getTitle());
	}
	
	@Test(priority=1)
	public void homePage()
	{
		System.out.println("*******Click on the login option to get into login Page*********");
		driver.findElement(By.xpath("//p[contains(text(),' Login or Create Account')]")).click();
		Assert.assertEquals("MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday", driver.getTitle());
	}
	@Test(priority=2,description="Login to WAUT")
	public void loginPage() {
		
		System.out.println("@@@@@Put UserId@@@@@");
		
		WebElement usrnm=driver.findElement(By.xpath("//input[@id='username']"));
		if(usrnm.isDisplayed())
		{
			usrnm.clear();
			usrnm.click();
		usrnm.sendKeys("ujjal.tcs1@gmail.com");
		
		}
		System.out.println("@@@@@ Enter Password @@@@@");
		WebElement pswd=driver.findElement(By.xpath("//input[@id='password']"));
		if(pswd.isDisplayed()){
			
		pswd.clear();
		pswd.click();
		pswd.sendKeys("ujjal@4792");
		}
		System.out.println("@@@@@ Click Login Button @@@@@");
		driver.findElement(By.xpath("//button[@class='capText font16']")).click();

		
	}
	@AfterTest
	public void tearDownSession()
	{
		driver.quit();
		System.out.println("*******Session Closed***********");
	}
}
