package ecommercelambda;

import org.openqa.selenium.WebDriver;

public class ShoppingCartPageLambda extends BasePageLambda {
    public ShoppingCartPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void closeAddedItemCartPopUp() {
        actions.waitForElementClickable("//button[@class='ml-2 mb-1 close' and @data-dismiss='toast' and @aria-label='Close']");
        actions.clickElement("//button[@class='ml-2 mb-1 close' and @data-dismiss='toast' and @aria-label='Close']");
    }

    public void clickOnEditCartButton() {
        actions.waitForElementClickable("//a[@class='icon-right both btn btn-primary btn-lg btn-block']");
        actions.clickElement("//a[@class='icon-right both btn btn-primary btn-lg btn-block']");
    }

    public void clickCheckOutButtonInShoppingCart() {
        actions.waitForElementVisible("//a[@class='btn btn-secondary btn-block']");
        actions.clickElement("//a[@class='btn btn-secondary btn-block']");
    }

    public void removeAddedItemFromCart() {
        actions.waitForElementClickable("//tbody/tr[1]/td[4]/div[1]/div[1]/button[2]");
        actions.clickElement("//tbody/tr[1]/td[4]/div[1]/div[1]/button[2]");
    }

    public void assertEmptyShoppingCart(String message) {
        actions.waitForElementVisible(String.format("//div[@id='content' and .//p[text()='%s']]", message));
        actions.assertElementVisible(String.format("//div[@id='content' and .//p[text()='%s']]", message));
    }

    public void assertShoppingCartBadgeItemIs1(String number) {
        actions.waitForElementVisible(
                String.format("(//span[@class='badge badge-pill badge-info cart-item-total' " +
                        "and text()='%s'])[1]", number));
        actions.assertElementVisible(
                String.format("(//span[@class='badge badge-pill badge-info cart-item-total' " +
                        "and text()='%s'])[1]", number));
    }

    public void assertShoppingCardPopUpItemIs1(String number) {
        actions.waitForElementVisible(String.format("//td[@class='text-center' and text()='%s']", number));
        actions.assertElementVisible(String.format("//td[@class='text-center' and text()='%s']", number));
    }

    public void assertNavigateCheckOutPageFromShoppingCart(){
        actions.waitForElementVisible("//li[@class='breadcrumb-item active' and contains(text(), 'Checkout')]");
        actions.assertElementVisible("//li[@class='breadcrumb-item active' and contains(text(), 'Checkout')]");
    }

}
