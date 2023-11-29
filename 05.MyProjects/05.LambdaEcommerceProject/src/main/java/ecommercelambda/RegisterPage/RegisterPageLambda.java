package ecommercelambda.RegisterPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class RegisterPageLambda extends BasePageLambda {
    public RegisterPageLambda(WebDriver driver) {
        super(driver, "lambda.register.page");
    }


    public void registerUser(String generateFirstName, String generateLastName,
                             String generateEmail, String generatePassword, String phoneNumber) {

        registerPageElements().registerFirstNameField().sendKeys(generateFirstName);
        registerPageElements().registerLastNameField().sendKeys(generateLastName);
        registerPageElements().registerEmailField().sendKeys(generateEmail);
        registerPageElements().registerPhoneField().sendKeys(phoneNumber);
        registerPageElements().registerPasswordField().sendKeys(generatePassword);
        registerPageElements().registerConfirmPasswordField().sendKeys(generatePassword);

        actions.scrollToElementUsingWebElement(registerPageElements().registerAgreeCheckBox());
        registerPageElements().registerAgreeCheckBox().click();

        registerPageElements().registerContinueButton().click();

    }


}