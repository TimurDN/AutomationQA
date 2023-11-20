package ecommercelambda.RegisterPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class RegisterPageAssertions extends BasePageLambda {
    public RegisterPageAssertions(WebDriver driver) {
        super(driver, "lambda.register.page");
    }

    public void assertSuccessfulRegistration() {
        actions.assertElementPresentUsingWebElement(registerPageElements().registerSuccessHeader());
    }

    public void assertRegisterFormDisplayed() {
        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerAccountText());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerAccountText());

    }

    public void assertExistingEmailErrorMessage() {
        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerExistingEmailErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerExistingEmailErrorMessage());

    }

    public void assertUserIsNotNavigatedToNextPage() {
        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerAccountText());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerAccountText());
    }

    public void assertRegisterFormErrorMessagesForEmptyFields() {
        //separate assertions into methods
        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerFirstNameFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerFirstNameFieldErrorMessage());

        actions.clickElementUsingWebElement(registerPageElements().registerLastNameFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerLastNameFieldErrorMessage());

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerEmailFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerEmailFieldErrorMessage());

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerPhoneFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerPhoneFieldErrorMessage());

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerPasswordFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerPasswordFieldErrorMessage());

    }
}
