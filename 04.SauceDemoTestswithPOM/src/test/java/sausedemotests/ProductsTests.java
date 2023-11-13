package sausedemotests;

import core.BaseTest;
import dev.failsafe.internal.util.Assert;
import org.example.BrowserTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CheckoutCompletePage;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;

public class ProductsTests extends BaseTest {

    @BeforeEach
    public void beforeTest() {

        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");

    }

    @Test
    public void productAddedToShoppingCart_when_addToCart() {

        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = shoppingCartPage.getShoppingCartItems();

        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
    }


    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation() {
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        shoppingCartPage.clickCheckOutButton();

        // fill form

        checkoutYourInformationPage.fillShippingDetails("Fname", "Lname", "zip");
        //fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinueButton();

        var items = shoppingCartPage.getShoppingCartItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");


        var total = checkoutOverviewPage.getTotalPrice();
        double expectedPrice = 29.99 + 15.99 + 3.68;
        String expectedTotal = String.valueOf(new Formatter(Locale.US).format("Total: $%.2f", expectedPrice));

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(backpackTitle, items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(shirtTitle, items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedTotal, total, "Items total price not as expected");
    }


    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm() {
        String backpackTitle = "Sauce Labs Backpack";
        String shirtTitle = "Sauce Labs Bolt T-Shirt";

        // Add Backpack and T-shirt to shopping cart
        inventoryPage.addProductByTitle(backpackTitle);
        inventoryPage.addProductByTitle(shirtTitle);

        // Click on shopping Cart
        inventoryPage.clickShoppingCartLink();

        shoppingCartPage.clickCheckOutButton();

        // Fill Contact Details
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        // Complete Order (Assuming there's a button or action for this)
        checkoutYourInformationPage.clickContinueButton();

        checkoutCompletePage.clickOnFinishButton();

        var items = checkoutCompletePage.getShoppingCartItems();

        // Assert Items removed from Shopping Cart (You may need to navigate back to the cart page)
        Assertions.assertEquals(0, items.size(), "Cart should be empty after completing the order");
    }
}