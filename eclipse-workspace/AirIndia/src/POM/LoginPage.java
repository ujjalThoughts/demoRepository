package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
//	public String Id_Field="//input[@id='membershipNumber']";
//	public String pwd_Field="";
	
	@FindBy(xpath="//input[@id='membershipNumber']")
	WebElement usrnm;
	@FindBy(xpath="//input[@id='membershipPassword']")
	WebElement loginpwd;
	@FindBy(xpath="//input[@id='logonButton']")
	WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName(String memId)
	{
//		By username=By.xpath("Id_Field");
//		WebElement usrnm=driver.findElement(username);
		if(usrnm.isDisplayed()) 
		{
			usrnm.clear();
			usrnm.sendKeys(memId);
		}
		}
	public void setPassword(String pwd)
	{
		if(loginpwd.isDisplayed())
		{
			loginpwd.clear();
			loginpwd.sendKeys(pwd);
		}
	}
		public void clickLogin()
		{
			if(loginButton.isDisplayed())
			{
				loginButton.clear();
				loginButton.click();
			}
	}
	
}
