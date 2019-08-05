package framework.projectname.helper.listener;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


import framework.projectname.helper.logger.LoggerHelper;

public class Retry implements IRetryAnalyzer {
	
	private int retryCount=0;
	private int maxreTrycount=3;

	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult arg0) {
		if(retryCount<maxreTrycount) {
			log.info("Re trying test "+arg0.getName()+" with status "+getResultStatusName(arg0.getStatus())+ "for the "+(retryCount+1)+ "times ");
			retryCount++;
			return true;
			
		}
		
		return false;
	}
	
	public String getResultStatusName(int status)
	{
		String resultName=null;
		if(status==1)
		{
			resultName="Success";
		}
		
		if(status==2)
		{
			resultName="Failed";
		}
		
		if(status==3)
		{
			resultName="Skip";
		}
		
		return resultName;
	}
   
}
