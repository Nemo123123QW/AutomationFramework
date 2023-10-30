package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelSheetUtility;
import genericUtilities.javaFileUtilities;
import genericUtilities.proprtyFileUtility;
import genericUtilities.webDriverUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createContactWithOrganization {

	public static void main(String[] args) throws IOException {
		//step 1: create all the required objects
		
        javaFileUtilities jutil = new javaFileUtilities();
       ExcelSheetUtility eutil = new ExcelSheetUtility();
       proprtyFileUtility putil = new proprtyFileUtility();
       webDriverUtilities wutil = new webDriverUtilities();
      WebDriver driver = null;
//step 2: read the Required Data
       
      String BROWSER = putil.readDatafromPropertyFile("browser");
      String URL = putil.readDatafromPropertyFile("url");
      String USERNAME = putil.readDatafromPropertyFile("username");
      String PASSWORD = putil.readDatafromPropertyFile("password");
     String ORGNAME = eutil.readDataFromExcelSheet("contact", 7, 3)+jutil.getrandomnumber();
     String LASTNAME = eutil.readDataFromExcelSheet("contact", 7, 2);
     
     
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
     
     
     
//step 5: login to application
     
     
     driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
//step 6: Navigate to organizations Link
	driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();	
		
//driver.findElement(By.linkText("Organizations")).click();
		
	//Step 7: Click on Create Organization look Up Imge
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	//Step 7: Create Organization with mandatory information
	driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(ORGNAME);
	
	//Step 8: save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Step 9: Validate
	String OrgHeader = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	
	if(OrgHeader.contains(ORGNAME))
	{
		System.out.println(OrgHeader);
		System.out.println("PASS");
	}
	else
	{
		System.out.println("FAIL");
		
	}
	
	
	
	
	
	
	// Step 10: Navigate to Contacts
			driver.findElement(By.linkText("Contacts")).click();

			// Step 11: Click on create Contact look Up Image
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

			// Step 12: Create Contact with mandatory fields
			driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

			// Step 13: click on Organization look Up Image
			driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();

			wutil.windowHandling(driver, "Accounts");

			driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
			driver.findElement(By.name("search")).click();

			driver.findElement(By.xpath("//a[text()='" + ORGNAME + "']")).click();
			// Orgname is dynamic
			// xpath is changing dynamically - dynamic xpath
			// a[text()='"+varible+"']

			wutil.windowHandling(driver, "Contacts");

			// Step 14: save
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			// Step 15: Validate for Organization
			String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

			if (ContactHeader.contains(LASTNAME)) {
				System.out.println(ContactHeader);
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
			
			//Step 16: Logout of Application
			 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			wutil.handleMouseHover(driver, ele);
			
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("logout successful");


	}

}
