package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductsTests extends BaseTest {
    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
        inventoryPage.waitForPageTitle();
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){

        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        inventoryPage.addProductsByTitle(backpackTitle, shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = shoppingCartPage.getShoppingCartItems();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.clickCheckoutButton();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");
        checkoutYourInformationPage.clickContinueButton();

        var items = shoppingCartPage.getShoppingCartItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        var total = checkoutOverviewPage.getTotalPriceNumber();
        double expectedPrice = 29.99 + 15.99 + 3.68;

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedPrice, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Fill Contact Details

        // Complete Order

        // Assert Items removed from Shopping Cart
    }
}