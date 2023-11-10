package ecommercelambda;

import com.github.javafaker.Faker;
import com.telerikacademy.pages.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

public class RegisterPageLambda extends BasePage {
    public RegisterPageLambda(WebDriver driver) {
        super(driver, "lambda.register.page");
    }

    public void registerUser(String generateFirstName,String generateLastName,
                             String generateEmail, String generatePassword, String phoneNumber) {
        navigateToPage();

        actions.waitForElementClickable("register.page.firstNameField");
        actions.typeValueInField(generateFirstName, "register.page.firstNameField");

        actions.waitForElementClickable("register.page.lastNameField");
        actions.typeValueInField(generateLastName, "register.page.lastNameField");

        actions.waitForElementClickable("register.page.emailField");
        actions.typeValueInField(generateEmail, "register.page.emailField");

        actions.waitForElementClickable("register.page.phoneField");
        actions.typeValueInField(phoneNumber, "register.page.phoneField");

        actions.waitForElementClickable("register.page.passwordField");
        actions.typeValueInField(generatePassword, "register.page.passwordField");

        actions.waitForElementClickable("register.page.confirmPasswordField");
        actions.typeValueInField(generatePassword, "register.page.confirmPasswordField");

        actions.scrollToElement("//input[@id='input-agree']");
        actions.waitForElementClickable("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]");
        actions.clickElement("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/label[1]");

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

    public String generateEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public void assertSuccessfulRegistration() {
        actions.assertElementPresent("register.page.successful.register");
        actions.clickElement("register.page.successful.register");

    }

    public void assertRegisterFormDisplayed(){
        actions.waitForElementVisible("//h1[text()='Register Account']");
        actions.assertElementPresent("//h1[text()='Register Account']");

    }
    public void assertExistingEmailErrorMessage(){
        actions.waitForElementVisible
                ("//div[@class='alert alert-danger alert-dismissible' " +
                        "and contains(text(),' Warning: E-Mail Address is already registered!')] ");
        actions.assertElementVisible("//div[@class='alert alert-danger alert-dismissible' " +
                "and contains(text(),' Warning: E-Mail Address is already registered!')] ");

    }

    public void assertUserIsNotNavigatedToNextPage(){
        actions.waitForElementVisible("//h1[text()='Register Account']");
        actions.assertElementVisible("//h1[text()='Register Account']");
    }

    public void assertRegisterFormErrorMessagesForEmptyFields(){
        actions.waitForElementVisible("//div[text()='First Name must be between 1 and 32 characters!']");
        actions.assertElementVisible("//div[text()='First Name must be between 1 and 32 characters!']");

        actions.waitForElementVisible("//div[text()='Last Name must be between 1 and 32 characters!']");
        actions.assertElementVisible("//div[text()='Last Name must be between 1 and 32 characters!']");

        actions.waitForElementVisible("//div[text()='E-Mail Address does not appear to be valid!']");
        actions.assertElementVisible("//div[text()='E-Mail Address does not appear to be valid!']");

        actions.waitForElementVisible("//div[text()='Telephone must be between 3 and 32 characters!']");
        actions.assertElementVisible("//div[text()='Telephone must be between 3 and 32 characters!']");

        actions.waitForElementVisible("//div[text()='Password must be between 4 and 20 characters!']");
        actions.assertElementVisible("//div[text()='Password must be between 4 and 20 characters!']");

    }
}