package framework.projectname.helper.windows;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import framework.projectname.helper.logger.LoggerHelper;

public class Windowhelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(Windowhelper.class);

	public Windowhelper(WebDriver driver) {
		this.driver = driver;

	}

	public void switchToParentwindow() {
		log.info("Switching to parnet window");
		driver.switchTo().defaultContent();
	}
// this will land you window by index like 3rd window,4th window
	
	public void switchTowindow(int index) {
		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		for (String window : windows) {
			if (i == index)
			{
				log.info("switch to :"+index +" window");
				driver.switchTo().window(window);
			} else
				i++;
		}
	}
	
	//this will close all window and will land you in parent video
	
	public void closealltabAndSwitchtoMainwindow()
	{
		Set<String> windows = driver.getWindowHandles();
		
		String mainwindow= driver.getWindowHandle();
		
		for (String window:windows)
		{
			if(!window.equalsIgnoreCase(mainwindow))
			{
				driver.close();
			}
			log.info("switched to main window");
			driver.switchTo().window(mainwindow);
		}
	}
	
	// this will do browser back navigation
	public void navigateback()
	{
		driver.navigate().back();
		log.info("navigated browser to back window");
	}

	// this will navigate forward
	public void forward()
	{
		driver.navigate().forward();
		log.info("navigated browser to forward window");
	}
}
