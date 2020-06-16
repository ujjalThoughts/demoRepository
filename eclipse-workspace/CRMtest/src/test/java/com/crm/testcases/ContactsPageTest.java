package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage; 
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest()
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
driver.switchTo().frame("mainpanel");
contactsPage=homePage.clickOnContactLink();

}
	@Test(priority=1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing on the  CONTACTS PAGE");
	} 
	
	@Test(priority=2)
	public void selectSingleContactsTest()
	{
		
		contactsPage.selectContactsByName(prop.getProperty("selection1"));
	}

	@Test(priority=3)
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName(prop.getProperty("selection1"));
		contactsPage.selectContactsByName(prop.getProperty("selection2"));
		contactsPage.selectContactsByName(prop.getProperty("selection3"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
//1.07.37