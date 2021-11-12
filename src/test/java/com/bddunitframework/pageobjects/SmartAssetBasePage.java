package com.bddunitframework.pageobjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartAssetBasePage {
	WebDriver driver;

	@FindBy(css = "div.household-income-input span.tightcontainer .dollar")
	WebElement salaryInput;

	@FindBy(css = ".js-period-income-after-dol")
	WebElement takeHomePay;

	public SmartAssetBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void setSalaryTo(Integer salary) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 100; i++)
			sb.append(Keys.DELETE);
		for (int i = 0; i < 100; i++)
			sb.append(Keys.BACK_SPACE);
		sb.append(salary);
		sb.append(Keys.ENTER);
		salaryInput.sendKeys(sb.toString());
	}

	public Integer getTakeHomePay() {
		return Integer.valueOf(takeHomePay.getText().replace(",", ""));
	}

	public void verifyTakeHomePayIs(Integer value) {
		Integer result = -1;
		for (int i = 0; i < 3; i++) {
			result = getTakeHomePay();
			if (result == value)
				break;
			else
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
		}
		assertEquals(getTakeHomePay(), value);
	}
}
