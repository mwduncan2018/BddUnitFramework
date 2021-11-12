package com.bddunitframework.pageobjects;

import org.openqa.selenium.WebDriver;

public class SmartAssetFloridaPage extends SmartAssetBasePage {

	public SmartAssetFloridaPage(WebDriver driver) {
		super(driver);
	}

	public void goTo() {
		driver.navigate().to("https://smartasset.com/taxes/florida-paycheck-calculator");
	}
}
