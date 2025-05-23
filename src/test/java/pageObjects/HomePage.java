package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//----- Constructor -----------------
public class HomePage extends BasePage {
	public HomePage(WebDriver driver){
		super(driver);
	}

//-------- Locators ------------------
	@FindBy(xpath="//a[@href='/login']")
	private WebElement linkSignLogin;
	
//-------- Getter ------------------
	public WebElement getLinkSignLogin() {
		return linkSignLogin;
	}
//---------- Page Methods ------------------
	
	public void clickLinkSignLogin() {
		getLinkSignLogin().click();
	}

}
