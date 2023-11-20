package ecommercelambda.ShoppingCartPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPageElements extends BasePageLambda {
    public ShoppingCartPageElements(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public WebElement closeButtonCartPopUp() {
        actions.waitForElementClickable(
                "//button[@class='ml-2 mb-1 close' and @data-dismiss='toast' and @aria-label='Close']");
        return driver.findElement(By.xpath(
                "//button[@class='ml-2 mb-1 close' and @data-dismiss='toast' and @aria-label='Close']"));
    }

    public WebElement editCartButton() {
        actions.waitForElementClickable(
                "//a[@class='icon-right both btn btn-primary btn-lg btn-block']");
        return driver.findElement(By.xpath(
                "//a[@class='icon-right both btn btn-primary btn-lg btn-block']"));
    }

    public WebElement checkOutButtonPopUp() {
        actions.waitForElementClickable("//a[@class='btn btn-secondary btn-block']");
        return driver.findElement(By.xpath(
                "//a[@class='btn btn-secondary btn-block']"));
    }

    public WebElement checkOutButtonInShoppingCart() {
        actions.waitForElementClickable("//div[contains(@class, 'entry-row')]" +
                "//a[contains(@class, 'btn-secondary') and contains(@href, 'checkout/checkout')]");

        return driver.findElement(By.xpath("//div[contains(@class, 'entry-row')]" +
                "//a[contains(@class, 'btn-secondary') and contains(@href, 'checkout/checkout')]"));
    }

    public WebElement removeProductButton() {
        actions.waitForElementClickable("//button[contains(@onclick, 'cart.remove')]");
        return driver.findElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    }

    public WebElement emptyShoppingCartMessage(String message) {
        actions.waitTillElementIsVisible(String.format("//div[@id='content']//p[text()='%s']", message));
        return driver.findElement(By.xpath(String.format("//div[@id='content']//p[text()='%s']", message)));
    }

    public WebElement shoppingCartBadgeItem(String amount) {
        actions.waitTillElementIsVisible(String.format(
                "(//span[@class='badge badge-pill badge-info cart-item-total' and text()='%s'])[1]", amount));

        return driver.findElement(By.xpath(String.format(
                "(//span[@class='badge badge-pill badge-info cart-item-total' and text()='%s'])[1]", amount)));
    }

    public WebElement checkOutPageHeader() {
        actions.waitTillElementIsVisible(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Checkout')]");

        return driver.findElement(By.xpath(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Checkout')]"));
    }

}
