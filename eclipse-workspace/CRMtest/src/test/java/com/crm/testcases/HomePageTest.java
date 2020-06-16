 package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();//This will call constructor in the TestBase(Parent class) and then the property will be initialized.
	}
	
	@BeforeMethod //Before method is used instead of BeforeTest to refresh the page for every test case and clear the cache so that
				//browser wont be Exhausted
	public void setUp() throws InterruptedException
	{
		initialization();//Here all the initializations will take place already defined in the TestBase class
		loginPage=new LoginPage();//Creating LoginPage Object to access Login Page class method. 
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));//Using Login method,get logged in
	}
	 
	@Test(priority=1)
	public void homePageTitleTest()
	{
	String title=homePage.verifyHomePageTitle();//We are calling homePage object from HomePage class which is coming from LoginPage class.So everything is chained.
	Assert.assertEquals(title, "CRMPRO","Description:::Home page Title is not matched");//description will show when test case is getting failed
	}
	
	@Test(priority=2)
	public void verifyUserNameLabelTest()
	{
		driver.switchTo().frame("mainpanel");
	Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		driver.switchTo().frame("mainpanel");
		contactsPage=homePage.clickOnContactLink();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}




