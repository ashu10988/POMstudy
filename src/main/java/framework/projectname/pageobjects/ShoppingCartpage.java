package framework.projectname.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.projectname.helper.assertion.VerificationHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class ShoppingCartpage {
	private Logger log = LoggerHelper.getLogger(ShoppingCartpage.class);
	private WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty.')]")
	WebElement cartisempty;
	
	@FindBy(xpath="//a[@title='Delete']")
	List<WebElement> all_delete;
	
	@FindBy(xpath="//*[@id=\"order_step\"]/li[1]/span/text()")
    WebElement summarytab;	
	
	public ShoppingCartpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waithelper = new WaitHelper(driver);
		waithelper.waitforelementclickable(summarytab, ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
	}
	
	
	//Common method to delete all products 
	public void deleteAllproducts() throws InterruptedException {
		List<WebElement> deletes=all_delete;
		Iterator<WebElement> itr=deletes.iterator();
		while(itr.hasNext())
		{
			itr.next().click();
			Thread.sleep(2000);
		}
	}
	
	public boolean verifyProduct(String prod) {
		log.info("Selecteing prod: "+prod);
		WebElement product= driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));// To convert entire string to single string
		return new VerificationHelper(driver).isdisplayed(product);
	
	}
	
	public boolean verifyEmptyShoppingCartMessage() {
		return new VerificationHelper(driver).isdisplayed(cartisempty);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
