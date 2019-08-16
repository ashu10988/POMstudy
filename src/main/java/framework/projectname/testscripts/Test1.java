package framework.projectname.testscripts;

import org.testng.annotations.Test;

import framework.projectname.helper.assertion.AssertionHelper;
import framework.projectname.testbase.Testbase;

public class Test1 extends Testbase {
	
	@Test
	public void hello() {
		AssertionHelper.makeTrue();
		
	}
	

	@Test
	public void hello1() {
		AssertionHelper.makeFalse();
		
	}
}
