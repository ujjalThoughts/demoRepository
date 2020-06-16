package practice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class FirstMavenTest {
	private WebDriver driver;		
	@Test				
	public void loadAmazonPage() {	
		driver.get("https://www.amazon.in/");  
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")); 	
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver","C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\firefoxdriver_v0.23\\geckodriver.exe");
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();	
  }

}


