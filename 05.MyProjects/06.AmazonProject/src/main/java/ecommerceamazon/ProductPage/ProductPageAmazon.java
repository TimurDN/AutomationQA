package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;
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
            addNonDiscountedProductsToCartByOnlyProductName(webElementList.get(i), titleList.get(i));

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();
        }

    }

    public List<String> proceedCheckOut() throws InterruptedException {

        Map<String, WebElement> nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
        Iterator<Map.Entry<String, WebElement>> iterator = nonDiscountedProducts.entrySet().iterator();
        List<WebElement> webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
        List<String> titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());

        for (int i = 0; i < webElementList.size(); i++) {

            nonDiscountedProducts = searchResultPageAmazon().findNonDiscountedProductElement();
            webElementList = nonDiscountedProducts.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
            titleList = nonDiscountedProducts.entrySet().stream().map(e -> e.getKey()).collect(Collectors.toList());
            addNonDiscountedProductsToCartByOnlyProductName(webElementList.get(i), titleList.get(i));

            driver.navigate().back();
            Thread.sleep(1000);
            driver.navigate().back();
        }
        navigateToShoppingCart();
        List<String> cartTitleList = productPageElements().cartProductTitles();
        titleList = titleList.stream().map(title -> title.split("\n").length > 1 ? title.split("\n")[1] : title.split("\n")[0]).collect(Collectors.toList());
        titleList = removeDuplicateItemInList(titleList);
        //List<String> nonMatchingTitles = findNonMatchingTitles(cartTitleList, titleList);

        List<Boolean> flagList = new ArrayList<>();

        for (int i = 0; i < cartTitleList.size(); i++) {
          boolean flag =  findDifferenceBetweenTwoLists(cartTitleList.get(i),titleList);
          flagList.add(flag);

        }
        return cartTitleList;
    }

    private List<String> findNonMatchingTitles(List<String> cartTitleList, List<String> titleList) {
        return cartTitleList.stream()
                .filter(title -> !titleList.contains(title))
                .collect(Collectors.toList());
    }

    public boolean findDifferenceBetweenTwoLists(String item, List<String> comparableList) {
        return comparableList.stream().filter(c -> c.contains(item)).findAny().isEmpty();

    }

    public List<String> removeDuplicateItemInList(List<String> items) {
        Set<String> set = new HashSet<>(items.size());
        items.removeIf(p -> !set.add(p));
        return items;
    }

    private void addNonDiscountedProductsToCartByOnlyProductName(WebElement next, String key) {
        next.click();
        if (key.contains("\n")) {
            key = key.split("\n")[1];

        }
        productPageAssertions().assertProductTitleToAddToCart(key);
        productPageElements().addToCartButton().click();
        productPageAssertions().assertProductAddedToCart();

    }

    public void navigateToShoppingCart() {
        productPageElements().goToCartButton().click();
    }

}
