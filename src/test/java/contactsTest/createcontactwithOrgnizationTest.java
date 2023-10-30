package contactsTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import ObjectRepository.ContactsPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.contactInformationPage;
import ObjectRepository.createContactPage;
import ObjectRepository.createNewOrganizationPage;
import ObjectRepository.organizationsPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;
import genericUtilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createcontactwithOrgnizationTest extends BaseClass{

	
	@Test(groups="ReggressionSuite")
	public  void createContactWithOrgTest () throws IOException, InterruptedException {
		

//step 2: read the Required Data
       
      
     String ORGNAME = eutil.readDataFromExcelSheet("contact", 7, 3)+jutil.getrandomnumber();
     String LASTNAME = eutil.readDataFromExcelSheet("contact", 7, 2);
     
     
   
		//Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLinkEdt();
		
  //step7://Step 7: Click on Create Organization look Up Image
		organizationsPage op = new organizationsPage(driver);
		Thread.sleep(1000);
		op.clickOncreateOrgButnEdt();
		
		//Step 8: Create new Organization with Mandatory fields
				createNewOrganizationPage cnop = new createNewOrganizationPage(driver);
				cnop.createNewOrganization(ORGNAME);
				
				//Step 9: Validate for Organization
				 OrgInfoPage oip = new OrgInfoPage(driver);
				String orgHeader = oip.getHeaderText();
				Thread.sleep(3000);
				Assert.assertTrue(orgHeader.contains(ORGNAME));
				System.out.println(orgHeader);
				
				
				//Step 10: Click On Contacts Link
				hp.clickOnContactslinkEdt();
				
				Thread.sleep(3000);

				//Step 11: Click on Create contact Look Up Image
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOncreateContactBtnEdt();
				Thread.sleep(1000);
				
				//Step 12: Create Contact with Organization
				createContactPage cncp = new createContactPage(driver);
				cncp.createNewContact(driver, LASTNAME, ORGNAME);
				
				//Step 13: Validation
				
				 contactInformationPage cip = new contactInformationPage(driver);
				String contactHeader = cip.getCntctHeaderText();
				Assert.assertTrue(contactHeader.contains(LASTNAME));
				System.out.println(contactHeader);
				
				
				
	}

}
