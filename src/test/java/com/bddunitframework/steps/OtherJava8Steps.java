package com.bddunitframework.steps;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java8.En;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.context.ScenarioContext;

public class OtherJava8Steps implements En {
	public OtherJava8Steps(HashMap<String, Object> context) {

		Given("I verify something", () -> {
			context.put("numberOfSteps", (Integer) context.get("numberOfSteps") + 1);
			WebDriver driver = (WebDriver) context.get("driver");
			driver.findElement(By.id("btnLogin")).click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		});
	}
}
