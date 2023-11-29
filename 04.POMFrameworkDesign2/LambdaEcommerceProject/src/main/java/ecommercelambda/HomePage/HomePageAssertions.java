package ecommercelambda.HomePage;

import ecommercelambda.BasePage.BasePageLambda;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePageAssertions extends BasePageLambda {
    public HomePageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertHomePageNavigated() {
        driver.get("https://ecommerce-playground.lambdatest.io/");
        Assertions.assertTrue(driver.getTitle().contains("Your Store"));
    }

    public void assertSearchedProductInSearchResults(String productName) {
        actions.scrollToElementUsingWebElement(homePageElements().searchResultProductByName(productName));
        actions.assertElementPresentUsingWebElement(homePageElements().searchedProductByName(productName));
    }

    public void assertSearchedProductPriceIsCorrect(String productPrice) {
        actions.scrollToElementUsingWebElement(homePageElements().searchResultProductPrice(productPrice));
        actions.assertElementPresentUsingWebElement(homePageElements().searchResultProductPrice(productPrice));
    }
}
