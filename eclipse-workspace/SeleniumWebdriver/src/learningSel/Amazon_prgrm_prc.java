package learningSel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon_prgrm_prc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\Sujjal\\\\\\\\ECLIPSE_O2\\\\\\\\SeleniumAccs\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
		
		Actions Ele = new Actions(driver);
		
		driver.findElement(By.id("nav-link-yourAccount")).click();;
//		Ele.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']"))).perform();
//		driver.findElement(By.xpath("//a[@href='/gp/css/order-history/ref=nav_youraccount_orders']/span")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ujjaltheking@gmail.com");
		WebElement cl=driver.findElement(By.xpath("//input[@id='continue']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",cl);
		//driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("ujjal4792");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		Ele.moveToElement(driver.findElement(By.xpath("//input[@id='searchOrdersInput']"))).click().keyDown(Keys.SHIFT).sendKeys("Khadi").keyUp(Keys.SHIFT).doubleClick().sendKeys(Keys.ENTER).build().perform();
		

	}

}
