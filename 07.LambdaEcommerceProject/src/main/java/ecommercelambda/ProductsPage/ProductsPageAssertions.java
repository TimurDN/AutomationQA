package ecommercelambda.ProductsPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ProductsPageAssertions extends BasePageLambda {
    public ProductsPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public boolean assertProductAddedToCompareListMessage(String name) {
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToCartListMessage(String name) {
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToWishListMessage(String name) {
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public void assertComparisonPageNavigated() {
        actions.assertElementPresentUsingWebElement(productsPageElements().productComparisonPageHeader());
    }

    public void assertComparedProductName(String name) {
        actions.assertElementPresentUsingWebElement(productsPageElements().productInComparePageByName(name));
    }

    public void assertComparedCorrectPriceOfProduct(String price) {
        actions.assertElementPresentUsingWebElement(productsPageElements().productInComparePageByPrice(price));
    }

}
