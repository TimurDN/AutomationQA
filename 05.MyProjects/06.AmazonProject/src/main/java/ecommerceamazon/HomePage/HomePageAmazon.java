package ecommerceamazon.HomePage;

import ecommerceamazon.BasePage.BasePageAmazon;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HomePageAmazon extends BasePageAmazon {
    public HomePageAmazon(WebDriver driver) {
        super(driver, "amazon.homepage");
    }

    private static FileWriter writer;

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void getLinks() {

        try {
            // Retrieve department links
            List<WebElement> departmentLinks = driver.findElements(By.xpath("//a[@class='hmenu-item' and @data-menu-id >= 5 and @data-menu-id <= 26]"));

            // Create a timestamp for the results file
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Create a FileWriter to write results to a text file
            try (FileWriter writer = new FileWriter(timestamp + "_results.txt")) {
                // Write header to the file
                writer.write("Link, Page Title, Status\n");

                // Visit each department link
                for (WebElement departmentLink : departmentLinks) {
                    // Open the link for navigation using JavaScript executor
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", departmentLink);

                    // Delay to ensure the page is fully loaded (you may need to adjust the duration)
                    Thread.sleep(2000);

                    // Get the department page title
                    String departmentPageTitle = driver.getTitle();

                    // Retrieve all links within the department page
                    List<WebElement> departmentPageLinks = driver.findElements(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li/a"));

                    // Check each link within the department page
                    for (int i = 0; i < departmentPageLinks.size(); i++) {
                        WebElement pageLink = departmentPageLinks.get(i);
                        String link = pageLink.getAttribute("href");
                        String pageTitle = "";
                        String status;

                        // Open the link using JavaScript executor
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pageLink);

                        // Delay to ensure the page is fully loaded (you may need to adjust the duration)
                        Thread.sleep(2000);

                        // Get the page title
                        pageTitle = driver.getTitle();

                        // Check if the page is accessible (alive) or not (dead)
                        status = (driver.getCurrentUrl().equals(link)) ? "OK" : "Dead link";

                        // Write results to the file
                        writer.write(link + ", " + pageTitle + ", " + status + "\n");

                        // Navigate back to the department page for the next iteration
                        driver.navigate().back();
                    }

                    // Navigate back to the home page for the next department link
                    driver.navigate().back();
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            //driver.quit();
        }
    }


    public void brokenLinks() throws InterruptedException {

        List<WebElement> shopByDepartmentCategories = homePageElements().getShopByDepartment();

        initializeFileWriter();

        for (int i = 0; i < shopByDepartmentCategories.size(); i++) {

            if (shopByDepartmentCategories.get(i).getText().isEmpty()) {
                break;

            } else {

                shopByDepartmentCategories.get(i).click();

                Thread.sleep(5000);
                List<WebElement> links = driver.findElements(By.xpath("//ul[@class='hmenu hmenu-visible hmenu-translateX']//li/a"));
                // Iterating each link and checking the response status

                for (int j = 1; j < links.size(); j++) {
                    String url = links.get(j).getAttribute("href");
                    verifyLink(url, links.get(j).getText());

                }

                homePageElements().hamburgerMenuCloseButton().click();
                homePageElements().hamburgerMenuButton().click();
                Thread.sleep(2000);
            }

        }
    }

    public static void verifyLink(String url, String title) {
        try {

            RestAssured.baseURI = url;

            // Send a GET request with RestAssured
            Response response = RestAssured
                    .given()
                    .header("User-Agent", "PostmanRuntime/7.35.0") // Example header, replace with your actual headers
                    .header("Accept", "*/*")
                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Connection", "keep-alive")
                    .header("authority", "www.amazon.com")
                    .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
                    .header("referer","https://www.amazon.com/")
                    .header("sec-ch-ua-platform","Windows")
                    .header("sec-ch-ua-platform-version","15.0.0")
                    .when()
                    .get("");


            if (response.getStatusCode() == 200) {

                writeVisitedLinkStatusToFile(title, url, "OK");

            } else {
                writeVisitedLinkStatusToFile(title, url, "Dead");

            }
        } catch (Exception e) {
            System.out.println(url + " - " + "is a broken link");
        }
    }

    public static void writeVisitedLinkStatusToFile(String pageTitle, String link, String status) {
        try {
            // Write results to the file
            writer.write(link + ", " + pageTitle + ", " + status + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initializeFileWriter() {
        // Create a timestamp for the results file
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        try {
            // Create a FileWriter to write results to a text file
            writer = new FileWriter(timestamp + "_results.txt");

            // Write header to the file
            writer.write("Link, Page Title, Status\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeFileWriter() {
        try {
            // Close the FileWriter
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}