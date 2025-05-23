package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignupLoginPage;
import pageObjects.SignupPage;

public class T002_SignupLoginUITest extends BaseClass {
	@Test(groups="sanity")
	public void verifyUI() {
		HomePage hp=new HomePage(driver);
		hp.clickLinkSignLogin();
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		Assert.assertTrue(slp.getTxtSignUpEmail().isDisplayed());
		Assert.assertTrue(slp.getTxtName().isDisplayed());
		Assert.assertTrue(slp.getBtnSignup().isDisplayed());
		String name =getRandomAlphabetic(10);
		String email=getRandomAlphanumric(15)+"@Test.com";
		slp.getTxtName().sendKeys(name);
		slp.getTxtSignUpEmail().sendKeys(email);
		Assert.assertTrue(slp.getBtnSignup().isEnabled());
		slp.clickSignup();
		SignupPage sp = new SignupPage(driver);
		Assert.assertTrue(sp.getLblEnterAcctinfo().isDisplayed());
		
	}

}
