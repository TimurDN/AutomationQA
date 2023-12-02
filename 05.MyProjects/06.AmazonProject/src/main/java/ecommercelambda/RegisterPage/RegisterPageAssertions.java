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
        actions.assertElementPresentUsingWebElement(registerPageElements().registerAccountText());

    }

    public void assertExistingEmailErrorMessage() {
        actions.assertElementPresentUsingWebElement(registerPageElements().registerExistingEmailErrorMessage());

    }

    public void assertUserIsNotNavigatedToNextPage() {
        actions.assertElementPresentUsingWebElement(registerPageElements().registerAccountText());
    }

    public void assertRegisterFormErrorMessagesForEmptyFields() {
        //separate assertions into methods
        actions.assertElementPresentUsingWebElement(registerPageElements().registerFirstNameFieldErrorMessage());
        registerPageElements().registerLastNameFieldErrorMessage().click();
        actions.assertElementPresentUsingWebElement(registerPageElements().registerLastNameFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerEmailFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerPhoneFieldErrorMessage());
        actions.assertElementPresentUsingWebElement(registerPageElements().registerPasswordFieldErrorMessage());

    }
}
