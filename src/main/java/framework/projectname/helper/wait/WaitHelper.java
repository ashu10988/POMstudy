package framework.projectname.helper.wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.projectname.helper.logger.LoggerHelper;

public class WaitHelper {
	
	private WebDriver driver;
	
	private Logger log=LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper( WebDriver driver)
	{
		this.driver=driver;
	}
	public void setImplicitwait(long timeout, TimeUnit unit )  
	{
		log.info("Implicit wait has been set to :"+timeout);
       driver.manage().timeouts().implicitlyWait(timeout, unit);
	}

	// this will help us to get webdriver wait
	private WebDriverWait getwait(int timeOutInSeconds, int pollingEveryInmiliSec)
	{
		WebDriverWait wait= new WebDriverWait(driver, timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInmiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(NoSuchFrameException.class);
		wait.ignoring(StaleElementReferenceException.class);
		return wait;
	}
	// this will make sure element is visible now
	public void waitforelementvisible(WebElement element, int timeOutInSeconds, int pollingEveryInmiliSec) 
	{
		log.info("Waiting for "+element.toString()+"for: "+timeOutInSeconds+"seconds");
		WebDriverWait wait = getwait(timeOutInSeconds, pollingEveryInmiliSec);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
		
	}
	
	//This is Explicity wait and element is clickable 
	public void waitforelementclickable(WebElement element, int timeOutInSeconds) 
	{
		log.info("Waiting for "+element.toString()+"for: "+timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element clicked");
		
	}
	
	// this is element not present method 
	public void waitforelementnotpresent(WebElement element, int timeOutInSeconds) 
	{
		log.info("Waiting for "+element.toString()+"for: "+timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisble now");
		
	}
	// this is frame is available method
	public void waitforframetobeavaiableandswitched(WebElement element, int timeOutInSeconds) 
	{
		log.info("Waiting for "+element.toString()+"for: "+timeOutInSeconds+"seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is avaible now and switched");
		
	}
	//This is fluent wait 
	private Wait<WebDriver> getfluentwait(int timeOutInSeconds, int pollingEveryInMiliSec)
	{
	
		Wait<WebDriver> fwait= new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
				.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec))
				.ignoring(NoSuchElementException.class);
		return fwait;
	}
	
	public void waitforelement(WebElement element, int timeOutInSeconds,int PollingEveryInMiliSec)
	{
		 Wait<WebDriver> fwait = getfluentwait(timeOutInSeconds, PollingEveryInMiliSec);
		 fwait.until(ExpectedConditions.visibilityOf(element));
		 
	}
	
	public void pageloadtime(long timeout ,TimeUnit unit)
	{
		log.info("waiting for page to load"+unit);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("page is loaded");
	}
	
}