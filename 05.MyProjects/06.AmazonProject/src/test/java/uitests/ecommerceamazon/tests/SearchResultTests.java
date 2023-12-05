package uitests.ecommerceamazon.tests;

import org.junit.jupiter.api.Test;
import uitests.ecommerceamazon.base.BaseTestAmazon;

public class SearchResultTests extends BaseTestAmazon {

    @Test
    public void submittedSearchByProductNameAndResultsTest() {
        homePageAmazon.navigateToPage();
        homePageAmazon.searchProductByName("Laptop");

        searchResultPageAmazon.searchResultPageAssertions().assertSearchSubmission("Laptop");
        //searchResultPageAmazon.searchResultPageAssertions().assertSearchedProductByNameHasResults("Laptop");
    }

}
