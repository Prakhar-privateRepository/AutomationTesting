package com.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.corelayer.CoreClass;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks extends CoreClass {

	@AfterStep
	public void takeScreenshot(Scenario scenario) {

		try {
			if (scenario.isFailed()) {
				byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot");
			} else if (scenario.getStatus().toString().equalsIgnoreCase("skipped")) {
				byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot");
			} else {
				byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenshot, "image/png", "Screenshot");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
