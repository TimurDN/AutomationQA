package ecommerceamazon.BasePage;

import com.telerikacademy.pages.BasePage;;
import ecommerceamazon.HomePage.HomePageAssertions;
import ecommerceamazon.HomePage.HomePageElements;
import org.openqa.selenium.WebDriver;

public abstract class BasePageAmazon extends BasePage {
    public BasePageAmazon(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }

    public HomePageElements homePageElements() {
        return new HomePageElements(driver);
    }

    public HomePageAssertions homePageAssertions() {
        return new HomePageAssertions(driver);
    }

}
