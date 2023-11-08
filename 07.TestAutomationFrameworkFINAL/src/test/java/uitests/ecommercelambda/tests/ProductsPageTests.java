package uitests.ecommercelambda.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uitests.ecommercelambda.base.BaseTestLambda;

public class ProductsPageTests extends BaseTestLambda {

    @BeforeEach
    public void beforeTestSetup() {
        homePageLambda.navigateToPage();
    }

    @Test
    public void compareTwoProductsComparesSelectedProductsTest() {
        homePageLambda.searchForSpecificProduct("iPhone");
        homePageLambda.clickOnSearchedProduct("iPhone");
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage("iPhone"));

        homePageLambda.navigateToPage();

        homePageLambda.searchForSpecificProduct("HTC Touch HD");
        homePageLambda.clickOnSearchedProduct("HTC Touch HD");
        productsPageLambda.addProductToCompare();
        Assertions.assertTrue(productsPageLambda.assertProductAddedToCompareListMessage("HTC Touch HD"));

        productsPageLambda.clickOnCompareButton();

    }
}
