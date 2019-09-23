package framework.projectname.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import framework.projectname.helper.assertion.VerificationHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.javascript.JavascriptHelper;
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
	
	@FindBy(xpath="//input[@id='email']")
	WebElement registerdemail;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement enterpassword;
	
	@FindBy(xpath="//button[@id='SubmitLogin']/span")
	WebElement submitlogin;
	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement regestriationEmail;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']/span")
	WebElement CreateAnAccountButton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		WaitHelper waithelper= new WaitHelper(driver);
		waithelper.waitforelementclickable(signinlink,ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
	}
	
	public void clickOnsigninlink()
	{
		signinlink.click();
		log.info("clicked on signin link");
		logExtentReport("clicked on signin link");//this  will add log in extent report 
	}
	
	public void enterAlreadyRegisterdEmail(String emailaddress) {
		registerdemail.sendKeys("emailaddress");
	}
	
	public void enterPassword() {
		enterpassword.sendKeys("password");
	}
	
	public HomePage clickonsubmitbutton()
	{
		JavascriptHelper javascripthelper=new JavascriptHelper(driver);
		javascripthelper.scrollDownvertically();
		submitlogin.click();
		return new HomePage(driver); // we are returning to Homepage 
	}

//	public boolean verifysucessfulllogin() {
//		return new VerificationHelper(driver).isdisplayed(sucessMsgobject);
//	}
	
	public void enterRegistrationEmail() {
		String email= System.currentTimeMillis()+"@gmail.com";// this will create anew email every time
		registerdemail.sendKeys("email");
	}
	
	public RegistrationPage clickOnCreateAccount() {
		
		CreateAnAccountButton.click();
		return new RegistrationPage(driver);
	}
	
	public void loginToApplication(String emailaddress,String password) {
		clickOnsigninlink();
		enterAlreadyRegisterdEmail(emailaddress);
		enterPassword();
		clickonsubmitbutton();
	}
	
	public void logExtentReport(String s1) {
		Testbase.test.log(Status.INFO, s1); // here we create a method to add log in extent report 
	}
	
}
