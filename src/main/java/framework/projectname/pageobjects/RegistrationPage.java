package framework.projectname.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class RegistrationPage {
	private Logger log = LoggerHelper.getLogger(RegistrationPage.class);
	private WebDriver driver;

	@FindBy(xpath = "//input[@id='customer_firstname']")
	WebElement Firstname;

	@FindBy(xpath = "//input[@id='customer_lastname']")
	WebElement Lastname;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement Password;

	@FindBy(xpath = "//input[@id='firstname']")
	WebElement AddressFirstname;

	@FindBy(xpath = "//input[@id='lastname']")
	WebElement AddressLastname;

	@FindBy(xpath = "//input[@id='address1']")
	WebElement Address;

	@FindBy(xpath = "//input[@id='city']")
	WebElement City;

	@FindBy(xpath = "//select[@id='id_state']")
	WebElement State;

	@FindBy(xpath = "//input[@id='postcode']")
	WebElement Zipcode;

	@FindBy(xpath = "//select[@id='id_country']")
	WebElement Country;

	@FindBy(xpath = "//select[@id='phone_mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@value='My address']")
	WebElement myaddress;

	@FindBy(xpath = "//button[@id='submitAccount']/span")
	WebElement registerbutton;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waithelper = new WaitHelper(driver);
		waithelper.waitforelementclickable(Firstname, ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);

	}

		
	public void customerfirstname() {
		Firstname.sendKeys("Ashutosh");
	}

	public void customerlastname() {

		Lastname.sendKeys("chaturvedi");
	}

	public void password() {
		Password.sendKeys("hariom123");
	}

	public void addressfirstname() {
		AddressFirstname.sendKeys("Ashutosh");
	}

	public void addresslastname() {
		AddressLastname.sendKeys("Chaturvedi");
	}

	public void address() {
		Address.sendKeys("151 Tsutin ornagecounty");
	}

	public void city() {
		City.sendKeys("Orangecounty");
	}

	public void selectState() {
		Select statelist = new Select(Country);
		statelist.selectByValue("5");
	}

	public void zipcode() {
		Zipcode.sendKeys("78205");
	}

	public void selectCountry() {
		Select countrylist = new Select(Country);
		countrylist.selectByVisibleText("United States");
	}

	public void mobile() {
		mobile.sendKeys("9512584785");

	}

	public void myaddress() {
		myaddress.sendKeys("151 yamaha vihar");

	}

	public void registarbutton() {
		registerbutton.click();
		log.info(" new registration submitted");
	}

}
