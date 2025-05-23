package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignupLoginPage;
import pageObjects.SignupPage;

public class T003_SignupUITest extends BaseClass{
	
	@Test(groups="smoke")
	public void verifySignupPageUI() {
		HomePage hp=new HomePage(driver);
		hp.clickLinkSignLogin();
		
		SignupLoginPage slp = new SignupLoginPage(driver);
		String name =getRandomAlphabetic(10);
		String email=getRandomAlphanumric(15)+"@Test.com";
		slp.getTxtName().sendKeys(name);
		slp.getTxtSignUpEmail().sendKeys(email);
		slp.clickSignup();
		
		SignupPage sp = new SignupPage(driver);
		Assert.assertTrue(sp.getLblEnterAcctinfo().isDisplayed());
		logger.info(sp.getLblEnterAcctinfo().getText()+" is Displaying");
		
		Assert.assertEquals(sp.getTxtName().getAttribute("value"),name);
		logger.info(sp.getTxtName().getAttribute("value") +" is matching with "+name);
		
		Assert.assertEquals(sp.getTxtEmail().getAttribute("value"),email);
		logger.info(sp.getTxtEmail().getAttribute("value") +" is matching with "+email);
	}

}
