package com.cts.aig.selenium.test.testCase;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.cts.aig.selenium.test.actions.InputField;

public class Assignment04 extends SuitClass{
	InputField inputField = null;
	@BeforeMethod
	@Parameters({"URL","browser"})
	public void browserInitialization(String URL, String browser) {
		super.testExecutor.openBrowser(URL, browser);
		inputField = new InputField(super.testExecutor);
	}
  @Test(priority=1)
  public void handleInputFieldDisplay() {
	  super.testExecutor.testNGReporterLog("Executing priority = 1, @Test annotations method.");
	  String inputData="Aig Assignment";
	  String actalData = inputField.showMessage(inputData);
	  Assert.assertEquals(actalData, inputData);
  }
  
  @Test(priority = 2,dataProvider="dataGenerator")
  public void handleInputFieldSum(int valueA,int valueB) {
	  super.testExecutor.testNGReporterLog("Executing priority = 2, @Test annotations method.");
	  super.testExecutor.testNGReporterLog("Data: ValueA ="+String.valueOf(valueA)+" ValueB ="+String.valueOf(valueB));
	  String actualValue = inputField.sumTotal(valueA,valueB);
	  Assert.assertEquals(actualValue, String.valueOf(valueA+valueB));
  }
  
  @DataProvider
  public Object[][] dataGenerator(){
	  Object[][] data = new Object[4][2];
   
	  data[0][0] = 11;
	  data[0][1] = 21;
   
	  data[1][0] = 321;
	  data[1][1] = 987;
   
	  data[2][0] = 7895;
	  data[2][1] = 6524;
   
	  data[3][0] = 123545;
	  data[3][1] = 654872;
	  return data; 
  }
}