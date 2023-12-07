package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductPageAssertions extends BasePageAmazon {
    public ProductPageAssertions(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void assertProductTitleToAddToCart(String title) {

        Assertions.assertTrue(productPageElements().productTitleInProductPage().getText().contains(title),
                "Title does not contain the expected name: " + title);
    }

    public void assertProductAddedToCart(){
        int count = Integer.parseInt(productPageElements().shoppingCartAddedProductCount().getText());
        Assertions.assertTrue(count > 0, "Expected count should be greater than 0.");
    }

    public void assertShoppingCartDisplayed(){
        actions.assertElementPresentUsingWebElement(productPageElements().shoppingCartHeader());
    }

    public void assertShoppingCartProductTitles(List<String> nonMatchedTitle){
        Assertions.assertTrue(nonMatchedTitle.isEmpty());

    }
}
