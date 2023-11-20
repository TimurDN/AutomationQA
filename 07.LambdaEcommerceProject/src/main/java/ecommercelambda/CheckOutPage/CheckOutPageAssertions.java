package ecommercelambda.CheckOutPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class CheckOutPageAssertions extends BasePageLambda {
    public CheckOutPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertNavigationToConfirmOrderAfterCheckOut() {
        actions.assertElementPresentUsingWebElement(checkOutPageElements().confirmOrderText());
    }

    public void assertProductIsInCheckOutPage(String productName) {
        actions.assertElementPresentUsingWebElement(
                checkOutPageElements().checkOutPageAddedProductByName(productName));
    }
}
