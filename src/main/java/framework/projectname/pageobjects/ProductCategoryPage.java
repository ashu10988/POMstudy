package framework.projectname.pageobjects;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.javascript.JavascriptHelper;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.helper.select.DropdownHelper;
import framework.projectname.helper.wait.WaitHelper;
import framework.projectname.testbase.Testbase;

public class ProductCategoryPage {

	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
	private WebDriver driver;

	@FindBy(xpath = "//div[@id='layered_block_left']/p")
	WebElement catalogtext;

	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement productAddedSucessfully;

	@FindBy(xpath = "//a[ @data-id-product='1']/span")
	WebElement addToCart;

	@FindBy(xpath = "//a[@title='Proceed to checkout']/span")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li")
	List<WebElement> Totalproduct;

	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span[1]")
	List<WebElement> allPriceElements;

	@FindBy(xpath="//select[@id=\"selectProductSort\"]")
	WebElement sortby;
	public ProductCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waithelper = new WaitHelper(driver);
		waithelper.waitforelementclickable(catalogtext, ObjectReader.reader.getExplicitWait());
		new Testbase().getNavigationScreenshot(driver);
	}

	// Method to select product as per their number
	public void mouseOverProduct(int number) {
		String fpart = "//a[ @data-id-product=";
		String spart = "/span";
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(fpart + number + spart))).build().perform();
	}

	public void clickOnAddtoCart() {
		log.info("clicking on cart button");
		addToCart.click();
	}

	public void clickOnproccedToCheckout() {
		log.info("clicking on product to checkout: " + proceedToCheckout.getText());
		proceedToCheckout.click();
	}

	public void selectcolour(String data) {
		new JavascriptHelper(driver).scrollInToView(
				driver.findElement(By.xpath("//a[contains(text(),'White')]/parent::*/preceding-sibling::input[1]")));
		driver.findElement(By.xpath("//a[contains(text(),'White')]/parent::*/preceding-sibling::input[1]")).click();
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectSmallSize() {
		log.info("select small size");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1'])")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_1'])")).click();
				log.info("small size check box is selected");
			}
		} catch (Exception e) {
			log.info("checkbox is already checked ");
		}
	}

	public void selectMediumSize() {
		log.info("select small size");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2'])")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_2'])")).click();
				log.info("Medium size check box is selected");
			}
		} catch (Exception e) {
			log.info("checkbox is already checked ");
		}
	}

	public void selectLargeSize() {
		log.info("select large size");
		try {
			boolean selected = driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3'])")).isSelected();
			if (!selected) {
				driver.findElement(By.xpath("//*[@id='layered_id_attribute_group_3'])")).click();
				log.info("large size check box is selected");
			}
		} catch (Exception e) {
			log.info("larze size checkbox is already checked ");
		}
	}

	public void selectFirstProduct() {
		Actions action = new Actions(driver);
		Testbase.logExtentReport("perofrming mouse on the firts product ");
		action.moveToElement(Totalproduct.get(0)).build().perform();
		addToCart.click();
	}

	public int totalproduct() {
		log.info("Total product size is " + Totalproduct.size());
		return Totalproduct.size();
	}

	public List<WebElement> getAllproductprice() {
		return allPriceElements;
	}
	
	
	public void selectsortbyfilter(String dataToSelect) {
		DropdownHelper dropdown= new DropdownHelper(driver);
		dropdown.selectByUsingVisbleText(sortby, dataToSelect);
	}
	
	
	
	
	
	
	
	
	
	
}








