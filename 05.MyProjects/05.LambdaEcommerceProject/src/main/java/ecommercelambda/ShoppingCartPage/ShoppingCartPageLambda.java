package ecommercelambda.ShoppingCartPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageLambda extends BasePageLambda {
    public ShoppingCartPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void closeAddedItemCartPopUp() {
        shoppingCartPageElements().closeButtonCartPopUp().click();
    }

    public void clickOnEditCartButton() {;
        shoppingCartPageElements().editCartButton().click();
    }

    public void clickCheckOutButtonPopUp() {
        shoppingCartPageElements().checkOutButtonPopUp().click();
    }

    public void clickCheckOutButtonInShoppingCart() {
        shoppingCartPageElements().checkOutButtonInShoppingCart().click();
    }

    public void removeAddedItemFromCart() {
        shoppingCartPageElements().removeProductButton().click();
    }

}
