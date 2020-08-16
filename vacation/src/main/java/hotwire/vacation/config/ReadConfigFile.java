package hotwire.vacation.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Manoj Kadam : QA Automation
 * Contains methods to read properties file
 * Get methods for all 
 */
public class ReadConfigFile {

	private Properties properties;

	/** Path to the properties file */
	private final String propertyFilePath = "C:\\Manoj\\EclipseWorkspace\\UDM\\vacation\\"
			+ "src\\main\\java\\hotwire\\vacation\\config\\configurations.properties";

	public ReadConfigFile() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("configuration.properties not found at : " + propertyFilePath);
		}
	}

	public String getChromeDriverPath() {
		String chromeDriverPath = properties.getProperty("chromeDriverPath");
		if (chromeDriverPath != null)
			return chromeDriverPath;
		else
			throw new RuntimeException("chromeDriverPath not specified in the Configuration.properties file.");
	}

	public String getGeckoDriverPath() {
		String geckoDriverPath = properties.getProperty("geckoDriverPath");
		if (geckoDriverPath != null)
			return geckoDriverPath;
		else
			throw new RuntimeException("geckoDriverPath not specified in the Configuration.properties file.");
	}

	public long getImplicitWait() {
		String implicitlyWait = properties.getProperty("implicitWait");
		if (implicitlyWait != null)
			return Long.parseLong(implicitlyWait);
		else
			throw new RuntimeException("implicitWait not specified in the Configuration.properties file.");
	}

	public String getBaseURL() {
		String baseURL = properties.getProperty("baseURL");
		if (baseURL != null)
			return baseURL;
		else
			throw new RuntimeException("baseURL not specified in the Configuration.properties file.");
	}

	public String getFlyFrom() {
		String flyFrom = properties.getProperty("flyFrom");
		if (flyFrom != null)
			return flyFrom;
		else
			throw new RuntimeException("flyFrom not specified in the Configuration.properties file.");
	}

	public String getFlyTo() {
		String flyTo = properties.getProperty("flyTo");
		if (flyTo != null)
			return flyTo;
		else
			throw new RuntimeException("flyTo not specified in the Configuration.properties file.");
	}

	public String getDepartureTime() {
		String departureTime = properties.getProperty("departureTime");
		if (departureTime != null)
			return departureTime;
		else
			throw new RuntimeException("departureTime not specified in the Configuration.properties file.");
	}

	public String getReturnTime() {
		String returnTime = properties.getProperty("returnTime");
		if (returnTime != null)
			return returnTime;
		else
			throw new RuntimeException("returnTime not specified in the Configuration.properties file.");
	}
}
