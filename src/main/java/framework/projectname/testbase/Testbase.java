package framework.projectname.testbase;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.utils.FileUtil;
import com.google.common.io.Files;

import framework.projectname.helper.browserconfiguration.BrowserType;
import framework.projectname.helper.browserconfiguration.ChromeBrowser;
import framework.projectname.helper.browserconfiguration.FirefoxBrowser;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.browserconfiguration.waitconfig.PropertyReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.resource.Resourcehelper;
import framework.projectname.helper.wait.Waithelper;
import framework.projectname.utils.ExtentManager;

public class Testbase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static File reportDirectory;

	private Logger log = LoggerHelper.getLogger(Testbase.class);

	@BeforeSuite
	public void beforesuit() {
		extent = ExtentManager.getReporter();
	}

	@BeforeClass
	public void beforeclass() {
		test = extent.createTest(getClass().getName());
	}
 @BeforeTest
 public void beforetest() throws Exception {
	 ObjectReader.reader=new PropertyReader();
	 reportDirectory= new File(Resourcehelper.getResourcepath("/src/main/Resources/screenshot"));
	 setUpDriver(ObjectReader.reader.getBroswerType());
 }
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "test started");

	}

	@AfterMethod
	public void AfterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is passed");

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());

		}
		extent.flush();
	}

	// creating browser objects to launch browser

	public WebDriver getBrowseObject(BrowserType btype) throws Exception {

		try {
			switch (btype) {
			case Chrome:
				// get object of Chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions option = chrome.getChromeOptions();
				return chrome.getChromeDriver(option);

			case Firefox:
				// get object of Firefox browser class
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				FirefoxOptions options = firefox.getFirefoxOptions();
				return firefox.getFirefoxDriver(options);

			default:
				throw new Exception("browser Driver not found in testbase" + btype.name());
			}
		}

		catch (Exception e) {
			log.info(e.getMessage());
			throw e;

		}

	}

	//This method will setup driver
	public void setUpDriver(BrowserType btype) throws Exception {
		driver=getBrowseObject(btype);
		log.info("Intiliaze webdriver : "+driver.hashCode());
		Waithelper wait = new Waithelper(driver);
		wait.setImplicitwait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		wait.pageloadtime(ObjectReader.reader.getExplicitWait(),TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	//Screencapture method 
	
	public String capturescreen(String fileName)
	{
		if(driver==null)
		{
			log.info(" driver is null so cant take screenshot");
			return null;
		}
		if(fileName=="")
		{
			fileName="Blank";
		}
		
		File destFile= null;
		Calendar calendar = Calendar.getInstance();
		 SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		  File sourcefile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  
		  try {
			  
			  destFile= new File(reportDirectory+"/"+fileName +"_"+formater.format(calendar.getTime())+".png");
			  Files.copy(sourcefile, destFile);
			 Reporter.log("<img src='"+destFile+"'height='100' width='100'/>");
			 Reporter.log("<a href="+destFile+"></a>");
			 
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		
		return destFile.toString();
		
		
	}
	
	
	
	
	
	
}
