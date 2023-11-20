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
        actions.waitForElementClickable(
                "//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']");
        return driver.findElement(By.xpath(
                "//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']"));
    }

    public WebElement navigateToComparingPageButton() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(By.partialLinkText("Product Compare"));
    }

    public WebElement cartButton() {
        actions.waitForElementClickable("(//div[@class='cart-icon'])[1]");
        return driver.findElement(By.xpath("(//div[@class='cart-icon'])[1]"));
    }

    public WebElement addToCartButton() {
        actions.waitForElementClickable("(//button[@title='Add to Cart'])[2]");
        return driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]"));
    }

    public WebElement productSizeDropDown() {
        actions.waitForElementClickable("(//select[@class='custom-select'])[1]");
        return driver.findElement(By.xpath("(//select[@class='custom-select'])[1]"));
    }

    public WebElement productByName(String name) {
        actions.waitTillElementIsVisible(String.format(
                "//div[contains(@class, 'product-grid') and .//a[contains(@class, 'text-ellipsis-2') " +
                        "and contains(text(), '%s')]]", name));

        return driver.findElement(By.xpath(
                String.format("//div[contains(@class, 'product-grid') and .//a[contains(@class, 'text-ellipsis-2') " +
                        "and contains(text(), '%s')]]", name)));

    }

    public WebElement addProductToWishListByName(String name) {
        actions.waitForElementClickable(String.format(
                "(//h4[@class='title']/a[text()='%s']/ancestor::div[@class='product-thumb']" +
                        "//button[contains(@class, 'wishlist') and contains(@onclick, 'wishlist.add')])[1]", name));

        return driver.findElement(By.xpath(
                String.format("(//h4[@class='title']/a[text()='%s']/ancestor::div[@class='product-thumb']" +
                        "//button[contains(@class, 'wishlist') and contains(@onclick, 'wishlist.add')])[1]", name)));
    }

    public WebElement productAddedToCompareSuccessMessage() {
        actions.waitTillElementIsVisible("//*[contains(text(),'Success:')]");
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"));
    }

    public WebElement productComparisonPageHeader() {
        actions.waitTillElementIsVisible("//div[@id='content']/h1[@class='h4']");
        return driver.findElement(By.xpath("//div[@id='content']/h1[@class='h4']"));
    }

    public WebElement productInComparePageByName(String name) {
        actions.waitTillElementIsVisible(String.format("//strong[contains(text(),'%s')]", name));
        return driver.findElement(By.xpath(String.format("//strong[contains(text(),'%s')]", name)));
    }

    public WebElement productInComparePageByPrice(String name) {
        actions.waitTillElementIsVisible(String.format(
                "//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", name));
        return driver.findElement(By.xpath(
                String.format("//td[text()='Price']/following-sibling::td[contains(text(), '%s')]", name)));
    }
}
