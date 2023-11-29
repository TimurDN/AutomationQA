package ecommercelambda.ConfirmOrderPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderPageElements extends BasePageLambda {
    public ConfirmOrderPageElements(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public WebElement confirmOrderButton() {
        actions.waitForElementClickable("//button[@id='button-confirm']");
        return driver.findElement(By.xpath(
                "//button[@id='button-confirm']"));
    }

    public WebElement successfulOrderMessage() {
        actions.waitTillElementIsVisible(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Success')]");
        return driver.findElement(By.xpath(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Success')]"));
    }
}
