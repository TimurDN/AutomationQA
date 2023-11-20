package ecommercelambda.LoginPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class LoginPageLambda extends BasePageLambda {
    public LoginPageLambda(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void loginUser(String email, String password) {
        navigateToPage();
        loginPageElements().loginEmailField().sendKeys(email);

        loginPageElements().loginPasswordField().sendKeys(password);

        loginPageElements().loginSubmitButton().click();

    }

}