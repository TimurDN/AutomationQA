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
        productsPageLambda.productsPageAssertions().assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

    }

    @Test
    public void removeAddedItemFromTheShoppingCartTest() {
        productsPageLambda.productsPageAssertions().assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.clickOnEditCartButton();
        shoppingCartPageLambda.removeAddedItemFromCart();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertEmptyShoppingCart(YOUR_SHOPPING_CART_IS_EMPTY);

    }

    @Test
    public void userCanAccessCheckOutPageFromShoppingCartTest() {
        productsPageLambda.productsPageAssertions().assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertNavigateCheckOutPageFromShoppingCart();

    }
}
