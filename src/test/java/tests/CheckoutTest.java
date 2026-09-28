package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.TestDataKeys;

public class CheckoutTest extends BaseTest {

	@Test(groups = "smoke")
	public void verifySuccessfulCheckout() {

		LoginPage loginPage = new LoginPage(driver);

		HomePage homePage = loginPage.login(testDataReader.getTestData(TestDataKeys.USERNAME),
				testDataReader.getTestData(TestDataKeys.PASSWORD));

		Assert.assertEquals(homePage.getProductsTitle(), "Products", "Products page was not displayed");

		ProductPage productPage = new ProductPage(driver);

		productPage.addBackpackToCart();

		productPage.clickCart();

		CartPage cartPage = new CartPage(driver);

		Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack", "Product was not added to cart");

		cartPage.clickCheckout();

		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.enterFirstName(testDataReader.getTestData(TestDataKeys.FIRST_NAME));
		checkoutPage.enterLastName(testDataReader.getTestData(TestDataKeys.LAST_NAME));
		checkoutPage.enterPostalCode(testDataReader.getTestData(TestDataKeys.POSTAL_CODE));

		checkoutPage.clickContinue();

		checkoutPage.clickFinish();

		Assert.assertEquals(checkoutPage.getConfirmationMessage(), "Thank you for your order!",
				"Order confirmation was not displayed");
	}

}
