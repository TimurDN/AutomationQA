package sausedemotests;

import core.BaseTest;
import org.example.BrowserTypes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @BeforeAll
    public static void beforeAllTests(){
        driver = startBrowser(BrowserTypes.CHROME);

        // Configure wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Navigate to Google.com
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void userAuthenticated_when_validCredentialsProvided(){
        authenticateWithUser("standard_user", "secret_sauce");

        // Add Assert
    }

    @Test
    public void productAddedToShoppingCar_when_addToCart(){
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Assert Items and Totals
    }

    @Test
    public void userDetailsAdded_when_checkoutWithValidInformation(){
        // Add Backpack and T-shirt to shopping cart

        // Click on shopping Cart

        // Fill Contact Details

        // Assert Details in next step
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
