package framework.projectname.helper.alert;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

import framework.projectname.helper.logger.LoggerHelper;

public class AlertHelper {
	
	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(AlertHelper.class);

	public AlertHelper(WebDriver driver) {
		this.driver = driver;

	}
	
	public Alert getAlert()
	{
		log.info("Aler "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}

	public void acceptAlert()
	{
		getAlert().accept();
		log.info(" accpert Alert is done");
	}
	
	public void dismissAlert()
	{
		getAlert().dismiss();
		log.info(" dismiss Alert is done");
	}
	
	public String getAlertText()
	{
		String text = getAlert().getText();
		log.info("text is "+text);
		return text;
	}
	
	public boolean isAlertPresent()
	{
		try {
			driver.switchTo().alert();
			log.info("Alert is present");
			return true;
		}
		catch(NoAlertPresentException e)
		{
			log.info(e.getCause());
			return false;
		}
		
	}
	
	
	public void acceptAlertIfPresent()
	{
		if(isAlertPresent())
		{
			acceptAlert();
			log.info(" Alert accepted");
		}
		else {
			log.info("Alert is not present so not accepted");
		}
	}
	
	public void dismissAlertIfPresent()
	{
		if(isAlertPresent())
		{
			dismissAlert();
			log.info(" Alert dismissed");
		}
		else {
			log.info("Alert is not present so not dismissed");
		}
	}
	
	public void acceptPrompt(String Text)
	{
		if(isAlertPresent())
		{
			Alert alert=getAlert();
			alert.sendKeys(Text);
			alert.accept();
    log.info("Alert text"+Text);
		}
	}
	
	
}
