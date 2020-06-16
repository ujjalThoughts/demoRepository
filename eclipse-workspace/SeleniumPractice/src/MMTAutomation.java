import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MMTAutomation {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		
		//Click OneWay Radio Button
		driver.findElement(By.xpath("//li[@class='selected']")).click();
		
		//Validation of return Calendar active or not
		
		System.out.println(driver.findElement(By.xpath("//li[contains(@data-cy,'oneWayTrip')]")).getAttribute("class"));
				if(driver.findElement(By.xpath("//li[contains(@data-cy,'oneWayTrip')]")).getAttribute("class").contains("selected")) 
				{
					
					System.out.println("Only one way Calendar is enabled now");
					Assert.assertTrue(true);
				}
				else
					Assert.assertTrue(false);
		
		
		
//		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
//		Thread.sleep(2000);
//		
//		//driver.findElement(By.xpath("//a[@value='CCU']")).click(); --> 
//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='CCU']")).click() ; //--> XPATH By Parent Child relationship
//		Thread.sleep(2000);
//		
//		// This will always select the 2nd element option
//	//	driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click(); 
//		
//		// This will always select the 2nd element option
//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click(); //--> XPATH By Parent Child relationship     

		//To check calendar is enable or not
//		System.out.println("Attribute Check");
//		System.out.println(driver.findElement(By.xpath("//li[contains(@data-cy,'oneWayTrip')]")).getAttribute("class"));
//		driver.findElement(By.xpath("//li[contains(@data-cy,'roundTrip')]")).click();
//		System.out.println(driver.findElement(By.xpath("//li[contains(@data-cy,'oneWayTrip')]")).getAttribute("class"));
//		System.out.println("Attribute Check Done");
		
		
		
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		WebElement fromOption=driver.findElement(By.xpath("//input[contains(@placeholder,'From')]"));
		fromOption.click();
		//fromOption.clear();
		fromOption.sendKeys("New");
		Thread.sleep(2000);
		
		int i=0;
		while(i<2)
		{
			fromOption.sendKeys(Keys.ARROW_DOWN);
			i++;
		}
		fromOption.sendKeys(Keys.ENTER);
		
		
	
		WebElement toOption=driver.findElement(By.xpath("//input[contains(@placeholder,'To')]"));
		toOption.click();
		//fromOption.clear();
		toOption.sendKeys("Ind");
		Thread.sleep(2000);
		
		int j=0;
		while(j<4)
		{
			toOption.sendKeys(Keys.ARROW_DOWN);
			j++;
		}
		toOption.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.cssSelector("div.DayPicker-Day.DayPicker-Day--today")).click();
		Thread.sleep(2000);
		
		WebElement TeavellerButton=driver.findElement(By.xpath("//div[contains(@data-cy,'flightTraveller')]"));
		TeavellerButton.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='travellers'] //li[@data-cy='adults-5']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("a.primaryBtn.font24.latoBold.widgetSearchBtn")).click();
		
		
		
		
	}

}
