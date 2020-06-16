
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCart {

	public static void main(String[] args) throws InterruptedException {

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sujjal\\eclipse-workspace\\SeleniumPractice\\drivers\\CHROME_DRIVER\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Thread.sleep(3000);

		String[] requiredItems = { "Brocolli", "Beetroot", "Brinjal", "Mushroom" };

		addItems(driver, requiredItems);
	}

	public static void addItems(WebDriver driver, String[] requiredItems) throws InterruptedException {

		int j = 0;
		
		WebDriverWait explicit=new WebDriverWait(driver,5);

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String[] productsName = products.get(i).getText().split("-");
			String formattedProductsName = productsName[0].trim();

			// convert array into array list for easy search
			List<String> requiredItemsList = Arrays.asList(requiredItems);

			if (requiredItemsList.contains(formattedProductsName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == 4)
					break;
			}
		}

		System.out.println("All items are added in the cart");
		
		driver.findElement(By.xpath("//a[contains(@class,'cart-icon')]/img")).click();
		
		driver.findElement(By.xpath("//div[@class='action-block'] //button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='promoWrapper'] //span[@class='promoInfo']")));
		System.out.println(driver.findElement(By.xpath("//div[@class='promoWrapper'] //span[@class='promoInfo']")).getText());
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

		Thread.sleep(2000);
		// Closing the Tab
		driver.close();

	}

}
