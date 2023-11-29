package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutCompletePage extends BasePage {
    public CheckoutCompletePage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-complete.html");
    }

    public By orderCompletedMessage = By.xpath("//h2[@class='complete-header']");
    public By backToProductsButton = By.id("back-to-products");

    public WebElement getOrderCompletedMessage(){
        return driver.findElement(orderCompletedMessage);
    }
    public void clickBackToProductsButton(){
        driver.findElement(backToProductsButton).click();
    }
}
