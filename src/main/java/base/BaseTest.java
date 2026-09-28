package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;
import utilities.TestDataReader;
import utilities.WebDriverFactory;

public class BaseTest {

	protected WebDriver driver;
	protected ConfigReader configReader;
	protected TestDataReader testDataReader;
	protected String environment;

	@Parameters("environment")
	@BeforeMethod(alwaysRun = true)
	public void setUp(String environment) {

		this.environment = environment;

		configReader = new ConfigReader(environment);
		testDataReader = new TestDataReader();

		String browser = configReader.getProperty("browser");

		driver = WebDriverFactory.createDriver(browser);

		driver.manage().window().maximize();

		driver.get(configReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public ConfigReader getConfigReader() {
		return configReader;
	}

	public String getEnvironment() {
		return environment;
	}

	public TestDataReader getTestDataReader() {
		return testDataReader;
	}

}
