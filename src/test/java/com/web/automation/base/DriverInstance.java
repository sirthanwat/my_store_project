package com.web.automation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.web.automation.utility.ConfigReader;

public class DriverInstance {
	public static WebDriver driver;

	/**
	 * The method is used for intializing the Webdriver
	 * 
	 */
	public static void setDriverInstance() {
		if (ConfigReader.readProjectConfiguration("Browser").equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//driver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (ConfigReader.readProjectConfiguration("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/driver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (ConfigReader.readProjectConfiguration("Browser").equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "/driver/iedriver");
			driver = new InternetExplorerDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", "/driver/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(ConfigReader.readProjectConfiguration("ApplicationUrl"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	/**
	 * The method is used for getting driver instance
	 * 
	 */
	public static WebDriver getDriverInstance() {
		if (driver != null)
			return driver;
		else {
			setDriverInstance();
			return driver;
		}
	}

	/**
	 * The method is used for assigning driver valur to null page
	 */
	public void setDriverInstanceToNull() {
		driver = null;
	}
}
