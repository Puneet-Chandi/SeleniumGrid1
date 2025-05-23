package testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;  //Logger is interface
	public Properties prop;
	
	
	@Parameters({"os","browser"})
	@BeforeClass(groups= {"smoke","sanity","datadriven"})
 	public void setup(String os, String br) throws IOException {
		
		//os="windows"; br="chrome";
		
		//Loading config.properties
		
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		
		prop=new Properties();
		prop.load(fis);
		
			
		logger = LogManager.getLogger(this.getClass());  // getting logger for current class
	
		//--------- For Remote execution -------------------------
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {				
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			}else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
				}
			else if(os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
				}
			else {System.out.println("No Matching os found");
			return;
			}
		
		//browser
				switch(br.toLowerCase()) {
				case "chrome": capabilities.setBrowserName("chrome");break;
				case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
				case "firefox": capabilities.setBrowserName("firefox");break;
				default: System.out.println("No Matching browser found");return;
				}//switch ends
				
				driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
						
		}//end if
		
		//------------ for local execution ------- 
		if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
				switch(br.toLowerCase()) {
				case "chrome":   driver=new ChromeDriver();break;
				case "edge":     driver=new EdgeDriver();break;
				case "firefox":  driver=new FirefoxDriver();break;
				default:logger.info("Invalid Browser Name");return;	 // return will exit from current test case.	
		        }	
	     }// local execution if ends
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("appURL"));
		driver.manage().window().maximize();
		logger.info("Application is launched successfully");
		
	}
	
	@AfterClass(groups= {"smoke","sanity","datadriven"})
	public void tearDown() {
		driver.quit();		
		logger.info("Browser is closed");
	}
	
	//---------------- SELECT -----------------
	public static void SelectByValue(WebElement ele, String val) {
		Select opt = new Select(ele);
		opt.selectByValue(val);	
	}
	public static void SelectByVisibleText(WebElement ele, String val) {
		Select opt = new Select(ele);
		opt.selectByVisibleText(val);
	}
	public static void SelectByIndex(WebElement ele, int index) {
		Select opt = new Select(ele);
		opt.selectByIndex(index);
	}
	
	//--------------- RANDOM Strings---------------
	Random r = new Random();
	
	public String getRandomAlphabetic(int charcount) {
		return RandomStringUtils.randomAlphabetic(charcount);
	}
	public String getRandomAlphanumric(int charcount) {
		return RandomStringUtils.randomAlphanumeric(charcount);
	}
	public String getRandomNumber(int count) {
		return RandomStringUtils.randomNumeric(count);		
	}
	public String getRandomNumberInRange(int min, int max) {
		return String.valueOf(r.nextInt(min, max));
	}
	//------------------ JavascriptExecutor ---------------
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	public Object scrollToElement(WebElement ele) {
			try {
					return jse.executeScript("arguments[0].scrollIntoView(true)",ele);
				}catch(Exception e) {
					return e;
				}
	}
	public Object scrollToBottom() {
		return jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public Object scrollToTop() {
		return jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	//----------------------- Take Screenshot -----------------------------
	
	public String captureScreen (String tname) throws IOException {
		String timeStamp = new SimpleDateFormat ("yyyyMMddhhmmss").format(new Date()) ;
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp;
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
	}
}
