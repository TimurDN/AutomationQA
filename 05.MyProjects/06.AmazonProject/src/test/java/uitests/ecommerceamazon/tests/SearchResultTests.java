package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

import java.util.List;

public class SearchResultTests extends BaseTestAmazon {


    @BeforeEach
    public void testSetup() {
        homePageAmazon.navigateToPage();
        homePageAmazon.refreshPage();
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

        List<String> nonMatchedTitleList = productPageAmazon.proceedCheckOut();

        productPageAmazon.productPageAssertions().assertShoppingCartDisplayed();

        productPageAmazon.productPageAssertions().assertShoppingCartProductTitles(nonMatchedTitleList);

    }

}
