package ecommerceamazon.SearchResultsPage;

import ecommerceamazon.BasePage.BasePageAmazon;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.*;

public class SearchResultPageAmazon extends BasePageAmazon {
    public SearchResultPageAmazon(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    public Map<String, WebElement> findNonDiscountedProductElement() {

        List<WebElement> productElement = driver.findElements(By.xpath("//span[@class='a-price']/../../a"));
        List<WebElement> productTitleElement = driver.findElements(By.xpath("//div[@data-cy='title-recipe']"));
        Map<String, WebElement> nonDiscountedProductAndTitleMap = new HashMap<>();

        int index = -1;

        for (WebElement element : productElement) {
            index = index + 1;
            try {

                if (element.findElement(By.xpath("./div")) != null) {
                    System.out.println("Discounted element was found.");

                }

            } catch (NoSuchElementException e) {

                String title = productTitleElement.get(index).getText();
                nonDiscountedProductAndTitleMap.put(title, element.findElement(By.xpath("./span")));
            }

        }
        return nonDiscountedProductAndTitleMap;
    }
}