package com.bddunitframework.steps;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java8.En;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.context.ScenarioContext;

public class SampleJava8Steps implements En {
	HashMap<String, Object> context;

	public SampleJava8Steps(HashMap<String, Object> context) {
		this.context = context;

		Given("I do something", () -> {
			context.put("numberOfSteps", (Integer) context.get("numberOfSteps") + 1);
			WebDriver driver = (WebDriver) context.get("driver");
			driver.navigate().to(ConfigProps.getUrl());
			driver.findElement(By.id("Username")).sendKeys("mduncan");
		});

		Given("I do something else", this::iDoSomethingElse);
		Given("I do my favorite thing", this::iDoSomethingElse);
	}

	private void iDoSomethingElse() {
		context.put("numberOfSteps", (Integer) context.get("numberOfSteps") + 1);
		WebDriver driver = (WebDriver) context.get("driver");
		driver.findElement(By.id("Password")).sendKeys("cucumber");
	}
}
