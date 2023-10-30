package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class consist of all the generic methods of web driver actions
 * @author Namrata
 *
 */
public class webDriverUtilities 
{
	/**
	 * this method will maximize the window
	 * @param driver
	 */
public void maximizeWindow(WebDriver driver) 
{

	 
	driver.manage().window().maximize();//browser launched and maximized
}
/**
 * this method will minimize the window
 * @param driver
 */
public void minimizeWindow(WebDriver driver) 
{
	driver.manage().window().minimize();
}
/**
 * This method will wait for the page to load
 * @param driver
 */
public void waitForPageLoad(WebDriver driver) 
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
/**
 * This method will wait for a particular elemnet to be visible in the DOM
 * @param driver
 * @param element
 */
 public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
	 
 
 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
 wait.until(ExpectedConditions.visibilityOf(element));	 
 }

 /**
  * This method will wait for a particular element is clickable
  * @param driver
  * @param element
  */
 public void waitForElementToBeClickable(WebDriver driver,WebElement element)
 {
	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	 wait.until(ExpectedConditions.elementToBeClickable(element));
 }

 /**
  * this method will handle dropdown by index
  * @param element
  * @param index
  */
public void handleDropDown(WebElement element, int index)
{
	 Select sel = new Select(element);
	 sel.selectByIndex(index);
}
/**
 * This method will handle dropdown by value
 * @param element
 * @param value
 */
public void handleDropDown(WebElement element, String value)
{
	 Select sel = new Select(element);
	 sel.selectByValue(value);
}
/**
 * This method will handle dropdown by visible text
 * @param value
 * @param element
 */
public void handleDropDown(String value,WebElement element)
{
	 Select sel = new Select(element);
	 sel.selectByVisibleText(value);
}
/**
 * This method will mousehover on a particular element
 * @param driver
 * @param element
 */
public void handleMouseHover(WebDriver driver, WebElement element) 
{
	Actions act = new Actions(driver);
	act.moveToElement(element).click().perform();
}

/**
 * This method will rightclick on a particular elemnt
 * @param element
 * @param driver
 */
public void handleMouseHover(WebElement element,WebDriver driver ) 
{
	Actions act = new Actions(driver);
act.contextClick(element).perform();


}
/**
 * This method will click
 * @param driver
 */
public void doubleclick(WebDriver driver ) 
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}
/**
 * this method will move the mouse to particular x & Y coordinate
 * @param driver
 * @param x
 * @param y
 */
public void moveandClick(WebDriver driver) 
{
	Actions act = new Actions(driver);
	act.moveByOffset(10, 10).click().perform();
	
}
/**
 * this method will move the mouse to particular location
 * @param x
 * @param y
 * @param driver
 */
public void handleMouseHover(int x ,int y, WebDriver driver) 
{
	Actions act = new Actions(driver);
	act.moveToLocation(x, y);
}
/**
 * This method will drag and drop the particular element
 * @param driver
 * @param drag
 * @param drop
 */
    public void handleMouseHover(WebDriver driver,WebElement scrEle, WebElement desEle)
{
Actions act = new Actions(driver);
act.dragAndDrop(scrEle,desEle );
}
    /**
     * This method will click and hold the element
     * @param driver
     * @param drag
     */
    public void handleMouseHover1(WebDriver driver,WebElement drag)
    {
    	Actions act = new Actions(driver);
    	act.clickAndHold(drag).perform();
    	
}
    /**
     * This method is used to release the holded elemnt
     * @param drop
     * @param driver
     */
    
    public void handleMouseHover1(WebElement drop,WebDriver driver)
    {
    	Actions act = new Actions(driver);
    	act.release(drop).perform();
    	
    	
}
    /**
     * This method will handle frame by Name or ID
     * @param driver
     * @param x
     */
    
    public void frameHandling(WebDriver driver,String NameorID)
    {
    	driver.switchTo().frame(NameorID);
    }
    
    /**This method will handle frames by index
     * 
     * @param driver
     * @param index
     */
    
    public void frameHandling(WebDriver driver,int index)
    {
    	driver.switchTo().frame(index);
    }
    
    /**
     * This method will handle frames by web element
     * @param driver
     * @param element
     */
    public void frameHandling(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    /**
     * this method will handle scroll by JSE
     * @param driver
     */
    public void scrollHandling(WebDriver driver)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    }
    /**
     * This method will handle scroll down by 2000 units
     * @param driver
     */
    public void scrollBy(WebDriver driver)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,2000);", "");
    }
    
    /**
     * This method will handle scroll up by 2000 units
     * @param driver
     */
    public void scrollUp(WebDriver driver)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollBy(0,-2000);", "");
    }

    /**
     * This method will handle scroll complete page bar height
     * @param driver
     */
    public void scrollTo(WebDriver driver)
    {
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    /**
     * this method will handle alert pop ups accept
     * @param driver
     */
    public void alertPopUp(WebDriver driver)
    {
    	
    	driver.switchTo().alert().accept();
    
    	
    }
    
    /**
     * This method will handle alert popup dismiss
     */
    
    public void alertPopUp1(WebDriver driver)
    {
    	
    	driver.switchTo().alert().dismiss();
    	
    	
    }

    /**
     * this method will fetch the alert text and return to caller
     * @param driver
     * @return
     */
    
    public String getAlertText(WebDriver driver)
    {
    	
    	return driver.switchTo().alert().getText();
    	
    	
    }
    /**
     * this method will switch the window
     * @param driver
     * @param NameorHandle
     */
    
    public void windowHandling(WebDriver driver, String partialWinTitle)
    {
    	
    	//step 1: get all windowIDs
    	Set<String> allWinIDs = driver.getWindowHandles();
    	//step 2: navigate through each window
    	for (String winID : allWinIDs) 
    	{
    		//step 3: switch to ech window and capture the title
			String ActTitle = driver.switchTo().window(winID).getTitle();
			
			//step 4: compare actual title with expected partial title
			if (ActTitle.contains(partialWinTitle)) 
			{
				break;
			}
		}
    }
    
    
    /**
     * this method will take scrsht and return dest path
     * @param driver
     * @param ScreenshootName
     * @return
     * @throws IOException
     */
    
    public String takeScreenShot(WebDriver driver, String ScreenshootName) throws IOException
    {
    	TakesScreenshot ts = (TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);//temprary location
    	 File dest = new File(".\\Screenshoot\\"+ScreenshootName+".png");
    	 Files.copy(src, dest);
    	 
    	 return dest.getAbsolutePath();//used to extend reports
    }
    public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//Step 1: get all the window IDs
		Set<String> allWinIds = driver.getWindowHandles();
		
		//Step 2: Navigate thru each window
		for(String winID:allWinIds)
		{
			//Step 3: switch to each window and capture the title
			String actTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4: Compare act title with expected partial Title
			if(actTitle.contains(partialWinTitle))
			{
				break;
			}
}
    
	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

