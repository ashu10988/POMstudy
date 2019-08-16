package framework.projectname.helper.browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import framework.projectname.helper.resource.Resourcehelper;

public class FirefoxBrowser {

	public FirefoxOptions getFirefoxOptions()
	{
		FirefoxOptions profile= new FirefoxOptions();//Provided by selenium 
	    profile.addArguments("--test type--");
	    profile.addArguments("-disable pop blocking");
	    profile.setAcceptInsecureCerts(true);
	   
	    
	    // Object of Desire capabilities
	    
	    DesiredCapabilities firefox = DesiredCapabilities.chrome();
	    firefox.setJavascriptEnabled(true);
	   firefox.setCapability(FirefoxDriver.PROFILE, profile);
	   firefox.setCapability("marionette", true);
	    
	    //For Linux
	    if(System.getProperty("os.name").contains("Linux"))
	    {
	    	profile.addArguments("headless","window-size=1024,768", "no-sandbox");
	    	
	    }
	    return profile;
	}
	
	
	public WebDriver getFirefoxDriver(FirefoxOptions cap)
	{
		if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.gecko.driver",Resourcehelper.getResourcepath("/src/main/Resources/drivers/geckodriver.exe"));
			return new FirefoxDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			System.setProperty("webdriver.gecko.driver",Resourcehelper.getResourcepath("/src/main/Resources/drivers/geckodriver"));
			return new FirefoxDriver(cap);
		}
		return null;
		}
	
	
		
}
	
	
	
	
	

