package ecommercelambda.BasePage;

import com.telerikacademy.pages.BasePage;
import ecommercelambda.CheckOutPage.CheckOutPageAssertions;
import ecommercelambda.CheckOutPage.CheckOutPageElements;
import ecommercelambda.ConfirmOrderPage.ConfirmOrderPageAssertions;
import ecommercelambda.ConfirmOrderPage.ConfirmOrderPageElements;
import ecommercelambda.HomePage.HomePageAssertions;
import ecommercelambda.HomePage.HomePageElements;
import ecommercelambda.LoginPage.LoginPageAssertions;
import ecommercelambda.LoginPage.LoginPageElements;
import ecommercelambda.ProductsPage.ProductsPageAssertions;
import ecommercelambda.ProductsPage.ProductsPageElements;
import ecommercelambda.RegisterPage.RegisterPageAssertions;
import ecommercelambda.RegisterPage.RegisterPageElements;
import ecommercelambda.ShoppingCartPage.ShoppingCartPageAssertions;
import ecommercelambda.ShoppingCartPage.ShoppingCartPageElements;
import org.openqa.selenium.WebDriver;

public abstract class BasePageLambda extends BasePage {
    public BasePageLambda(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }

    protected RegisterPageElements registerPageElements() {
        return new RegisterPageElements(driver);
    }

    protected LoginPageElements loginPageElements() {
        return new LoginPageElements(driver);
    }

    protected ProductsPageElements productsPageElements() {
        return new ProductsPageElements(driver);
    }

    protected HomePageElements homePageElements() {
        return new HomePageElements(driver);
    }

    protected ShoppingCartPageElements shoppingCartPageElements() {
        return new ShoppingCartPageElements(driver);
    }

    protected ConfirmOrderPageElements confirmOrderPageElements() {
        return new ConfirmOrderPageElements(driver);
    }

    protected CheckOutPageElements checkOutPageElements() {
        return new CheckOutPageElements(driver);
    }

    public RegisterPageAssertions registerPageAssertions() {
        return new RegisterPageAssertions(driver);
    }

    public LoginPageAssertions loginPageAssertions() {
        return new LoginPageAssertions(driver);
    }

    public HomePageAssertions homePageAssertions() {
        return new HomePageAssertions(driver);
    }

    public ProductsPageAssertions productsPageAssertions() {
        return new ProductsPageAssertions(driver);
    }

    public ShoppingCartPageAssertions shoppingCartPageAssertions() {
        return new ShoppingCartPageAssertions(driver);
    }

    public ConfirmOrderPageAssertions confirmOrderPageAssertions() {
        return new ConfirmOrderPageAssertions(driver);
    }

    public CheckOutPageAssertions checkOutPageAssertions() {
        return new CheckOutPageAssertions(driver);
    }


}
