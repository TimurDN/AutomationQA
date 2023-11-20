package ecommercelambda.CheckOutPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class CheckOutPageAssertions extends BasePageLambda {
    public CheckOutPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertNavigationToConfirmOrderAfterCheckOut() throws InterruptedException {
        Thread.sleep(2000); //will be improved, will avoid using thread sleep.
        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().confirmOrderText());
        actions.assertElementPresentUsingWebElement(checkOutPageElements().confirmOrderText());
    }

    public void assertProductIsInCheckOutPage(String productName) {
        actions.waitTillElementIsVisibleUsingWebElement(
                checkOutPageElements().checkOutPageAddedProductByName(productName));
        actions.assertElementPresentUsingWebElement(
                checkOutPageElements().checkOutPageAddedProductByName(productName));
    }
}
