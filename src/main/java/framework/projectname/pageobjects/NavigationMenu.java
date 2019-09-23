package framework.projectname.pageobjects;



import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class NavigationMenu {
	
	private Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	private WebDriver driver;
	
	@FindBy(xpath="//li/a[@title='Women']")
	WebElement womenMenu;

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement dressesMenu;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tshirtsMenu;
    
	@FindBy(xpath="//li/a[@title='Tops']")
	WebElement tops;

	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/a")
	WebElement subDressessmenu;

	public NavigationMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		WaitHelper waithelper= new WaitHelper(driver);
		waithelper.waitforelementclickable(womenMenu,ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
		Testbase.logExtentReport("Navigation menu object created");
	}
	public void mouseover(String data)
	{
		Testbase.logExtentReport("doing mouse over on :" +data);
		Actions action= new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
		
	}
	
	public ProductCategoryPage clickOnItem(String data)
	{
		driver.findElement(By.xpath("//*[contains(text(),'"+data+"']")).click();
		return new ProductCategoryPage(driver);
	}
	
	public ProductCategoryPage clickOnMenu(WebElement element)
	{
		log.info("clciking on"+element.getText());
		element.click();
		return new ProductCategoryPage(driver);
	}
	
}
