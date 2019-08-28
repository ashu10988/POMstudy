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

public class RegistrationPage {
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signinlink;
	
	@FindBy(xpath = "//h3[contains(text(),'Create an account')]")
	WebElement createAnAccountText;
	

	@FindBy(xpath = "//input[@id='email_create']")
	WebElement regestriationemail;

	@FindBy(xpath = "//button[@id='SubmitCreate']/span")
	WebElement CreateAnAccountButton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement Firstname;

	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement Lastname;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement AdreessFirstname;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement AdressLastname;
	public RegistrationPage(WebDriver driver) {
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
	
	public void registeraccount()
	{
		regestriationemail.sendKeys("ashu.chaturvedi109@gmail.com");
		CreateAnAccountButton.click();
		
	}
	
	
	
	
	
}
