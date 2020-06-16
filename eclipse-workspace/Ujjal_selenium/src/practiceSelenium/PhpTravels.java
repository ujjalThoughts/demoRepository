package practiceSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;	

public class PhpTravels { 

	public WebDriver driver;
	
	@Test //@BeforeMethod
	public void startBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	options.addArguments("--disable-notifications");
	driver= new ChromeDriver(options);
	driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://phptravels.com/demo/");
	}
	@Test
	public void loginPage() throws InterruptedException
	{
//		WebDriverWait wait=new WebDriverWait(driver,50);
//		if(wait.until(ExpectedConditions.alertIsPresent().apply(driver))==null)
//		    System.out.println("alert was not present");
//		else
//		    System.out.println("alert was present");
		//wait.until((ExpectedConditions.alertIsPresent())!=null);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onesignal-popover-cancel-button']")));
		//Thread.sleep(10000);
		//driver.findElement(By.xpath("//button[@class='mc-closeModal']")).click();
		driver.findElement(By.xpath("//a[@class='login']")).click();
	}
	
	
}
