package guru99Project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass extends LoginPage{


		WebDriver driver;
		public String username1="mngr184703";
		public String password="hujYpyj";
		
		 public BaseClass(WebDriver driver) {
		        this.driver = driver;
		    }
		 
		 public void loginToGuru99(String username1,String password)
			{
				//Fill user name
		        this.setUserName(username1);
		        //Fill password
		        this.setPassword(password);

		        //Click Login button

		        this.clickLoginButton();    
			}
			
		 
		
	}
