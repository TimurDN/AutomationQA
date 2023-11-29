package uitests.ecommercelambda.tests;

import com.telerikacademy.testframework.Utils;
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

        firstName += Utils.generateUser();
        lastName += Utils.generateUser();
        password += Utils.generatePassword();
        email += Utils.generateEmail();

        homePageLambda.navigateToPage();

    }

    @Test
    public void loginFormAccessTest() {
        homePageLambda.navigateToLoginButton();

        loginPageLambda.loginPageAssertions().assertLoginFormElementsDisplayed();

    }

    @Test
    public void loginWithValidCredentials() {
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.logoutUser();

        loginPageLambda.loginUser(email, password);

        loginPageLambda.loginPageAssertions().assertAuthenticatedUser();

    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword() {
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.logoutUser();

        loginPageLambda.loginUser(email, INVALID_PASSWORD);
        loginPageLambda.loginPageAssertions().assertAuthenticationError();

    }

}
