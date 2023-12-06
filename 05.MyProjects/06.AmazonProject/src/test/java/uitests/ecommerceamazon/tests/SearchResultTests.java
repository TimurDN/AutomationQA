package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

public class SearchResultTests extends BaseTestAmazon {

    @Test
    public void submittedSearchByProductNameAndResultsTest() {
        homePageAmazon.navigateToPage();
        homePageAmazon.searchProductByName("Laptop");

        searchResultPageAmazon.searchResultPageAssertions().assertSearchSubmission("Laptop");
        searchResultPageAmazon.searchResultPageAssertions().assertSearchedProductByNameHasResults("Laptop");
    }

    @Test
    public void addNonDiscountedProductsInStockToShoppingCart() throws InterruptedException {
        homePageAmazon.navigateToPage();
        homePageAmazon.searchProductByName("Laptop");

        productPageAmazon.addNonDiscountedProductsToCart();

    }

    @Test
    public void addNonDiscountedProductsInStockToShoppingCart2() throws InterruptedException {
        homePageAmazon.navigateToPage();
        homePageAmazon.searchProductByName("Laptop");

        productPageAmazon.addNonDiscountedProductsToCartAndCheckCart();

    }

}
