package ecommerceamazon.BasePage;

import com.telerikacademy.pages.BasePage;;
import ecommerceamazon.HomePage.HomePageAssertions;
import ecommerceamazon.HomePage.HomePageElements;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageAssertions;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageElements;
import org.openqa.selenium.WebDriver;

public abstract class BasePageAmazon extends BasePage {
    public BasePageAmazon(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }

    protected HomePageElements homePageElements() {
        return new HomePageElements(driver);
    }

    protected ShoppingCartPageElements shoppingCartPageElements() {
        return new ShoppingCartPageElements(driver);
    }

    public HomePageAssertions homePageAssertions() {
        return new HomePageAssertions(driver);
    }

    public ShoppingCartPageAssertions shoppingCartPageAssertions() {
        return new ShoppingCartPageAssertions(driver);
    }


}
