package ecommercelambda.ProductsPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPageElements extends BasePageLambda {
    public ProductsPageElements(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public WebElement addProductCompareButton() {
        return driver.findElement(By.xpath(
                "//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']"));
    }

    public WebElement navigateToComparingPageButton() {
        return driver.findElement(By.partialLinkText(
                "Product Compare"));
    }

    public WebElement cartButton() {
        return driver.findElement(By.xpath("(//div[@class='cart-icon'])[1]"));
    }

    public WebElement addToCartButton() {
        return driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]"));
    }

    public WebElement productSizeDropDown() {
        return driver.findElement(By.xpath("(//select[@class='custom-select'])[1]"));
    }

    public WebElement productByName(String name) {
        return driver.findElement(By.xpath(
                String.format("//div[contains(@class, 'product-grid') and .//a[contains(@class, 'text-ellipsis-2') " +
                        "and contains(text(), '%s')]]", name)));

    }

    public WebElement addProductToWishListByName(String name) {
        return driver.findElement(By.xpath(
                String.format("(//h4[@class='title']/a[text()='%s']/ancestor::div[@class='product-thumb']" +
                        "//button[contains(@class, 'wishlist') and contains(@onclick, 'wishlist.add')])[1]", name)));
    }

    public WebElement productAddedToCompareSuccessMessage() {
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"));
    }

    public WebElement productComparisonPageHeader() {
        return driver.findElement(By.xpath("//div[@id='content']/h1[@class='h4']"));
    }

    public WebElement productInComparePageByName(String name) {
        return driver.findElement(By.xpath(String.format("//strong[contains(text(),'%s')]", name)));
    }

    public WebElement productInComparePageByPrice(String name) {
        return driver.findElement(By.xpath(
                String.format("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", name)));
    }
}
