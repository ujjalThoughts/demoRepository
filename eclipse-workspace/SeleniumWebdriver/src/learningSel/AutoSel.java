package learningSel;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSel {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("nav-link-yourAccount")).click();
	driver.findElement(By.xpath("//input[@id='ap_email']")).click();
	driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ujjaltheking@gmail.com");
	driver.findElement(By.xpath("//input[@id='continue']")).click();
	driver.findElement(By.id("ap_password")).sendKeys("ujjal4792");
	driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	
	WebElement ele=driver.findElement(By.xpath("//a[@id='nav-link-yourAccount']"));

	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	//driver.findElement(By.linkText("Your Wish List")).click();
	
	for(int i=1;i<=9;i++) 
		driver.findElement(By.xpath("//*[@id='nav-flyout-yourAccount']/div[2]/a[i]/span)")).click();
	
		
	
	/*List<WebElement> links=driver.findElements(By.xpath("//a[@class='nav-a nav-a-2']"));
	int total_count= links.size();
	for(int i=0;i<total_count;i++)
	{
		WebElement element= links.get(i);
		
	//System.out.println(total_count);
*/	
	
	//driver.findElement(By.xpath("//*[@id=\"nav-flyout-yourAccount\"]/div[3]/a[4]/span")).click();
	}
	}

