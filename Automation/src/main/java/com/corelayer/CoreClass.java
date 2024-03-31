package com.corelayer;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.utilitylayer.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CoreClass {

	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();

	public static void initialization() {
		if (ConfigReader.readValue("config", "browserType").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-web-security");
			options.addArguments("--no-proxy-server");
			options.addArguments("--remote-allow-origins=*");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);
			tldriver.set(new ChromeDriver(options));

		} else if (ConfigReader.readValue("config", "browserType").equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			tldriver.set(new EdgeDriver());

		} else if (ConfigReader.readValue("config", "browserType").equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		getDriver().manage().window().maximize();
	}

	public static WebDriver getDriver() {
		return tldriver.get();
	}

	public static void closeTab() {
		getDriver().close();
	}

	public static void closeBrowser() {
		getDriver().quit();
	}

}
