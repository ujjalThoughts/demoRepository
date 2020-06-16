package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	private WebElement contactsLabel;

	//Initializing the Page Objects
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
		boolean flag= contactsLabel.isDisplayed();
		System.out.println(flag);
		return flag;
	}
	
	public void selectContactsByName(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']")).click();
		//Here we are using findElements instead of PageFactory as we have to select different elements just by changing name
	}
	
	
}
