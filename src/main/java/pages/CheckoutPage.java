package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class CheckoutPage extends BasePage {

	private final By firstName = By.id("first-name");
	private final By lastName = By.id("last-name");
	private final By postalCode = By.id("postal-code");
	private final By continueBtn = By.id("continue");
	private final By finishBtn = By.id("finish");
	private final By confirmationMessage = By.className("complete-header");
	private final By errorMessage = By.cssSelector("[data-test='error']");

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public void enterFirstName(String value) {
		waitUtil.waitForElementAndSendKeys(firstName, value);
	}

	public void enterLastName(String value) {
		waitUtil.waitForElementAndSendKeys(lastName, value);
	}

	public void enterPostalCode(String value) {
		waitUtil.waitForElementAndSendKeys(postalCode, value);
	}

	public void clickContinue() {
		waitUtil.waitForElementAndClick(continueBtn);
	}

	public void clickFinish() {
		waitUtil.waitForElementAndClick(finishBtn);
	}

	public String getConfirmationMessage() {
		return waitUtil.waitForElementVisible(confirmationMessage).getText();
	}

	public String getErrorMessage() {
		return waitUtil.waitForElementVisible(errorMessage).getText();
	}

}
