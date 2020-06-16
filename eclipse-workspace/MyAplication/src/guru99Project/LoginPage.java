package guru99Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

		WebDriver driver;
		
		public String loginBtn="//input[@value='LOGIN']";
		public String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
		
		
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		}
		//Set user name in textbox
		public void setUserName(String username1)
		{
			By username= By.name("uid");
			WebElement usrn = driver.findElement(username);
			if(usrn.isDisplayed()) {			
			usrn.clear();
			usrn.sendKeys(username1);
			}
		}
		
		public void setPassword(String password)
		{
			By pwd= By.name("password");
			WebElement epwd = driver.findElement(pwd);
			if(epwd.isDisplayed())	{			
			epwd.clear();	
			epwd.sendKeys(password);
			}
		}
		
		public void clickLoginButton()
		{	By button= By.xpath(loginBtn);
			WebElement clck=driver.findElement(button);			
			if(clck.isDisplayed()||clck.isEnabled())		
				clck.click();
		}
		
		//This POM method will be exposed in test case to login in the application
		
	}
