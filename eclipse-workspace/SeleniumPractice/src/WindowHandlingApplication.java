
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WindowHandlingApplication {

	public static void main(String[] args) throws InterruptedException {


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com");
		
		handleMultipleWindows(driver);

	}
	
	public static void handleMultipleWindows(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement multipleWindowsButton = driver.findElement(By.xpath("//div[@id='content']/ul//a[contains(text(),'Multiple Windows')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", multipleWindowsButton);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='content']/ul//a[contains(text(),'Multiple Windows')]")).click();
		
		
		
		driver.findElement(By.xpath("//div[@class='example'] //a[contains(text(),'Click Here')]")).click();
		
		
		String parentWindow=driver.getWindowHandle();
		
		
		//Switching to another opened window
		Set<String> windowHandles= driver.getWindowHandles();

		Iterator<String> iT=windowHandles.iterator();
		while(iT.hasNext()){
			
			String childWindow=iT.next();
			if(!parentWindow.equalsIgnoreCase(childWindow)) {
				
				driver.switchTo().window(childWindow);
				
			}
		}
		
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("div.example h3")).getText());
		
		//return to parent Window
		driver.switchTo().window(parentWindow);
		System.out.println(driver.findElement(By.cssSelector("div[id='content'] h3")).getText());
		
		
		
		
		
		
		
	}
}
