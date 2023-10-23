package bingsearchtests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchByTermTests {

    private static WebDriver driver;

    // private static WebDriverWait wait;

    @BeforeAll
    public static void classSetup() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // this method did not work no idea why

        driver.get("https://google.com/");

        WebElement agreeButton = driver.findElement(By.xpath("//button[@id='L2AGLb']"));
        agreeButton.click();

    }

    @AfterAll
    public static void classTearDown() {
        driver.close();
    }

    @BeforeEach
    public void testSetup() {
        driver.get("https://google.com/");

    }

    @Test
    public void resultFound_when_searchTermProvided_telerikAcademyAlpha() {
        String searchTerm = "Telerik Academy Alpha";

        WebElement searchField = driver.findElement(By.xpath("//textarea[@type='search']"));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath("(//input[@type='submit' and @name='btnK'])[1]"));
        searchButton.click();

        WebElement firstResult = driver.findElement(By.xpath("(//a/h3)[1]"));
        Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText(), "Search result not found");

    }

}
