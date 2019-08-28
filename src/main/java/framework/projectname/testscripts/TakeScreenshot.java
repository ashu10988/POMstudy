package framework.projectname.testscripts;

import org.testng.annotations.Test;

import framework.projectname.testbase.Testbase;

public class TakeScreenshot extends Testbase {
	
	@Test
	public void test1()
	{
		driver.get("https://google.com");
	    capturescreen("First screenshot", driver);
	}

}
