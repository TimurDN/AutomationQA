package ecommercelambda.HomePage;

import ecommercelambda.BasePage.BasePageLambda;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePageLambda extends BasePageLambda {
    public HomePageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void navigateToRegisterButton() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        actions.waitTillElementIsVisibleUsingWebElement(homePageElements().homeRegisterButton());
        homePageElements().homeRegisterButton().click();

    }

    public void navigateToLoginButton() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        actions.waitTillElementIsVisibleUsingWebElement(homePageElements().homeLoginButton());
        homePageElements().homeLoginButton().click();

    }

    public void logoutUser() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        actions.waitTillElementIsVisibleUsingWebElement(homePageElements().homeLogoutButton());
        homePageElements().homeLogoutButton().click();

    }

    public void searchForSpecificProduct(String productName) {
        actions.waitTillElementIsVisibleUsingWebElement(homePageElements().homeSearchBar());
        homePageElements().homeSearchBar().click();

        homePageElements().homeSearchBar().sendKeys(productName);
        actions.keyboardActionEnterUsingWebElement(homePageElements().homeSearchBar());
    }

    public void clickOnSearchedProduct(String name) {
        actions.waitTillElementIsVisibleUsingWebElement(homePageElements().searchedProductByName(name));
        homePageElements().searchedProductByName(name).click();
    }

    public void navigateToFirstTopProduct(String name) {
        actions.scrollDown(500); //scroll to element scrolls too much check why
        actions.assertElementPresentUsingWebElement(homePageElements().firstTopProductByName(name));
        homePageElements().firstTopProductByName(name).click();
    }

}
