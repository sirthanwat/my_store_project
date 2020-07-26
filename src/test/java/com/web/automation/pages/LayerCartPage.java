package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.web.automation.assertions.Validation;

/**
 * The HomePage class contains all the Xpath and method related to Layer Cart Page.
 * 
 * @author Aarti
 *
 */
public class LayerCartPage {

	// Concatenate driver
	public LayerCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2/i[@class=\"icon-ok\"]")
	@CacheLookup
	public WebElement okIcon;
	
	@FindBy(xpath = "//h2[contains(.,'Product successfully added to your shopping cart')]")
	@CacheLookup
	public WebElement layerMessage;
	
	@FindBy(xpath = "//span[@class=\"ajax_cart_product_txt  unvisible\"]")
	@CacheLookup
	public WebElement noOfItemMsg;
	
	@FindBy(xpath = "//strong[contains(.,'Quantity')]")
	@CacheLookup
	public WebElement quality;
	
	@FindBy(xpath = "//div/span[@id='layer_cart_product_price']/preceding-sibling::strong")
	@CacheLookup
	public WebElement total;
	
	@FindBy(xpath = "//span[@class='cross']")
	@CacheLookup
	public WebElement crossIcon;

	/**
	 * The method is used for validating Layer cart page 
	 */
	public void verifyLayerCartPage() {
		Assert.assertTrue(Validation.isElementDisplay(okIcon), "Is okIcon text display");
		Assert.assertTrue(Validation.isElementDisplay(layerMessage), "Is layerMessage display");
		Assert.assertTrue(Validation.isElementDisplay(noOfItemMsg), "Is noOfItemMsg display");
		Assert.assertTrue(Validation.isElementDisplay(quality), "Is quality text display");
		Assert.assertTrue(Validation.isElementDisplay(total), "Is total text display");
		Assert.assertTrue(Validation.isElementDisplay(crossIcon), "Is cross Icon display");
	}
}