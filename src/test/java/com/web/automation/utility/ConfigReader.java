package com.web.automation.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

	public static String readProjectConfiguration(String keyValue) {
		String keyName = null;
		try {
			FileReader file = new FileReader(new File("./configFile/projectConfiguration.properties"));
			Properties readProperty = new Properties();
			readProperty.load(file);
			keyName = readProperty.getProperty(keyValue).trim();
		} catch (Exception excetion) {
			excetion.printStackTrace();
			throw (new RuntimeException("*****ERROR***** :- Key with name " +keyValue+ " dose not exist"));
		}
		return keyName;
	}

	public static String readLocators(String keyValue) {
		String keyName = null;
		try {
			FileReader file = new FileReader(new File("./elementLocators/locators.properties"));
			Properties readProperty = new Properties();
			readProperty.load(file);
			keyName = readProperty.getProperty(keyValue).trim();
		} catch (Exception excetion) {
			excetion.printStackTrace();
			throw (new RuntimeException("*****ERROR***** :- Key with name " +keyValue+ " dose not exist"));
		}
		return keyName;
	}
}
