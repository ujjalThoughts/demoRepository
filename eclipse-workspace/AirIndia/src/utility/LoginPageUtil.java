package utility;

import org.openqa.selenium.WebDriver;

import POM.LoginPage;

public class LoginPageUtil {

	
	public void loginPageAirInd(String usrName,String password,WebDriver driver)
	{
		LoginPage objLoginPage=new LoginPage(driver);
		objLoginPage.setUserName(usrName);
		
		objLoginPage.setPassword(password);
		
		objLoginPage.clickLogin();
	}
}
