package googlesearchtests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchByTermTests {

    public WebDriver driver;
    @Test
    public void resultsFound_when_searchForTerm() {
        // Setup Browser
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to Google.com
        driver.get("https://google.com");

        // Accept Terms
        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();

        // Type Term to search in input
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Programming");

        // Submit Search form
        WebElement submitButton = driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]"));
        submitButton.click();

        // Assert Result found
        WebElement resultAnchor = driver.findElement(By.xpath("//a/h3"));
        Assertions.assertTrue(resultAnchor.getText().contains("Programming"), "expected result not found. Actual text: " + resultAnchor.getText());

        // close driver
        driver.close();
    }
}