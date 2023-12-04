package ecommerceamazon.HomePage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePageAssertions extends BasePageAmazon {
    public HomePageAssertions(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void assertHomePageNavigated() {
        driver.get("https://www.amazon.com/");
        Assertions.assertTrue(driver.getTitle().contains("Amazon.com"));
    }

    public void assertSearchBarVisibleAndClickable() {
        actions.assertElementPresentUsingWebElement(homePageElements().homeSearchBar());
        actions.assertElementPresentUsingWebElement(homePageElements().homeSearchBarAjax());
    }

    public void assertHomePageLogo() {
        actions.assertElementPresentUsingWebElement(homePageElements().homeAmazonLogo());

    }

    public void assertTodaysDealsButton(String buttonName) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeShopNavButtons(buttonName));

    }
    public void assertRegistryButton(String buttonName) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeShopNavButtons(buttonName));

    }

    public void assertCustomerServiceButton(String buttonName) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeShopNavButtons(buttonName));

    }

    public void assertGiftCardsButton(String buttonName) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeShopNavButtons(buttonName));

    }

    public void assertSellButton(String buttonName) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeShopNavButtons(buttonName));

    }

    public void assertHomeAccountButton() {
        actions.assertElementPresentUsingWebElement(homePageElements().homeAccountButton());

    }

    public void assertHomeLanguageButton() {
        actions.assertElementPresentUsingWebElement(homePageElements().homeLanguageButton());

    }

    public void assertHomeDefaultLanguage(String language) {
        actions.assertElementPresentUsingWebElement(homePageElements().homeDefaultLanguage(language));

    }

    public void assertOrdersButton(){
        actions.assertElementPresentUsingWebElement(homePageElements().homeOrdersButton());
    }

    public void assertShoppingCartButton(){
        actions.assertElementPresentUsingWebElement(homePageElements().homeShoppingCartButton());
    }

}
