package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webDriverUtilities;

public class HomePage extends webDriverUtilities { //rule 1
	
	//rule 2: declaration
	 @FindBy(xpath = "(//a[text()=\"Organizations\"])[1]")
	 private WebElement OrgLinkEdt;
	 
	 
	 @FindBy(xpath = "//a[text()=\"Contacts\"]")private WebElement ContactslinkEdt;
	 
	 @FindBy(xpath = "(//img[@style=\"padding: 0px;padding-left:5px\"])[1]")
	 private WebElement adminBtnEdt;
	 
	 @FindBy(xpath = "//a[text()=\"Sign Out\"]")private WebElement signOutEdt;
	 
	//rule 3: initialization
	 
	 public HomePage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	// rule 4: utilization
	 
   public WebElement getOrgLinkEdt(){
	return OrgLinkEdt;
   }
   public WebElement getContactslinkEdt() {
	return ContactslinkEdt;
}

   public WebElement getAdminBtnEdt() {
		return adminBtnEdt;
	}

   
   public WebElement getsignOutEdt() {
		return signOutEdt;
	}
   
public WebElement getSignOutEdt() {
	return signOutEdt;
}

public WebElement getadminBtnEdt() {
	   return adminBtnEdt;
   }

//Business logic

/**
 * This method will click on orglink
 */
public void clickOnOrgLinkEdt() {
	OrgLinkEdt.click();
}

/** 
 * This method will click on contacts links
 */
public void clickOnContactslinkEdt() {
	ContactslinkEdt.click();
}
/**
 * This method will signout the application
 * @param driver
 * @throws InterruptedException
 */
public void logoutOfapp(WebDriver driver) throws InterruptedException {
	handleMouseHover(driver,  adminBtnEdt);
	Thread.sleep(1000);
	signOutEdt.click();
}

   
}