package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageClass {

	WebDriver driver;
	
	By username=By.id("email");
	By password=By.id("pass");
	By login=By.id("loginbutton");

	
	public HomePageClass(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void typeUserNAme()
	
{
		driver.findElement(username).sendKeys("sujjal.saha4@gmail.com");
}
	
	public void typeUserPassword()
	
	{
			driver.findElement(password).sendKeys("ujjalmona");

	}
	
	public void ClickLoginButton()
	
	{
			driver.findElement(login).click();

	}
	
}
