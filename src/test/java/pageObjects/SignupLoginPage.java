package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupLoginPage extends BasePage {
	//----------- Constructor---------------
	public SignupLoginPage(WebDriver driver) {
		super(driver);
	}
	// ----------Locators -----------------
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement txtName;

	@FindBy(xpath="//form[@action='/signup']/input[@name='email']")
	private WebElement txtSignUpEmail;
	
	@FindBy(xpath="//button[text()='Signup']")
	private WebElement btnSignup;
	
	//---login elements ---
	
	@FindBy(xpath="//form[@action='/login']/input[@name='email']")
	private WebElement txtLoginEmail;

	@FindBy(xpath="//form[@action='/login']/input[@name='password']")
	private WebElement txtLoginPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//p[text()=\"Your email or password is incorrect!\"]")
	private WebElement msgInvalidEmailPassword;
	
	//------------- Getters --------------------------
	
	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtSignUpEmail() {
		return txtSignUpEmail;
	}

	public WebElement getBtnSignup() {
		return btnSignup;
	}

	public WebElement getTxtLoginEmail() {
		return txtLoginEmail;
	}

	public WebElement getTxtLoginPassword() {
		return txtLoginPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getMsgInvalidEmailPassword() {
		return msgInvalidEmailPassword;
	}
	
	//------------------ Page Methods ----------------------
	public void setName(String fname) {
		txtName.sendKeys(fname);
	}	
	
	public void setEmail(String email) {
		txtSignUpEmail.sendKeys(email);
	}
	
	public void clickSignup() {
		btnSignup.click();
	}
	
	public void setLoginEmail(String email) {
		txtLoginEmail.sendKeys(email);
	}	
	
	public void setLoginPassword(String password) {
		txtLoginPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	public boolean isInvalidCredentials() {
		return msgInvalidEmailPassword.isDisplayed();
	}
	
	public String getMsgInvalidCredentials() {
		return msgInvalidEmailPassword.getText();
	}

}
