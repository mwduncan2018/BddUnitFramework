package com.bddunitframework.steps;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java8.En;

import com.bddunitframework.pageobjects.SmartAssetBasePage;
import com.bddunitframework.pageobjects.SmartAssetFloridaPage;
import com.bddunitframework.pageobjects.SmartAssetMarylandPage;

public class SmartAssetSteps implements En {
	HashMap<String, Object> context;

	public SmartAssetSteps(HashMap<String, Object> context) {
		this.context = context;

		Given("I navigate to the SmartAsset paycheck calculator for Maryland", () -> {
			WebDriver driver = (WebDriver) context.get("driver");
			SmartAssetMarylandPage smartAssetMarylandPage = PageFactory.initElements(driver,
					SmartAssetMarylandPage.class);

			smartAssetMarylandPage.goTo();
		});

		Given("I navigate to the SmartAsset paycheck calculator for Florida", () -> {
			WebDriver driver = (WebDriver) context.get("driver");
			SmartAssetFloridaPage smartAssetFloridaPage = PageFactory.initElements(driver,
					SmartAssetFloridaPage.class);

			smartAssetFloridaPage.goTo();
		});

		When("I have a salary of {}", (Integer baseSalary) -> {
			WebDriver driver = (WebDriver) context.get("driver");
			SmartAssetBasePage smartAssetBasePage = PageFactory.initElements(driver, SmartAssetBasePage.class);

			smartAssetBasePage.setSalaryTo(baseSalary);
		});

		Then("verify the semi-monthly take home pay is {}", (Integer semiMonthly) -> {
			WebDriver driver = (WebDriver) context.get("driver");
			SmartAssetBasePage smartAssetBasePage = PageFactory.initElements(driver, SmartAssetBasePage.class);

			smartAssetBasePage.verifyTakeHomePayIs(semiMonthly);
		});
	}
}

