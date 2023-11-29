package ecommercelambda.ConfirmOrderPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPageAssertions extends BasePageLambda {
    public ConfirmOrderPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertOrderIsSuccessful() {
        actions.assertElementPresentUsingWebElement(confirmOrderPageElements().successfulOrderMessage());

    }
}
