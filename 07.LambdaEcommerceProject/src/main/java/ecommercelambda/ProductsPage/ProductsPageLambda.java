package ecommercelambda.ProductsPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ProductsPageLambda extends BasePageLambda {
    public ProductsPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");

    }

    public void addProductToCompare() {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().addProductCompareButton());
        productsPageElements().addProductCompareButton().click();
    }

    public void clickOnCompareButton() {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().navigateToComparingPageButton());
        productsPageElements().navigateToComparingPageButton().click();
    }

    public void clickOnCartButton() {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().cartButton());
        productsPageElements().cartButton().click();
    }

    public void addToCartFromProductPage() throws InterruptedException {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().addToCartButton());
        Thread.sleep(2000);
        productsPageElements().addToCartButton().click();
    }

    public void selectProductSize() {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productSizeDropDown());
        productsPageElements().productSizeDropDown().click();

        actions.keyboardActionArrowDownUsingWebElement(productsPageElements().productSizeDropDown());
        actions.keyboardActionEnterUsingWebElement(productsPageElements().productSizeDropDown());
    }

    public void addProductToWishList(String productName) {
        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().productByName(productName));
        actions.mouseHoverByUsingWebElement(productsPageElements().productByName(productName));

        actions.waitTillElementIsVisibleUsingWebElement(productsPageElements().addProductToWishListByName(productName));
        productsPageElements().addProductToWishListByName(productName).click();
    }

}
