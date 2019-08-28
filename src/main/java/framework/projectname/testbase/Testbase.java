package framework.projectname.testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
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
import org.testng.annotations.AfterTest;
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
import framework.projectname.helper.resource.Resourcehelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.utils.ExtentManager;

public class Testbase {

	public static ExtentReports extent;
	public static ExtentTest test;
	public WebDriver driver;
	public static File reportDirectery;

	private Logger log = LoggerHelper.getLogger(Testbase.class);

	@BeforeSuite
	public void beforesuit() {
		extent = ExtentManager.getInstance();
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	}

	@BeforeClass
	public void beforeclass() {
		test = extent.createTest(getClass().getSimpleName());
	}

	@BeforeTest
	public void beforetest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectery = new File(Resourcehelper.getResourcepath("/src/main/Resources/screenshot"));
		setUpDriver(ObjectReader.reader.getBroswerType());
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "test started");

	}

	@AfterMethod
	public void AfterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath=capturescreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
			
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + " is passed");
			String imagePath=capturescreen(result.getName(),driver);
			test.addScreenCaptureFromPath(imagePath);

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getThrowable());

		}
		extent.flush();
	}
	
	@AfterTest
	public void afterTest() throws Exception{
		if(driver!=null){
			driver.quit();
		}
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

	// This method will setup driver
	public void setUpDriver(BrowserType btype) throws Exception {
		driver = getBrowseObject(btype);
		log.info("Intiliaze webdriver : " + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitwait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		wait.pageloadtime(ObjectReader.reader.getExplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	// Screencapture method

	public String capturescreen(String fileName, WebDriver driver) {
		if (driver == null) {
			log.info(" driver is null so cant take screenshot");
			return null;
		}
		if (fileName == "") {
			fileName = "Blank";
		}

		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File sourcefile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			destFile = new File(reportDirectery +"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(sourcefile.toPath(), destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'/></a>");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return destFile.toString();

	}
	
	// This method will capture screenshot of all pages 
	
	public void getNavigationScreenshot(WebDriver driver)
	{
		String screen=capturescreen("", driver);
		try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
