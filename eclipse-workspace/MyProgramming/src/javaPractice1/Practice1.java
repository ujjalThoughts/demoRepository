package javaPractice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.This;

public class Practice1 {
	WebDriver driver;
	@Test
	public void test() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Sujjal\\ECLIPSE_O2\\SeleniumAccs\\chromedriver_win32\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(01,TimeUnit.SECONDS);
	 driver.get("https://book.airindia.in/itd/itd/home");
	 try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	 System.out.println(driver.getTitle());
}
}
