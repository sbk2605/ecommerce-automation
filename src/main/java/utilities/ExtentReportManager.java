package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utilities.ConfigReader;

public class ExtentReportManager {

	private static ExtentReports extentReports;

	public static ExtentReports getReportInstance() {

		if (extentReports == null) {

			String reportDirectory = System.getProperty("user.dir") + File.separator
					+ FrameworkConstants.REPORT_DIRECTORY;

			File directory = new File(reportDirectory);

			if (!directory.exists()) {
				directory.mkdirs();
			}

			String reportPath = reportDirectory + File.separator + FrameworkConstants.REPORT_FILE_NAME;

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

			sparkReporter.config().setReportName("E-Commerce Automation Report");
			sparkReporter.config().setDocumentTitle("Automation Test Report");

			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);

			extentReports.setSystemInfo("Project", "E-Commerce Automation");

		}

		return extentReports;
	}

}
