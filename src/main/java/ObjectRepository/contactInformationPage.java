package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactInformationPage {//rule 1
	
	//rule 2: declaration
	@FindBy(xpath = "//span[@class=\"dvHeaderText\"]")private WebElement CntctHeaderText;
	
	//rule 3: initialization
	
	public contactInformationPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	
	//rule 4: initialization
	public WebElement getCntctHeaderText1() {
		   return CntctHeaderText;
	   }


	
	
	//business library
	/**
	 * this method captures the header and returns to caller
	 * @return
	 */
	 public String getCntctHeaderText() {
		 return CntctHeaderText.getText();
	 }
	 
	 
	 
}
