package ecommercelambda;

import com.telerikacademy.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPageLambda extends BasePage {
    public LoginPageLambda(WebDriver driver) {
        super(driver, "lambda.login.page");
    }

    public void loginUser(String username, String password) {

        navigateToPage();

        actions.waitForElementVisible("login.page.username");
        actions.typeValueInField(username, "login.page.username");

        actions.waitForElementVisible("login.page.password");
        actions.typeValueInField(password, "login.page.password");

        actions.clickElement("login.submit.button");

        actions.waitForElementVisible("header.member.menu.button");
    }

    public void assertAdminAuthenticatedUser() {
        actions.assertElementPresent("header.admin.member.button");
    }

    public void assertAuthenticatedUser() {
        actions.assertElementPresent("header.member.menu.button");
    }
}