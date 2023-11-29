package hrm.orange;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginTests extends BaseOrangeHrmTest {
    @Before
    public void testSetup(){
        // Navigate to Google.com
        driver.get(LOGIN_URL);
    }

    @Test
    public void userAuthenticated_when_validUsernameAndPassword(){
        submitLoginForm("Admin", "admin123");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='oxd-userdropdown-img']")));

        WebElement pageHeader = driver.findElement(By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6"));
        Assert.assertEquals("Dashboard page was not navigated after login", "Dashboard", pageHeader.getText());
    }
}

