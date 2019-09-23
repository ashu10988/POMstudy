package framework.projectname.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class HomePage {

	private Logger log = LoggerHelper.getLogger(HomePage.class);
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		WaitHelper waithelper= new WaitHelper(driver);
		//waithelper.waitforelementclickable(signinlink,ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
			
	}

}
