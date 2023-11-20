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
        return driver.findElement(By.xpath("//button[@id='button-confirm']"));
    }

    public WebElement successfulOrderMessage() {
        return driver.findElement(By.xpath(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Success')]"));
    }
}
