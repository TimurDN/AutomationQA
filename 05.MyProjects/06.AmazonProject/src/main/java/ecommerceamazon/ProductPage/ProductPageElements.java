package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

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

    public WebElement goToCartButton(){
        actions.waitForElementClickable("//a[normalize-space()='Go to Cart']");
        return driver.findElement(By.xpath("//a[normalize-space()='Go to Cart']"));
    }

    public WebElement shoppingCartHeader(){
        actions.waitTillElementIsVisible("//h1[normalize-space()='Shopping Cart']");
        return driver.findElement(By.xpath("//h1[normalize-space()='Shopping Cart']"));
    }


    public List<String> cartProductTitles() throws InterruptedException {
        actions.waitTillElementIsVisible("//h1[normalize-space()='Shopping Cart']");
        return driver.findElements(By.xpath(
                "//span[@class='a-truncate-cut']"))
                .stream().map(e->e.getText()).collect(Collectors.toList());
    }
}