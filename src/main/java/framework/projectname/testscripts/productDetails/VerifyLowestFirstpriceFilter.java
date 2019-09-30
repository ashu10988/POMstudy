package framework.projectname.testscripts.productDetails;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import framework.projectname.helper.assertion.AssertionHelper;
import framework.projectname.helper.browserconfiguration.waitconfig.ObjectReader;
import framework.projectname.helper.logger.LoggerHelper;
import framework.projectname.pageobjects.NavigationMenu;
import framework.projectname.pageobjects.ProductCategoryPage;
import framework.projectname.testbase.Testbase;

public class VerifyLowestFirstpriceFilter extends Testbase {

	private final Logger log = LoggerHelper.getLogger(VerifyLowestFirstpriceFilter.class);

	@Test
	public void verifyLowestFirstPriceList() throws InterruptedException {

		getApplicationUrl(ObjectReader.reader.getUrl());

		NavigationMenu navigation = new NavigationMenu(driver);

		ProductCategoryPage category = navigation.clickOnMenu(navigation.womenMenu);
		category.selectsortbyfilter("Price: Lowest first");
		Thread.sleep(10000);
		List<WebElement> price = category.getAllproductprice();

		//ArrayList<Integer> array = new ArrayList<Integer>();

		Iterator<WebElement> itr = price.iterator();

		ArrayList<Integer> pricedata = category.getPriceMassagedData(itr);
		boolean status = category.verifyArrayHasAscendingData(pricedata);
		AssertionHelper.updateTestStatus(status);

	}

}
