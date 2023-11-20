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
        return driver.findElement(By.id("input-firstname"));
    }

    public WebElement registerLastNameField() {
        return driver.findElement(By.id("input-lastname"));
    }

    public WebElement registerEmailField() {
        return driver.findElement(By.id("input-email"));
    }

    public WebElement registerPhoneField() {
        return driver.findElement(By.id("input-telephone"));
    }

    public WebElement registerPasswordField() {
        return driver.findElement(By.id("input-password"));
    }

    public WebElement registerConfirmPasswordField() {
        return driver.findElement(By.id("input-confirm"));
    }

    public WebElement registerAgreeCheckBox() {
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement registerContinueButton() {
        return driver.findElement(By.xpath(
                "//input[@type='submit' and contains(@value, 'Continue')]"));
    }

    public WebElement registerSuccessHeader() {
        return driver.findElement(By.xpath(
                "//div[@id='content']//h1[contains(text(), 'Your Account Has Been Created!')]"));
    }

    public WebElement registerAccountText() {
        return driver.findElement(By.xpath("//h1[text()='Register Account']"));
    }

    public WebElement registerExistingEmailErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]"));
    }

    public WebElement registerFirstNameFieldErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()='First Name must be between 1 and 32 characters!']"));
    }

    public WebElement registerLastNameFieldErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()='Last Name must be between 1 and 32 characters!']"));
    }

    public WebElement registerEmailFieldErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()='E-Mail Address does not appear to be valid!']"));
    }

    public WebElement registerPhoneFieldErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()='Telephone must be between 3 and 32 characters!']"));
    }

    public WebElement registerPasswordFieldErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()='Password must be between 4 and 20 characters!']"));
    }

}
