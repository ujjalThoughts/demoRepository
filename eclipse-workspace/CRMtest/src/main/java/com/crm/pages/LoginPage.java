package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory- Object Repository:::::::
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[contains(@class,'btn btn-small')]") 
	private WebElement loginButton;
	
	@FindBy(xpath="//img[@src='https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png']") 
	private WebElement CRMlogo;
	
	//Initializing the Page Objects:::::
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	//Actions:::
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	 public boolean validateCRMPage()
	 {
		 return CRMlogo.isDisplayed();
	 }
	 
	 public HomePage login(String usrnm,String pwd) throws InterruptedException
	 {
		 username.sendKeys(usrnm);
		 password.sendKeys(pwd);
		 Thread.sleep(3000);
		 loginButton.click();
		 
		 return new HomePage();
	 }
}
