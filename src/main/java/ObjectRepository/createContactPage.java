package ObjectRepository;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webDriverUtilities;

public class createContactPage extends webDriverUtilities{ //rule 1
	
	//rule 2:Declaration
	
	@FindBy(xpath="(//input[@class=\"detailedViewTextBox\"])[3]") WebElement LastNameEdt;
	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[1]")
	private WebElement orgNameSelectBtnEDt;
	
	@FindBy(xpath = "//input[@class=\"crmButton small save\"]")private WebElement saveBtnEdt;
	@FindBy(xpath = "//input[@id=\"search_txt\"]")private WebElement OrgsearchEdt;
	@FindBy(xpath="//input[@name=\"search\"]")private WebElement OrgSearchBtn;
	
	//rule 3:initialization
	public createContactPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	//rule 4: utilization
	
	
	public WebElement getLastNameEdt(){
		return LastNameEdt;
	   }

	public WebElement getOrgNameSelectBtnEDt() {
		return orgNameSelectBtnEDt;
	}

	public WebElement getSaveBtnEdt() {
		return saveBtnEdt;
	}

	public WebElement getorgNameSelectBtnEDt() {
		return orgNameSelectBtnEDt;
	   }
	public WebElement getsaveBtnEdt(){
		return saveBtnEdt;
	
	   }
	
	public WebElement getOrgsearchEdt() {
		return OrgsearchEdt;
	}
	
	public WebElement getOrgSearchBtn() {
		return OrgSearchBtn;
	}
	//business lib
	/**
	 * This method will create new contact using mandatory fields
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		
	LastNameEdt.sendKeys(LASTNAME);
	saveBtnEdt.click();
}
 public void createNewContact(WebDriver driver,String LASTNAME ,String ORGNAME) {
	 LastNameEdt.sendKeys(LASTNAME);
	 orgNameSelectBtnEDt.click();
	 switchToWindow(driver, "Accounts");
	 OrgsearchEdt.sendKeys(ORGNAME);
	 OrgSearchBtn.click();
	 driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
	 switchToWindow(driver, "Contacts");
	 saveBtnEdt.click();
}


 
}
