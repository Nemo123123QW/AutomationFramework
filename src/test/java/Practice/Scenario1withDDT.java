package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1withDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		//step1: read all the neccessary data
		/*read data from property file*/
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fisp);
		
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		/* read data from excel*/
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fise);
	String LASTNAME = wb.getSheet("contact").getRow(1).getCell(2).getStringCellValue();
	 WebDriver driver=null;
	 
	 //step 2: launch the browser
	 
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

	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
driver.get(URL);
		
		//Step 3: Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
        
		//Step 4: Navigate to Contacts LInk
				driver.findElement(By.linkText("Contacts")).click();
				
				//Step 5: Click on create conatct look up Image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				//Step 6: create conatct
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				//Step 7: Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Validate
				String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
        if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}
			
		
WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Sign Out")).click();
		
		System.out.println("SignOut successful");
		
		
        
        
        
	}

}
