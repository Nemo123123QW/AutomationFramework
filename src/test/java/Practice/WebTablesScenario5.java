package Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTablesScenario5 {

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
        driver.findElement(By.xpath("(//a[text()=\"Organizations\"])[1]")).click();
        driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[9]/td[1]")).click();
        String orgname = driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[9]/td[3]")).getText();

        System.out.println(orgname);
         driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
         Thread.sleep(1000);
         Alert alt = driver.switchTo().alert();
         Thread.sleep(1000);
         alt.accept();
        
	}

}
