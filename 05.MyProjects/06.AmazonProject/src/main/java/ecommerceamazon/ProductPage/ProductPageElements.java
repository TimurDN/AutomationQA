package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPageElements extends BasePageAmazon {
    public ProductPageElements(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public WebElement addToCartButton() {
        actions.waitForElementClickable("//input[@id='add-to-cart-button']");
        return driver.findElement(By.id("add-to-cart-button"));
    }

    public WebElement productTitleInProductPage() {
        actions.waitForElementClickable("//input[@id='add-to-cart-button']");
        return driver.findElement(By.id("productTitle"));
    }

    public WebElement shoppingCartAddedProductCount(){
        actions.waitTillElementIsVisible("//span[@id='nav-cart-count']");
        return driver.findElement(By.id("nav-cart-count"));
    }
}
