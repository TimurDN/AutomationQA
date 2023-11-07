package ecommercelambda;

import com.telerikacademy.pages.BasePage;
import org.openqa.selenium.WebDriver;

public abstract class BasePageLambda extends BasePage {
    public BasePageLambda(WebDriver driver, String urlKey) {
        super(driver, urlKey);
    }
}
