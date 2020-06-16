package com.cts.aig.selenium.test.actions;

import java.util.Map;

import com.cts.aig.selenium.utility.TestExecutor;

public class UserSignUp {
	TestExecutor testExecutor = null;
	public UserSignUp(TestExecutor testExecutor) {
		this.testExecutor = testExecutor;
	}
	
	public void registerUser(Map<String, String> testData) {
		
		testExecutor.sendKeysBy("xpath", "//input[@name='firstName']", testData.get("FirstName"))
		            .sendKeysBy("xpath", "//input[@name='lastName']", testData.get("LastName"))
		            .sendKeysBy("xpath", "//input[@name='phone']", testData.get("Phone"))
		            .sendKeysBy("xpath", "//input[@name='userName']", testData.get("Email"))
		            .sendKeysBy("xpath", "//input[@name='address1']", testData.get("Address"))
		            .sendKeysBy("xpath", "//input[@name='city']", testData.get("City"))
		            .sendKeysBy("xpath", "//input[@name='state']", testData.get("State"))
		            .sendKeysBy("xpath", "//input[@name='postalCode']", testData.get("PostalCode"))
		            .selectDropDownBy("xpath", "//select[@name='country']", testData.get("Country"))
		            .sendKeysBy("xpath", "//input[@name='email']", testData.get("UserName"))
		            .sendKeysBy("xpath", "//input[@name='password']", testData.get("Password"))
		            .sendKeysBy("xpath", "//input[@name='confirmPassword']", testData.get("ConfirmedPassword"));
		
	}

}
