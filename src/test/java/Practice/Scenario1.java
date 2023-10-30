package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenario1 {

	
	public static void main(String[] args) throws Throwable {
		
		//launch browser
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		
		driver.get("http://localhost:8888");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name=\"user_name\"]")).sendKeys("admin");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"user_password\"]")).sendKeys("admin");
		Thread.sleep(1000);
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.xpath("//td[@class=\"tabUnSelected\"][4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("NamrataPrakash");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name=\"button\"]")).click();
        
        driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()=\"Sign Out\"]")).click();
        //driver.close();
        System.out.println("program successful");
        
	}

}
