package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario5 {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888");
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
        driver.findElement(By.id("submitButton")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"][4]")).click();
        driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("NamrataPrakash");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name=\"button\"]")).click();
        
        
        Thread.sleep(1000);
       WebElement org = driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"][3]"));
     Actions act3 = new Actions(driver);
       act3.moveToElement(org).click().perform();
       driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
       driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("Qspiders");
       Thread.sleep(1000);
       driver.findElement(By.xpath("//input[@name=\"button\"]")).click();
       
       
   
       
        driver.close();
           
       System.out.println("program successful");
       
	}

}
