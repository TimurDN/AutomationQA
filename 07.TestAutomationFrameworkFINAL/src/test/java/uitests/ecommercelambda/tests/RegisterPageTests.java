package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

public class RegisterPageTests extends BaseTestLambda {

    String firstName = "";
    String lastName = "";
    String password = "";

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

        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();

        registerPageLambda.registerUser(firstName, lastName, password);

    }

    @Test
    public void registerUserWithAllFieldsTest() {

    }

    @Test
    public void errorMessagesWhenEmptyFieldsSubmittedTest() {

    }
}
