package framework.projectname.helper.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

import framework.projectname.testbase.Testbase;

public class B extends Testbase{

	int i = 1;

	@Test
	public void hellob() {
		if (i == 3) {
			Assert.assertTrue(true);
		}
		else {
			i++;
			Assert.assertTrue(false);
		}

	}
}