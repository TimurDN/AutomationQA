package ecommercelambda.ProductsPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ProductsPageAssertions extends BasePageLambda {
    public ProductsPageAssertions(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public boolean assertProductAddedToCompareListMessage(String name) throws InterruptedException {
        Thread.sleep(3000); //check later below wait seems like not working, working only with thread sleep
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productAddedToCompareSuccessMessage());
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToCartListMessage(String name) throws InterruptedException {
        Thread.sleep(3000);//check later below wait seems like not working, working only with thread sleep
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productAddedToCompareSuccessMessage());
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToWishListMessage(String name) throws InterruptedException {
        Thread.sleep(3000);//check later below wait seems like not working, working only with thread sleep
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productAddedToCompareSuccessMessage());
        return productsPageElements().productAddedToCompareSuccessMessage()
                .getText().contains(String.format("You have added\n%s", name));
    }

    public void assertComparisonPageNavigated() {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productComparisonPageHeader());
        actions.assertElementPresentUsingWebElement(productsPageElements().productComparisonPageHeader());
    }

    public void assertComparedProductName(String name) {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productInComparePageByName(name));
        actions.assertElementPresentUsingWebElement(productsPageElements().productInComparePageByName(name));
    }

    public void assertComparedCorrectPriceOfProduct(String price) {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productInComparePageByPrice(price));
        actions.assertElementPresentUsingWebElement(productsPageElements().productInComparePageByPrice(price));
    }

}
