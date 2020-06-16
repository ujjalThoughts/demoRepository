package testNGlearning;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestngScript {

	
@Test(priority=-2,description="For testing the login functionality")
public void Login()
{
	System.out.println("Loggedin to the application");
	}

@Test(priority=1,description="For checking the items are seleted are not")
public void Selectitems()
{
	System.out.println("Items selected");
	Assert.assertEquals(12, 13);
}

@Test(priority=3,description="For testing the checkout feature")
public void checkout()
{
	System.out.println("Checkout Completed");

}
}
