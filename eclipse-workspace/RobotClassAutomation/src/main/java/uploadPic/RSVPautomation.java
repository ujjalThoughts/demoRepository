package uploadPic;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RSVPautomation {

	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUpBrowser()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\"
			+ "chromedriver.exe");
	 driver=new ChromeDriver(); 
	}
	
	@Test(priority=1)
	public void openURL()
	{
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://bg-dev.eweblife.com/prm/bgbtw/rsvp-signup/apply?record=826");
	}
	
	@Test(priority=2)
	public void profileImageFunctionality() throws InterruptedException
	{
		
		WebElement uploadNewPhotoButton=driver.findElement(By.xpath("//a[contains(text(),'Upload new Photo')]"));
		
		//Will Scroll to UploadNewPhoto button and will click that button
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",uploadNewPhotoButton);
		uploadNewPhotoButton.click();
		
		WebElement DragOrClick= driver.findElement(By.xpath("//*[@id='drop-area_field_12059']/img"));
		
		//Click on the Crag and Drop button
		js.executeScript("arguments[0].scrollIntoView();",DragOrClick);
		DragOrClick.click();
		Thread.sleep(5000);
		
		//Creating Robot class Object
		Robot r=null;
		try {
			r=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_ALT);
		r.setAutoDelay(3000);
		
		// Specify the file location with extension: This two lines are equivalent to "Control C" in Keyboard
				StringSelection selection1= new StringSelection("C:\\Users\\Sujjal\\Desktop\\Image test.jpg");
				Clipboard clipboard1=Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard1.setContents(selection1, null);
				
				//Pasting the location using ctrl+v
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.setAutoDelay(3000);
				r.keyRelease(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.setAutoDelay(3000);
				
				//Pressing the Open button using Alt+o shortcut
				r.keyPress(KeyEvent.VK_ALT);
				r.keyPress(KeyEvent.VK_O);
				r.setAutoDelay(3000);
				r.keyRelease(KeyEvent.VK_O);
				r.keyRelease(KeyEvent.VK_ALT);
				r.setAutoDelay(3000);
				
				//Clicking the Save button
				WebElement saveButton= driver.findElement(By.xpath("//*[@id='cropBtn_field_12059']/div[3]/a"));
				js.executeScript("arguments[0].scrollIntoView();",saveButton);
				saveButton.click();	
				
	}
	
	@AfterTest
	public void terminateTest(){
		driver.quit();
	}
	
}
