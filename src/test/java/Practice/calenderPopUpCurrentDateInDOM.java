package Practice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.javaFileUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderPopUpCurrentDateInDOM {

	
		
		public static void main(String[] args) throws Throwable {
			
			
			
			Date d = new Date();
			String dateNow = d.toString();
			System.out.println(dateNow);
			String[] dArr = d.toString().split(" ");
			String currentDate = dArr[0]+" "+dArr[1]+" "+dArr[2]+" "+dArr[5];
			System.out.println(currentDate);
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.makemytrip.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Actions act = new Actions(driver);
			act.moveByOffset(20, 20).click().perform();
			Thread.sleep(1000);
			act.moveByOffset(10, 20).click().perform();
			Thread.sleep(1000);
			act.moveByOffset(10, 30).click().perform();
		    driver.findElement(By.xpath("//span[.='Departure']")).click();
			 
		    driver.findElement(By.xpath("//div[@aria-label='"+currentDate+"']")).click();
		    
		    
		  
	}
		
		
		

}
