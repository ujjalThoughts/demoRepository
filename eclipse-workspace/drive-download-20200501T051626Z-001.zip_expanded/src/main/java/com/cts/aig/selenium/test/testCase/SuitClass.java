package com.cts.aig.selenium.test.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import com.cts.aig.selenium.utility.TestExecutor;

public class SuitClass {
	public TestExecutor testExecutor = null;
	@BeforeClass
	public void initialization() {
		testExecutor = new TestExecutor();
	}
	@AfterMethod
	public void tearDown() {
		testExecutor.getDriver().quit();
	}

}
