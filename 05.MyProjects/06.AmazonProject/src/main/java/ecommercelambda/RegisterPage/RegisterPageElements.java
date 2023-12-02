package ecommercelambda.RegisterPage;

import com.telerikacademy.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageElements extends BasePage {
    public RegisterPageElements(WebDriver driver) {
        super(driver, "lambda.register.page");
    }

    public WebElement registerFirstNameField() {
        actions.waitForElementClickable("//input[@id='input-firstname']");
        return driver.findElement(By.id("input-firstname"));
    }

    public WebElement registerLastNameField() {
        actions.waitForElementClickable("//input[@id='input-lastname']");
        return driver.findElement(By.id("input-lastname"));
    }

    public WebElement registerEmailField() {
        actions.waitForElementClickable("//input[@id='input-email']");
        return driver.findElement(By.id("input-email"));
    }

    public WebElement registerPhoneField() {
        actions.waitForElementClickable("//input[@id='input-telephone']");
        return driver.findElement(By.id("input-telephone"));
    }

    public WebElement registerPasswordField() {
        actions.waitForElementClickable("//input[@id='input-password']");
        return driver.findElement(By.id("input-password"));
    }

    public WebElement registerConfirmPasswordField() {
        actions.waitForElementClickable("//input[@id='input-confirm']");
        return driver.findElement(By.id("input-confirm"));
    }

    public WebElement registerAgreeCheckBox() {
        actions.waitForElementClickable("//label[@for='input-agree']");
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement registerContinueButton() {
        actions.waitForElementClickable("//input[@type='submit' and contains(@value, 'Continue')]");
        return driver.findElement(By.xpath(
                "//input[@type='submit' and contains(@value, 'Continue')]"));
    }

    public WebElement registerSuccessHeader() {
        actions.waitTillElementIsVisible(
                "//div[@id='content']//h1[contains(text(), 'Your Account Has Been Created!')]");
        return driver.findElement(By.xpath(
                "//div[@id='content']//h1[contains(text(), 'Your Account Has Been Created!')]"));
    }

    public WebElement registerAccountText() {
        actions.waitTillElementIsVisible("//h1[text()='Register Account']");
        return driver.findElement(By.xpath("//h1[text()='Register Account']"));
    }

    public WebElement registerExistingEmailErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]");
        return driver.findElement(By.xpath(
                "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]"));
    }

    public WebElement registerFirstNameFieldErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()='First Name must be between 1 and 32 characters!']");
        return driver.findElement(By.xpath(
                "//div[text()='First Name must be between 1 and 32 characters!']"));
    }

    public WebElement registerLastNameFieldErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()='Last Name must be between 1 and 32 characters!']");
        return driver.findElement(By.xpath(
                "//div[text()='Last Name must be between 1 and 32 characters!']"));
    }

    public WebElement registerEmailFieldErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()='E-Mail Address does not appear to be valid!']");
        return driver.findElement(By.xpath(
                "//div[text()='E-Mail Address does not appear to be valid!']"));
    }

    public WebElement registerPhoneFieldErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()='Telephone must be between 3 and 32 characters!']");
        return driver.findElement(By.xpath(
                "//div[text()='Telephone must be between 3 and 32 characters!']"));
    }

    public WebElement registerPasswordFieldErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()='Password must be between 4 and 20 characters!']");
        return driver.findElement(By.xpath(
                "//div[text()='Password must be between 4 and 20 characters!']"));
    }

}
