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
        return driver.findElement(By.name("firstname"));
    }

    public WebElement billingFormLastNameField() {
        return driver.findElement(By.name("lastname"));
    }

    public WebElement billingFormCompanyField() {
        return driver.findElement(By.name("company"));
    }

    public WebElement billingFormAddressField() {
        return driver.findElement(By.name("address_1"));
    }

    public WebElement billingFormCityField() {
        return driver.findElement(By.name("city"));
    }

    public WebElement billingFormPostCodeField() {
        return driver.findElement(By.name("postcode"));
    }

    public WebElement billingFormPaymentCountryDropDown() {
        return driver.findElement(By.id("input-payment-country"));
    }

    public WebElement billingFormPaymentCityDropDown() {
        return driver.findElement(By.id("input-payment-zone"));
    }

    public WebElement billingFormAgreeTermsBox() {
        return driver.findElement(By.xpath("//label[@for='input-agree']"));
    }

    public WebElement billingFormSubmitButton() {
        return driver.findElement(By.id("button-save"));
    }

    public WebElement confirmOrderText() {
        return driver.findElement(By.xpath("//h1[text()='Confirm Order']"));
    }

    public WebElement checkOutPageAddedProductByName(String name) {
        return driver.findElement(By.xpath(String.format("//td[@class='text-left' and contains(text(), '%s')]", name)));
    }


}
