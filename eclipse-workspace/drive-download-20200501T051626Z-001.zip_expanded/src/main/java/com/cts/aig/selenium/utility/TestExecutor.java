package com.cts.aig.selenium.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class TestExecutor {
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	

	public TestExecutor openBrowser(String url, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/CHROME_DRIVER/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/GekoDriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			Assert.assertFalse(false, "Please define correct browser name! Current Browser name: "+browser);
		}
		driver.manage().window().maximize();
		driver.get(url);
		
		wait = new WebDriverWait(driver, 60);
		return this;
	}
	
	public WebDriver getDriver() {
		return driver;
		
	}
	
	private By getBy(String locatorType, String locatorValue) {
		if(locatorType.equalsIgnoreCase("xpath")) {
			return By.xpath(locatorValue);
		}else if(locatorType.equalsIgnoreCase("id")) {
			return By.id(locatorValue);
		}else if(locatorType.equalsIgnoreCase("name")) {
			return By.name(locatorValue);
		}
		return null;
	}
	
	public TestExecutor sendKeysBy(String locatorType, String locatorValue, String data) {
		driver.findElement(getBy(locatorType, locatorValue)).sendKeys(data);
		return this;
	}
	
	public TestExecutor sendKeysByAction(String locatorType, String locatorValue, String data) {
		Actions action = new Actions(this.driver);
		action.sendKeys(driver.findElement(getBy(locatorType, locatorValue)), data).perform();
		return this;
	}
	
	public TestExecutor clickByAction(String locatorType, String locatorValue) {
		Actions action = new Actions(this.driver);
		action.click(driver.findElement(getBy(locatorType, locatorValue))).perform();
		return this;
	}
	
	public TestExecutor clickBy(String locatorType, String locatorValue) {
		driver.findElement(getBy(locatorType, locatorValue)).click();
		return this;
	}
	
	public String getTextBy(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue)).getText();
		 
	}
	
	public TestExecutor implicitWait(int timeInMilliSec) throws Exception {
		Thread.sleep(timeInMilliSec);
		return this;
	}
	
	public TestExecutor selectDropDownBy(String locatorType, String locatorValue, String value) {
		 Select select = new Select(driver.findElement(getBy(locatorType, locatorValue)));
		 select.selectByVisibleText(value);
		 return this;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}

	public TestExecutor waitForElementVisible(String locatorType, String locatorValue) {
		this.wait.until(ExpectedConditions.elementToBeClickable(getBy(locatorType, locatorValue)));
		return this;
	}
	
	public TestExecutor captureScreenshot(String imageName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File scrFile = ts.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
			String path = "./screenshot/"+imageName+"_" + timestamp + ".png";
			FileUtils.copyFile(scrFile, new File(path));
			Reporter.log("<br>");
			Reporter.log("<p>"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+" : "+imageName+"</p>");
			Reporter.log("<img src='"+new File(path).getCanonicalPath()+"' height ='550' width='1080' >");
			Reporter.log("</br>");
			return this;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public TestExecutor testNGReporterLog(String message) {
		Reporter.log("<p>"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date())+" : "+message+"</p>");
		return this;
	}

	public String getTotalLinks() {
		String total = String.valueOf(driver.findElements(getBy("xpath", "//a")).size());
		captureScreenshot("Total Links available-"+total);
		return total;
	}
	
	public TestExecutor switchToWindow(int index) {
		Set<String> window = driver.getWindowHandles();
		List<String> windowList = new ArrayList<String>(window);
		driver.switchTo().window(windowList.get(index));
		return this;
	}

	public TestExecutor goToIframe(String locatorType, String locatorValue) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(getBy(locatorType, locatorValue)));
		return this;
	}

	public boolean isElementPresent(String locatorType, String locatorValue) {
		return driver.findElements(getBy(locatorType, locatorValue)).size()>0;
	}

}
