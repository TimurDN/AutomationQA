package uitests.ecommercelambda.base;

import com.telerikacademy.testframework.CustomWebDriverManager;
import com.telerikacademy.testframework.UserActions;
import ecommercelambda.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestLambda {

    public static UserActions actions = new UserActions();
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

//    @AfterEach
//    public void tearDown() {
//        UserActions.quitDriver();
//    }

    public static void registerUser(String firstName,String lastName, String email, String password) {
        registerPageLambda.registerUser(firstName, lastName, email, password);
    }

    public static void loginUser(String username, String password) {
        loginPageLambda.loginUser(username, password);
    }
}
