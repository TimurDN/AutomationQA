package ecommercelambda.LoginPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements extends BasePageLambda {
    public LoginPageElements(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public WebElement loginEmailField() {
        actions.waitForElementClickable("//input[@id='input-email']");
        return driver.findElement(By.id("input-email"));
    }

    public WebElement loginPasswordField() {
        actions.waitForElementClickable("//input[@id='input-password']");
        return driver.findElement(By.id("input-password"));
    }

    public WebElement loginSubmitButton() {
        actions.waitForElementClickable("//input[@value='Login']");
        return driver.findElement(By.xpath("//input[@value='Login']"));
    }

    public WebElement loginMyAccountButton() {
        actions.waitTillElementIsVisible(
                "(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[4]");
        return driver.findElement(By.xpath(
                "(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[4]"));
    }

    public WebElement loginErrorMessage() {
        actions.waitTillElementIsVisible(
                "//div[text()=' Warning: No match for E-Mail Address and/or Password.']");
        return driver.findElement(By.xpath(
                "//div[text()=' Warning: No match for E-Mail Address and/or Password.']"));
    }
}
