package learningSel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\Sujjal\\\\\\\\ECLIPSE_O2\\\\\\\\SeleniumAccs\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://jqueryui.com/droppable/");
		//find number of frames
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//to switch by index
		driver.switchTo().frame(0);
		System.out.println("Switched");
		driver.switchTo().defaultContent();
		System.out.println("Back to default");
		
		//to switch by webelement -- preferred
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		System.out.println(driver.findElement(By.id("draggable")).isDisplayed());
		Actions act= new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		act.dragAndDrop(source, target).build().perform();
		
		driver.close();
	}

}
