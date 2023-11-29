package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends BasePage {
    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-two.html");
    }

    public By totalPrice = By.className("summary_total_label");

    public String getTotalPrice(){
        return driver.findElement(totalPrice).getText();
    }

    public Double getTotalPriceNumber(){
        String priceText = getTotalPrice();
        return Double.parseDouble(priceText.replace("$", ""));
    }
}
