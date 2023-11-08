package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

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

    }

    @Test
    public void testRegisterFormAccessTest() {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();

        registerPageLambda.assertRegisterFormDisplayed();

    }

    @Test
    public void registerUserWithMandatoryFieldsTest() {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password);

        registerPageLambda.assertSuccessfulRegistration();
    }

    @Test
    public void registerUserWithAllFieldsTest() {

    }

    @Test
    public void errorMessagesWhenEmptyFieldsSubmittedTest() {

    }
}
