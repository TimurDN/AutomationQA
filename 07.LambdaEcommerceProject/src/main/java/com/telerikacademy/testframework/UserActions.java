package com.telerikacademy.testframework;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserActions {

    final WebDriver driver;
    public WebDriverWait webDriverWait;
    int defaultTimeout = Integer.parseInt(Utils.getConfigPropertyByKey("config.defaultTimeoutSeconds"));

    public WebDriver getDriver() {
        return driver;
    }

    public UserActions() {
        this.driver = Utils.getWebDriver();
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(defaultTimeout));
    }

    public static void loadBrowser(String baseUrlKey) {
        Utils.getWebDriver().get(Utils.getConfigPropertyByKey(baseUrlKey));
    }

    public static void quitDriver() {
        Utils.tearDownWebDriver();
    }

    public void keyboardActionArrowDownUsingWebElement(WebElement element) {
        Utils.LOGGER.info("Performing keyboard action (Arrow Down) on element");
        element.sendKeys(Keys.ARROW_DOWN);
    }

    public void keyboardActionEnterUsingWebElement(WebElement element) {
        Utils.LOGGER.info("Performing keyboard action (Enter) on element");
        element.sendKeys(Keys.ENTER);
    }


    public void scrollToElementUsingWebElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void scrollDown(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, " + pixels + ");");
    }


    public void mouseHoverByUsingWebElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }


    //############# WAITS #########

    public void waitTillElementIsVisible(String locator) {

        int defaultTimeout = Integer.parseInt(Utils.getConfigPropertyByKey("config.defaultTimeoutSeconds"));

        waitForElementVisibleUntilTimeout(locator, defaultTimeout);

    }

    public void waitForElementClickable(String locatorKey, Object... arguments) {
        int defaultTimeout = Integer.parseInt(Utils.getConfigPropertyByKey("config.defaultTimeoutSeconds"));

        waitForElementToBeClickableUntilTimeout(locatorKey, defaultTimeout, arguments);
    }

    public void waitForElementToBeClickableUntilTimeout(String locator, int seconds, Object... locatorArguments) {
        Duration timeout = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String xpath = getLocatorValueByKey(locator, locatorArguments);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        } catch (Exception exception) {
            Assertions.fail("Element with locator: '" + xpath + "' was not found.");
        }
    }

    private void waitForElementVisibleUntilTimeout(String locator, int seconds, Object... locatorArguments) {
        Duration timeout = Duration.ofSeconds(seconds);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        String xpath = getLocatorValueByKey(locator, locatorArguments);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception exception) {
            Assertions.fail("Element with locator: '" + xpath + "' was not found.");
        }
    }

    private String getLocatorValueByKey(String locator, Object[] arguments) {
        return String.format(Utils.getUIMappingByKey(locator), arguments);
    }

    public void assertElementPresentUsingWebElement(WebElement element, Object... arguments) {
        Assertions.assertNotNull(element, String.format("Element with %s doesn't present.", element));
    }

}