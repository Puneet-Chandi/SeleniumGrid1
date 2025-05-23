package testCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import utilities.DataProviders;

public class T004_ReadDataTest {
	
	@Test(dataProvider="dp2", dataProviderClass=DataProviders.class, groups="datadriven")
	public void readDataProvider1(String fName, String lName, int age) {
		System.out.println(fName+" "+lName+" "+age);
		Reporter.log("insede T004");
		
	}
	
	@Test(dataProvider="dp3", dataProviderClass=DataProviders.class, groups="datadriven")
	public void readDataProvider2(String Email, String Password, String Name, String Status) {
		System.out.println(Email+" "+Password+" "+Name+" "+Status);
		
	}

}
