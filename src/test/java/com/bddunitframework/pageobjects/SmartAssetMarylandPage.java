package com.bddunitframework.pageobjects;

import org.openqa.selenium.WebDriver;

public class SmartAssetMarylandPage extends SmartAssetBasePage {

	public SmartAssetMarylandPage(WebDriver driver) {
		super(driver);
	}

	public void goTo() {
		driver.navigate().to("https://smartasset.com/taxes/maryland-paycheck-calculator");
	}
}
