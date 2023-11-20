package ecommercelambda.ConfirmOrderPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPageAssertions extends BasePageLambda {
    public ConfirmOrderPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertOrderIsSuccessful() throws InterruptedException {
        Thread.sleep(2000);//will be improved, will avoid using it.
        actions.waitTillElementIsVisibleUsingWebElement(confirmOrderPageElements().successfulOrderMessage());
        actions.assertElementPresentUsingWebElement(confirmOrderPageElements().successfulOrderMessage());

    }
}
