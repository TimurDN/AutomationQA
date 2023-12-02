package ecommercelambda.HomePage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class HomePageLambda extends BasePageLambda {
    public HomePageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void navigateToRegisterButton() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        homePageElements().homeRegisterButton().click();

    }

    public void navigateToLoginButton() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        homePageElements().homeLoginButton().click();

    }

    public void logoutUser() {
        actions.mouseHoverByUsingWebElement(homePageElements().homeMyAccountButton());
        homePageElements().homeLogoutButton().click();

    }

    public void searchForSpecificProduct(String productName) {
        homePageElements().homeSearchBar().click();

        homePageElements().homeSearchBar().sendKeys(productName);
        actions.keyboardActionEnterUsingWebElement(homePageElements().homeSearchBar());
    }

    public void clickOnSearchedProduct(String name) {
        homePageElements().searchedProductByName(name).click();
    }

    public void navigateToFirstTopProduct(String name) {
        actions.scrollDown(500); //scroll to element scrolls too much check why
        actions.assertElementPresentUsingWebElement(homePageElements().firstTopProductByName(name));
        homePageElements().firstTopProductByName(name).click();
    }

}
