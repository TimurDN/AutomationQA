package ecommerceamazon.ProductPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ProductPageAssertions extends BasePageAmazon {
    public ProductPageAssertions(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public void assertProductTitleToAddToCart(String title) {

        Assertions.assertEquals(title, productPageElements().productTitleInProductPage().getText(),
                "Title does not contain the expected name: " + title);
    }

    public void assertProductAddedToCart(){
        int count = Integer.parseInt(productPageElements().shoppingCartAddedProductCount().getText());
        Assertions.assertTrue(count > 0, "Expected count should be greater than 0.");
    }
}
