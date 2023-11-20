package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class ShoppingCartTests extends BaseTestLambda {

    @BeforeEach
    public void beforeTestSetup() throws InterruptedException {
        homePageLambda.navigateToPage();
        homePageLambda.navigateToFirstTopProduct(PRODUCT_IMAC);
        productsPageLambda.addToCartFromProductPage();
    }

    @Test
    public void addItemToTheShoppingCartTest() throws InterruptedException {
        productsPageLambda.productsPageAssertions().assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

    }

    @Test
    public void removeAddedItemFromTheShoppingCartTest() throws InterruptedException {
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
    public void userCanAccessCheckOutPageFromShoppingCartTest() throws InterruptedException {
        productsPageLambda.productsPageAssertions().assertProductAddedToCartListMessage(PRODUCT_IMAC);
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertShoppingCartBadgeByAddedAmount("1");

        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();
        shoppingCartPageLambda.shoppingCartPageAssertions().assertNavigateCheckOutPageFromShoppingCart();

    }
}
