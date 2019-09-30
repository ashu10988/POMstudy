package framework.projectname.testscripts.RegistrationTest;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import framework.projectname.helper.assertion.AssertionHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.pageobjects.LoginPage;
import framework.projectname.pageobjects.MyaccountPage;
import framework.projectname.pageobjects.RegistrationPage;
import framework.projectname.testbase.Testbase;

public class RegistrationTest extends Testbase{

	private final Logger log= LoggerHelper.getLogger(RegistrationTest.class);
	
	
	 @Test(description="Email registration")
	 public void emailRegistration() throws InterruptedException
	 {
		 // enter url
		 getApplicationUrl(ObjectReader.reader.getUrl());
		 
		 // Login page data
		 LoginPage loginpageobj= new LoginPage(driver);
		 loginpageobj.clickOnsigninlink();
		 Thread.sleep(20);
		 loginpageobj.clickOnCreateAccount();
		 //enter registration data
		 RegistrationPage registerpage= new RegistrationPage(driver);
		 registerpage.registernewuser();
		 MyaccountPage myaccountpage= new MyaccountPage(driver);
		 boolean status= myaccountpage.welcomeText();
		 AssertionHelper.updateTestStatus(status);
		 
	 }
	
	
}
