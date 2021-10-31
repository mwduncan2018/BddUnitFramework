package com.bddunitframework.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProps {
	private static String configFile = "config/config.properties";

	public static String getEnvironment() {
		return getProperty("environment");
	}

	public static String getDriverType() {
		return getProperty("driverType");
	}

	public static String getWindowMaximize() {
		return getProperty("windowMaximize");
	}

	public static String getBrowserHorizontalPixels() {
		return getProperty("browserHorizontalPixels");
	}

	public static String getBrowserVerticalPixels() {
		return getProperty("browserVerticalPixels");
	}

	public static String getUrl() {
		return getProperty("url");
	}

	public static String getImplicitWait() {
		return getProperty("implicitWait");
	}

	public static String getTestDataPath() {
		return getProperty("testDataPath");
	}

	public static String getProperty(String propName) {
		String x = readConfigFile().getProperty(propName);
		if (x != null)
			return x;
		else
			throw new RuntimeException(propName + " not found in config.properties!");
	}

	private static Properties readConfigFile() {
		Properties properties;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(configFile));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException("config.properties not found at " + configFile + "!");
		}
		return properties;
	}

}
