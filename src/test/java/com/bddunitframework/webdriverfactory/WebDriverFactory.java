package com.bddunitframework.webdriverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.grid.GridScheduler;

public class WebDriverFactory {
	static String environment = ConfigProps.getEnvironment();
	static String driverType = ConfigProps.getDriverType();
	static Boolean maximize = Boolean.valueOf(ConfigProps.getMaximize());
	static Integer horizontalPixels = Integer.valueOf(ConfigProps.getHorizontalPixels());
	static Integer verticalPixels = Integer.valueOf(ConfigProps.getVerticalPixels());
	static String implicitWait = ConfigProps.getImplicitWait();

	public static WebDriver getDriver() throws MalformedURLException {
		WebDriver driver;

		if (environment.equals("remote"))
			driver = getRemoteDriver();
		else
			driver = getLocalDriver();

		if (maximize)
			driver.manage().window().maximize();
		else
			driver.manage().window().setSize(new Dimension(horizontalPixels, verticalPixels));

		driver.manage().timeouts().implicitlyWait(Long.valueOf(implicitWait), TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver getRemoteDriver() throws MalformedURLException {
		new GridScheduler().waitForAvailableNode();
		if (driverType.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("acceptSslCerts", true);
			return new RemoteWebDriver(new URL(getGridHubIp()), options);
		} else if (driverType.equals("chrome")) {
			return null; // Implement later
		}
		return null;
	}

	private static WebDriver getLocalDriver() {
		if (driverType.equals("firefox")) {
			return new FirefoxDriver();
		} else if (driverType.equals("chrome")) {
			return new ChromeDriver();
		}
		return null;
	}

	private static String getGridHubIp() {
		String url = System.getenv("GRID_IP");
		if (url == null)
			url = ConfigProps.getGridIp();
		return url + "/wd/hub";
	}
}