package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        //url
        super(webDriver, driverWait, "checkout-complete.html");


    }

    ///locators
    public By finishButtonLocator = By.xpath("//button[@id='finish']");

    public By shoppingCartItemName = By.className("inventory_item_name");


    ///methods
    public void clickOnFinishButton() {
        driver.findElement(finishButtonLocator).click();
    }

    public List<WebElement> getShoppingCartItems (){
        return driver.findElements(shoppingCartItemName);
    }
}
