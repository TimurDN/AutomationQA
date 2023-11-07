package ecommercelambda;

import com.telerikacademy.pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class RegisterPageLambda extends BasePage {
    public RegisterPageLambda(WebDriver driver) {
        super(driver, "lambda.register.page");
    }

    public void registerUser(String generateFirstName,String generateLastName,String generatePassword) {
        navigateToPage();

        actions.waitForElementClickable("register.page.firstNameField");
        actions.typeValueInField(generateFirstName, "register.page.firstNameField");

        actions.waitForElementClickable("register.page.lastNameField");
        actions.typeValueInField(generateLastName, "register.page.lastNameField");

        actions.waitForElementClickable("register.page.emailField");
        actions.typeValueInField("test@abv.bg", "register.page.emailField");

        actions.waitForElementClickable("register.page.phoneField");
        actions.typeValueInField("151517815454", "register.page.phoneField");

        actions.waitForElementClickable("register.page.passwordField");
        actions.typeValueInField(generatePassword, "register.page.passwordField");

        actions.waitForElementClickable("register.page.confirmPasswordField");
        actions.typeValueInField(generatePassword, "register.page.confirmPasswordField");

        actions.scrollToElement("//input[@id='input-agree']");
        actions.waitForElementVisible("register.page.privacyPolicyField");
        actions.waitForElementClickable("register.page.privacyPolicyField");
        actions.clickElement("register.page.privacyPolicyField");

        actions.waitForElementClickable("register.page.continueButton");
        actions.clickElement("register.page.continueButton");

    }

    public String generateUser() {
        String username = RandomStringUtils.randomAlphabetic(4);
        return "User" + username;
    }

    public String generatePassword() {
        String randomPass = RandomStringUtils.randomAlphabetic(5);
        return "password" + randomPass;
    }

    public void assertSuccessfulRegistration() {
        actions.assertElementPresent("register.page.successful.register");
        actions.clickElement("register.page.successful.register");

    }

    public void assertRegisterFormDisplayed(){
        actions.waitForElementVisible("//h1[text()='Register Account']");
        actions.assertElementPresent("//h1[text()='Register Account']");

    }
}