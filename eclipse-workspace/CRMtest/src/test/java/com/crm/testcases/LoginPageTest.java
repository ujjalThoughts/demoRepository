 package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();//This will call constructor in the TestBase(Parent class) and then the property will be initialized.
	}
	
	//Test Cases should be separated from each other(Independent)
	//Before each test cases--Launch the browser and login
	//@Test--execute test cases
	//After each test case, close the browser
	
	
	@BeforeMethod  //Before method is used instead of BeforeTest to refresh the page for every test case and clear the cache so that
				  //browser wont be Exhausted 
	public void setUp()
	{
		initialization();//Here all the initializations will take place already defined in the TestBase class
		loginPage=new LoginPage();//Creating LoginPage Object
	}

	@Test(priority=1)
	public void loginPageTitleTest()
	{
	String title=loginPage.verifyLoginPageTitle();
	Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CRMlogoImageTest()
	{
		boolean imageFlag=loginPage.validateCRMPage();
		Assert.assertTrue(imageFlag);	
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException
	{
	homePage=loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
