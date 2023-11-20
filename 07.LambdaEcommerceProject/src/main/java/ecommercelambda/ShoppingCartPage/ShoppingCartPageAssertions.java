package ecommercelambda.ShoppingCartPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageAssertions extends BasePageLambda {
    public ShoppingCartPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertEmptyShoppingCart(String message) throws InterruptedException {
        Thread.sleep(3000); ///check what can be done better instead thread sleep later, it is working fine with it for now.
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().emptyShoppingCartMessage(message));
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().emptyShoppingCartMessage(message));
    }

    public void assertShoppingCartBadgeByAddedAmount(String number) {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().shoppingCartBadgeItem(number));
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().shoppingCartBadgeItem(number));
    }

    public void assertNavigateCheckOutPageFromShoppingCart() {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().checkOutPageHeader());
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().checkOutPageHeader());
    }

}


