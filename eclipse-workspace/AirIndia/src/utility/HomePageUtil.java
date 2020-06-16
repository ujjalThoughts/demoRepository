package utility;

import org.openqa.selenium.WebDriver;

import POM.HomePage;

public class HomePageUtil {

	public void homePageAirInd(WebDriver driver) {
		
		HomePage objLogon=new HomePage(driver);
		objLogon.clickLogon();
	}
}
