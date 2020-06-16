package guru99Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoProject {

	WebDriver driver;
	static By username= By.name("uid");
	static By pwd= By.name("password");
	static By button= By.xpath("//input[@value='LOGIN']");
	
	@BeforeTest
	public void goToLoginPage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://www.demo.guru99.com/V4/index.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void enterCredentials()
	{
		//Set user name in textbox
		
			WebElement usrn = driver.findElement(username);
			if(usrn.isDisplayed())
			
			usrn.clear();
			usrn.sendKeys("username1");
		
		
			WebElement epwd = driver.findElement(pwd);
			if(epwd.isDisplayed())
				
			epwd.clear();	
			epwd.sendKeys("password");
		
			
		
			WebElement clck=driver.findElement(button);
			
			if(clck.isDisplayed()||clck.isEnabled())		
				clck.click();
			
			
		
		
	}

	 @AfterTest
	 public void stopTest()
	 {
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.quit(); 
	 }
}
