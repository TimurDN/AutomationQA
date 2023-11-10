package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class ConfirmOrderPageTests extends BaseTestLambda {

    String firstName = "";
    String lastName = "";
    String password = "";
    String email = "";

    @Test
    public void placingOrderSuccessfullyTest() throws InterruptedException {

        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();

        homePageLambda.navigateToPage();
        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);
        homePageLambda.clickOnLogoutButton();

        homePageLambda.navigateToLoginButton();
        loginPageLambda.loginUser(email, password);

        homePageLambda.searchForSpecificProduct(PRODUCT_CANON_EOS_5_D);
        homePageLambda.clickOnSearchedProduct(PRODUCT_CANON_EOS_5_D);
        productsPageLambda.selectProductSize();

        productsPageLambda.addToCartFromProductPage();
        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();

        checkOutPageLambda.fillInBillingDetailsAndCheckOut(firstName, lastName,
                COMPANY_NAME, COMPANY_ADDRESS, CITY_SOFIA, POST_CODE_SOFIA);

        checkOutPageLambda.assertNavigationToConfirmOrderAfterCheckOut();
        checkOutPageLambda.assertProductIsInCheckOutPage(PRODUCT_CANON_EOS_5_D);

        confirmOrderPageLambda.clickOnConfirmOrderButton();
        confirmOrderPageLambda.assertOrderIsSuccessful();

    }

    @AfterEach
    public void logOut() {
        homePageLambda.navigateToPage();
        homePageLambda.clickOnLogoutButton();
    }
}
