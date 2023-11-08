package ecommercelambda;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPageLambda extends BasePageLambda {
    public ProductsPageLambda(WebDriver driver) {
        super(driver, "lambda.homepage");

    }

    public void addProductToCompare() {
        actions.waitForElementClickable("//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']");
        actions.clickElement("//*[@title='Add to Cart']/../../../../div/button[@title='Compare this Product']");
    }

    public void clickOnCompareButton(){
        actions.waitForElementClickable("//a[@class='btn btn-secondary btn-block']");
        actions.clickElement("//a[@class='btn btn-secondary btn-block']");
    }

    public boolean assertProductAddedToCompareListMessage(String name) {
        actions.waitForElementVisible("//*[contains(text(),'Success:')]");
        return driver.findElement(By.xpath("//*[contains(text(),'Success:')]"))
                .getText().contains(String.format("You have added\n%s", name));
    }


}
