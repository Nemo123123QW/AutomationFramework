package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableScenario1 {

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
    driver.findElement(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[1]")).click();
     

	}

}
