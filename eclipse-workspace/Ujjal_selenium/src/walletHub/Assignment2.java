package walletHub;

import static org.testng.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment2 {

	WebDriver driver;
	@BeforeTest
	public void browserSetUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
		System.out.println("********* Put URL ***********");
		driver.get("https://wallethub.com/profile/test-insurance-company-13732055i");
		System.out.println("@@@@@@@@@@@ URL Opened @@@@@@@@@@@");
		driver.manage().window().maximize();
	}
	
	@Test(priority=1,description="*************Put credentials and Login*************")
	public void walletHubLogin()
	{
		
		//Click on the login Button
		driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
		
		System.out.println("******************Give your credentials and Login**********************");
		driver.findElement(By.xpath("//input[@type='text' and @name='em']")).sendKeys("saha.ujjal4792@gmail.com");
		driver.findElement(By.xpath("//input[@type='password' and @name='pw']")).sendKeys("Ujjal@1234");
		driver.findElement(By.xpath("//*[@type='button'][2]")).click();
		System.out.println("@@@@@@@@@@@@@ Logged in @@@@@@@@@@@@@");
	}
	@Test(priority=2,description="*************Scroll down, hover and click on 5 stars*************")
	public void hoverAndClick5Star() throws InterruptedException
	{
		
		//Scroll Down till "what's your rating" is available
		WebElement reviewStar=driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[4]"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", reviewStar);
		
		
	//Hover over the Review Star 4
		Actions hover=new Actions(driver);
		WebElement Star4= driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[4]"));
		hover.moveToElement(Star4).perform();
		Thread.sleep(3000);
		
		//Click on 5 Star
		WebElement Star5=driver.findElement(By.xpath("//div[@class='review-action ng-enter-element']//*[5]"));
		Star5.click();
		Thread.sleep(2000);
		}
	
	@Test(priority=3,description="************* Select Health Insurance in Policy Dropdown and Write review and Submit *************")
	public void selectReviewSubmit() throws InterruptedException 
	{		
		//Select Health Insurance in Policy Dropdown
		WebElement policyDropdown= driver.findElement(By.xpath("//ng-dropdown[@class='wrev-drp']//div//span"));
		policyDropdown.click();
		WebElement healthInsurance= driver.findElement(By.xpath("//li[contains(text(),'Health Insurance')]"));
		healthInsurance.click();
		Thread.sleep(4000);
		
		//Write Review
		WebElement writeReviewField=driver.findElement(By.xpath("//textarea[@placeholder='Write your review...']"));
		writeReviewField.click();
		writeReviewField.clear();
		writeReviewField.sendKeys("If you are successful you should see a confirmation screen saying you have reviewed the institution. You then have to go to your profile and confirm that a “review feed” got posted there.\r\n" + 
				"Go to https://wallethub.com/profile/<username>/reviews/ and assertTrue() that you can see the review feed with the text you entered on the previous page.");
		Thread.sleep(4000);
		
		//Click the Submit button
		WebElement submitButton=driver.findElement(By.xpath("//div[@class='sbn-action semi-bold-font btn fixed-w-c tall']"));
		Thread.sleep(3000);
		
		submitButton.click();
		Thread.sleep(4000);
		
	}
	
	@Test(priority=4,description="************* Go to profile and confirm Review Feed posted in the Reviews section *************")
	public void goToProfileAndConfirm() throws InterruptedException 
	{
		//Go to profile Section
		WebElement profiledrpdwn= driver.findElement(By.xpath("//span[contains(text(),'Ujjal')]"));
		WebElement profileOption= driver.findElement(By.xpath(".//*[@id=\"web-app\"]/header/div/nav[1]/div[5]/div/a[1]"));
		//a[@class='brgm-list-it' and contains(text(),'Profile')]
		
		Actions profileHover=new Actions(driver);
		profileHover.moveToElement(profiledrpdwn).perform();
		profileHover.moveToElement(profileOption).click().perform();
		

//Go to Reviews
WebElement reviewsButton= driver.findElement(By.xpath("//div[@id='wh-body']//li[3]//a[1]"));
reviewsButton.click();

//Confirm the Review Feed posted

String Expected="If you are successful you should see a confirmation screen";
String actual= driver.findElement(By.xpath("//div[@class='wh-profile-tab-contents']")).getText();
Assert.assertTrue(actual.contains(Expected),"Confirmed");
System.out.println("Review Posted");
	}
	
	@AfterTest
	public void terminateBrowser()
	{
		driver.quit();
	}
	
}
