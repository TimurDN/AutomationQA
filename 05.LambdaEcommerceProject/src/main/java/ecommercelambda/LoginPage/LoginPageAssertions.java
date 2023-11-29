package ecommercelambda.LoginPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class LoginPageAssertions extends BasePageLambda {
    public LoginPageAssertions(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void assertAuthenticatedUser() {
        actions.assertElementPresentUsingWebElement(loginPageElements().loginMyAccountButton());
    }

    public void assertAuthenticationError() {
        actions.assertElementPresentUsingWebElement(loginPageElements().loginErrorMessage());
    }

    public void assertLoginFormElementsDisplayed() {
        actions.assertElementPresentUsingWebElement(loginPageElements().loginEmailField());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginPasswordField());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginSubmitButton());

    }
}
