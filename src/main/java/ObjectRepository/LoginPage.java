package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage { //rule 1
	
	//rule2:declaration
	@FindBy(name = "user_name")private WebElement userNameEdt;
	
	@FindBy(name="user_password")private WebElement psswrdEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement loginBtn;

	
	
	//step 3: initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	//rule 4: Utilisation
	
	


	public WebElement getuserNameEdt() {
		return userNameEdt;
	}
	

	public WebElement getpsswrdEdt() {
		return psswrdEdt;
	}
	
	public WebElement getloginBtn() {
		return loginBtn;
	}




	public WebElement getUserNameEdt() {
		return userNameEdt;
	}




	public WebElement getPsswrdEdt() {
		return psswrdEdt;
	}




	public WebElement getLoginBtn() {
		return loginBtn;
	}

/**
 * This method will login to application
 * used for code optimization
 * @param USERNAME
 * @param PASSWORD
 */
	
//bussiness libraries--generic method as per project requirement
	
	public void loginToApp(String USERNAME,String PASSWORD )
	{
		userNameEdt.sendKeys(USERNAME);
		psswrdEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

	


	
	
}
