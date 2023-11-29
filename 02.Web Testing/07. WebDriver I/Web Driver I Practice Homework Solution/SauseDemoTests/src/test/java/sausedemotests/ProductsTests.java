package sausedemotests;

import core.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class ProductsTests extends BaseTest {
    @BeforeEach
    public void beforeTest(){
        loginPage.navigate();
        loginPage.fillLoginForm("standard_user", "secret_sauce");
    }

    @Test
    public void productAddedToShoppingCart_when_addToCart(){

        inventoryPage.addProductByTitle(Products.BACKPACK.getTitle());
        inventoryPage.addProductByTitle(Products.SHIRT.getTitle());

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        var items = driver.findElements(By.className("inventory_item_name"));

        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        Assertions.assertEquals(Products.BACKPACK.getTitle(), items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(Products.SHIRT.getTitle(), items.get(1).getText(), "Item title not as expected");
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        inventoryPage.addProductByTitle(Products.BACKPACK.getTitle());
        inventoryPage.addProductByTitle(Products.SHIRT.getTitle());

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        driver.findElement(By.id("checkout")).click();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinueButton();

        var items = checkoutOverviewPage.getShoppingCartItems();
        Assertions.assertEquals(2, items.size(), "Items count not as expected");

        var total = checkoutOverviewPage.getSummaryPriceNumber();
        double expectedPrice = 29.99 + 15.99 + 3.68;

        Assertions.assertEquals(2, items.size(), "Items count not as expected");
        Assertions.assertEquals(Products.BACKPACK.getTitle(), items.get(0).getText(), "Item title not as expected");
        Assertions.assertEquals(Products.SHIRT.getTitle(), items.get(1).getText(), "Item title not as expected");
        Assertions.assertEquals(expectedPrice, total, "Items total price not as expected");
    }

    @Test
    public void orderCompleted_when_addProduct_and_checkout_withConfirm(){
        inventoryPage.addProductByTitle(Products.BACKPACK.getTitle());
        inventoryPage.addProductByTitle(Products.SHIRT.getTitle());

        Assertions.assertEquals(2, inventoryPage.getShoppingCartItemsCount(), "shopping cart Items were not added.");

        inventoryPage.clickShoppingCartLink();

        // Assert Items and Totals
        driver.findElement(By.id("checkout")).click();

        // fill form
        checkoutYourInformationPage.fillShippingDetails("Fname", "lname", "zip");

        checkoutYourInformationPage.clickContinueButton();

        checkoutOverviewPage.clickFinishButton();

        Assertions.assertTrue(checkoutCompletePage.getOrderCompletedMessage().isDisplayed(), "Success message was not displayed.");
        Assertions.assertEquals("Thank you for your order!", checkoutCompletePage.getOrderCompletedMessage().getText(), "Success message was nota as expected.");

        checkoutCompletePage.clickBackToProductsButton();
        Assertions.assertEquals(0, inventoryPage.getShoppingCartItemsCount(), "shopping cart was not emptied after purchase.");
    }
}