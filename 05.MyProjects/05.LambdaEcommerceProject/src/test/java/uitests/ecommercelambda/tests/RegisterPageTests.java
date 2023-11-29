package uitests.ecommercelambda.tests;

import com.telerikacademy.testframework.Utils;
import ecommercelambda.RegisterPage.RegisterPageAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class RegisterPageTests extends BaseTestLambda {

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
        homePageLambda.navigateToRegisterButton();
    }

    @Test
    public void testRegisterFormAccessTest() {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();

        registerPageLambda.registerPageAssertions().assertRegisterFormDisplayed();
    }

    @Test
    public void registerUserWithMandatoryFieldsTest() {
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);

        registerPageLambda.registerPageAssertions().assertSuccessfulRegistration();
    }

    @Test
    public void registerUserWithExistingEmailTest() {
        registerPageLambda.registerUser(firstName, lastName, EXISTING_EMAIL, password, PHONE_NUMBER);

        registerPageLambda.registerPageAssertions().assertExistingEmailErrorMessage();
    }

    @Test
    public void errorMessagesWhenEmptyFieldsSubmittedTest() {
        registerPageLambda.registerUser("",
                "", "", "", "");

        registerPageLambda.registerPageAssertions().assertUserIsNotNavigatedToNextPage();
        registerPageLambda.registerPageAssertions().assertRegisterFormErrorMessagesForEmptyFields();
    }
}
