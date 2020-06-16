package learningSel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("http://www.amazon.in");
		driver.manage().window().maximize();
		Actions ele= new Actions(driver);
		ele.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']"))).perform();
		driver.findElement(By.xpath("//a[@href='/gp/registry/wishlist/ref=nav_youraccount_wl?ie=UTF8&requiresSignIn=1']/span")).click();
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ujjaltheking@gmail.com");
		
		WebElement element= driver.findElement(By.xpath("//input[@id='continue']"));
				element.sendKeys(Keys.ENTER);
				
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys("ujjal4792");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		ele.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("ujjal").doubleClick().build().perform();
		Thread.sleep(1500);
		ele.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).contextClick().sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		
		
	}

}
