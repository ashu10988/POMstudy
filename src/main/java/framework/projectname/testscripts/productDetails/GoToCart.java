package framework.projectname.testscripts.productDetails;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import framework.projectname.helper.assertion.AssertionHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.pageobjects.NavigationMenu;
import framework.projectname.pageobjects.ProductCategoryPage;
import framework.projectname.pageobjects.ShoppingCartpage;
import framework.projectname.testbase.Testbase;

public class GoToCart extends Testbase {

	private final Logger log = LoggerHelper.getLogger(GoToCart.class);

	@Test
	public void gotocartpage() throws InterruptedException {

		getApplicationUrl(ObjectReader.reader.getUrl());

		NavigationMenu navigation = new NavigationMenu(driver);
		ProductCategoryPage productCategory = navigation.clickOnMenu(navigation.womenMenu);
		Thread.sleep(500);
		productCategory.mouseOverOnProduct(1);
		productCategory.clickOnAddtoCart();
		productCategory.clickOnproccedToCheckout();
		ShoppingCartpage cartpage = new ShoppingCartpage(driver);
		boolean status = cartpage.cartSummaryText();
		AssertionHelper.updateTestStatus(status);
	}

}
