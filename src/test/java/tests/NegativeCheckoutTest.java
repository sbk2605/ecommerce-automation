package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.ReportUtil;
import utilities.TestDataKeys;

public class NegativeCheckoutTest extends BaseTest {

	@Test(groups = "regression")
	public void verifyCheckoutWithoutFirstName() {

		ReportUtil.logStep("Login with valid credentials");

		LoginPage loginPage = new LoginPage(driver);

		HomePage homePage = loginPage.login(testDataReader.getTestData(TestDataKeys.USERNAME),
				testDataReader.getTestData(TestDataKeys.PASSWORD));

		Assert.assertEquals(homePage.getProductsTitle(), "Products", "Products page was not displayed");

		ReportUtil.logStep("Add product to cart");

		ProductPage productPage = new ProductPage(driver);

		productPage.addBackpackToCart();
		productPage.clickCart();

		CartPage cartPage = new CartPage(driver);

		Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack", "Product was not added to cart");

		ReportUtil.logStep("Open checkout");

		cartPage.clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		ReportUtil.logStep("Leave First Name empty");

		checkoutPage.enterLastName(testDataReader.getTestData(TestDataKeys.LAST_NAME));

		checkoutPage.enterPostalCode(testDataReader.getTestData(TestDataKeys.POSTAL_CODE));

		checkoutPage.clickContinue();

		ReportUtil.logStep("Verify checkout validation message");

		String errorMessage = checkoutPage.getErrorMessage();

		Assert.assertTrue(errorMessage.contains("First Name is required"),
				"Expected First Name validation message was not displayed");
	}
}