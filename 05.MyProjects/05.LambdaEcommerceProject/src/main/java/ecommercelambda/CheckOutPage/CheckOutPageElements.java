package ecommercelambda.CheckOutPage;

import ecommercelambda.BasePage.BasePageLambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPageElements extends BasePageLambda {
    public CheckOutPageElements(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public WebElement billingFormFirstNameField() {
        actions.waitTillElementIsVisible("//input[@name='firstname']");
        return driver.findElement(By.name("firstname"));
    }

    public WebElement billingFormLastNameField() {
        actions.waitTillElementIsVisible("//input[@name='lastname']");
        return driver.findElement(By.name("lastname"));
    }

    public WebElement billingFormCompanyField() {
        actions.waitTillElementIsVisible("//input[@name='company']");
        return driver.findElement(By.name("company"));
    }

    public WebElement billingFormAddressField() {
        actions.waitTillElementIsVisible("//input[@name='address_1']");
        return driver.findElement(By.name("address_1"));
    }

    public WebElement billingFormCityField() {
        actions.waitTillElementIsVisible("//input[@name='city']");
        return driver.findElement(By.name("city"));
    }

    public WebElement billingFormPostCodeField() {
        actions.waitTillElementIsVisible("//input[@name='postcode']");
        return driver.findElement(By.name("postcode"));
    }

    public WebElement billingFormPaymentCountryDropDown() {
        actions.waitTillElementIsVisible("//select[@id='input-payment-country']");
        return driver.findElement(By.id("input-payment-country"));
    }

    public WebElement billingFormPaymentCityDropDown() {
        actions.waitTillElementIsVisible("//select[@id='input-payment-zone']");
        return driver.findElement(By.id("input-payment-zone"));
    }

    public WebElement billingFormAgreeTermsBox() {
        actions.waitTillElementIsVisible("//label[@for='input-agree']");
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement billingFormSubmitButton() {
        actions.waitForElementClickable("//button[@id='button-save']");
        return driver.findElement(By.id("button-save"));
    }

    public WebElement confirmOrderText() {
        actions.waitTillElementIsVisible("//h1[text()='Confirm Order']");
        return driver.findElement(By.xpath(
                "//h1[text()='Confirm Order']"));
    }

    public WebElement checkOutPageAddedProductByName(String name) {
        actions.waitTillElementIsVisible(String.format(
                "//td[@class='text-left' and contains(text(), '%s')]", name));
        return driver.findElement(By.xpath(String.format(
                "//td[@class='text-left' and contains(text(), '%s')]", name)));
    }


}
