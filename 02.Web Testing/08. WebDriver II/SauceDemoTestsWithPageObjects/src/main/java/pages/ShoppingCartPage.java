package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartPage  extends BasePage {
    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    // Locators
    public By shoppingCartItemName = By.className("inventory_item_name");
    public By checkoutButton = By.id("checkout");

    // Methods
    public List<WebElement> getShoppingCartItems(){
        return driver.findElements(shoppingCartItemName);
    }

    public void clickCheckoutButton(){
        driver.findElement(checkoutButton).click();
    }
}
