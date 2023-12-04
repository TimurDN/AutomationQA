package uitests.ecommerceamazon.base;

import com.telerikacademy.testframework.CustomWebDriverManager;
import com.telerikacademy.testframework.UserActions;
import ecommerceamazon.CheckOutPage.CheckOutPageAmazon;
import ecommerceamazon.ConfirmOrderPage.ConfirmOrderPageAmazon;
import ecommerceamazon.HomePage.HomePageAmazon;
import ecommerceamazon.LoginPage.LoginPageAmazon;
import ecommerceamazon.ProductsPage.ProductsPageAmazon;
import ecommerceamazon.RegisterPage.RegisterPageAmazon;
import ecommerceamazon.ShoppingCartPage.ShoppingCartPageAmazon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestAmazon {

    //PAGES
    public static HomePageAmazon homePageLambda;
    public static CheckOutPageAmazon checkOutPageLambda;
    public static ConfirmOrderPageAmazon confirmOrderPageLambda;
    public static RegisterPageAmazon registerPageLambda;
    public static LoginPageAmazon loginPageLambda;
    public static ShoppingCartPageAmazon shoppingCartPageLambda;
    public static ProductsPageAmazon productsPageLambda;

    @BeforeEach
    public void setUp() {
        UserActions.loadBrowser("amazon.homepage");
        WebDriver driver = CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.getDriver();

        homePageLambda = new HomePageAmazon(driver);
        checkOutPageLambda = new CheckOutPageAmazon(driver);
        confirmOrderPageLambda = new ConfirmOrderPageAmazon(driver);
        registerPageLambda = new RegisterPageAmazon(driver);
        loginPageLambda = new LoginPageAmazon(driver);
        shoppingCartPageLambda = new ShoppingCartPageAmazon(driver);
        productsPageLambda = new ProductsPageAmazon(driver);
    }

    @AfterEach
    public void tearDown() {
        UserActions.quitDriver();
    }
}

