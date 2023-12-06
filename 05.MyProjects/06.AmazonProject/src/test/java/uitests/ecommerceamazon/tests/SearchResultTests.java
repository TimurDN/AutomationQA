package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

public class SearchResultTests extends BaseTestAmazon {


    @BeforeEach
    public void testSetup() {
        homePageAmazon.navigateToPage();
    }

    @Test
    public void submittedSearchByProductNameAndResultsTest() {
        homePageAmazon.searchProductByName("Laptop");

        searchResultPageAmazon.searchResultPageAssertions().assertSearchSubmission("Laptop");
        searchResultPageAmazon.searchResultPageAssertions().assertSearchedProductByNameHasResults("Laptop");
    }

    @Test
    public void addNonDiscountedProductsInStockToShoppingCart() throws InterruptedException {
        homePageAmazon.searchProductByName("Laptop");

        //add and assert
        productPageAmazon.addNonDiscountedProductsToCart();

    }

    @Test
    public void addNonDiscountedProductsInStockToShoppingCart2() throws InterruptedException {
        homePageAmazon.searchProductByName("Laptop");

        productPageAmazon.addNonDiscountedProductsToCart();

        productPageAmazon.navigateToShoppingCart();
        productPageAmazon.productPageAssertions().assertShoppingCartDisplayed();

    }

}
