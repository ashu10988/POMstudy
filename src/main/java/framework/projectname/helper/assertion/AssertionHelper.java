package framework.projectname.helper.assertion;

import org.apache.log4j.Logger;
import org.testng.Assert;

import framework.projectname.helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	
	public static void verifyText(String s1, String s2)
	{
		log.info("veriy test "+s1+"with"+s2);
		Assert.assertEquals(s1, s2);
	}
	
	public static void makeTrue()
	{
		log.info("making script pass");
		Assert.assertTrue(true);;
	}
	
	public static void makeTrue(String message)
	{
		log.info("making script pass"+message);
		Assert.assertTrue(true, message);
	}
	
	
	public static void makeFalse()
	{
		log.info("making script fail");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message)
	{
		log.info("making script fail"+message);
		Assert.assertTrue(false, message);
	}
	
	public static void verifyTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	
	public static void VerifyFalse(boolean status)
	{
		Assert.assertFalse(status);
	}
	
	public static void VerifyNull(String S1)
	{
		log.info("verify object is null");
		Assert.assertNull(S1);
	}
	

	public static void VerifyNotNull(String S1)
	{
		log.info("verify object is not null");
		Assert.assertNotNull(S1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
