package framework.projectname.helper.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.projectname.testbase.Testbase;

public class A extends Testbase {
	@Test
	public void hello()
	{
		Assert.assertTrue(true);
	}

}
