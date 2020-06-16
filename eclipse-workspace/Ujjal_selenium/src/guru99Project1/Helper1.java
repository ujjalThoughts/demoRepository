package guru99Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Helper1 {

	WebDriver driver;
	
	 public Helper1(WebDriver driver) {
	        this.driver = driver;
	    }
	 
	 @BeforeTest
	 public void Login()
	 {
		 System.setProperty("webdriver.chrome.driver","Page1.firefoxPath");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 driver.get("http://www.demo.guru99.com/V4/index.php");
	 }
	 
	 @AfterTest
	 public void stopTest()
	 {
		driver.quit(); 
	 }
}
