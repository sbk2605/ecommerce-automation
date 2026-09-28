package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private final Properties properties;

	public ConfigReader(String environment) {

		try {

			if (environment == null || environment.trim().isEmpty()) {
				environment = "qa";
			}

			String configFile = "config-" + environment.toLowerCase() + ".properties";

			InputStream input = getClass().getClassLoader().getResourceAsStream(configFile);

			if (input == null) {
				throw new FrameworkException("Configuration file not found: " + configFile);
			}

			properties = new Properties();
			properties.load(input);
			input.close();

		} catch (IOException e) {
			throw new FrameworkException("Unable to load configuration file", e);
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}