package ecommercelambda.LoginPage;

import com.telerikacademy.pages.BasePage;
import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageElements extends BasePageLambda {
    public LoginPageElements(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public WebElement loginEmailField() {
        return driver.findElement(By.id("input-email"));
    }

    public WebElement loginPasswordField() {
        return driver.findElement(By.id("input-password"));
    }

    public WebElement loginSubmitButton() {
        return driver.findElement(By.xpath("//input[@value='Login']"));
    }

    public WebElement loginMyAccountButton() {
        return driver.findElement(By.xpath(
                "(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[4]"));
    }

    public WebElement loginErrorMessage() {
        return driver.findElement(By.xpath(
                "//div[text()=' Warning: No match for E-Mail Address and/or Password.']"));
    }
}
