package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.PHONE_NUMBER;
import static com.telerikacademy.testframework.Constants.PRODUCT_CANON_EOS_5_D;

public class CheckOutTests extends BaseTestLambda {

    String firstName = "";
    String lastName = "";
    String password = "";
    String email = "";

    @Test
    public void checkOutWithValidAddressDetailsAndFieldsTest() {

        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();

        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.navigateToLogoutButton();

        homePageLambda.navigateToLoginButton();
        loginPageLambda.loginUser(email, password);

        homePageLambda.searchForSpecificProduct(PRODUCT_CANON_EOS_5_D);
        homePageLambda.clickOnSearchedProduct(PRODUCT_CANON_EOS_5_D);
        productsPageLambda.selectProductSize();

        productsPageLambda.addToCartFromProductPage();
        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();
    }
}
