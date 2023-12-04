package uitests.ecommerceamazon.base;

import com.telerikacademy.testframework.CustomWebDriverManager;
import com.telerikacademy.testframework.UserActions;
import ecommerceamazon.HomePage.HomePageAmazon;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageAmazon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestAmazon {

    //PAGES
    public static HomePageAmazon homePageAmazon;
    public static ShoppingCartPageAmazon shoppingCartPageLambda;

    @BeforeEach
    public void setUp() {
        UserActions.loadBrowser("amazon.homepage");
        WebDriver driver = CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.getDriver();

        homePageAmazon = new HomePageAmazon(driver);

    }

//    @AfterEach
//    public void tearDown() {
//        UserActions.quitDriver();
//    }
}

