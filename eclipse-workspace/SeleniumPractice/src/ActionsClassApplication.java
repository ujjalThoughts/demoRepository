
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class ActionsClassApplication {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		searchSomething(driver);

	}
	
	public static void searchSomething(WebDriver driver) throws InterruptedException
	{
		String parentWindow=driver.getWindowHandle();
		
		System.out.println("Title Before switching windows, parent window : " +driver.getTitle());
		
		Actions a=new Actions(driver);
		WebElement searchTab=driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		
		a.moveToElement(searchTab).click().keyDown(Keys.SHIFT).sendKeys("resistance band").keyUp(Keys.SHIFT).build().perform();
		
		driver.findElement(By.cssSelector("div.nav-search-submit.nav-sprite input")).click();
		
		
		Set<String> windowHandleId=driver.getWindowHandles();
		//Print all the Window Handles
		for(String handle : windowHandleId)
		{
		System.out.println("Switching to window - > - > " + handle);
		}
		
		Iterator<String> iT=windowHandleId.iterator();
		while(iT.hasNext())
		{
		
		String childWindow = iT.next();
		if(!parentWindow.equals(childWindow))
		{
		driver.switchTo().window(childWindow);
		System.out.println("Title After switching windows to Child: " +driver.getTitle());
		}
		}
//		a.moveToElement(driver.findElement(By.cssSelector("div[id='nav-tools'] a[id='nav-link-accountList']"))).build().perform();
//		driver.findElement(By.cssSelector("div[id='nav-flyout-ya-signin'] span.nav-action-inner")).click();
		driver.findElement(By.cssSelector("div[id='nav-tools'] a[id='nav-link-accountList']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		String parentWindow1=driver.getWindowHandle();
		System.out.println(parentWindow1);
		Set<String> windowHandleId1=driver.getWindowHandles();
		System.out.println(windowHandleId1.size());
		for(String handle1 : windowHandleId1)
		{
		System.out.println("Switching to window - > - > " + handle1);
		}
		
		Iterator<String> iT1=windowHandleId1.iterator();
		while(iT1.hasNext())
		{
		
		String childWindow1 = iT1.next();
		if(!parentWindow1.equals(childWindow1))
		{
		driver.switchTo().window(childWindow1);
		Thread.sleep(3000);
		}
		}
		
		System.out.println("Title After switching windows to Child: " +driver.getTitle());
		driver.findElement(By.xpath("//input[@id='ap_email']")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("sujjal.saha4@gmail.com");
		driver.findElement(By.cssSelector("span[id='continue'] input[id='continue']")).click();

	
}
}
