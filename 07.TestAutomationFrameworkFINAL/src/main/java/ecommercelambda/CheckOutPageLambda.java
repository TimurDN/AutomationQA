package ecommercelambda;

import org.openqa.selenium.WebDriver;

public class CheckOutPageLambda extends BasePageLambda {
    public CheckOutPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void fillInBillingDetailsAndCheckOut(String firstName, String lastName, String companyName,
                                                String address1, String city, String postCode) throws InterruptedException {
        actions.waitForElementVisible("//input[@name='firstname']");
        actions.sendKeys("//input[@name='firstname']", firstName);

        actions.waitForElementVisible("//input[@name='lastname']");
        actions.sendKeys("//input[@name='lastname']", lastName);

        actions.waitForElementVisible("//input[@name='company']");
        actions.sendKeys("//input[@name='company']", companyName);

        actions.waitForElementVisible("//input[@name='address_1']");
        actions.sendKeys("//input[@name='address_1']", address1);

        actions.waitForElementVisible("//input[@name='city']");
        actions.sendKeys("//input[@name='city']", city);

        actions.waitForElementVisible("//input[@name='postcode']");
        actions.sendKeys("//input[@name='postcode']", postCode);

        actions.waitForElementClickable("//select[@id='input-payment-country']");
        actions.clickElement("//select[@id='input-payment-country']");
        actions.keyboardActionArrowDown("//select[@id='input-payment-country']");

        actions.waitForElementClickable("//select[@id='input-payment-zone']");
        actions.clickElement("//select[@id='input-payment-zone']");
        actions.keyboardActionArrowDown("//select[@id='input-payment-zone']");
        actions.keyboardActionArrowDown("//select[@id='input-payment-zone']");

        actions.scrollToElement("//input[@id='input-agree']");
        actions.waitForElementClickable
                ("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[5]/label[1]");
        actions.clickElement
                ("//body/div[1]/div[5]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[5]/label[1]");

        actions.waitForElementClickable("//button[@id='button-save']");
        actions.clickElement("//button[@id='button-save']");

    }

    public void assertNavigationToConfirmOrderAfterCheckOut(){
        actions.waitForElementVisible("//h1[text()='Confirm Order']");
        actions.assertElementVisible("//h1[text()='Confirm Order']");
    }

    public void assertProductIsInCheckOutPage(String productName){
        actions.waitForElementVisible
                (String.format("//td[@class='text-left' and contains(text(), '%s')]", productName));
        actions.assertElementPresent
                (String.format("//td[@class='text-left' and contains(text(), '%s')]", productName));
    }

}
