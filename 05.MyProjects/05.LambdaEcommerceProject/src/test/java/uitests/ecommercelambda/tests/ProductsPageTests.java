package uitests.ecommercelambda.tests;

import com.telerikacademy.testframework.Utils;
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
    public void compareTwoProductsComparesSelectedProductsCorrectlyTest() throws InterruptedException {
        homePageLambda.searchForSpecificProduct(PRODUCT_IPHONE);
        homePageLambda.clickOnSearchedProduct(PRODUCT_IPHONE);

        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.productsPageAssertions().
                assertProductAddedToCompareListMessage(PRODUCT_IPHONE));

        homePageLambda.navigateToPage();

        homePageLambda.searchForSpecificProduct(PRODUCT_HTC_TOUCH_HD);
        homePageLambda.clickOnSearchedProduct(PRODUCT_HTC_TOUCH_HD);
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.productsPageAssertions().
                assertProductAddedToCompareListMessage(PRODUCT_HTC_TOUCH_HD));

        productsPageLambda.clickOnCompareButton();
        productsPageLambda.productsPageAssertions().assertComparisonPageNavigated();
        productsPageLambda.productsPageAssertions().assertComparedProductName(PRODUCT_IPHONE);
        productsPageLambda.productsPageAssertions().assertComparedProductName(PRODUCT_HTC_TOUCH_HD);
        productsPageLambda.productsPageAssertions().assertComparedCorrectPriceOfProduct(IPHONE_PRICE);
        productsPageLambda.productsPageAssertions().assertComparedCorrectPriceOfProduct(HTC_TOUCH_HD_PRICE);

    }

    @Test
    public void addToCartButtonAddsProductToCartTest() {
        homePageLambda.searchForSpecificProduct(PRODUCT_CANON_EOS_5_D);
        homePageLambda.clickOnSearchedProduct(PRODUCT_CANON_EOS_5_D);

        productsPageLambda.selectProductSize();
        productsPageLambda.addToCartFromProductPage();

        Assertions.assertTrue(productsPageLambda.productsPageAssertions().
                assertProductAddedToCartListMessage(PRODUCT_CANON_EOS_5_D));

    }

    @Test
    public void wishListButtonAddsProductToWishListTest() {
        firstName += Utils.generateUser();
        lastName += Utils.generateUser();
        password += Utils.generatePassword();
        email += Utils.generateEmail();

        homePageLambda.navigateToRegisterButton();
        registerPageLambda.registerUser(firstName, lastName, email, password, PHONE_NUMBER);

        homePageLambda.searchForSpecificProduct(PRODUCT_PALM_TREO_PRO);
        productsPageLambda.addProductToWishList(PRODUCT_PALM_TREO_PRO);

        productsPageLambda.productsPageAssertions().assertProductAddedToWishListMessage(PRODUCT_PALM_TREO_PRO);

    }

}
