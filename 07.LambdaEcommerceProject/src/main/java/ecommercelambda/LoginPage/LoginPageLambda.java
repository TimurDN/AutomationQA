package ecommercelambda.LoginPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class LoginPageLambda extends BasePageLambda {
    public LoginPageLambda(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void loginUser(String email, String password) {

        navigateToPage();
        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginEmailField());
        loginPageElements().loginEmailField().sendKeys(email);

        actions.waitTillElementIsVisibleUsingWebElement(loginPageElements().loginPasswordField());
        loginPageElements().loginPasswordField().sendKeys(password);

        loginPageElements().loginSubmitButton().click();

    }

}