package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

public class HomePageTests extends BaseTestLambda {
    @BeforeEach
    public void setUpBefore() {
        homePageLambda.navigateToPage();

    }

    @Test
    public void homePageNavigatedTest() {
        homePageLambda.assertHomePageNavigated();
    }

    @Test
    public void searchExistingProductVerifyNameAndPriceTest() {
        homePageLambda.searchForSpecificProduct("iPhone");

        homePageLambda.assertSearchedProductInSearchResults("iPhone");
        homePageLambda.assertSearchedProductPriceIsCorrect("$123.20");
    }
}
