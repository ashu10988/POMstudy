package framework.projectname.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerHelper {
	
	public static boolean root=false;
	
	public static Logger getLogger(Class cls)
	{
		if (root)
		{
			return Logger.getLogger(cls);
		}
	PropertyConfigurator.configure("C:/Users/Diligence soft/git/POMstudy/src/main/Resources/configfile/log4j.properties");	
		root=true;
		return Logger.getLogger(cls);
	}

	public static void main(String[] args) {
		Logger log = LoggerHelper.getLogger(LoggerHelper.class);
		log.info("looger is configured");
		log.info("looger is configured");
	}
}
