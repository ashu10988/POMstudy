package framework.projectname.helper.javascript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.projectname.helper.logger.LoggerHelper;

public class JavascriptHelper {

	private WebDriver driver;

	private Logger log = LoggerHelper.getLogger(JavascriptHelper.class);

	public JavascriptHelper(WebDriver driver) {
		this.driver = driver;

	}

	// This method will execute javascript
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	// This method will executeScript with arguments
	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	// This method will ScrollToElement
	public void scrollToElement(WebElement element) {
		log.info("scroll to element");
		executeScript("Window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);

	}

	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
		log.info("element is clicked" + element.toString());
	}

// This is another method to scroll till element
	public void scrollInToView(WebElement element) {
		executeScript("arguments[0].scrollInToView()", element);
	}

	public void scrollInToViewAndClick(WebElement element) {
		scrollInToView(element);
		element.click();
		log.info("element is clicked" + element.toString());
	}

// Scroll down vertically till end of page 

	public void scrollDownvertically() {
		executeScript("window.scrollTo(0,document.body.scrollheight)");

	}

//Scroll up vertically till end of page 
	public void scrollUpvertically() {
		executeScript("window.scrollTo(0,-document.body.scrollheight)");

	}

// This will scroll down to given pixel(1500)

	public void ScrollDownToPixel(int pixel) {
		
		executeScript("window.scrollBy(0,"+pixel+")");

	}
	
	// This will scroll Up to given pixel(1500)

		public void ScrollUpToPixel(int pixel) {
			
			executeScript("window.scrollBy(0,-"+pixel+")");

		}
	
	// This method will zoom screen by 60%
		
		public void zoomScreenby60percent()
		{
			executeScript("document.body.style.zoom='60%'");
		}
		
		// This method will zoom screen by 100%
		
				public void zoomScreenby100percent()
				{
					executeScript("document.body.style.zoom='100%'");
				}
		
	// This will click top of the element without scrolling 
		
		public void topElementClick(WebElement element)
		
		{
			executeScript("argumnets[0].click()",element);
		}

}
