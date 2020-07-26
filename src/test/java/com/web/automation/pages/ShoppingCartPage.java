package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.web.automation.assertions.Validation;

/**
 * The HomePage class contains all the Xpath and method related to Shopping Cart Page.
 * 
 * @author Aarti
 *
 */
public class ShoppingCartPage {

	// Concatenate driver
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='navigation_page']]")
	@CacheLookup
	public WebElement shoppingPage;
	
	@FindBy(xpath = "//td/p[@class='product-name']/a")
	@CacheLookup
	public WebElement productName;
	
	@FindBy(id = "cart_title")
	@CacheLookup
	public WebElement summary;

	/**
	 * The method is used for validating shopping cart page 
	 */
	public void verifyShoppingCartPage() {
		Assert.assertTrue(Validation.isElementDisplay(shoppingPage), "Is shopping Page span display");
		Assert.assertTrue(Validation.isElementDisplay(productName), "Is productName text display");
		Assert.assertTrue(Validation.isElementDisplay(summary), "Is SHOPPING-CART SUMMARY text display");
	}
}