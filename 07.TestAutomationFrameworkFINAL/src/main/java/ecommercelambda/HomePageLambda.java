package ecommercelambda;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePageLambda extends BasePageLambda {
    public HomePageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void navigateToRegisterButton() {
        actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
        actions.waitForElementVisible("//a[contains(@href, 'register')]");
        actions.clickElement("//a[contains(@href, 'register')]");

    }

    public void navigateToLoginButton() {
        actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
        actions.waitForElementVisible("//a[contains(@href, 'login')]");
        actions.clickElement("//a[contains(@href, 'login')]");

    }

    public void clickOnLogoutButton() {
        actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
        actions.waitForElementVisible("//a[contains(@href, 'logout')]");
        actions.clickElement("//a[contains(@href, 'logout')]");

    }

    public void searchForSpecificProduct(String productName) {
        actions.waitForElementClickable("(//input[@type='text'][@placeholder='Search For Products'])[1]");
        actions.clickElement("(//input[@type='text'][@placeholder='Search For Products'])[1]");
        actions.sendKeys("(//input[@type='text'][@placeholder='Search For Products'])[1]", productName);
        actions.keyboardActionEnter("(//input[@type='text'][@placeholder='Search For Products'])[1]");
    }

    public void clickOnSearchedProduct(String name) {
        actions.waitForElementClickable(String.format("(//h4[@class='title']/a[text()='%s'])[2]", name));
        actions.clickElement(String.format("(//h4[@class='title']/a[text()='%s'])[2]", name));
    }

    public void navigateToFirstTopProduct(String name) {
        actions.scrollDown(500); //scroll to element scrolls too much check why
        actions.waitForElementClickable(String.format("(//h4[@class='title']/a[@class='text-ellipsis-2' and text()='%s'])[1]", name));
        actions.clickElement(String.format("(//h4[@class='title']/a[@class='text-ellipsis-2' and text()='%s'])[1]", name));
    }

    public void assertHomePageNavigated() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
        Assertions.assertTrue(driver.getTitle().contains("Your Store"));
    }

    public void assertSearchedProductInSearchResults(String productName) { ///use stringformat and make iPhone with %s to provide it in tests
        actions.scrollToElement(String.format("(//h4[@class='title']/a[text()='%s'])[1]", productName));
        actions.assertElementPresent(String.format("(//h4[@class='title']/a[text()='%s'])[1]", productName));
    }

    public void assertSearchedProductPriceIsCorrect(String productPrice) {
        actions.scrollToElement(String.format("(//span[@class='price-new' and text()='%s'])[1]", productPrice));
        actions.assertElementPresent(String.format("(//span[@class='price-new' and text()='%s'])[1]", productPrice));
    }
}
