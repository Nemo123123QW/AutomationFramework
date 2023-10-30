package organizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.OrgInfoPage;
import ObjectRepository.createNewOrganizationPage;
import ObjectRepository.organizationsPage;
import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;
import genericUtilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createMultipleOrganization {
	javaFileUtilities jutil = new javaFileUtilities();
    ExcelSheetUtility eutil = new ExcelSheetUtility();
    proprtyFileUtility putil = new proprtyFileUtility();
    webDriverUtilities wutil = new webDriverUtilities();
  
	
	
	@Test(dataProvider="getData")
	public void createMultipleOrga(String ORG,String INDUSTRY) throws IOException, InterruptedException {
		 WebDriver driver = null;
		
		//step 2: read the Required Data
	       
	      String BROWSER = putil.readDatafromPropertyFile("browser");
	      String URL = putil.readDatafromPropertyFile("url");
	      String USERNAME = putil.readDatafromPropertyFile("username");
	      String PASSWORD = putil.readDatafromPropertyFile("password");
	      String ORGNAME =ORG+jutil.getrandomnumber();
	      
	     
	   //step 3: launch the browser
	     if (BROWSER.equalsIgnoreCase("chrome"))
		 {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println(BROWSER+ "launched");
		}
		 else if (BROWSER.equalsIgnoreCase("firefox"))
		 {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+ "launched");
		} 
		 
		 else if (BROWSER.equalsIgnoreCase("edge"))
		 {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+ "launched");
		} 
		 else {
			 System.out.println("invalid Browser Name");

		}
	     
	     wutil.maximizeWindow(driver);
	     wutil.waitForPageLoad(driver);
	     
	     
	//step 4: Load the url
	     driver.get(URL);
	     
	   //Step 5: Login To Application
	   		LoginPage lp = new LoginPage(driver);
	   		lp.loginToApp(USERNAME, PASSWORD);
	   		
	 

			//Step 6: click on Organization
			HomePage hp = new HomePage(driver);
			hp.clickOnOrgLinkEdt();
			
	  //step7://Step 7: Click on Create Organization look Up Image
			organizationsPage op = new organizationsPage(driver);
			op.clickOncreateOrgButnEdt();
			
			//Step 8: Create new Organization with Mandatory fields
					createNewOrganizationPage cnop = new createNewOrganizationPage(driver);

				cnop.createNewOrganization(ORG, INDUSTRY);
				wutil.takeScreenShot(driver, ORGNAME);
					
					
				
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
		
	
	
	//Step 10: Logout
	hp.logoutOfapp(driver);
	
	//Step 11: Close the Browser
	driver.quit();
	
}
	
	
	@DataProvider
	public Object[][]getData() throws EncryptedDocumentException, IOException{
		
		return (Object[][]) eutil.readMultipleData("MultipleOrganizations");
	}
	}
	


