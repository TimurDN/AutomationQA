package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductPageAmazon extends BasePageAmazon {
    public ProductPageAmazon(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void addProductToCart() {
        productPageElements().addToCartButton().click();

    }

    public void addNonDiscountedProductsToCart() throws InterruptedException {

        Map<String, WebElement> nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
        Iterator<Map.Entry<String, WebElement>> iterator = nonDiscountedProducts.entrySet().iterator();
        List<WebElement> webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        List<String> titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

        for (int i = 0; i < webElementList.size(); i++) {

            nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
            webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
            titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
            addNonDiscountedProductsToCartByProduct(webElementList.get(i), titleList.get(i));

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();
        }

    }

    public void addNonDiscountedProductsToCartAndCheckCart() throws InterruptedException {

        Map<String, WebElement> nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
        Iterator<Map.Entry<String, WebElement>> iterator = nonDiscountedProducts.entrySet().iterator();
        List<WebElement> webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        List<String> titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

        for (int i = 0; i < webElementList.size(); i++) {

            nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
            webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
            titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
            addNonDiscountedProductsToCartByProduct(webElementList.get(i), titleList.get(i));

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();
        }

        //karta git
        //kart sayfasındaki tüm elemanların titlelarını listeye ata
        //elindeki title list ile atadığın title listi karşılaştır.

    }

    private void addNonDiscountedProductsToCartByProduct(WebElement next, String key) {
        next.click();

        if (key.contains("\n")) {
            key = key.split("\n")[1];

        }
        productPageAssertions().assertProductTitleToAddToCart(key);
        productPageElements().addToCartButton().click();
        productPageAssertions().assertProductAddedToCart();


    }

}
