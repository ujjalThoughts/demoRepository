package com.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Ujjal Saha')]")
	private WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement tasksLink;
	
	//Initializing the Page Objects
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:::::
	public boolean verifyCorrectUserName()
	{
		
		boolean flag= userNameLabel.isDisplayed();
		System.out.println(flag);
		return flag;
	}
	
		
	public String verifyHomePageTitle()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public ContactsPage clickOnContactLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}

}