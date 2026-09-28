package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

	private final By productsTitle = By.cssSelector(".title");
	private final By menuBtn = By.id("react-burger-menu-btn");
	private final By logoutLink = By.id("logout_sidebar_link");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public String getProductsTitle() {
		return waitUtil.waitForElementVisible(productsTitle).getText();
	}

	public void clickMenu() {
		waitUtil.waitForElementAndClick(menuBtn);
	}

	public void clickLogout() {
		waitUtil.waitForElementAndClick(logoutLink);
	}

}
