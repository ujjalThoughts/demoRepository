package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAuto {

	WebDriver driver;
	
	@BeforeTest
	public void browserSetup() {
		
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		//JavaScriptExecutor js=(JavaScriptExecutor)driver;
		driver.manage().window().maximize();
	
	}
	@AfterTest
	public void closingTest() {
		
	}
	@Test(description="Go to Amazon Site")
	public void homePage() {
	driver.get("https://www.amazon.in/");
	driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']")).click();
	System.out.println(driver.getTitle());
	Assert.assertEquals(driver.getTitle(),"Amazon Sign In");
	}
	
	@Test(description="LoginPage")
	public void loginPage() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).click();
		String username="ujjaltheking@gmail.com";
		String password="ujjal4792";
		
		By uname=By.xpath("//input[@id='ap_email']");
		WebElement id=driver.findElement(uname);
		
		if(id.isDisplayed())
		{
			id.clear();
			id.sendKeys(username);
		}
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		By pwdPath=By.id("ap_password");
		WebElement pwd=driver.findElement(pwdPath);
		
		if(pwd.isDisplayed())
		{
		pwd.clear();
		pwd.sendKeys(password);
		}		
		
		WebElement clickBtn=driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		if(clickBtn.isDisplayed()||clickBtn.isEnabled())
		clickBtn.click();
			
			//js.executeScript("arguments[0].click();",clickBtn);
		Thread.sleep(5000);
		//driver.quit();
	}
	
}
