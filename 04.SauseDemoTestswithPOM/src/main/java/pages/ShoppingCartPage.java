package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ShoppingCartPage extends BasePage{
    public ShoppingCartPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "cart.html");
    }

    //

    //locators
    public By checkOutButtonLocator = By.id("checkout");
    public By shoppingCartItemName = By.className("inventory_item_name");


    //methods

    public List<WebElement> getShoppingCartItems (){
       return driver.findElements(shoppingCartItemName);
    }

    public void clickCheckOutButton(){
        driver.findElement(checkOutButtonLocator).click();

    }

}
