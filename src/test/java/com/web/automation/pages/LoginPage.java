package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.web.automation.assertions.Validation;
import com.web.automation.utility.ConfigReader;

/**
 * The HomePage class contains all the Xpath and method related to login page.
 * 
 * @author Aarti
 *
 */
public class LoginPage {

	// Concatenate driver
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "email")
	@CacheLookup
	public WebElement emailTxt;
	
	@FindBy(id = "passwd")
	@CacheLookup
	public WebElement passwdTxt;
	
	@FindBy(id = "SubmitLogin")
	@CacheLookup
	public WebElement loginBtn;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']/p")
	@CacheLookup
	public WebElement errorMsg;
	
	public void setUserEmailId(String email){
		emailTxt.clear();
		emailTxt.sendKeys(ConfigReader.readLocators(email));
	}

	public void setUserPassword(String pass){
		passwdTxt.clear();
		passwdTxt.sendKeys(ConfigReader.readLocators(pass));
	}
	
	/**
	 * The method is used for validating login page 
	 */
	public void verifyLoginPage() {
		Assert.assertTrue(Validation.isElementDisplay(emailTxt), "Is email textbox display");
		Assert.assertTrue(Validation.isElementDisplay(passwdTxt), "Is passwd text box display");
		Assert.assertTrue(Validation.isElementDisplay(loginBtn), "Is login button display");
	}

	/**
	 * The method is used for validating error message while entering invalid password
	 */
	public void verifyLoginError() throws InterruptedException {
		Validation.isTextDisplay(errorMsg, "error");
	}
}