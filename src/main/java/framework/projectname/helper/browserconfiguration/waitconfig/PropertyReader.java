package framework.projectname.helper.browserconfiguration.waitconfig;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import framework.projectname.helper.browserconfiguration.BrowserType;
import framework.projectname.helper.resource.Resourcehelper;

public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		String filepath = Resourcehelper.getResourcepath("\\src\\main\\Resources\\configfile\\config.properties");
		try {
			file = new FileInputStream(new File(filepath));
			Properties OR = new Properties();
			OR.load(file);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitWait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitWait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadTime"));
	}

	public BrowserType getbroswerType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

}