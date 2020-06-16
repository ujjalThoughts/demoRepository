import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClearTripAutomation {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();

		WebElement searchFlightButton = driver.findElement(By.cssSelector(".booking.large"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", searchFlightButton);

		driver.findElement(By.xpath("//div[contains(@class,'datePicker')] //input[@id='DepartDate']")).click();
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();

		Select NoOfAdults = new Select(driver.findElement(By.id("Adults")));
		NoOfAdults.selectByValue("5");

		Select NoOfChildrens = new Select(driver.findElement(By.id("Childrens")));
		NoOfChildrens.selectByValue("1");

		driver.findElement(By.xpath("//a[@id='MoreOptionsLink'] //strong[contains(text(),'More options:')]")).click();

		driver.findElement(By.xpath("//span[contains(@class,'clearField')] //input[@id='AirlineAutocomplete']")).clear();
		driver.findElement(By.xpath("//span[contains(@class,'clearField')] //input[@id='AirlineAutocomplete']"))
				.sendKeys("Air India");

		driver.findElement(By.cssSelector(".booking.large")).click();

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

		Thread.sleep(2000);
		// Closing the Tab
		driver.close();
	}

}
