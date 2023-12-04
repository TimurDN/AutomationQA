package ecommerceamazon.SearchResultPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPageElements extends BasePageAmazon {
    public SearchResultsPageElements(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public WebElement searchedProductInResults(String productName){
        actions.waitTillElementIsVisible(String.format("(//span[contains(text(), '%s')])[3]",productName));
        return driver.findElement(By.xpath(String.format("(//span[contains(text(), '%s')])[3]",productName)));

    }
}
