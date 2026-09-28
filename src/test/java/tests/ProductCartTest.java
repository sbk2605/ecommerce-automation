package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestDataKeys;
import utilities.ReportUtil;

public class ProductCartTest extends BaseTest {

	@Test(groups = "smoke")
	public void verifyProductAddedToCart() {
		ReportUtil.logStep("Open Login Page");

		LoginPage loginPage = new LoginPage(driver);

		ReportUtil.logStep("Login with valid credentials");

		HomePage homePage = loginPage.login(testDataReader.getTestData(TestDataKeys.USERNAME),
				testDataReader.getTestData(TestDataKeys.PASSWORD));

		ReportUtil.logStep("Verify Products page");

		Assert.assertEquals(homePage.getProductsTitle(), "Products", "Products page was not displayed");

		ReportUtil.logStep("Add Sauce Labs Backpack to cart");

		ProductPage productPage = new ProductPage(driver);

		productPage.addBackpackToCart();

		ReportUtil.logStep("Open shopping cart");

		productPage.clickCart();

		CartPage cartPage = new CartPage(driver);

		ReportUtil.logStep("Verify product in cart");

		Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack",
				"Expected product was not added to cart");

		ReportUtil.logStep("Verify Checkout button");

		Assert.assertTrue(cartPage.isCheckoutButtonDisplayed(), "Checkout button was not displayed");

		ReportUtil.logStep("Product cart validation completed");
	}
}