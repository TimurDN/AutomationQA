package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Map;

public class ProductPageAmazon extends BasePageAmazon {
    public ProductPageAmazon(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void addProductToCart() {
        productPageElements().addToCartButton().click();

    }

    public void addNonDiscountedProductsToCart() throws InterruptedException {
        Map<String,WebElement> nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
        Iterator<Map.Entry<String, WebElement>> iterator = nonDiscountedProducts.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WebElement> entry = iterator.next();
            entry.getValue().click();
            productPageAssertions().assertProductTitleToAddToCart(entry.getKey());
            productPageElements().addToCartButton().click();
            productPageAssertions().assertProductAddedToCart();
            Thread.sleep(1000);

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();

            Thread.sleep(2000);

        }
    }

}
