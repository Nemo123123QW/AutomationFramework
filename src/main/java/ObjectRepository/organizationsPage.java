package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationsPage { //rule1
	
	//rule2: declaration
	
	@FindBy(xpath = "//img[@title=\"Create Organization...\"]")private WebElement createOrgButnEdt;
	
	
	//rule 3: initialization
	 
		 public WebElement getCreateOrgButnEdt() {
		return createOrgButnEdt;
	}

		public organizationsPage(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
		 
		// rule 4: utilization
		 
		   public WebElement getcreateOrgButnEdt(){
			return createOrgButnEdt;
		   }
		   
		   
		   //business logic
		   /**
		    * This method will click on the Create org lookup image
		    */
		   public void clickOncreateOrgButnEdt()
		   {
			   createOrgButnEdt.click();
		   }

}
