package ecommerceamazon.BasePage;

import com.telerikacademy.pages.BasePage;;
import ecommerceamazon.HomePage.HomePageAssertions;
import ecommerceamazon.HomePage.HomePageElements;
import ecommerceamazon.ProductPage.ProductPageAssertions;
import ecommerceamazon.ProductPage.ProductPageElements;
import ecommerceamazon.SearchResultsPage.SearchResultPageAmazon;
import ecommerceamazon.SearchResultsPage.SearchResultPageAssertions;
import ecommerceamazon.SearchResultsPage.SearchResultsPageElements;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageAssertions;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageElements;
import org.openqa.selenium.WebDriver;

public abstract class BasePageAmazon extends BasePage {
    public BasePageAmazon(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }

    protected HomePageElements homePageElements() {
        return new HomePageElements(driver);
    }

    protected ProductPageElements productPageElements() {
        return new ProductPageElements(driver);
    }

    protected SearchResultsPageElements searchResultsPageElements() {
        return new SearchResultsPageElements(driver);
    }

    protected SearchResultPageAmazon searchResultPageAmazon() {
        return new SearchResultPageAmazon(driver);
    }


    protected ShoppingCartPageElements shoppingCartPageElements() {
        return new ShoppingCartPageElements(driver);
    }

    public HomePageAssertions homePageAssertions() {
        return new HomePageAssertions(driver);
    }

    public SearchResultPageAssertions searchResultPageAssertions() {
        return new SearchResultPageAssertions(driver);
    }

    public ProductPageAssertions productPageAssertions() {
        return new ProductPageAssertions(driver);
    }

    public ShoppingCartPageAssertions shoppingCartPageAssertions() {
        return new ShoppingCartPageAssertions(driver);
    }


}
