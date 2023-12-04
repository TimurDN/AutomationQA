package ecommerceamazon.HomePage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageAmazon extends BasePageAmazon {
    public HomePageAmazon(WebDriver driver) {
        super(driver, "amazon.homepage");
    }
    public void clickOnEmptySearchbar(){
        homePageElements().homeSearchBar().click();
    }

}
