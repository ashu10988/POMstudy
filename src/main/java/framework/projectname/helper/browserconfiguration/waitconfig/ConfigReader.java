package framework.projectname.helper.browserconfiguration.waitconfig;

import framework.projectname.helper.browserconfiguration.BrowserType;

public interface ConfigReader {

	public int getImpliciteWait();

	public int getExplicitWait();

	public int getPageLoadTime();

	public BrowserType getBroswerType();

	public String getUrl();

	public String getUserName();

	public String getPassword();
}
