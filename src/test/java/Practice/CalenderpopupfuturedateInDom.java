package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderpopupfuturedateInDom {

	public static void main(String[] args) throws InterruptedException {
		
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
	 // navigate to any future Date date in calendar
	 		Thread.sleep(1000); 
	 		
	 		for(;;)//1 2 3 4 5
	 		{
	 			try 
	 			{ //not visible - exception - visible - click()
	 				driver.findElement(By.xpath("//div[@aria-label=\"Thu Jan 04 2024\"]")).click(); // No such element exception
	 				break;
	 			} 
	 			catch (Exception e) 
	 			{//click on next month
	 				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
	 				Thread.sleep(1000);
	 			}
	 			
	 			System.out.println("program successful");
	 			driver.close();
	 		}
		 
	}

}
