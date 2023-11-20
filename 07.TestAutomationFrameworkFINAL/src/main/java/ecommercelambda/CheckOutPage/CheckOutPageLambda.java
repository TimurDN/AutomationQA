package ecommercelambda.CheckOutPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.WebDriver;

public class CheckOutPageLambda extends BasePageLambda {
    public CheckOutPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void fillInBillingDetailsAndCheckOut(String firstName, String lastName, String companyName,
                                                String address1, String city, String postCode) throws InterruptedException {

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormFirstNameField());
        checkOutPageElements().billingFormFirstNameField().sendKeys(firstName);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormLastNameField());
        checkOutPageElements().billingFormLastNameField().sendKeys(lastName);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormCompanyField());
        checkOutPageElements().billingFormCompanyField().sendKeys(companyName);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormAddressField());
        checkOutPageElements().billingFormAddressField().sendKeys(address1);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormCityField());
        checkOutPageElements().billingFormCityField().sendKeys(city);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormPostCodeField());
        checkOutPageElements().billingFormPostCodeField().sendKeys(postCode);

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormPaymentCountryDropDown());
        checkOutPageElements().billingFormPaymentCountryDropDown().click();
        actions.keyboardActionArrowDownUsingWebElement(checkOutPageElements().billingFormPaymentCountryDropDown());

        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormPaymentCityDropDown());
        checkOutPageElements().billingFormPaymentCityDropDown().click();

        Thread.sleep(2000); //will be improved, will avoid using it.
        actions.keyboardActionArrowDownUsingWebElement(checkOutPageElements().billingFormPaymentCityDropDown());
        actions.keyboardActionArrowDownUsingWebElement(checkOutPageElements().billingFormPaymentCityDropDown());

        actions.scrollToElementUsingWebElement(checkOutPageElements().billingFormAgreeTermsBox());
        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormAgreeTermsBox());
        checkOutPageElements().billingFormAgreeTermsBox().click();

        Thread.sleep(2000);//will be improved, will avoid using it.
        actions.waitTillElementIsVisibleUsingWebElement(checkOutPageElements().billingFormSubmitButton());
        checkOutPageElements().billingFormSubmitButton().click();

    }


}
