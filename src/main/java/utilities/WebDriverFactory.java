package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeOptions;

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

			EdgeOptions options = new EdgeOptions();

			if (System.getenv("JENKINS_HOME") != null) {
				if (System.getenv("JENKINS_HOME") != null) {
					options.addArguments("--headless=new");
					options.addArguments("--disable-gpu");
					options.addArguments("--window-size=1920,1080");
					options.addArguments("--no-first-run");
					options.addArguments("--no-default-browser-check");

					String userDataDir = System.getProperty("java.io.tmpdir") + "selenium-edge-"
							+ java.util.UUID.randomUUID();

					options.addArguments("--user-data-dir=" + userDataDir);
				}
			}

			return new EdgeDriver(options);

		}

		else {
			throw new FrameworkException("Unsupported browser: " + browser);
		}
	}
}