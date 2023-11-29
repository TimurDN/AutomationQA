package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-two.html");
    }

    // locators
    public By shoppingCartItems = By.className("inventory_item_name");
    public By summaryPriceLabel = By.className("summary_total_label");
    public By finishLocator = By.id("finish");

    // methods
    public List<WebElement> getShoppingCartItems(){
        return driver.findElements(shoppingCartItems);
    }
    public String getSummaryPrice(){
        return driver.findElement(summaryPriceLabel).getText();
    }
    public Double getSummaryPriceNumber(){
        return Double.parseDouble(getSummaryPrice().replaceAll("$", ""));
    }

    public void clickFinishButton(){
        driver.findElement(finishLocator).click();
    }
}
