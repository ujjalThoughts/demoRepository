package library4Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void captureScreenshot(WebDriver driver,String sh) 
	{
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			  FileUtils.copyFile(src, new File("./Screenshots/"+sh+".png"));
			  System.out.println("Screenshot Captured");
		} 
		
		catch (Exception e) {
			
			System.out.println("Exception While taking Screenshot" +e.getMessage());
		}
		
	}
	
	
}
