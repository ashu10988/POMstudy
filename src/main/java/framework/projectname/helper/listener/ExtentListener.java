package framework.projectname.helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.utils.ExtentManager;

public class ExtentListener implements ITestListener {

	private Logger log = LoggerHelper.getLogger(ExtentListener.class);
	public static ExtentReports extent;
	public static ExtentTest test;

	public void onStart(ITestContext context) {
//		extent = ExtentManager.getInstance();
//		test = extent.createTest(context.getName());
		Reporter.log(context.getName() + "test Started");
		log.info(context.getName() + "test Started");
	}

	public void onFinish(ITestContext context) {
		// extent.flush();
		Reporter.log(context.getName() + "Test Finished");
		log.info(context.getName() + "test Finshed");
	}

	public void onTestStart(ITestResult result) {
//		test.log(Status.INFO, result.getName() + "started..");
		Reporter.log(result.getMethod().getMethodName() + "test started");
		log.info(result.getMethod().getMethodName() + "test started");
	}

	public void onTestSuccess(ITestResult result) {
//		test.log(Status.PASS, result.getName() + " Passed");
		Reporter.log(result.getMethod().getMethodName() + "test Passed");
		log.info(result.getMethod().getMethodName() + "test passed");
	}

	public void onTestFailure(ITestResult result) {
//		test.log(Status.FAIL, result.getThrowable() + "Failed");
		Reporter.log(result.getMethod().getMethodName() + "test Failed" + result.getThrowable());
		log.error(result.getMethod().getMethodName() + "test Failed" + result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
//		test.log(Status.SKIP, result.getThrowable() + "skipped");
		Reporter.log(result.getMethod().getMethodName() + "test skipped" + result.getThrowable());
		log.warn(result.getMethod().getMethodName() + "test skipped" + result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
