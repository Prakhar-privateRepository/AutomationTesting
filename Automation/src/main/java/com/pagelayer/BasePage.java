package com.pagelayer;

import org.openqa.selenium.WebElement;

import com.corelayer.CoreClass;

public class BasePage extends CoreClass {

	public static void loadUrl(String url) {
		CoreClass.getDriver().get(url);
	}

	public static String getText(WebElement webelement) {
		return webelement.getText();
	}

	public static String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

}
