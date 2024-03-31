package com.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "com.allfeature\\composeemailtest.feature" }, glue = { "com.hooks",
		"com.stepdef" }, dryRun = false, monochrome = true, publish = true, tags = ("@logingmail or @sendcomposeemail"), plugin = {
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty" })
public class TestRunner extends AbstractTestNGCucumberTests {
	
	
}
