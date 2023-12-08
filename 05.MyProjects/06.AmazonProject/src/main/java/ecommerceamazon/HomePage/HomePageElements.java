package ecommerceamazon.HomePage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePageElements extends BasePageAmazon {
    public HomePageElements(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public WebElement homeAccountButton(){
        actions.waitForElementClickable("//a[@id='nav-link-accountList']");
        return driver.findElement(By.id("nav-link-accountList"));
    }

    public WebElement homeSearchBar() {
        actions.waitForElementClickable("//input[@id='twotabsearchtextbox']");
        return driver.findElement(By.id("twotabsearchtextbox"));
    }

    public WebElement homeSearchBarAjax() {
        actions.waitForElementClickable("//div[@id='nav-flyout-searchAjax']");
        return driver.findElement(By.id("nav-flyout-searchAjax"));
    }

    public WebElement homeSearchSubmitButton(){
        actions.waitForElementClickable("//input[@id='nav-search-submit-button']");
        return driver.findElement(By.id("nav-search-submit-button"));
    }

    public WebElement homeAmazonLogo() {
        actions.waitForElementClickable("//a[@id='nav-logo-sprites']");
        return driver.findElement(By.id("nav-logo-sprites"));
    }

    public WebElement homeShopNavButtons(String buttonName) {
        actions.waitForElementClickable(String.format("(//a[text()=\"%s\"])[1]",buttonName));
        return driver.findElement(By.xpath(String.format("(//a[text()=\"%s\"])[1]",buttonName)));
    }

    public WebElement homeLanguageButton(){
        actions.waitForElementClickable("//a[@id='icp-nav-flyout']");
        return driver.findElement(By.id("icp-nav-flyout"));
    }

    public WebElement homeDefaultLanguage(String language){
        actions.waitForElementClickable(String.format("//div[contains(text(),'%s')]",language));
        return driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]",language)));
    }

    public WebElement homeOrdersButton(){
        actions.waitForElementClickable("//a[@id='nav-orders']");
        return driver.findElement(By.id("nav-orders"));
    }

    public WebElement homeShoppingCartButton(){
        actions.waitForElementClickable("//a[@id='nav-cart']");
        return driver.findElement(By.id("nav-cart"));
    }

    public WebElement hamburgerMenuButton(){
        actions.waitForElementClickable("//a[@id='nav-hamburger-menu']");
        return driver.findElement(By.id("nav-hamburger-menu"));
    }

    public WebElement seeAllButtonInHamburgerMenu(){
        actions.waitForElementClickable(
                "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']" +
                        "/div[@id='hmenu-content']/ul[1]/li[11]/a[1]");
        return driver.findElement(By.xpath(
                "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']" +
                        "/div[@id='hmenu-content']/ul[1]/li[11]/a[1]"));
    }

    public List<WebElement> getShopByDepartment(){
        return driver.findElements(By.xpath(
                "//a[@class='hmenu-item' and @data-menu-id >= 5 and @data-menu-id <= 26]"));
    }

    public WebElement hamburgerMenuCloseButton(){
        actions.waitForElementClickable("//div[@class='nav-sprite hmenu-close-icon']");
        return driver.findElement(By.xpath("//div[@class='nav-sprite hmenu-close-icon']"));
    }

}