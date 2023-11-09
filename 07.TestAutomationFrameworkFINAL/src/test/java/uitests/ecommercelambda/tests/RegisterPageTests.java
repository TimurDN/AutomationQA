package uitests.ecommercelambda.tests;

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

        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();
        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();

    }

    @Test
    public void testRegisterFormAccessTest() {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();

        registerPageLambda.assertRegisterFormDisplayed();

    }

    @Test
    public void registerUserWithMandatoryFieldsTest() {
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        registerPageLambda.assertSuccessfulRegistration();
    }

    @Test
    public void registerUserWithExistingEmailTest() {
        registerPageLambda.registerUser(firstName, lastName, EXISTING_EMAIL, password, PHONE_NUMBER);
        registerPageLambda.assertExistingEmailErrorMessage();


    }

    @Test
    public void errorMessagesWhenEmptyFieldsSubmittedTest() {
        registerPageLambda.registerUser("",
                "", "", "", "");

    }
}
