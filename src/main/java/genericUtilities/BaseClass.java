package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * this class consist of all basic configuration annotation of testNG
 * @author Namrata
 *
 */
public class BaseClass {
	
	public javaFileUtilities jutil = new javaFileUtilities();
    public ExcelSheetUtility eutil = new ExcelSheetUtility();
   public proprtyFileUtility putil = new proprtyFileUtility();
   public  webDriverUtilities wutil = new webDriverUtilities();
  public WebDriver driver=null;
  //used for listener
  public static WebDriver sdriver;
	@BeforeSuite(groups={"SmokeSuite","ReggressionSuite"})
	
	public void bsConfig() {
		System.out.println("------DB connection successful------");
	}
	//@Parameters("browser")
     //@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/ ) throws IOException {
		String BROWSER = putil.readDatafromPropertyFile("browser");
	      String URL = putil.readDatafromPropertyFile("url");
	      
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
	      //used in listeners
	      sdriver=driver;
	      driver.get(URL);
	      
	 //step 4: Load the url
	      driver.get(URL);
	      
	      System.out.println("----browser launched successfully------");
	    
	    		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME = putil.readDatafromPropertyFile("username");
	      String PASSWORD = putil.readDatafromPropertyFile("password");
		
		//Step 5: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		
		System.out.println("---login successful----");
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.logoutOfapp(driver);
		System.out.println("----Logout successful-----");
		
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("----Browser closed----");
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("---DB Connection closed---");
		
	}
}
