package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;
import static com.telerikacademy.testframework.Constants.*;

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
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage(PRODUCT_IPHONE));

        homePageLambda.navigateToPage();

        homePageLambda.searchForSpecificProduct(PRODUCT_HTC_TOUCH_HD);
        homePageLambda.clickOnSearchedProduct(PRODUCT_HTC_TOUCH_HD);
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage(PRODUCT_HTC_TOUCH_HD));

        productsPageLambda.clickOnCompareButton();
        productsPageLambda.assertComparisonPageNavigated();
        productsPageLambda.assertComparedProductName1(PRODUCT_IPHONE);
        productsPageLambda.assertComparedProductName2(PRODUCT_HTC_TOUCH_HD);
        productsPageLambda.assertComparedCorrectPriceOfProduct1(IPHONE_PRICE);
        productsPageLambda.assertComparedCorrectPriceOfProduct2(HTC_TOUCH_HD_PRICE);

    }

    @Test
    public void addToCartButtonAddsProductToCartTest() {
        homePageLambda.searchForSpecificProduct(PRODUCT_CANON_EOS_5_D);
        homePageLambda.clickOnSearchedProduct(PRODUCT_CANON_EOS_5_D);

        productsPageLambda.selectProductSize();
        productsPageLambda.addToCartFromProductPage();

        Assertions.assertTrue(productsPageLambda.assertProductAddedToCartListMessage(PRODUCT_CANON_EOS_5_D));

    }

    @Test
    public void wishListButtonAddsProductToWishListTest() {
        firstName += registerPageLambda.generateUser();
        lastName += registerPageLambda.generateUser();
        password += registerPageLambda.generatePassword();
        email += registerPageLambda.generateEmail();

        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName,lastName,email,password,PHONE_NUMBER);

        homePageLambda.searchForSpecificProduct(PRODUCT_PALM_TREO_PRO);
        productsPageLambda.addProductToWishList();

        productsPageLambda.assertProductAddedToWishListMessage(PRODUCT_PALM_TREO_PRO);

    }

}
