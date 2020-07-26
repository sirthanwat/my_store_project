package com.web.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.web.automation.assertions.Validation;

/**
 * The HomePage class contains all the Xpath and method related to Product Search Page.
 * 
 * @author Aarti
 *
 */
public class ProductSearchPage {

	// Concatenate driver
	public ProductSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@itemprop='name']")
	@CacheLookup
	public WebElement productName;
	
	@FindBy(xpath = "//ul[@id='usefull_link_block']/li[@class='sendtofriend']/a")
	@CacheLookup
	public WebElement sendtofriendLnk;
	
	@FindBy(xpath = "//ul[@id='usefull_link_block']/li[@class='print']/a")
	@CacheLookup
	public WebElement printLnk;
	
	@FindBy(xpath = "//button[@type='submit']/span[contains(.,'Add to cart')]")
	@CacheLookup
	public WebElement addToCardBtn;
	
	@FindBy(xpath = "//span[@class='span_link no-print']")
	@CacheLookup
	public WebElement pluseIcon;
	
	@FindBy(xpath = "//div/img[@class='fancybox-image']")
	@CacheLookup
	public WebElement imageIcon;
	
	@FindBy(xpath = "//a[@title='Close']")
	@CacheLookup
	public WebElement closeIcon;
	
	@FindBy(id = "quantity_wanted")
	@CacheLookup
	public WebElement quality;
	
	@FindBy(id = "uniform-group_1")
	@CacheLookup
	public WebElement size;

	/**
	 * The method is used for validating product search page 
	 */
	public void verifyProductSearchPage() {
		Assert.assertTrue(Validation.isElementDisplay(productName), "Is product Name field display");
		Assert.assertTrue(Validation.isElementDisplay(sendtofriendLnk), "Is sendtofriend ink display");
		Assert.assertTrue(Validation.isElementDisplay(printLnk), "Is print link display");
		Assert.assertTrue(Validation.isElementDisplay(addToCardBtn), "Is addToCard button display");
	}
}