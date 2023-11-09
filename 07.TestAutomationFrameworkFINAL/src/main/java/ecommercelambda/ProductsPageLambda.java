package ecommercelambda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPageLambda extends BasePageLambda {
    public ProductsPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");

    }

    public void addProductToCompare() {
        actions.waitForElementClickable("//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']");
        actions.clickElement("//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']");
    }

    public void clickOnCompareButton() {
        actions.waitForElementClickable("//a[@class='btn btn-secondary btn-block']");
        actions.clickElement("//a[@class='btn btn-secondary btn-block']");
    }

    public void clickOnCartButton() {
        actions.waitForElementClickable("(//div[@class='cart-icon'])[1]");
        actions.clickElement("(//div[@class='cart-icon'])[1]");
    }

    public void addToCartFromProductPage() {
        actions.waitForElementClickable("(//button[@title='Add to Cart'])[2]");
        actions.clickElement("(//button[@title='Add to Cart'])[2]");
    }

    public void selectProductSize() {
        actions.waitForElementClickable("//select[@id='input-option230-216836']");
        actions.clickElement("//select[@id='input-option230-216836']");
        actions.keyboardActionArrowDown("//select[@id='input-option230-216836']");
        actions.keyboardActionEnter("//select[@id='input-option230-216836']");
    }

    public void addProductToWishList(){
        actions.waitForElementVisible
                ("(//img[@class='lazy-load' and @alt='Palm Treo Pro' and @title='Palm Treo Pro'])[1]");
        actions.mouseHoverBy
                ("(//img[@class='lazy-load' and @alt='Palm Treo Pro' and @title='Palm Treo Pro'])[1]");
        actions.waitForElementClickable
                ("(//button[contains(@class, 'btn-wishlist') and contains(@title, 'Add to Wish List')])[1]");
        actions.clickElement
                ("(//button[contains(@class, 'btn-wishlist') and contains(@title, 'Add to Wish List')])[1]");
    }

    public boolean assertProductAddedToCompareListMessage(String name) {
        actions.waitForElementVisible("//*[contains(text(),'Success:')]");
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"))
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToCartListMessage(String name) {
        actions.waitForElementVisible("//*[contains(text(),'Success:')]");
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"))
                .getText().contains(String.format("You have added\n%s", name));
    }

    public boolean assertProductAddedToWishListMessage(String name) {
        actions.waitForElementVisible("//*[contains(text(),'Success:')]");
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"))
                .getText().contains(String.format("You have added\n%s", name));
    }

    public void assertComparisonPageNavigated() {
        actions.waitForElementVisible("//div[@id='content']/h1[@class='h4']");
        actions.assertElementVisible("//div[@id='content']/h1[@class='h4']");
    }

    public void assertComparedProductName1(String name) {
        actions.waitForElementVisible(String.format("//strong[contains(text(),'%s')]", name));
        actions.assertElementPresent(String.format("//strong[contains(text(),'%s')]", name));
    }

    public void assertComparedProductName2(String name) {
        actions.waitForElementVisible(String.format("//strong[contains(text(),'%s')]", name));
        actions.assertElementPresent(String.format("//strong[contains(text(),'%s')]", name));
    }

    public void assertComparedCorrectPriceOfProduct1(String price) {
        actions.waitForElementVisible(String.format
                ("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", price));
        actions.assertElementPresent(String.format
                ("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", price));
    }

    public void assertComparedCorrectPriceOfProduct2(String price) {
        actions.waitForElementVisible(String.format
                ("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", price));
        actions.assertElementPresent(String.format
                ("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", price));
    }

}
