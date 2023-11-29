package hrm.orange;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class LoginTests_Parameterized extends BaseOrangeHrmTest {

    @Parameterized.Parameters(name="Login credentials: user: {0}, pass: {1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {{"Admin1", "admin123"}, {"Admin", "admin1234"}, {"a", "admin123"}});
    }

    @Parameterized.Parameter(value = 0)
    public String usernameParam;

    @Parameterized.Parameter(value = 1)
    public String passwordParam;

    @Test
    public void userNotAuthenticated_when_inValidUsernameAndPassword(){
        driver.get(LOGIN_URL);
        submitLoginForm(usernameParam, passwordParam);

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']//p"));
        Assert.assertEquals("Error message was not shown", "Invalid credentials",  errorMessage.getText());
    }
}

