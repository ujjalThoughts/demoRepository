package com.CRMPRO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {
	
	public static void main(String args[])
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\Users\\\\\\\\Sujjal\\\\\\\\ECLIPSE_O2\\\\\\\\SeleniumAccs\\\\\\\\chromedriver_win32\\\\\\\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.crmpro.com/");
		driver.manage().window().maximize();
		
		//Signin to the portal
		driver.findElement(By.name("username")).sendKeys("Ujjal4");
		driver.findElement(By.name("password")).sendKeys("Ujjal@4792");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).click();
		
	System.out.println("*******Logged in succssfully**********");
	
	
	//Switch to iFrame and click on Contact tab
	
	driver.switchTo().frame("mainpanel");
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	System.out.println("********Clicked on the Contacts********");
	
	//Select one contact
	
	driver.findElement(By.xpath("//a[contains(text(),'Mom Mom')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}

}
