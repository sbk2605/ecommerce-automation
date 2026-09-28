package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {

	private final Properties properties;

	public TestDataReader() {

		try {
			InputStream input = getClass().getClassLoader().getResourceAsStream("testdata.properties");

			if (input == null) {
				throw new FrameworkException("testdata.properties file not found");
			}

			properties = new Properties();
			properties.load(input);

			input.close();

		} catch (IOException e) {
			throw new FrameworkException("Unable to load testdata.properties", e);
		}
	}

	public String getTestData(String key) {
		return properties.getProperty(key);
	}
}