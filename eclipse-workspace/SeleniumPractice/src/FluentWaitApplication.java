
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class FluentWaitApplication {

	public static void main(String[] args) throws InterruptedException {

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		
		Thread.sleep(3000);
		
		findElement(driver);

	}
	
	public static void findElement(WebDriver driver)
	{
		driver.findElement(By.cssSelector("div[id='start'] button")).click();
		
		
		
		WebElement helloWorld=driver.findElement(By.cssSelector("div[id='finish'] h4"));
		
		//Declaring Fluent Wait Customized method
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo=wait.until(new Function<WebDriver, WebElement>()
				{
			
					public WebElement apply(WebDriver driver) {
						
						if(helloWorld.isDisplayed())
						{
							return helloWorld;
					}
					else
						return null;
		}
				});
	
		
		System.out.println("Final Visible word is: "+foo.getText());
	}
}
