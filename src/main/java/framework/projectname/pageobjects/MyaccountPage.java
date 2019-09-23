package framework.projectname.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class MyaccountPage {
	
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	private WebDriver driver;
	
	
	@FindBy(xpath="//*[contains(text(),'Order history and details')]")
	WebElement Orderhistoryanddetails;
	
	@FindBy(xpath="//li/a[@href='http://automationpractice.com/index.php?controller=order-slip' and @title='Credit slips']")
	WebElement Mycreditslips;
	
	@FindBy(xpath="//li/a[@href='http://automationpractice.com/index.php?controller=addresses' and @title='Addresses']")
	WebElement MyAddresses;
	
	@FindBy(xpath="//li/a[@href='http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist' and @title='My wishlists']")
	WebElement Mywishlists;
	
	@FindBy(xpath="//li/a[@href='http://automationpractice.com/index.php?controller=identity' and @title='Information']")
	WebElement Mypersonalinformation;
	
	@FindBy(xpath="//li/a[@href='http://automationpractice.com/']")
	WebElement Homebutton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement MyAccount;
	
	public MyaccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		WaitHelper waithelper= new WaitHelper(driver);
		waithelper.waitforelementclickable(MyAccount,ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
			
	}
	
	public void orderhistoryanddetails()
	{
		Orderhistoryanddetails.click();
		logExtentReport("click on orderhistoryanddetails");
	}

	public void MyAddresses() {
		MyAddresses.click();
	}
	
	public void Mypersonalinformation() {
		Mypersonalinformation.click();
	}
	
	public HomePage Homebutton()
	{
		Homebutton.click();
		return new HomePage(driver);
	}
	
	public void Myaccountpageobjects() {
		orderhistoryanddetails();
		MyAddresses();
		Mypersonalinformation();
		Homebutton();
	}
	
	public void logExtentReport(String s1) {
		Testbase.test.log(Status.INFO, s1);
	}

}
