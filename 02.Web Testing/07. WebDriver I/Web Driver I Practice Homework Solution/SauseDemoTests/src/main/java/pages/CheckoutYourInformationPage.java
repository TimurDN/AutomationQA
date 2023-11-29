package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }

    // Locators
    public By continueLocator = By.id("continue");
    public By firstName = By.id("first-name");
    public By lastName = By.id("last-name");
    public By postalCode = By.id("postal-code");


    public void clickContinueButton(){
        driver.findElement(continueLocator).click();
    }

    public void fillShippingDetails(String firstNameInput, String lastNameInput, String zipInput) {
        driver.findElement(firstName).sendKeys(firstNameInput);
        driver.findElement(lastName).sendKeys(lastNameInput);
        driver.findElement(postalCode).sendKeys(zipInput);
    }

}
