package com.web.automation.utility;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonFuntions {

	public static WebDriver driver;
	public static Actions act = new Actions(driver);

	/**
	 * The method is used for scroll down the web page using action classes
	 * 
	 * @return : will return the result in String
	 */
	public static void scrollDown() {
		act.sendKeys(Keys.DOWN);
	}

	/**
	 * The method is used for validating the page title which is displaying on web
	 * page
	 * 
	 * @return : will return the result in String
	 */
	public static String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	/**
	 * The click method is use for performing click operation for web elements
	 * 
	 * @param element : will define WebElement value
	 * @throws InterruptedException
	 */
	public static void click(WebElement element) throws InterruptedException {
		element.click();
	}

	/**
	 * @param ele  : will define WebElement value
	 * @param text : will define string value
	 * @return : will return the result in boolean.
	 */
	public static boolean verifyingPage(WebElement ele, String text) {
		boolean result = false;
		result = ele.getText().equals(text) ? true : false;
		return result;
	}

	/**
	 * The click method is used for returning text for web elements
	 * 
	 * @param element : will define WebElement value
	 * @throws InterruptedException
	 */
	public static String getElementText(WebElement element) throws InterruptedException {
		return element.getText();
	}

	/**
	 * The method is used for returning to child window
	 * 
	 * @throws InterruptedException
	 */
	public static void switchToWindow() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String windowHandle : handles) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	/**
	 * The method is used for returning to parent window
	 * 
	 * @throws InterruptedException
	 */
	public static void switchToParentWindow() throws InterruptedException {
		String parentWindow = driver.getWindowHandle();
		driver.switchTo().window(parentWindow);
	}

	/**
	 * The method is used for scroll down the web page using action classes page
	 * 
	 * @param element : will define WebElement value
	 */
	public static void scrollDownByJE(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**
	 * The method is used for elementMoveOver
	 * 
	 * @param element : will define WebElement value
	 */
	public static void elementMoveOver(WebElement element) {
       act.moveToElement(element).click();
	}
	
	/**
	 * The method is used for sending the elements
	 * 
	 * @param element : will define WebElement value
	 */
	public static void sendkeys(WebElement element, String text) {
		element.sendKeys(ConfigReader.readLocators(text));
	}
}
