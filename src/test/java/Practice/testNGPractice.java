package Practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGPractice {
	@Test(invocationCount = 2,priority = 1)
	public void createCustomer()
	{
		//Assert.fail();
		System.out.println("create");//failed
	}
	@Test(enabled = false)
	
	public void modifyCustomer()
	{
		System.out.println("Modify");
	}

@Test(dependsOnMethods = "createCustomer")
	
	public void deleteCustomer()
	{
		System.out.println("delete");
	}
}
