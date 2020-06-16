package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://www.amazon.in/");
driver.findElement(By.className("nav-line-1")).click();
driver.findElement(By.xpath("//input[@id='ap_email']")).click();
driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys("ujjaltheking@gmail.com");
driver.findElement(By.xpath("//input[@id='continue']")).click();
driver.findElement(By.id("ap_password")).sendKeys("ujjal4792");
driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("The Secrets of Meluha");
driver.findElement(By.xpath("//input[@value='Go']")).click();
driver.findElement(By.linkText("The Secret Of The Nagas (Shiva Trilogy-2)")).click();
driver.findElement(By.id("add-to-cart-button")).click();




	}

}
