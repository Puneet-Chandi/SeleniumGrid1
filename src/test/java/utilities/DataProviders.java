package utilities;

import java.lang.System.Logger;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	public org.apache.logging.log4j.Logger logger;
	
	 @DataProvider(name="dp")
	  Object[][] loginData()
	  {
		  Object[][] data= {
				  {"L6wpYkwItw@gm.com","password","EWGKhjeZEC","valid"},
				  {"L6wpYkwItw@gm.com","passw","EWGKhjeZEC","invalid"},
				  {"L6wpYkwItw@yah.com","password","EWGKhjeZEC","invalid"},
				  {"L6wpYkwItw@gm.com","password","EWGKhjeZEC","invalid"},  
				  {"L6wpYkwItw@gm.com","assword","EWGKhjeZEC","valid"}
		  };		  
		  return data;
	  }
	 
	 @DataProvider(name="dp2", indices={2,3})
	  Object[][] loginData2()
	  {
		  Object[][] data= {
				  {"email1", "password1", 35},
				  {"email2", "password2", 55},
				  {"email3", "password3", 43},
				  {"email4", "password4", 53}			  
		  };		  
		  return data;
	}
	
	 @DataProvider(name="dp3")
	 public Object[][] getData() throws Exception{
		 logger = LogManager.getLogger(this.getClass());
		 
		 String path =".\\testdata\\login.xlsx";
		 
		 ExcelUtils xlutil=new ExcelUtils(path);
		 
		 int totalrows = xlutil.getRowCount("Sheet1");
		// System.out.println(totalrows);
		 int totalcols=xlutil.getCellCount("Sheet1",1);
		// System.out.println(totalcols);
		 Reporter.log("This is TesTNG Report logger");
		 logger.info("This is logger");
		 
		 String logindata[][]=new String[totalrows][totalcols];
		 
		 for(int i=1;i<=totalrows;i++) {
			 for(int j=0;j<totalcols;j++) {
				 logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
				// System.out.println(xlutil.getCellData("Sheet",i,j));
				 }
		 }
         return logindata;

		}
	
}
