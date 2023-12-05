package ecommerceamazon.SearchResultsPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.logging.Logger;

public class SearchResultPageAssertions extends BasePageAmazon {

    public SearchResultPageAssertions(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void assertSearchSubmission(String name) {
        String actualTitle = driver.getTitle();
        Assertions.assertTrue(actualTitle.contains(name),
                "Title does not contain the expected name: " + name);

    }

    public void assertSearchedProductByNameHasResults(String productName) {
        this.actions.assertElementPresentUsingWebElement(searchResultsPageElements().searchedProductInResults(productName));
    }
}