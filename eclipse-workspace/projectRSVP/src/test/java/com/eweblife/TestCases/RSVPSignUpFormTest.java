package com.eweblife.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.RSVP.Base.TestBase;
import com.RSVP.Pages.SignUpPage;





public class RSVPSignUpFormTest extends TestBase{

	SignUpPage signup;
	public RSVPSignUpFormTest()
	{
		super();
		}
	
	@BeforeMethod
public void setUp()
{
initialization();
signup=new SignUpPage();
}
	
	
	@Test(priority=1, description="Test Case-1::::Submiting Form without any inputs")
	public void submitWithoutFillingTest() throws InterruptedException
	{
		//Verifying Landing Page Title
		String title=signup.verifySignUpPageTitle(); 
		Assert.assertEquals(title,"My RSVPs - Powered by eWebLife.com");
		
	signup.submitWithoutFilling();
	Thread.sleep(3000);
	}
	
	@Test(priority=2, description="Test Case-2::::Testing Profile image Functionality")
	public void profileImageFunctionalityTest()
	{
	signup.profileImageFunctionality();
	}
	
	@Test(priority=3, description="Test Case-3::::Submiting form after filling all the mandatory fields")
	public void submitAfterFillingTest() throws InterruptedException
	{
	signup.submitAfterFilling();
	}
	
	@AfterMethod
	public void terminateTest(){
		driver.quit();
	}
	
	
}