package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.HomePage;
import utilities.TestDataReader;
import utilities.ReportUtil;
import utilities.RetryAnalyzer;
import utilities.TestDataKeys;

public class LoginTest extends BaseTest {

	@Test(groups = "smoke", retryAnalyzer = RetryAnalyzer.class)
	public void verifyValidLogin() {

		ReportUtil.logStep("Open Login Page");

		LoginPage loginPage = new LoginPage(driver);

		ReportUtil.logStep("Enter username");

		HomePage homePage = loginPage.login(testDataReader.getTestData("username"),
				testDataReader.getTestData("password"));

		ReportUtil.logStep("Verify Products page");

		Assert.assertEquals(homePage.getProductsTitle(), "Products", "Products page was not displayed");

		ReportUtil.logStep("Valid login verification completed");
	}

	@DataProvider(name = "invalidLoginData")
	public Object[][] invalidLoginData() {

		TestDataReader testData = new TestDataReader();

		return new Object[][] {
				{ testData.getTestData(TestDataKeys.INVALID_USERNAME), testData.getTestData(TestDataKeys.PASSWORD) },

				{ testData.getTestData(TestDataKeys.USERNAME), testData.getTestData(TestDataKeys.INVALID_PASSWORD) },

				{ testData.getTestData(TestDataKeys.EMPTY_USERNAME), testData.getTestData(TestDataKeys.PASSWORD) },

				{ testData.getTestData(TestDataKeys.USERNAME), testData.getTestData(TestDataKeys.EMPTY_PASSWORD) } };
	}

	@Test(dataProvider = "invalidLoginData", groups = "regression")
	public void verifyInvalidLogin(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		String errorMessage = loginPage.getErrorMessage();

		Assert.assertTrue(errorMessage.contains("Epic sadface"), "Expected login error message was not displayed");
	}

}
