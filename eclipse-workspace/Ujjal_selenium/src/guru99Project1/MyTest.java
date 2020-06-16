package guru99Project1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MyTest extends Helper1
{
	WebDriver driver;
	Page1 objLogin;
	
public void MyTest(WebDriver driver)
{
	this.driver=driver;
}
	
	@Test(priority=0)
	public void testLoginObject()
	{
		  //Create Login Page object
		objLogin= new Page1(driver);
		//login to application
		objLogin.loginToGuru99("mngr184703","hujYpyj");
	}
}
