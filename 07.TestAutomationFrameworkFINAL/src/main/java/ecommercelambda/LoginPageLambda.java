package ecommercelambda;

import com.telerikacademy.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageLambda extends BasePage {
    public LoginPageLambda(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void loginUser(String email, String password) {

        navigateToPage();

        actions.waitForElementVisible("login.page.emailField");
        actions.typeValueInField(email, "login.page.emailField");

        actions.waitForElementVisible("login.page.passwordField");
        actions.typeValueInField(password, "login.page.passwordField");

        actions.clickElement("login.submit.buttonField");

    }

    public void loginUserWithInvalidPassword(String email, String password) {

        navigateToPage();

        actions.waitForElementVisible("login.page.emailField");
        actions.typeValueInField(email, "login.page.emailField");

        actions.waitForElementVisible("login.page.passwordField");
        actions.typeValueInField(password, "login.page.passwordField");

        actions.clickElement("login.submit.buttonField");

    }

    public void assertAuthenticatedUser() {
        actions.assertElementPresent("login.page.myAccountButton");
    }

    public void assertAuthenticationError() {
        actions.assertElementPresent("login.page.failedLoginExclamation");
    }

    public void assertLoginFormElementsDisplayed() {

        actions.assertElementPresent("login.page.emailField");
        actions.assertElementPresent("login.page.passwordField");
        actions.assertElementPresent("login.submit.buttonField");

    }
}