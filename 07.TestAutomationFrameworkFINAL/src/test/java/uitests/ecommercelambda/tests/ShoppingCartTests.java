package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class ShoppingCartTests extends BaseTestLambda {

    @BeforeEach
    public void beforeTestSetup() {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToFirstTopProduct(PRODUCT_IMAC);
        productsPageLambda.addToCartFromProductPage();
    }

    @Test
    public void addItemToTheShoppingCartTest() {
        productsPageLambda.assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

    }

    @Test
    public void removeAddedItemFromTheShoppingCartTest() {
        ;
        productsPageLambda.assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

        shoppingCartPageLambda.clickOnEditCartButton();
        shoppingCartPageLambda.removeAddedItemFromCart();
        shoppingCartPageLambda.assertEmptyShoppingCart(YOUR_SHOPPING_CART_IS_EMPTY);

    }

    @Test
    public void userCanAccessCheckOutPageFromShoppingCartTest() {
        productsPageLambda.assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();
        shoppingCartPageLambda.assertNavigateCheckOutPageFromShoppingCart();
    }
}
