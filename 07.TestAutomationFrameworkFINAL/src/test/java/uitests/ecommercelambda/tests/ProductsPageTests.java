package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

public class ProductsPageTests extends BaseTestLambda {

    String firstName = "";
    String lastName = "";
    String password = "";
    String email = "";

    @BeforeEach
    public void beforeTestSetup() {
        homePageLambda.navigateToPage();
    }

    @Test
    public void compareTwoProductsComparesSelectedProductsCorrectlyTest() {
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage("iPhone"));

        homePageLambda.navigateToPage();

        homePageLambda.searchForSpecificProduct("HTC Touch HD");
        homePageLambda.clickOnSearchedProduct("HTC Touch HD");
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage("HTC Touch HD"));

        productsPageLambda.clickOnCompareButton();
        productsPageLambda.assertComparisonPageNavigated();
        productsPageLambda.assertComparedProductName1("iPhone");
        productsPageLambda.assertComparedProductName2("HTC Touch HD");
        productsPageLambda.assertComparedCorrectPriceOfProduct1("$123.20");
        productsPageLambda.assertComparedCorrectPriceOfProduct2("$146.00");

    }

    @Test
    public void addToCartButtonAddsProductToCartTest() {
        homePageLambda.searchForSpecificProduct("Canon EOS 5D");
        homePageLambda.clickOnSearchedProduct("Canon EOS 5D");

        productsPageLambda.selectProductSize();
        productsPageLambda.addToCartFromProductPage();

        Assertions.assertTrue(productsPageLambda.assertProductAddedToCartListMessage("Canon EOS 5D"));

    }

    @Test
    public void wishListButtonAddsProductToWishListTest() {
        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();

        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName,lastName,email,password);

        homePageLambda.searchForSpecificProduct("Palm Treo Pro");
        productsPageLambda.addProductToWishList();

        productsPageLambda.assertProductAddedToWishListMessage("Palm Treo Pro");

    }

}
