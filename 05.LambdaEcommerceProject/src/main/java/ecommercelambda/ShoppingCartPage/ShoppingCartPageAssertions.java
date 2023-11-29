package ecommercelambda.ShoppingCartPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageAssertions extends BasePageLambda {
    public ShoppingCartPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void assertEmptyShoppingCart(String message) {
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().emptyShoppingCartMessage(message));
    }

    public void assertShoppingCartBadgeByAddedAmount(String number) {
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().shoppingCartBadgeItem(number));
    }

    public void assertNavigateCheckOutPageFromShoppingCart() {
        actions.assertElementPresentUsingWebElement(shoppingCartPageElements().checkOutPageHeader());
    }

}


