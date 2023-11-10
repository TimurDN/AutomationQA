package ecommercelambda;

import org.openqa.selenium.WebDriver;

public class ConfirmOrderPageLambda extends BasePageLambda{
    public ConfirmOrderPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }
    public void clickOnConfirmOrderButton(){
        actions.waitForElementVisible("//button[@id='button-confirm']");
        actions.clickElement("//button[@id='button-confirm']");
    }

    public void assertOrderIsSuccessful(){
        actions.waitForElementVisible("//li[@class='breadcrumb-item active' and contains(text(), 'Success')]");
        actions.assertElementPresent("//li[@class='breadcrumb-item active' and contains(text(), 'Success')]");

    }
}
