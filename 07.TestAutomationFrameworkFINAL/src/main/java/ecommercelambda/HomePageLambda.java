package ecommercelambda;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePageLambda extends BasePageLambda{
    public HomePageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");
    }

    public void navigateToRegisterButton(){
       actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
       actions.waitForElementVisible("//a[contains(@href, 'register')]");
       actions.clickElement("//a[contains(@href, 'register')]");

    }

    public void navigateToLoginButton(){
        actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
        actions.waitForElementVisible("//a[contains(@href, 'login')]");
        actions.clickElement("//a[contains(@href, 'login')]");

    }

    public void navigateToLogoutButton(){
        actions.mouseHoverBy("(//span[@class='title' and contains(text(), 'My account')])[2]");
        actions.waitForElementVisible("//a[contains(@href, 'logout')]");
        actions.clickElement("//a[contains(@href, 'logout')]");

    }
}
