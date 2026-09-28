package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class ProductPage extends BasePage {

	private final By backpack = By.id("add-to-cart-sauce-labs-backpack");
	private final By cartIcon = By.className("shopping_cart_link");

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public void addBackpackToCart() {
		waitUtil.waitForElementAndClick(backpack);
	}

	public void clickCart() {
		waitUtil.waitForElementAndClick(cartIcon);
	}

}
