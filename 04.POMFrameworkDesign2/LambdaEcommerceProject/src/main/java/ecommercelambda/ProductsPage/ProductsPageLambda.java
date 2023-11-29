package ecommercelambda.ProductsPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ProductsPageLambda extends BasePageLambda {
    public ProductsPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");

    }

    public void addProductToCompare() {
        productsPageElements().addProductCompareButton().click();
    }

    public void clickOnCompareButton() throws InterruptedException {
        productsPageElements().navigateToComparingPageButton().click();
    }

    public void clickOnCartButton() {
        productsPageElements().cartButton().click();
    }

    public void addToCartFromProductPage() {
        productsPageElements().addToCartButton().click();
    }

    public void selectProductSize() {
        productsPageElements().productSizeDropDown().click();

        actions.keyboardActionArrowDownUsingWebElement(productsPageElements().productSizeDropDown());
        actions.keyboardActionEnterUsingWebElement(productsPageElements().productSizeDropDown());
    }

    public void addProductToWishList(String productName) {
        actions.mouseHoverByUsingWebElement(productsPageElements().productByName(productName));

        productsPageElements().addProductToWishListByName(productName).click();
    }

}
