package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath="//*[@id=\"mainform\"]/table/tbody/tr[1]/td/ul/li[1]/a")
	WebElement logonOptn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogon()
	{
		if(logonOptn.isDisplayed()||logonOptn.isEnabled()) {
			
				
			logonOptn.click();
		}
	}
	
	
}
