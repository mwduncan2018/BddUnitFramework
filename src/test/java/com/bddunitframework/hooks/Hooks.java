package com.bddunitframework.hooks;

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

	@Before(order = 99)
	public void beforeScenario() {
		WebDriver driver = WebDriverFactory.getDriver();
		context.put("driver", driver);
		context.put("numberOfSteps", 0);
	}

	@After(order = 1)
	public void afterScenario() {
		((WebDriver) context.get("driver")).close();
		System.out.println("Number Of Steps: " + (Integer) context.get("numberOfSteps"));
	}
}
