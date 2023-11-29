package googlesearchtests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTests_Refactored {

    public static WebDriver driver;

    @BeforeAll
    public static void beforeTest(){

        ChromeOptions options = new ChromeOptions();

        // Setup Browser
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navigate to Google.com
        driver.get("https://google.com");

        // Accept Terms
        WebElement acceptButton = driver.findElement(By.id("L2AGLb"));
        acceptButton.click();
    }

    @Test
    public void resultsFound_when_searchForTerm() {
        String searchTerm = "Programming";
        // Navigate to Google.com
        driver.get("https://google.com");

        // Type Term to search in input
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys(searchTerm);

        // Submit Search form
        WebElement submitButton = driver.findElement(By.xpath("(//input[@class='gNO89b'])[1]"));
        submitButton.click();

        // Assert Result found
        WebElement resultAnchor = driver.findElement(By.xpath("//a/h3"));
        Assertions.assertTrue(resultAnchor.getText().contains(searchTerm), "expected result not found. Actual text: " + resultAnchor.getText());
    }

    @Test
    public void resultsFound_when_searchForTerm_TelerikAcademy() {
        String searchTerm = "Telerik Academy";
        // Navigate to Google.com
        driver.get("https://google.com");

        // Type Term to search in input
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys(searchTerm);

        // Submit Search form
        WebElement submitButton = driver.findElement(By.xpath("(//input[@class='gNO89b'])[2]"));
        submitButton.click();

        // Assert Result found
        WebElement resultAnchor = driver.findElement(By.xpath("//a/h3"));
        Assertions.assertTrue(resultAnchor.getText().contains(searchTerm), "expected result not found. Actual text: " + resultAnchor.getText());
    }

    @AfterAll
    public static void afterTest(){
        // close driver
        driver.close();
    }
}