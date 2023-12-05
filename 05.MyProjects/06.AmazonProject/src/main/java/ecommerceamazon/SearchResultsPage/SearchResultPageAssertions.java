package ecommerceamazon.SearchResultsPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class SearchResultPageAssertions extends BasePageAmazon {
    public SearchResultPageAssertions(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void assertSearchSubmission(String name) {
        Assertions.assertTrue(this.driver.getTitle().contains(String.format("%s", name)), "Title does not contain the expected name: " + name);
    }

    public void assertSearchedProductByNameHasResults(String productName) {
        this.actions.assertElementPresentUsingWebElement(searchResultsPageElements().searchedProductInResults(productName));
    }
}