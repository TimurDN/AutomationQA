package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }
        public By firstName = By.id("first-name");
        public By lastName = By.id("last-name");
        public By postalCode = By.id("postal-code");
        public By continueButton = By.id("continue");

    public void fillShippingDetails(String firstNameVal, String lastNameVal, String zipVal) {
        driver.findElement(firstName).sendKeys(firstNameVal);
        driver.findElement(lastName).sendKeys(lastNameVal);
        driver.findElement(postalCode).sendKeys(zipVal);
    }

    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
}
