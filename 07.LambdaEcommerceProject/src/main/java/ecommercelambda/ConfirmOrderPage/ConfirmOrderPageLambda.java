package ecommercelambda.ConfirmOrderPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class ConfirmOrderPageLambda extends BasePageLambda {
    public ConfirmOrderPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void clickOnConfirmOrderButton() {
        actions.waitTillElementIsVisibleUsingWebElement(confirmOrderPageElements().confirmOrderButton());
        confirmOrderPageElements().confirmOrderButton().click();
    }

}
