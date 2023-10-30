package organizationTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.createNewOrganizationPage;
import ObjectRepository.organizationsPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;
import genericUtilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createOrganizationWithIndustryTest extends BaseClass {
@Test
	
		public  void createOrgWithIndTest() throws IOException, InterruptedException {
			
			      String ORGNAME = eutil.readDataFromExcelSheet("organization", 1, 2)+jutil.getrandomnumber();
			      String LASTNAME = eutil.readDataFromExcelSheet("contact", 7, 2);
			    String INDUSRTY = eutil.readDataFromExcelSheet("organization", 4, 3);
			     
			   
					//Step 6: click on Organization
					HomePage hp = new HomePage(driver);
					hp.clickOnOrgLinkEdt();
					
			  //step7://Step 7: Click on Create Organization look Up Image
					organizationsPage op = new organizationsPage(driver);
					op.clickOncreateOrgButnEdt();
					
					//Step 8: Create new Organization with Mandatory fields
							createNewOrganizationPage cnop = new createNewOrganizationPage(driver);

						cnop.createNewOrganization(ORGNAME, INDUSRTY);
							
							
						
							//Step 9: Validate for Organization
							 OrgInfoPage oip = new OrgInfoPage(driver);
							String orgHeader = oip.getHeaderText();
							if(orgHeader.contains(ORGNAME))
							{
								System.out.println(orgHeader);
								System.out.println("Organization Created");
							}
							else
							{
								System.out.println("FAIL");
							}
							
							
							
							

	}

}
