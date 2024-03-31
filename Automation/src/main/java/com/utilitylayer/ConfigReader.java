package com.utilitylayer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static ThreadLocal<Properties> property = new ThreadLocal<Properties>();

	public static void initializePropertyFile(String fileName) {

		String path = System.getProperty("user.dir") + "\\src\\main\\java\\com\\configlayer\\" + fileName
				+ ".properties";

		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		property.set(prop);
	}

	public static String readValue(String fileName, String key) {
		ConfigReader.initializePropertyFile(fileName);
		return ConfigReader.property.get().getProperty(key);
	}

}
