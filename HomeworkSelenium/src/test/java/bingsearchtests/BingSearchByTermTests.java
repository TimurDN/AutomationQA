package bingsearchtests;

;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.time.Duration;

public class BingSearchByTermTests {

    public enum BrowserType {
        FIREFOX,
        CHROME,
        EDGE,
    }

    private static final BrowserType chosenBrowser = BrowserType.EDGE;

    private static WebDriver driver;

    //private static WebDriverWait wait;


    @BeforeAll
    public static void classSetup() {

        driver = startBrowser(chosenBrowser);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // this method did not work no idea why

        driver.get("https://bing.com/");

        WebElement agreeButton = driver.findElement(By.xpath("//button[@class='bnp_btn_accept']"));
        agreeButton.click();

    }

    @AfterAll
    public static void classTearDown() {
        driver.close();
    }

    @Test
    public void resultFound_when_searchTermProvided_telerikAcademyAlpha() {

        String searchTerm = "Telerik Academy Alpha";

        WebElement searchField = driver.findElement(By.xpath("//input[@id='sb_form_q']"));
        searchField.sendKeys(searchTerm);

        WebElement searchButton = driver.findElement(By.xpath("//label[@id='search_icon']"));
        searchButton.click();

        if (chosenBrowser == BrowserType.FIREFOX) {

            WebElement firstResult = driver.findElement(By.cssSelector("h2 > a[href^='https://www.bing.com']"));
            String x = firstResult.getText();
            Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText(), "Search result not found");
            //assertTrue(x.equals("Telerik Academy Alpha - IT Career Start in 6 Months") || x.equals("IT Career Start in 6 Months - Telerik Academy Alpha"));

        } else {

            WebElement firstResult = driver.findElement(By.xpath("//h2[@class = ' b_topTitle']/a[1]"));
            //Assertions.assertEquals("IT Career Start in 6 Months - Telerik Academy Alpha", firstResult.getText(), "Search result not found");
            String x = firstResult.getText();

            assertTrue(x.equals("Telerik Academy Alpha - IT Career Start in 6 Months") || x.equals("IT Career Start in 6 Months - Telerik Academy Alpha"));
        }

    }

    private static WebDriver startBrowser(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                return new ChromeDriver();
            case FIREFOX:
                return new FirefoxDriver();
            case EDGE:
                return new EdgeDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser" + chosenBrowser);

        }

    }

}
