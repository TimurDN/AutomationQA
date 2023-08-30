package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage extends BasePage{
    public CheckoutOverviewPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait,"checkout-step-two.html");
    }

    ///url

    //locator
   public By summaryTotalLocator = By.className("summary_total_label");


    //methods

    public String getTotalPrice (){
        return driver.findElement(summaryTotalLocator).getText();

    }
    public Double getTotalPriceNumber (){
        String priceText = getTotalPrice();
        return Double.parseDouble(priceText.replace("$",""));

    }
}
