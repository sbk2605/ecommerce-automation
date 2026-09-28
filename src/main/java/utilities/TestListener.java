package utilities;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utilities.ConfigReader;

public class TestListener implements ITestListener, IInvokedMethodListener {

	private ExtentReports extentReports = ExtentReportManager.getReportInstance();

	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		String className = result.getTestClass().getName();

		ExtentTest test = extentReports.createTest(testName);

		test.info("Test Class: " + className);

		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		extentTest.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentTest testReport = extentTest.get();

		if (testReport != null) {
			testReport.fail(result.getThrowable());
		}

		BaseTest test = (BaseTest) result.getInstance();

		if (test.getDriver() != null) {

			String testName = result.getMethod().getMethodName();

			String screenshotPath = ScreenshotUtil.captureScreenshot(test.getDriver(), testName);

			if (testReport != null) {
				testReport.addScreenCaptureFromPath(screenshotPath);
			}
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.get().skip("Test Skipped");
	}

	@Override
	public void onFinish(ITestContext context) {

		extentReports.flush();
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

		if (method.isConfigurationMethod() && testResult.getStatus() == ITestResult.SUCCESS
				&& testResult.getMethod().getMethodName().equals("setUp")) {

			if (testResult.getInstance() instanceof BaseTest) {

				BaseTest baseTest = (BaseTest) testResult.getInstance();

				ExtentTest testReport = extentTest.get();

				if (testReport != null) {

					testReport.info("Browser: " + baseTest.getConfigReader().getProperty("browser"));

					testReport.info("Environment: " + baseTest.getEnvironment());
				}
			}
		}
	}
}