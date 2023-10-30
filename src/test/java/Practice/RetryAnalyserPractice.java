package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;


public class RetryAnalyserPractice {
@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplimentation.class)

public void analysePractice() 
{
	Assert.fail();
	System.out.println("HI");
}
	
}

