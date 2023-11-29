package googlesearchtests;

import base.BaseTest;
import org.example.BrowserTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTests extends BaseTest {
    @Before
    public void beforeAllTests(){

        driver = startBrowser(BrowserTypes.CHROME);

        // Configure wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Navigate to Google.com
        driver.get("https://google.com");

        // Accept Terms
        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();
    }

    @Test
    public void resultsFound_when_searchForTerm_TelerikAcademy() {
        String searchTerm = "Telerik Academy Alpha";

        // Type Term to search in input
        WebElement input = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(searchTerm);

        // Submit Search form
        WebElement submitButton = driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]"));
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();

        String expectedResult = "IT Career Start in 6 Months - Telerik Academy Alpha";
        // Assert Result found
        WebElement resultAnchor = driver.findElement(By.xpath("//a/h3"));
        wait.until(ExpectedConditions.visibilityOf(resultAnchor));
        Assert.assertTrue(
                "expected result '" + expectedResult + "' not found. Actual text: " + resultAnchor.getText(),
                resultAnchor.getText().contains(expectedResult));
    }
}