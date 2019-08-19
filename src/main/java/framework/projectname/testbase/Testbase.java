package framework.projectname.testbase;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import framework.projectname.helper.browserconfiguration.BrowserType;
import framework.projectname.helper.browserconfiguration.ChromeBrowser;
import framework.projectname.helper.browserconfiguration.FirefoxBrowser;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.browserconfiguration.waitconfig.PropertyReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.Waithelper;
import framework.projectname.utils.ExtentManager;

public class Testbase {

	public static ExtentReports extent;
	public static ExtentTest test;

	public WebDriver driver;

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
 public void beforetest() {
	 ObjectReader.reader=new PropertyReader();
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
	
	
	
	
	
	
	
}
