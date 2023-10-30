package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.webDriverUtilities;

public class createNewOrganizationPage extends webDriverUtilities{ //rule 1
	
	//rule 2: declaration
	
	@FindBy(xpath = "//input[@name=\"accountname\"]")private WebElement orgNameEdt;
	@FindBy(xpath="(//input[@title=\"Save [Alt+S]\"])[1]")private WebElement saveBtnEdt;
	@FindBy(name = "accounttype")private WebElement TypeDropDown;
	@FindBy(name = "industry")private WebElement IndNameEdt;
	//rule3: initialization
		public  createNewOrganizationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		
		// rule 4:utilization
		public WebElement getorgNameEdt() {
			return orgNameEdt;
		}
		
		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getSaveBtnEdt() {
			return saveBtnEdt;
		}

		
		public WebElement getTypeDropDown() {
			return TypeDropDown;
		}
		
		
		public WebElement getIndNameEdt(){
			return IndNameEdt;
		}
		
		public WebElement getsaveBtnEdt() {
			return saveBtnEdt;
		}
		
		//business logic
		/**
		 * This method will create new organization with mandatory fields
		 * @param ORGNAME
		 */
		public void createNewOrganization(String ORGNAME) 
		{
			orgNameEdt.sendKeys(ORGNAME);
			saveBtnEdt.click();
		}
		/**
		 * This method will create new organization with industry drop down
		 * @param ORGNAME
		 * @param INDUSTRY
		 */
		public void createNewOrganization(String ORGNAME,String INDUSTRY) 
		{
			orgNameEdt.sendKeys(ORGNAME);
			handleDropDown(IndNameEdt, INDUSTRY);
			saveBtnEdt.click();
		}
		
		
		public void createNewOrganization(String ORGNAME,String INDUSTRY,String TYPE) 
		{
			orgNameEdt.sendKeys(ORGNAME);
			handleDropDown(IndNameEdt, INDUSTRY);
			handleDropDown(TypeDropDown, TYPE);
			saveBtnEdt.click();
		}
		
}
