package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.crm.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()  //Constructor is created to define Properties code for reading property file
	{
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:\\Users\\Sujjal\\eclipse-workspace\\CRMtest\\src\\main\\java\\com\\crm\\config\\"
					+ "config.properties");
			prop.load(fis);
		}	
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e) { //In this case, the second catch would get everything that was not caught in the first catch because all exceptions 
								//extend the Exception class, you can catch all derived classes with that statement.
			e.printStackTrace();
		}	
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("BROWSER");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sujjal\\\\ECLIPSE_O2\\\\SeleniumAccs\\\\chromedriver_win32\\\\"
					+ "chromedriver.exe");
			 driver=new ChromeDriver(); 
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sujjal\\eclipse-workspace\\CRMtest\\drivers\\GekoDriver"+"geckodriver.exe");
	
			driver = new InternetExplorerDriver();
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Sujjal\\eclipse-workspace\\CRMtest\\drivers\\IEDriver"+"IEDriverServer.exe");
	
			 driver=new FirefoxDriver();
		}
		
		else {
			Assert.assertFalse(false, "Please define correct browser name! Current Browser name: "+browserName);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);// set the time of 20 seconds for page to complete the loading
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		}
		
		
}

