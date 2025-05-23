package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//--------- Constructor ------------------
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//---------------Locators---------------------------
	@FindBy(xpath="//ul[contains(@class,'navbar-nav')]//a[contains(text(),'Logged in as')]")
    private WebElement msgLoggedUser;
	
	@FindBy(xpath="//ul[contains(@class,'navbar-nav')]//a[contains(text(),'Logout')]")
	private WebElement linkLogout;
	
	//------------ Getters --------------------	
	
	public WebElement getMsgLoggedUser() {
		return msgLoggedUser;
	}

	public WebElement getLinkLogout() {
		return linkLogout;
	}
	
	//------------------- Page Methods ----------------------

	public boolean isUserLogged() {
		try {
			return msgLoggedUser.isDisplayed();
		}catch(Exception e) {
			return false;
		}		
	}
	
	public String getLoggedUserInfo() {
		return msgLoggedUser.getText();
	}
	public void clickLogout() {
		linkLogout.click();
	}
	

}
