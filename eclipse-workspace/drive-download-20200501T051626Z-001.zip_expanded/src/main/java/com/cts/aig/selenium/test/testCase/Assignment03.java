package com.cts.aig.selenium.test.testCase;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.cts.aig.selenium.test.actions.UserSignUp;

public class Assignment03 extends SuitClass{
	private Map<String,String> testData = new HashMap<String,String>();
	@Test
	@Parameters({"URL","browser"})
	public void userRegistration(String URL, String browser) {
		super.testExecutor.openBrowser(URL, browser);
		prepareTestData();
		new UserSignUp(super.testExecutor).registerUser(testData);
		super.testExecutor.captureScreenshot("User Registration");
	}

	private void prepareTestData() {
		testData.put("FirstName", "USERFIRSTNAME");
		testData.put("LastName", "USERLASTNAME");
		testData.put("Phone", "9874563210");
		testData.put("Email", "useremail@test.com");
		testData.put("Address", "useraddress");
		testData.put("City", "KOLKATA");
		testData.put("State", "WB");
		testData.put("PostalCode", "700000");
		testData.put("Country", "INDIA");
		testData.put("UserName", "username123");
		testData.put("Password", "password123");
		testData.put("ConfirmedPassword", "password123");
	}
	
}
