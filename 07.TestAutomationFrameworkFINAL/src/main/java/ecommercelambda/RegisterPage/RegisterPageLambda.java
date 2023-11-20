package ecommercelambda.RegisterPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class RegisterPageLambda extends BasePageLambda {
    public RegisterPageLambda(WebDriver driver) {
        super(driver, "lambda.register.page");
    }


    public void registerUser(String generateFirstName, String generateLastName,
                             String generateEmail, String generatePassword, String phoneNumber) {

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerFirstNameField());
        registerPageElements().registerFirstNameField().sendKeys(generateFirstName);

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerLastNameField());
        registerPageElements().registerLastNameField().sendKeys(generateLastName);

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerEmailField());
        registerPageElements().registerEmailField().sendKeys(generateEmail);

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerPhoneField());
        registerPageElements().registerPhoneField().sendKeys(phoneNumber);

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerPasswordField());
        registerPageElements().registerPasswordField().sendKeys(generatePassword);

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerConfirmPasswordField());
        registerPageElements().registerConfirmPasswordField().sendKeys(generatePassword);

        actions.scrollToElementUsingWebElement(registerPageElements().registerAgreeCheckBox());
        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerAgreeCheckBox());
        registerPageElements().registerAgreeCheckBox().click();

        actions.waitTillElementIsVisibleUsingWebElement(registerPageElements().registerContinueButton());
        registerPageElements().registerContinueButton().click();

    }


}