package framework.projectname.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class LoginPage {

	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	private WebDriver driver;

	@FindBy(xpath = "//button[@id='SubmitLogin']/span")
	WebElement alreadyregisteredsignin;
     
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinlink;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		WaitHelper waithelper= new WaitHelper(driver);
		waithelper.waitforelementclickable(signinlink,ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
			
	}
	
	public void signinlink()
	{
		signinlink.click();
		log.info("clicked on signin link");
	}
	
	
	
}
