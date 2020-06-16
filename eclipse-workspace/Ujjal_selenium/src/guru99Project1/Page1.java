package guru99Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page1 {

	WebDriver driver;
	
	public static String firefoxPath="C:\\\\\\\\Users\\\\\\\\Sujjal\\\\\\\\ECLIPSE_O2\\\\\\\\SeleniumAccs\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe";
	public String WebURL= "http://www.demo.guru99.com/V4/";
	public int WaitTime=30;
	
	public String username1="mngr184703";
	public String password="hujYpyj";
	
	static By username= By.name("uid");
	static By pwd= By.name("password");
	static By button= By.xpath("//input[@value='LOGIN']");
	
	public String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	
	
	public void Page1(WebDriver driver) {
		this.driver = driver;
	}
	//Set user name in textbox
	public void setUserName(String username1)
	{
		WebElement usrn = driver.findElement(username);
		if(usrn.isDisplayed())
		
		usrn.clear();
		usrn.sendKeys("username1");
	}
	
	public void enterPassword(String password)
	{
		WebElement epwd = driver.findElement(pwd);
		if(epwd.isDisplayed())
			
		epwd.clear();	
		epwd.sendKeys("password");
	}
	
	public void clickLoginButton()
	{
		WebElement clck=driver.findElement(button);
		
		if(clck.isDisplayed()||clck.isEnabled())		
			clck.click();
	}
	
	//This POM method will be exposed in test case to login in the application
	
	public void loginToGuru99(String username1,String password)
	{
		//Fill user name

        this.setUserName(username1);

        //Fill password

        this.enterPassword(password);

        //Click Login button

        this.clickLoginButton();    
	}
	
}
	
