package ecommercelambda.CheckOutPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class CheckOutPageLambda extends BasePageLambda {
    public CheckOutPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void fillInBillingDetailsAndCheckOut(String firstName, String lastName, String companyName,
                                                String address1, String city, String postCode) {

        checkOutPageElements().billingFormFirstNameField().sendKeys(firstName);
        checkOutPageElements().billingFormLastNameField().sendKeys(lastName);
        checkOutPageElements().billingFormCompanyField().sendKeys(companyName);
        checkOutPageElements().billingFormAddressField().sendKeys(address1);
        checkOutPageElements().billingFormCityField().sendKeys(city);
        checkOutPageElements().billingFormPostCodeField().sendKeys(postCode);

        checkOutPageElements().billingFormPaymentCountryDropDown().click();
        checkOutPageElements().billingFormPaymentCityDropDown().click();
        actions.keyboardActionArrowDownUsingWebElement(checkOutPageElements().billingFormPaymentCityDropDown());
        actions.keyboardActionArrowDownUsingWebElement(checkOutPageElements().billingFormPaymentCityDropDown());

        actions.scrollToElementUsingWebElement(checkOutPageElements().billingFormAgreeTermsBox());
        checkOutPageElements().billingFormAgreeTermsBox().click();

        checkOutPageElements().billingFormSubmitButton().click();

    }


}
