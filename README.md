# E-Commerce Automation Framework

A Java-based Selenium automation framework developed using Maven and TestNG for automating end-to-end e-commerce workflows.

## Tech Stack

- Java 21
- Selenium WebDriver 4.47.0
- TestNG 7.11.0
- Maven
- Extent Reports
- Git / GitHub
- Page Object Model (POM)

## Framework Features

- Page Object Model (POM)
- Data-driven testing using TestNG DataProvider
- Environment-based configuration
- Centralized test data management
- WebDriver Factory
- Explicit wait utility
- TestNG groups
- Retry mechanism for failed tests
- Parallel test execution
- Extent HTML reporting
- Automatic screenshot capture on failure
- Custom framework exception handling
- Maven execution
- Git/GitHub integration

## Project Structure

```text
ecommerce-automation
│
├── src/main/java
│   ├── base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── HomePage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   └── CheckoutPage.java
│   │
│   └── utilities
│       ├── ConfigReader.java
│       ├── ExtentReportManager.java
│       ├── FrameworkConstants.java
│       ├── FrameworkException.java
│       ├── ReportUtil.java
│       ├── RetryAnalyzer.java
│       ├── ScreenshotUtil.java
│       ├── TestDataKeys.java
│       ├── TestDataReader.java
│       ├── TestListener.java
│       ├── WaitUtil.java
│       └── WebDriverFactory.java
│
├── src/main/resources
│   ├── config.properties
│   ├── config-qa.properties
│   └── config-uat.properties
│
├── src/test/java
│   └── tests
│       ├── LoginTest.java
│       ├── ProductCartTest.java
│       ├── CheckoutTest.java
│       └── NegativeCheckoutTest.java
│
├── src/test/resources
│   └── testdata.properties
│
├── testng.xml
├── pom.xml
└── README.md
Test Scenarios
Smoke Tests
Valid user login
Add product to cart
Successful checkout
Regression Tests
Invalid login scenarios
Checkout validation when First Name is missing
Configuration

The framework supports environment-based execution.

Example configuration files:

config-qa.properties
config-uat.properties

The environment is passed through testng.xml:

<parameter name="environment" value="uat"/>

The ConfigReader dynamically loads the corresponding configuration file.

Test Data

Test data is maintained separately in:

src/test/resources/testdata.properties

Frequently used test-data keys are centralized in:

TestDataKeys.java

This avoids hardcoded test-data keys throughout the test classes.

Reporting

The framework uses Extent Reports to generate an HTML execution report.

The report is generated under:

test-output/ExtentReport.html

The report includes:

Test status
Test class
Browser
Environment
Test execution steps
Failure details
Screenshots for failed tests
Screenshot on Failure

The custom TestNG listener automatically captures a screenshot when a test fails and attaches it to the Extent report.

Retry Mechanism

The framework uses TestNG's IRetryAnalyzer to retry failed tests caused by temporary or flaky issues.

The current configuration allows a limited number of retry attempts.

Parallel Execution

TestNG parallel execution is configured in testng.xml.

parallel="tests"
thread-count="2"

Each test execution creates its own WebDriver instance through BaseTest.

Running Tests
Using Maven

Run the complete TestNG suite:

mvn test
Using Eclipse

Right-click:

testng.xml
→ Run As
→ TestNG Suite
Application Under Test

The framework currently automates:

https://www.saucedemo.com/
Framework Architecture

The framework follows a layered architecture:

Test Classes
     ↓
Page Objects
     ↓
Base Page
     ↓
Wait Utility
     ↓
Selenium WebDriver

Supporting components:

TestNG
 ├── Test Listener
 ├── Retry Analyzer
 ├── Groups
 └── Data Provider

Configuration
 └── Config Reader

Test Data
 └── Test Data Reader

Reporting
 └── Extent Reports
Author

Shubham Kakde