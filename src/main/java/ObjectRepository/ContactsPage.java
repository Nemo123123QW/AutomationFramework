package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {//rule 1
	
	//rule2: declaration
	
	
	
	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")private WebElement createContactBtnEdt;
	
	//rule 3: initialization
	
	public WebElement getCreateContactBtnEdt() {
		return createContactBtnEdt;
	}


	public ContactsPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	
	//rule 4: utilization
	 public WebElement getcreateContactBtnEdt(){
			return createContactBtnEdt;
		   }
	 
	 //business library
	 /**
	  * this method will click on createcontact lookup image
	  */
	 public void clickOncreateContactBtnEdt() {
		 createContactBtnEdt.click();
	 }

}
