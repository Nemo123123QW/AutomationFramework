package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("http://localhost:8888");
	
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"][3]")).click();
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/btnL3Add.gif\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys("Qspiders");
        Thread.sleep(1000);
        WebElement industry = driver.findElement(By.xpath("//select[@name=\"industry\"]"));
        industry.click();
       
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        industry.sendKeys(Keys.ARROW_DOWN);
        
        industry.click();
        
       WebElement type = driver.findElement(By.xpath("//select[@name=\"accounttype\"]"));
       type.click();
       type.sendKeys(Keys.ARROW_DOWN);
       type.sendKeys(Keys.ARROW_DOWN);
       type.sendKeys(Keys.ARROW_DOWN);
       type.click();
       driver.findElement(By.xpath("//input[@name=\"button\"]")).click();
       Thread.sleep(1000);
      WebElement data = driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"));
      Thread.sleep(1000);
       Actions act = new Actions(driver);
       act.moveToElement(data).click().perform();
       Thread.sleep(1000);
      
        driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
        driver.close();
        System.out.println("program successful");
        
	}

}
