package ecommercelambda.ShoppingCartPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageLambda extends BasePageLambda {
    public ShoppingCartPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void closeAddedItemCartPopUp() {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().closeButtonCartPopUp());
        shoppingCartPageElements().closeButtonCartPopUp().click();
    }

    public void clickOnEditCartButton() {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().editCartButton());
        shoppingCartPageElements().editCartButton().click();
    }

    public void clickCheckOutButtonPopUp() throws InterruptedException {
        Thread.sleep(2000);
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().checkOutButtonPopUp());
        shoppingCartPageElements().checkOutButtonPopUp().click();
    }

    public void clickCheckOutButtonInShoppingCart() {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().checkOutButtonInShoppingCart());
        shoppingCartPageElements().checkOutButtonInShoppingCart().click();
    }

    public void removeAddedItemFromCart() {
        actions.waitTillElementIsVisibleUsingWebElement(shoppingCartPageElements().removeProductButton());
        shoppingCartPageElements().removeProductButton().click();
    }

}
