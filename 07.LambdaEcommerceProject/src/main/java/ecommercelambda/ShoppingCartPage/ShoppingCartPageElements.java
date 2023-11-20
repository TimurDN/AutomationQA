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
        return driver.findElement(By.xpath(
                "//button[@class='ml-2 mb-1 close' and @data-dismiss='toast' and @aria-label='Close']"));
    }

    public WebElement editCartButton() {
        return driver.findElement(By.xpath(
                "//a[@class='icon-right both btn btn-primary btn-lg btn-block']"));
    }

    public WebElement checkOutButtonPopUp() {
        return driver.findElement(By.xpath(
                "//a[@class='btn btn-secondary btn-block']"));
    }

    public WebElement checkOutButtonInShoppingCart() {
        return driver.findElement(By.xpath("//div[contains(@class, 'entry-row')]" +
                "//a[contains(@class, 'btn-secondary') and contains(@href, 'checkout/checkout')]"));
    }

    public WebElement removeProductButton() {
        return driver.findElement(By.xpath("//button[contains(@onclick, 'cart.remove')]"));
    }

    public WebElement emptyShoppingCartMessage(String message) {
        return driver.findElement(By.xpath(String.format("//div[@id='content']//p[text()='%s']", message)));
    }

    public WebElement shoppingCartBadgeItem(String amount) {
        return driver.findElement(By.xpath(String.format(
                "(//span[@class='badge badge-pill badge-info cart-item-total' and text()='%s'])[1]", amount)));
    }

    public WebElement checkOutPageHeader() {
        return driver.findElement(By.xpath(
                "//li[@class='breadcrumb-item active' and contains(text(), 'Checkout')]"));
    }

}
