package com.bddunitframework;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import com.bddunitframework.context.TestRunContext;

@CucumberOptions(
		features = "src/test/resources/features", 
		plugin = "json:target/cucumber-reports/cucumber.json",
		tags = "@GridDemo")
class RunCucumberTest extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeSuite
	public static void beforeClass() {
		System.out.println("***************************************************************");
		System.out.println("BEFORE SUITE");
		System.out.println("***************************************************************");
		TestRunContext.getHashMap().put("numberOfTests", 0);
	}

	@AfterSuite
	public static void afterClass() {
		System.out.println("***************************************************************");
		System.out.println("AFTER SUITE");
		System.out.println("***************************************************************");
		Integer numberOfTests = (Integer) TestRunContext.getHashMap().get("numberOfTests");
		System.out.println("Number of tests = " + numberOfTests);
	}
}