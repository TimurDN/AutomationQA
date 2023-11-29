package hrm.orange;

import base.BaseTest;
import org.example.BrowserTypes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseOrangeHrmTest extends BaseTest {
    public static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    @Before
    public void beforeAllTests(){

        driver = startBrowser(BrowserTypes.CHROME);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Configure wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void submitLoginForm(String username, String password){
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
    }
}
