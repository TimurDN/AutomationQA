package uitests.ecommercelambda.base;

import com.telerikacademy.testframework.CustomWebDriverManager;
import com.telerikacademy.testframework.UserActions;
import ecommercelambda.CheckOutPage.CheckOutPageLambda;
import ecommercelambda.ConfirmOrderPage.ConfirmOrderPageLambda;
import ecommercelambda.HomePage.HomePageLambda;
import ecommercelambda.LoginPage.LoginPageLambda;
import ecommercelambda.ProductsPage.ProductsPageLambda;
import ecommercelambda.RegisterPage.RegisterPageLambda;
import ecommercelambda.ShoppingCartPage.ShoppingCartPageLambda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestLambda {

    //PAGES
    public static HomePageLambda homePageLambda;
    public static CheckOutPageLambda checkOutPageLambda;
    public static ConfirmOrderPageLambda confirmOrderPageLambda;
    public static RegisterPageLambda registerPageLambda;
    public static LoginPageLambda loginPageLambda;
    public static ShoppingCartPageLambda shoppingCartPageLambda;
    public static ProductsPageLambda productsPageLambda;

    @BeforeEach
    public void setUp() {
        UserActions.loadBrowser("lambda.homepage");
        WebDriver driver = CustomWebDriverManager.CustomWebDriverManagerEnum.INSTANCE.getDriver();

        homePageLambda = new HomePageLambda(driver);
        checkOutPageLambda = new CheckOutPageLambda(driver);
        confirmOrderPageLambda = new ConfirmOrderPageLambda(driver);
        registerPageLambda = new RegisterPageLambda(driver);
        loginPageLambda = new LoginPageLambda(driver);
        shoppingCartPageLambda = new ShoppingCartPageLambda(driver);
        productsPageLambda = new ProductsPageLambda(driver);
    }

    @AfterEach
    public void tearDown() {
        UserActions.quitDriver();
    }
}

