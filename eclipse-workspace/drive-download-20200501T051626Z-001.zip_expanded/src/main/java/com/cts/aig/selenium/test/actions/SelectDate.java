package com.cts.aig.selenium.test.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cts.aig.selenium.utility.TestExecutor;

public class SelectDate {
	TestExecutor testExecutor = null;
	public SelectDate(TestExecutor testExecutor) {
		this.testExecutor = testExecutor;
	}
	
	public void goToDate(String date,String monthYear) {
		while(!testExecutor.getTextBy("xpath", "//a[@aria-label='Go to previous month']//following-sibling::div").contains(monthYear)) {
			testExecutor.clickBy("xpath", "//a[@aria-label='Go to next month']");
		}
		
		List<WebElement> dateList = testExecutor.getDriver().findElements(By.xpath("//tbody//td"));
		
		for(WebElement element : dateList) {
			if(element.isDisplayed() && element.getText().equals(date)) {
				element.click();
			}
		}
	}

}
