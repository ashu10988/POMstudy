package framework.projectname.testscripts.loginpage;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import framework.projectname.helper.assertion.AssertionHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.pageobjects.LoginPage;
import framework.projectname.testbase.Testbase;

public class LoginTest extends Testbase {

	private final Logger log= LoggerHelper.getLogger(LoginTest.class);
	
	@Test(description="login with valid credetinals")
	
	public void loginToApplication()
	 {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
        boolean status=login.verifysucessfulllogin();
        log.info(" Login sucessfully and redirectrec to my account page ");
        AssertionHelper.updateTestStatus(status);

	 }
	
}
