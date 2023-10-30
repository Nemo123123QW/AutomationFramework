package contactsTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.contactInformationPage;
import ObjectRepository.createContactPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;
import genericUtilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(genericUtilities.ListenerImplimentationClass.class)
public class createContactTest extends BaseClass {
	
	@Test(groups={"SmokeSuite","ReggressionSuite"})
	public void createContactTest() throws IOException, InterruptedException {
		
		     String ORGNAME = eutil.readDataFromExcelSheet("contact", 7, 3)+jutil.getrandomnumber();
		     String LASTNAME = eutil.readDataFromExcelSheet("contact", 7, 2);
		     
		   //step 6:navigate to contact link
		   	HomePage hp = new HomePage(driver);
		   	hp.clickOnContactslinkEdt();
		   	Reporter.log("Click on contact");
		   	//step 7: click on createcontact lookup tool
		   	ContactsPage cp = new ContactsPage(driver);
			cp.clickOncreateContactBtnEdt();
			Reporter.log("Click on createcontact lookup tool");
			Thread.sleep(1000);
			
			//step 8:create contact with mandatory fields
			createContactPage cncp = new createContactPage(driver);
			cncp.createNewContact(LASTNAME);
			Reporter.log("Click on new contact");
			
			//step 9:Validation
			
			 contactInformationPage cip = new contactInformationPage(driver);
			 Thread.sleep(1000);
			 Reporter.log("Header Captured");
			// Assert.fail();//--for listeners
			 
			String contactHeader = cip.getCntctHeaderText();
			Assert.assertTrue(contactHeader.contains(LASTNAME));
			
				System.out.println(contactHeader);
				Reporter.log("Heaer Validated");
		   		
	}
	@Test
	public void demo()
	{
		System.out.println("demo Hi");
	}
}
