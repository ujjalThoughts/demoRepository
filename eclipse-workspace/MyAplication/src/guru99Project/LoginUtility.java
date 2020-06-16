package guru99Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class LoginUtility{

		//public String username1="mngr184703";
		//public String password="hujYpyj";
				 
		 public void loginToGuru99(String username1,String password, WebDriver driver)
			{	LoginPage loginObj= new LoginPage(driver);
				//Fill user name
				loginObj.setUserName(username1);
		        //Fill password
				loginObj.setPassword(password);
		        //Click Login button
				loginObj.clickLoginButton();    
			}
			
		 
		
	}
