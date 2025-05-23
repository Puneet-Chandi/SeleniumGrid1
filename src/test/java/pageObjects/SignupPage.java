package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testCases.BaseClass;

public class SignupPage extends BasePage{
	//----------- Constructor----------------
	public SignupPage(WebDriver driver) {
		super(driver);
	}

	//-------- Locators ----------------------
	@FindBy(xpath="//b[text()='Enter Account Information']")
	private WebElement lblEnterAcctInfo;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	private WebElement chkTitleMr;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	private WebElement chkTitleMrs;
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement txtName;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//select[@id='days']")
	private WebElement selectDay;
	
	@FindBy(xpath="//select[@id='months']")
	private WebElement selectMonth;
	
	@FindBy(xpath="//select[@id='years']")
	private WebElement selectYear;
	
	@FindBy(xpath="//input[@id='newsletter']")
	private WebElement chkNewsLetter;
	
	@FindBy(xpath="//input[@id='first_name']")
	private WebElement txtFname;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement txtLname;
	
	@FindBy(xpath="//input[@id='company']")
	private WebElement txtCompany;
	
	@FindBy(xpath="//input[@id='address1']")
	private WebElement txtAddress1;
	
	private @FindBy(xpath="//input[@id='address2']")
	WebElement txtAddress2;
	
	private @FindBy(xpath="//select[@id='country']")
	WebElement selectCountry;
	
	private @FindBy(xpath="//input[@id='state']")
	WebElement txtState;
	
	private @FindBy(xpath="//input[@id='city']")
	WebElement txtCity;
	
	private @FindBy(xpath="//input[@id='zipcode']")
	WebElement txtZipCode;
	
	private @FindBy(xpath="//input[@id='mobile_number']")
	WebElement txtMobile;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement btnCreateAccount;
	
	@FindBy(xpath="//b[text()='Account Created!']")
	private WebElement msgAccountCreated;
	
	@FindBy(xpath="//p[text()='Congratulations! Your new account has been successfully created!']")
	private WebElement msgCongrats;
	
	//------------ Getters ---------------------------------

	public WebElement getLblEnterAcctinfo() {
		return lblEnterAcctInfo;
	}
	
	public WebElement getChkTitleMr() {
		return chkTitleMr;
	}

	public WebElement getChkTitleMrs() {
		return chkTitleMrs;
	}

	public WebElement getTxtName() {
		return txtName;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getSelectDay() {
		return selectDay;
	}

	public WebElement getSelectMonth() {
		return selectMonth;
	}

	public WebElement getSelectYear() {
		return selectYear;
	}

	public WebElement getChkNewsLetter() {
		return chkNewsLetter;
	}

	public WebElement getTxtFname() {
		return txtFname;
	}

	public WebElement getTxtLname() {
		return txtLname;
	}

	public WebElement getTxtCompany() {
		return txtCompany;
	}

	public WebElement getTxtAddress1() {
		return txtAddress1;
	}

	public WebElement getTxtAddress2() {
		return txtAddress2;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public WebElement getTxtState() {
		return txtState;
	}

	public WebElement getTxtCity() {
		return txtCity;
	}

	public WebElement getTxtZipCode() {
		return txtZipCode;
	}

	public WebElement getTxtMobile() {
		return txtMobile;
	}

	public WebElement getBtnCreateAccount() {
		return btnCreateAccount;
	}

	public WebElement getMsgAccountCreated() {
		return msgAccountCreated;
	}

	public WebElement getMsgCongrats() {
		return msgCongrats;
	}
	
	//---------------- Page Methods --------------
	
	public void setTitleMale() {
		chkTitleMr.click();
	}
	public void setTitleFemale() {
		chkTitleMrs.click();
	}
	public void getName() {
		txtName.getAttribute("value");
	}
	public void getEmail() {
		txtEmail.getAttribute("value");
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setDay(String day) {
	BaseClass.SelectByValue(selectDay, day);
	}
	public void setMonth(String month) {
	BaseClass.SelectByValue(selectMonth, month);
	}
	public void setYear(String year) {
	BaseClass.SelectByValue(selectYear, year);
	}
	public void chkNewsLetter() {
		chkNewsLetter.click();
	}	
	public void setFname(String fname) {
		txtFname.sendKeys(fname);
	}	
	public void setLname(String lname) {
		txtLname.sendKeys(lname);
	}
	public void setCompany(String company) {
		txtCompany.sendKeys(company);
	}
	public void setAddress1(String address1) {
		txtAddress1.sendKeys(address1);
	}
	public void setAddress2(String address2) {
		txtAddress2.sendKeys(address2);
	}
	public void setCountry(int index) {
	BaseClass.SelectByIndex(selectCountry,index);;
	}
	public void setState(String state) {
		txtState.sendKeys(state);
	}
	public void setCity(String city) {
		txtCity.sendKeys(city);
	}
	public void setZip(String zip) {
		txtZipCode.sendKeys(zip);
	}
	public void setMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}
	public void clickCreateAccount() {
		btnCreateAccount.click();
	}
	public String getLblAccountCreated() {
		return msgAccountCreated.getText();
	}
	public String getLblCongrats() {
		return msgCongrats.getText();
	}

	
	
		
}
