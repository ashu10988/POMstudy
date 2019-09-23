package framework.projectname.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.projectname.helper.logger.LoggerHelper;

public class ShoppingCartpage {
	private Logger log = LoggerHelper.getLogger(ShoppingCartpage.class);
	private WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty.')]")
	WebElement cartisempty;
	
	@FindBy(xpath="//a[@title='Delete']")
	List<WebElement> all_delete;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
