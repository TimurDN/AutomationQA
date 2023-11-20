package ecommercelambda.HomePage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements extends BasePageLambda {
    public HomePageElements(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public WebElement homeMyAccountButton() {
        actions.waitForElementClickable("(//span[contains(text(), 'My account')])[2]");
        return driver.findElement(By.xpath(
                "(//span[contains(text(), 'My account')])[2]"));
    }

    public WebElement homeRegisterButton() {
        actions.waitForElementClickable("(//a[contains(@href, 'register')])[1]");
        return driver.findElement(By.xpath("(//a[contains(@href, 'register')])[1]"));
    }

    public WebElement homeLoginButton() {
        actions.waitForElementClickable("(//a[contains(@href, 'login')])[1]");
        return driver.findElement(By.xpath(
                "(//a[contains(@href, 'login')])[1]"));
    }

    public WebElement homeLogoutButton() {
        actions.waitForElementClickable("//a[contains(@href, 'logout')]");
        return driver.findElement(By.xpath(
                "//a[contains(@href, 'logout')]"));
    }

    public WebElement homeSearchBar() {
        actions.waitForElementClickable("(//input[@type='text'][@placeholder='Search For Products'])[1]");
        return driver.findElement(By.xpath(
                "(//input[@type='text'][@placeholder='Search For Products'])[1]"));
    }

    public WebElement searchedProductByName(String name) {
        actions.waitTillElementIsVisible(String.format("(//h4[@class='title']/a[text()='%s'])[2]", name));
        return driver.findElement(By.xpath(String.format("(//h4[@class='title']/a[text()='%s'])[2]", name)));

    }

    public WebElement firstTopProductByName(String name) {
        return driver.findElement(By.xpath(
                String.format("(//h4[@class='title']/a[@class='text-ellipsis-2' and text()='%s'])[1]", name)));

    }

    public WebElement searchResultProductByName(String name) {
        return driver.findElement(By.xpath(String.format("(//h4[@class='title']/a[text()='%s'])[1]", name)));
    }

    public WebElement searchResultProductPrice(String price) {
        return driver.findElement(By.xpath(String.format(
                "(//span[@class='price-new' and text()='%s'])[1]", price)));

    }


}
