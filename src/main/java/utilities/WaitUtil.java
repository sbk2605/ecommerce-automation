package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	private final WebDriverWait wait;

	public WaitUtil(WebDriver driver) {
	    this.wait = new WebDriverWait(driver,
	            Duration.ofSeconds(FrameworkConstants.EXPLICIT_WAIT_SECONDS));
	}

	public WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementAndClick(By locator) {
		waitForElementClickable(locator).click();
	}

	public void waitForElementAndSendKeys(By locator, String text) {
		waitForElementVisible(locator).sendKeys(text);
	}

}
