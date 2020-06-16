package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class practice1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
//Open Amazon website and maximize the window		
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
//Sign-in to Amazon		
		driver.findElement(By.id("nav-link-yourAccount")).click();
		driver.findElement(By.id("ap_email")).sendKeys("sujjal.saha4@gmail.com");;
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("ujjal4792");
		driver.findElement(By.id("signInSubmit")).click();
		Thread.sleep(25000);
		driver.findElement(By.id("ap-account-fixup-phone-skip-link")).click();
//Selection of product to order	
	Actions ele = new Actions(driver);
	ele.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys(" books").perform();
	driver.findElement(By.xpath("//input[@class='nav-input']")).click();
	/*JavascriptExecutor scroll=(JavascriptExecutor)driver;
	scroll.executeScript("window.scrollBy(0, 1800)");*/
	
	driver.findElement(By.xpath("//h2[contains(text(),'Learning Selenium Testing Tools with Python')]")).click();
		
	}

}
