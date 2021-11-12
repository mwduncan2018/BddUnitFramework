package com.bddunitframework.hooks;

import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.context.ScenarioContext;
import com.bddunitframework.webdriverfactory.WebDriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private HashMap<String, Object> context;

	public Hooks(HashMap<String, Object> context) {
		this.context = context;
	}

	@Before(value = "@Browser", order = 99)
	public void beforeScenario() throws MalformedURLException {
		WebDriver driver = WebDriverFactory.getDriver();
		context.put("driver", driver);
	}

	@After(value = "@Browser", order = 1)
	public void afterScenario() {
		((WebDriver) context.get("driver")).quit();
	}
}
