package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage { //rule 1
	
	//rule2: declaration
	
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")private WebElement orgIdEdt;
	
	//rule 3:
	public OrgInfoPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }

	
	//rule 4:
	
	public WebElement getorgIdEdt() {
		return orgIdEdt;
	}


	public WebElement getOrgIdEdt() {
		return orgIdEdt;
	}
	
	//business logic
	/**
	 * This method will capture the header text and return it to the caller
	 * @return
	 */
	public String getHeaderText() {
		return orgIdEdt.getText();
	}
}
