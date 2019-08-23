package framework.projectname.helper.browserconfiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import framework.projectname.helper.resource.Resourcehelper;

public class ChromeBrowser {

	public ChromeOptions getChromeOptions()
	{
		ChromeOptions option= new ChromeOptions();//Provided by selenium 
	   // option.addArguments("--test type--");
	   // option.addArguments("-disable pop blocking");
	    
	    // Object of Desire capabilities
	    
	    DesiredCapabilities chrome = DesiredCapabilities.chrome();
	    chrome.setJavascriptEnabled(true);
	    
	    
	    option.setCapability(ChromeOptions.CAPABILITY, chrome);
	    
	    //For Linux
	    if(System.getProperty("os.name").contains("Linux"))
	    {
	    	option.addArguments("headless","window-size=1024,768", "no-sandbox");
	    	
	    }
	    return option;
	}
	
	
	public WebDriver getChromeDriver(ChromeOptions cap)
	{
		if(System.getProperty("os.name").contains("Window"))
		{
			System.setProperty("webdriver.chrome.driver",Resourcehelper.getResourcepath("/src/main/Resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			System.setProperty("webdriver.chrome.driver",Resourcehelper.getResourcepath("/src/main/Resources/drivers/chromedriver.exe"));
			return new ChromeDriver(cap);
		}
		return null;
		
	}
	
//	public static void main(String[] args) {
//		ChromeBrowser obj = new ChromeBrowser();
//		WebDriver driver = obj.getChromeDriver(obj.getChromeOptions());
//		driver.get("https://facebook.com");
//	}
	
}
