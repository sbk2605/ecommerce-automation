package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String captureScreenshot(WebDriver driver, String testName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File source = screenshot.getScreenshotAs(OutputType.FILE);

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String path = FrameworkConstants.SCREENSHOT_DIRECTORY + "/" + testName + "_" + timestamp + ".png";

		File destination = new File(path);

		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			throw new FrameworkException("Unable to save screenshot", e);
		}

		return path;
	}
}