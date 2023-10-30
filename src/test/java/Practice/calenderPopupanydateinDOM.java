package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderPopupanydateinDOM {

	
		public static void main(String[] args) throws Throwable {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			driver.get("https://www.makemytrip.com/");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			Actions act = new Actions(driver);
			act.moveByOffset(20, 20).click().perform();
			Thread.sleep(1000);
			act.moveByOffset(10, 20).click().perform();
			Thread.sleep(1000);
			act.moveByOffset(20, 30).click().perform();
			act.moveByOffset(50, 30).click().perform();
		    driver.findElement(By.xpath("//span[.='Departure']")).click();
			Thread.sleep(1000);
 driver.findElement(By.xpath("//div[@aria-label=\"Wed Oct 04 2023\"]")).click();
			
		

	}

}
