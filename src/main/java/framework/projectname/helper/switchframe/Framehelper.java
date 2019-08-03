package framework.projectname.helper.switchframe;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.projectname.helper.logger.LoggerHelper;


public class Framehelper {
	
private WebDriver driver;
	
	private Logger log=LoggerHelper.getLogger(Framehelper.class);

	public Framehelper(WebDriver driver)
	{
	
		this.driver=driver;
	}
	
	// This method will switchtoframe by using index
	public void switchToframe(int index)
	{
		driver.switchTo().frame(index);
		log.info("switched to "+index + "Frame");
	}
	
	// This method will switchtoframe by using name
	public void switchToframe(String name)
	{
		driver.switchTo().frame(name);
		log.info("switched to "+name + "Frame");
	}
	
	// This method will switchtoframe by using webelement
	public void switchToframe(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("switched to "+element + "Frame");
	}
	
	
	
}
