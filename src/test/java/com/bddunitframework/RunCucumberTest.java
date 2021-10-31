package com.bddunitframework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import com.bddunitframework.context.TestRunContext;

@CucumberOptions(features = "src/test/resources/features", plugin = "json:target/cucumber-reports/cucumber.json", tags = "@Debug")
class RunCucumberTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	public static void beforeClass() {
		System.out.println("*******************************************");
		System.out.println("BEFORE CLASS");
		System.out.println("*******************************************");
		TestRunContext.getHashMap().put("numberOfTests", 0);
	}

	@AfterClass
	public static void afterClass() {
		System.out.println("*******************************************");
		System.out.println("AFTER CLASS");
		System.out.println("*******************************************");
	}
}