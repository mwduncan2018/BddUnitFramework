package com.bddunitframework.steps;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import com.bddunitframework.config.ConfigProps;
import com.bddunitframework.context.ScenarioContext;

public class SampleSteps {
	private HashMap<String, Object> context;

	public SampleSteps(HashMap<String, Object> context) {
		this.context = context;
	}

	@Given("I do a thing")
	public void iDoAThing() {
		WebDriver driver = (WebDriver) context.get("driver");
		driver.navigate().to(ConfigProps.getUrl());
		driver.findElement(By.id("Username")).sendKeys("mduncan");
	}

	@When("I do another thing")
	public void iDoAnotherThing() {
		WebDriver driver = (WebDriver) context.get("driver");
		driver.findElement(By.id("Password")).sendKeys("cucumber");
	}

	@Then("I verify the thing")
	public void iVerifyTheThing() {
		WebDriver driver = (WebDriver) context.get("driver");
		driver.findElement(By.id("btnLogin")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
	}
}
