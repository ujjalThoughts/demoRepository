package practiceSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class IframesPrctc {

	public WebDriver driver;
	@BeforeTest
	  public void launchingBrowser() {
		  
		  System.out.println("**********Launching Firefox Browser***********");
		  System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://toolsqa.com/iframe-practice-page/");
		  driver.manage().window().maximize();
		  System.out.println("Browser Launched");
	  }
	
	@Test(priority=2)
	public void ClickOnImage() throws InterruptedException
	{
		
		driver.switchTo().frame(0);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		driver.findElement(By.xpath("//input[@name='firstname']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ujjal");
		driver.findElement(By.xpath("//input[@name='lastname']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("4792");;
		
		
	/*
	int size = driver.findElements(By.tagName("iframe")).size();

    for(int i=0; i<=size; i++)
    {
	driver.switchTo().frame(i);
	int total=driver.findElements(By.xpath("html/body/a/img")).size();
	System.out.println(total);
    driver.switchTo().defaultContent();
	
	;		
	}*/
//	int size = driver.findElements(By.tagName("iframe")).size();
//	System.out.println("No. of iFrames" +size);
//	driver.switchTo().frame("a077aa5e");
//	//driver.findElement(By.xpath("html/body/a/img")).click();
//	driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
//	driver.switchTo().defaultContent();
	
	
	//driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
		
		Thread.sleep(10000);
		
		driver.quit();	
		
}
	
}