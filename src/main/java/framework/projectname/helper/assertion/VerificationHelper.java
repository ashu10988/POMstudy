package framework.projectname.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.projectname.helper.logger.LoggerHelper;

public class VerificationHelper {

	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public VerificationHelper(WebDriver driver) {
		this.driver = driver;

	}
	
	public boolean isdisplayed(WebElement element)
	{
		try {
              element.isDisplayed();
              log.info(" element is displayed "+element.getText());
		     return true;
		}
		catch(Exception e){
			element.isDisplayed();
			log.error(" element is not displayed"+e.getCause());
			return false;
			
		}
		
	}
	
	public String getText(WebElement element)
	{
		if(null==element)
		{
			log.info("element is null");
			return null;
		}
		
	     boolean status = isdisplayed(element);
	     if(status)
	     {
	    	 log.info("element text is: "+element.getText());
	    	 return element.getText();
	     }
		return null;
	}
	
	public String readValurFromElement(WebElement element)
	{
		if(null==element)
		{
			log.info("element is null");
			return null;
		}
		
	     boolean status = isdisplayed(element);
	     if(status)
	     {
	    	 log.info("element text is: "+element.getText());
	    	 return element.getText();
	     }
		return null;
	}
	
	public String getTitle()
	{
	log.info("Title is "+driver.getTitle());
		return driver.getTitle();
	}
	
	
	
	
}
