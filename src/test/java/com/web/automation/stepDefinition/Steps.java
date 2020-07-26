package com.web.automation.stepDefinition;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.web.automation.pages.LoginPage;
import com.web.automation.pages.HomePage;
import com.web.automation.pages.LayerCartPage;
import com.web.automation.pages.ShoppingCartPage;
import com.web.automation.pages.ProductSearchPage;
import com.web.automation.utility.CommonFuntions;
import com.web.automation.utility.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.web.automation.assertions.Validation;
import com.web.automation.base.DriverInstance;

/**
 * The StepDefinition class contains all the method definition for given
 * assignment.
 * 
 * @author Aarti
 *
 */
public class Steps {
	public WebDriver driver;
	public WebDriverWait wait= new WebDriverWait(driver, 5);

	public Steps( WebDriver driver) {
		this.driver=driver;
	}
	

	LoginPage login = new LoginPage(driver);
	HomePage homePage = new HomePage(driver);
	LayerCartPage layerCartPage = new LayerCartPage(driver);
	ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
	ProductSearchPage productSearch = new ProductSearchPage(driver);

	/**
	 * This method has been used for launching browser
	 */
	@Given("^Open the browser and launch the application$")
	public void browserInitiate() throws Throwable {
		DriverInstance.setDriverInstance();
	}

	/**
	 * This method has been used for verifying Home page
	 */
	@When("^User is on Home page$")
	public void verifyPage() throws Throwable {
		String title = CommonFuntions.getPageTitle();
		assertEquals(ConfigReader.readLocators("homeTitle"), title);
		homePage.verifyHomePage();
	}

	/**
	 * This method has been used for searching the product
	 */
	@When("^User will search for the product$")
	public void searchingProduct() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(homePage.selectProduct));
		homePage.searchProduct("product");
	}

	/**
	 * This method has been used for validating searching browser
	 */
	@When("^User validate the search result$")
	public void validateProduct() throws Throwable {
		CommonFuntions.scrollDownByJE(homePage.selectProduct);
		boolean selectProductDisplay = Validation.isElementDisplay(homePage.selectProduct);
		assertEquals(selectProductDisplay, true);
	}

	/**
	 * This method has been used for adding the product in cart
	 */
	@Then("^User will add a product to cart$")
	public void addProductToCart() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(homePage.addToCard));
		CommonFuntions.click(homePage.addToCard);
	}

	/**
	 * This method has been used for validating added cart product
	 */
	@Then("^User validate the addition of the product is successful to the cart$")
	public void validateCartProduct() throws Throwable {
		CommonFuntions.switchToWindow();
		String text = CommonFuntions.getElementText(homePage.layerCardTitle);
		boolean layerProductDisplay = Validation.isTextDisplay(homePage.layerCardTitle, text);
		assertEquals(layerProductDisplay, true);
		layerCartPage.verifyLayerCartPage();
		CommonFuntions.click(layerCartPage.crossIcon);
		wait.until(ExpectedConditions.visibilityOf(homePage.cartView));
		CommonFuntions.click(homePage.cartView);
		shoppingCartPage.verifyShoppingCartPage();
	}

	/**
	 * This method has been used for clicking on more button
	 */
	@Then("^User will scroll down to a product to a mouse over and click on More$")
	public void scrollToPoductAndClickOnMore() throws Throwable {
		CommonFuntions.scrollDownByJE(homePage.selectProduct);
		wait.until(ExpectedConditions.elementToBeClickable(homePage.moreBtn));
		CommonFuntions.elementMoveOver(homePage.moreBtn);
		CommonFuntions.click(homePage.moreBtn);
	}

	/**
	 * This method has been used for validating cart product informations
	 */
	@Then("^User validate the resulting page has correct information$")
	public void validatingResultingPage() throws Throwable {
		String text = CommonFuntions.getElementText(productSearch.productName);
		assertEquals(text, ConfigReader.readLocators("product"));
		productSearch.verifyProductSearchPage();
	}

	/**
	 * This method has been used for validating quality, size of product
	 */
	@Then("^User is validating increment and decrement of quantity, size$")
	public void validatingIncrementDecrementQuantitySize() throws Throwable {
		CommonFuntions.click(productSearch.pluseIcon);
		Assert.assertTrue(Validation.isElementDisplay(productSearch.imageIcon), "Is fancybox-image display");
		CommonFuntions.click(productSearch.closeIcon);
		Assert.assertTrue(Validation.isElementDisplay(productSearch.quality), "Is quality text box display");
		Assert.assertTrue(Validation.isElementDisplay(productSearch.size), "Is size text box display");
	}

	/**
	 * This method has been used for adding product in cart using more button
	 */
	@Then("^User is adding product to Cart$")
	public void addingProductToCart() throws Throwable {
		CommonFuntions.click(productSearch.addToCardBtn);
		CommonFuntions.switchToWindow();
		String text = CommonFuntions.getElementText(homePage.layerCardTitle);
		assertEquals(text, ConfigReader.readLocators("product"));
	}

	/**
	 * This method has been used for validating login page
	 */
	@When("^User is on login page$")
	public void userloginVerification() throws Throwable {
		login.verifyLoginPage();
	}

	/**
	 * This method has been used for entering email id in text box
	 */
	@When("^User enter email id$")
	public void enterEmailId() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(login.emailTxt));
		login.setUserEmailId("userEmailId");
	}

	/**
	 * This method has been used for validating invalid login
	 */
	@When("^User enter invalid password$")
	public void enterInvalidPassword() throws Throwable {
		wait.until(ExpectedConditions.visibilityOf(login.passwdTxt));
		login.setUserPassword("userPassword");
	}

	/**
	 * This method has been used for validating error login message
	 */
	@Then("^User should be not be logged in the application$")
	public void applicationFailedLogin() throws Throwable {
		CommonFuntions.click(login.loginBtn);
		login.verifyLoginError();
	}

	/**
	 * This method has been used for closing browser
	 */
	@When("^Close the browser$")
	public void closeBrowser() throws Throwable {
		DriverInstance.getDriverInstance().quit();
	}
}
