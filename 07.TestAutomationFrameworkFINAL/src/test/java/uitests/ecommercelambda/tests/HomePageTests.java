package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

import static com.telerikacademy.testframework.Constants.*;

public class HomePageTests extends BaseTestLambda {

    @BeforeEach
    public void setUpBefore() {
        homePageLambda.navigateToPage();

    }

    @Test
    public void homePageNavigatedTest() {
        homePageLambda.homePageAssertions().assertHomePageNavigated();
    }

    @Test
    public void searchExistingProductVerifyNameAndPriceTest() {
        homePageLambda.searchForSpecificProduct(PRODUCT_IPHONE);

        homePageLambda.homePageAssertions().assertSearchedProductInSearchResults(PRODUCT_IPHONE);
        homePageLambda.homePageAssertions().assertSearchedProductPriceIsCorrect(IPHONE_PRICE);
    }
}
