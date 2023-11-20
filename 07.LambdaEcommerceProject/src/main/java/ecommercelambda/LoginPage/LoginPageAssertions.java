package ecommercelambda.LoginPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class LoginPageAssertions extends BasePageLambda {
    public LoginPageAssertions(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void assertAuthenticatedUser() {
        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginMyAccountButton());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginMyAccountButton());
    }

    public void assertAuthenticationError() {
        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginErrorMessage());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginErrorMessage());
    }

    public void assertLoginFormElementsDisplayed() {

        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginEmailField());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginEmailField());

        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginPasswordField());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginPasswordField());

        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginSubmitButton());
        actions.assertElementPresentUsingWebElement(loginPageElements().loginSubmitButton());

    }
}
