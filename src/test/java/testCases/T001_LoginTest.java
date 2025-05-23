package testCases;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SignupLoginPage;

public class T001_LoginTest extends BaseClass {
	@Test(groups="smoke")
	public void verifyLogin1() {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickLinkSignLogin();
			
			SignupLoginPage slp = new SignupLoginPage(driver);
			slp.getTxtLoginEmail().sendKeys("L6wpYkwItw@gm.com");
			slp.getTxtLoginPassword().sendKeys("password");
			slp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			boolean logged=lp.isUserLogged();
			if(!logged)
			{
				if(slp.getMsgInvalidEmailPassword().isDisplayed())
				logger.info("Login failed - Invalid username or password");	
				Assert.fail();
			}
			Assert.assertEquals(lp.getLoggedUserInfo(), "Logged in as EWGKhjeZEC", "Logged user not matching");
			logger.info(lp.getLoggedUserInfo());	
			lp.clickLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test(groups= "smoke")
	public void verifyLogin2() {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickLinkSignLogin();
			
			SignupLoginPage slp = new SignupLoginPage(driver);
			slp.getTxtLoginEmail().sendKeys("L6wpYkwItw@gm.com");
			slp.getTxtLoginPassword().sendKeys("passwor");
			slp.clickLogin();
			
			
			
			logger.info("running invalid");
			LoginPage lp=new LoginPage(driver);
			boolean logged=lp.isUserLogged();
			if(!logged)
			{
				if(slp.getMsgInvalidEmailPassword().isDisplayed())
				logger.info("Login failed - Invalid username or password");	
				Reporter.log("Login failed - Invalid password");
				Assert.fail();
			}
			Assert.assertEquals(lp.getLoggedUserInfo(), "Logged in as EWGKhjeZEC", "Logged user not matching");
			logger.info(lp.getLoggedUserInfo());	
			lp.clickLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//testends
	
	@Test(groups="smoke")
	public void verifyLogin3() {
		try {
			HomePage hp = new HomePage(driver);
			hp.clickLinkSignLogin();
			
			SignupLoginPage slp = new SignupLoginPage(driver);
			slp.getTxtLoginEmail().sendKeys("6wpYkwItw@gm.com");
			slp.getTxtLoginPassword().sendKeys("password");
			slp.clickLogin();
			
			logger.info("running invalid");
			LoginPage lp=new LoginPage(driver);
			boolean logged=lp.isUserLogged();
			if(!logged)
			{
				if(slp.getMsgInvalidEmailPassword().isDisplayed())
				logger.info("Login failed - Invalid username or password");	
				Reporter.log("Login failed - Invalid Email");
				Assert.fail();
			}
			Assert.assertEquals(lp.getLoggedUserInfo(), "Logged in as EWGKhjeZEC", "Logged user not matching");
			logger.info(lp.getLoggedUserInfo());	
			lp.clickLogout();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
