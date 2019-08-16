package framework.projectname.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.projectname.helper.logger.LoggerHelper;

public final class DropdownHelper {
	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(DropdownHelper.class);

	public DropdownHelper(WebDriver driver) {
		this.driver = driver;

	}
	
	
	public void selectByUsingValue(WebElement element ,String value) {
		Select select = new Select(element); // Select is a Selenium method
		log.info("Select by using value "+value);
				select.selectByValue(value);
				
	}

	public void selectByUsingIndex(WebElement element ,int index) {
		Select select = new Select(element); // Select is a Selenium method
		log.info("Select by using index "+index);
				select.selectByIndex(index);;
				
	}

	public void selectByUsingVisbleText(WebElement element ,String visbiletext) {
		Select select = new Select(element); // Select is a Selenium method
		log.info("Select by using visbleText "+visbiletext);
				select.selectByVisibleText(visbiletext);
				
	}
	
	public List<String> getalldropdowndata(WebElement element )
	{
		Select select= new Select(element);
		List<WebElement> elementList = select.getOptions();
		List<String> valueList = new LinkedList<String>();
	for(WebElement ele:elementList)
	{
		log.info(ele.getText());
		valueList.add(ele.getText());
	}
	return valueList;
	
	
	}
	
	
	
}
