package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	public static WebDriver createDriver(String browser) {

		if (browser == null || browser.trim().isEmpty()) {
			throw new FrameworkException("Browser is not configured in configuration file");
		}

		if (browser.equalsIgnoreCase("chrome")) {
			return new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			return new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			return new EdgeDriver();

		} else {
			throw new FrameworkException("Unsupported browser: " + browser);
		}
	}
}