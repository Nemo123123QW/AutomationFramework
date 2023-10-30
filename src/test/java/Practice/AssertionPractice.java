package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test
	
	public void practice(){
	
	System.out.println("step 1");
	System.out.println("step 2");
	//Assert.assertEquals(false, true);
	Assert.assertEquals(0, 0);
	
	System.out.println("step 3");
	System.out.println("step 4");
		
	}

@Test

public void practice1(){
	
	SoftAssert sa=new SoftAssert();

System.out.println("step 1");


Assert.assertEquals(0, 1);//failed

System.out.println("step 2");
Assert.assertEquals(false, true);//failed


System.out.println("step 3");
System.out.println("step 4");
	sa.assertAll();
	
	Assert.assertEquals("A", "B");//failed
}



}
