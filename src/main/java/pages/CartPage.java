package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CartPage extends BasePage {

	private final By cartItem = By.className("inventory_item_name");
	private final By checkoutBtn = By.id("checkout");

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public String getCartItemName() {
		return waitUtil.waitForElementVisible(cartItem).getText();
	}

	public void clickCheckout() {
		waitUtil.waitForElementAndClick(checkoutBtn);
	}

	public boolean isCheckoutButtonDisplayed() {
		return waitUtil.waitForElementVisible(checkoutBtn).isDisplayed();
	}

}
