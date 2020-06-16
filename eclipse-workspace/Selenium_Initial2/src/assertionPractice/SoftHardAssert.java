package assertionPractice;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftHardAssert {

	
	 @Test
	 public void testAssert(){
		 
	 SoftAssert assertion= new SoftAssert();
	 System.out.println("softAssert Method Was Started");
	 assertion.assertTrue(false,"Didnt Match");
	 System.out.println("softAssert Method Was Executed");
	 assertion.assertAll();
	 }
	 
	 @Test
	 public void testhardAssert(){
	 System.out.println("hardAssert Method Was Started");
	 Assert.assertTrue(false);
	 System.out.println("hardAssert Method Was Executed");
	 }
}
