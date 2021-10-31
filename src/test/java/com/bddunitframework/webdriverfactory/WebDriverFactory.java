package com.bddunitframework.webdriverfactory;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bddunitframework.config.ConfigProps;

public class WebDriverFactory {

	public static WebDriver getDriver() {
		if (ConfigProps.getEnvironment().equals("remote")) {
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.LINUX);
			return new RemoteWebDriver(dc);
		} else if (ConfigProps.getEnvironment().equals("local")) {
			if (ConfigProps.getDriverType().equals("firefox")) {
				return new FirefoxDriver();
			} else if (ConfigProps.getDriverType().equals("chrome")) {
				return new ChromeDriver();
			}
			return new FirefoxDriver();
		}
		return null;
	}
}