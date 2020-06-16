package Amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class amazonTestNG {

@Test(priority=1)
public void testing()
{
System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\firefoxdriver_v0.23\\geckodriver.exe");
WebDriver driver= new FirefoxDriver();
//Open Amazon website and maximize the window		
driver.get("https://www.amazon.in");
driver.manage().window().maximize();
//Sign-in to Amazon		
driver.findElement(By.id("nav-link-yourAccount")).click();
driver.findElement(By.id("ap_email")).sendKeys("sujjal.saha4@gmail.com");;
driver.findElement(By.id("continue")).click();
driver.findElement(By.id("ap_password")).sendKeys("ujjal4792");
driver.findElement(By.id("signInSubmit")).click();
driver.findElement(By.id("ap-account-fixup-phone-skip-link")).click();
//Selection of product to order	
Actions ele = new Actions(driver);
ele.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("selenium").keyUp(Keys.SHIFT).sendKeys(" books").perform();
driver.findElement(By.xpath("//input[@class='nav-input']")).click();


driver.findElement(By.xpath("//h2[contains(text(),'Selenium WebDriver, 1e')]")).click();

//To go to different window and put that product in the cart.
/*JavascriptExecutor scroll=(JavascriptExecutor)driver;
scroll.executeScript("window.scrollBy(0, 1800)");*/

String parent= driver.getWindowHandle();
String child=driver.getWindowHandles().iterator().next();
driver.switchTo().window(child);
/*for(String child :driver.getWindowHandles())
{
driver.switchTo().window(child);

}
//Thread.sleep(10000);
driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
driver.switchTo().window(parent);*/

}
}
