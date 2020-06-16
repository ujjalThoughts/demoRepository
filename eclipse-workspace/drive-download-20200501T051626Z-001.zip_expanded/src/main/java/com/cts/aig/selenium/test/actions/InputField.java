package com.cts.aig.selenium.test.actions;

import com.cts.aig.selenium.utility.TestExecutor;

public class InputField {
	
	TestExecutor testExecutor = null;
	public InputField(TestExecutor testExecutor) {
		this.testExecutor = testExecutor;
	}
	
	public String showMessage(String data) {
		return testExecutor.sendKeysBy("xpath", "//input[@id='user-message']", data)
						   .clickBy("xpath", "//button[contains(text(),'Show Message')]")
						   .waitForElementVisible("id", "display")
						   .captureScreenshot("Show Message")
						   .getTextBy("id", "display");
	}

	public String sumTotal(int valueA, int valueB) {
		testExecutor.sendKeysBy("id", "sum1", String.valueOf(valueA))
					.sendKeysBy("id", "sum2", String.valueOf(valueB))
					.clickBy("xpath", "//button[contains(text(),'Get Total')]")
					.captureScreenshot("Sum Total");
					
		return testExecutor.getTextBy("id", "displayvalue");
	}
	
	

}
