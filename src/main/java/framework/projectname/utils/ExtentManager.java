package framework.projectname.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			return createInstance("test-output/extent.html");
		} else
			return extent;
	}

	public static ExtentReports createInstance(String filename) {

		// Here we are creating object on Html Extent reporter

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(filename);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(filename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	}

}
