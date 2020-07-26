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
 * The HomePage class contains all the Xpath and method related to home page.
 * 
 * @author Aarti
 *
 */
public class HomePage {

	// Concatenate driver
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='login']")
	@CacheLookup
	public WebElement signInBtn;
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	@CacheLookup
	public WebElement search;
	
	@FindBy(xpath = "//button[@name=\"submit_search\"]")
	@CacheLookup
	public WebElement clickSearch;
	
	@FindBy(xpath = "//h5/a[@title='Printed Chiffon Dress' and @itemprop='url']")
	@CacheLookup
	public WebElement selectProduct;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	@CacheLookup
	public WebElement addToCard;
	
	@FindBy(id = "layer_cart_product_title")
	@CacheLookup
	public WebElement layerCardTitle;
	
	@FindBy(xpath = "//div[@class='shopping_cart']/a[@title='View my shopping cart']")
	@CacheLookup
	public WebElement cartView;
	
	@FindBy(xpath = "//a[@title='View']/span[contains(., 'More')]")
	@CacheLookup
	public WebElement moreBtn;
	
	/**
	 * The method is used for searching the product
	 * 
	 * @param ele : will define String value
	 */
	public void searchProduct(String product) {
		search.sendKeys(ConfigReader.readLocators(product));
		clickSearch.click();
	}
	/**
	 * The method is used for validating home page 
	 */
	public void verifyHomePage() {
		Assert.assertTrue(Validation.isElementDisplay(signInBtn), "Is signIn button display");
		Assert.assertTrue(Validation.isElementDisplay(search), "Is search field display");
		Assert.assertTrue(Validation.isElementDisplay(clickSearch), "Is search button display");
		Assert.assertTrue(Validation.isElementDisplay(cartView), "Is cartView field display");
	}
}