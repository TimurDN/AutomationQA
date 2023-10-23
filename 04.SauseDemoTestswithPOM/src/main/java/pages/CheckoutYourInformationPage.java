package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutYourInformationPage extends BasePage{
    public CheckoutYourInformationPage(WebDriver webDriver, WebDriverWait driverWait) {
        super(webDriver, driverWait, "checkout-step-one.html");
    }

    ///locators
    public By firstNameLocator = By.id("first-name");
    public By secondNameLocator = By.id("last-name");
    public By zipCodeLocator = By.id("postal-code");
    public By continueButton = By.id("continue");


    //methods

    public void fillShippingDetails(String firstName, String lastName, String zip) {

        driver.findElement(firstNameLocator).sendKeys(firstName);
        driver.findElement(secondNameLocator).sendKeys(lastName);
        driver.findElement(zipCodeLocator).sendKeys(zip);
    }

    public void clickContinueButton(){

        driver.findElement(continueButton).click();

    }

}
