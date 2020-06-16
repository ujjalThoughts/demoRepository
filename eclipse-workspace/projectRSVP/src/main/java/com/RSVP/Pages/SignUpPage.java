package com.RSVP.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.RSVP.Base.TestBase;

public class SignUpPage extends TestBase{
	
	
	@FindBy(xpath="//div[@class='center']//input[@type='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//a[contains(text(),'Upload new Photo')]")
	private WebElement uploadNewPhotoButton;
	
	@FindBy(xpath="//*[@id='drop-area_field_12059']/img")
	private WebElement dropArea;
	
	@FindBy(xpath="//*[@id='cropBtn_field_12059']/div[3]/a")
	private WebElement saveButton;
	
	@FindBy(id="field_12052")
	private WebElement firstNameField;
	
	@FindBy(id="field_12053")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='field[12054][value]']")
	private WebElement emailField;
	
	@FindBy(xpath="(//div[contains(text(),'Phone')]/..//input[@type='checkbox'])[2]")
	private WebElement mobileChekcBox;
	
	@FindBy(xpath = "(//div[contains(text(),'Phone')]/..//input)[9]")
	private WebElement mobileNumber;
	
	@FindBy(xpath = "(//div[contains(text(),'Phone')]/..//input)[10]")
	private WebElement mobileNumber1;
	
	@FindBy(xpath = "(//div[contains(text(),'Radio')]/..//input)[1]")
	private WebElement radioGroupButton;
	
		@FindBy(xpath = "(//div[contains(text(),'Radio')]/..//input[@type='radio'])[1]")
		private WebElement gender;
		
		@FindBy(xpath = "//div[contains(text(),'profile :')]/..//select")
		private WebElement profileType;
	
	@FindBy(xpath = "//*[contains(text(),'Ticket')]/../../..//select")
	private WebElement ticketNumbers;
	
	@FindBys(value = { @FindBy(xpath = "(//*[text()='Required field']/../..)/div[1]") })
	private java.util.List<WebElement> requiredName;
	
	
	
	
	
	public SignUpPage()
	{
		PageFactory.initElements(driver,this);
	}

	
	public String verifySignUpPageTitle()
	{
		return driver.getTitle();
	}
	
	public void submitWithoutFilling() throws InterruptedException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",submitButton);
		submitButton.click();
		//Thread.sleep(10000);

		for (WebElement webElement : requiredName) {

			System.out.println("required Name   " + webElement.getText().trim());
		}
	}
	
	public void profileImageFunctionality()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",uploadNewPhotoButton);
		uploadNewPhotoButton.click();
		
//		Set<String> window=driver.getWindowHandles();
//		for (String string : window) {
//			driver.switchTo().window(string);
//		}
		js.executeScript("arguments[0].scrollIntoView();",dropArea);
		dropArea.click();
		
		Robot r=null;
		try {
			r = new  Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_N);
		r.keyRelease(KeyEvent.VK_ALT);
		r.delay(1000);
		
		// Specify the file location with extension
		StringSelection selection1= new StringSelection("C:\\Users\\Sujjal\\Desktop\\Image test.jpg");
		
		// Copy to clipboard
		Clipboard clipboard1=Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard1.setContents(selection1, selection1);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.delay(1000);
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_O);
		r.keyRelease(KeyEvent.VK_ALT);
		
		r.delay(3000);
		js.executeScript("arguments[0].scrollIntoView();",saveButton);
		saveButton.click();	
	}
	
	public void submitAfterFilling() throws InterruptedException
	{
		firstNameField.sendKeys("Ujjal");
		lastNameField.sendKeys("Saha");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",uploadNewPhotoButton);
		
		emailField.sendKeys("saha.ujjal4792@gmail.com");
		
		mobileChekcBox.click();
		Thread.sleep(3000);
		mobileNumber.sendKeys("9898989898");
		mobileNumber1.sendKeys("91");
		
		radioGroupButton.click();
		
		Select drpdwn=new Select(profileType);
		drpdwn.selectByVisibleText("Tester");
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();",ticketNumbers);
		
		Select drpdwn1=new Select(ticketNumbers);
		drpdwn1.selectByValue("2");
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		js2.executeScript("arguments[0].scrollIntoView();",submitButton);
		submitButton.click();
		
	}
}
