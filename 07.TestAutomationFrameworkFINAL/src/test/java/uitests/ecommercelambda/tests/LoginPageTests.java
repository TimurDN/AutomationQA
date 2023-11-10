package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class LoginPageTests extends BaseTestLambda {

    String firstName = "";
    String lastName = "";
    String password = "";
    String email = "";

    @BeforeEach
    public void beforeTestSetup() {

        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();

        homePageLambda.navigateToPage();

    }

    @Test
    public void loginFormAccessTest() {
        homePageLambda.navigateToLoginButton();

        loginPageLambda.assertLoginFormElementsDisplayed();

    }

    @Test
    public void loginWithValidCredentials() {
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.clickOnLogoutButton();

        loginPageLambda.loginUser(email, password);
        loginPageLambda.assertAuthenticatedUser();

    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.clickOnLogoutButton();

        loginPageLambda.loginUserWithInvalidPassword(email, INVALID_PASSWORD);
        loginPageLambda.assertAuthenticationError();

    }


}
