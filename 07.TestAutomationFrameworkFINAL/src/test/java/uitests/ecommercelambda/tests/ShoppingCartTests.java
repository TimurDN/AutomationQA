package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

public class ShoppingCartTests extends BaseTestLambda {

    @BeforeEach
    public void beforeTestSetup(){
        homePageLambda.navigateToPage();
        homePageLambda.navigateToFirstTopProduct("iMac");
        productsPageLambda.addToCartFromProductPage();
    }
    @Test
    public void addItemToTheShoppingCartTest() {
        productsPageLambda.assertProductAddedToCartListMessage("iMac");
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

    }

    @Test
    public void removeAddedItemFromTheShoppingCartTest() {;
        productsPageLambda.assertProductAddedToCartListMessage("iMac");
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

        shoppingCartPageLambda.clickOnEditCartButton();
        shoppingCartPageLambda.removeAddedItemFromCart();
        shoppingCartPageLambda.assertEmptyShoppingCart("Your shopping cart is empty!");

    }
    @Test
    public void userCanAccessCheckOutPageFromShoppingCartTest() {
        productsPageLambda.assertProductAddedToCartListMessage("iMac");
        shoppingCartPageLambda.assertShoppingCartBadgeItemIs1("1");

        shoppingCartPageLambda.closeAddedItemCartPopUp();
        productsPageLambda.clickOnCartButton();
        shoppingCartPageLambda.assertShoppingCardPopUpItemIs1("x1");

        shoppingCartPageLambda.clickCheckOutButtonInShoppingCart();
        shoppingCartPageLambda.assertNavigateCheckOutPageFromShoppingCart();
    }
}
