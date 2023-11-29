package googlesearchtests;

import base.BaseTest;
import org.example.BrowserTypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class GoogleSearchByTermTests_Parameterized extends BaseTest {
    @Parameterized.Parameters(name="SearchTerm: {0}, result: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Telerik Academy Alpha", "IT Career Start in 6 Months - Telerik Academy Alpha"},
                {"Programming", "Programming"}
        });
    }

    @Parameterized.Parameter(value = 0)
    public String searchTerm;

    @Parameterized.Parameter(value = 1)
    public String expectedResult;

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
        // Type Term to search in input
        WebElement input = driver.findElement(By.name("q"));
        wait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(searchTerm);

        // Submit Search form
        input.sendKeys(Keys.ENTER);

        // Assert Result found
        WebElement resultAnchor = driver.findElement(By.xpath("//a/h3"));
        wait.until(ExpectedConditions.visibilityOf(resultAnchor));
        Assert.assertTrue(
                "expected result '" + expectedResult + "' not found. Actual text: " + resultAnchor.getText(),
                resultAnchor.getText().contains(expectedResult));
    }
}