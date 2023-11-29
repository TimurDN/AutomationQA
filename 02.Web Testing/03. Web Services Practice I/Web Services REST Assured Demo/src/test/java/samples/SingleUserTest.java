package samples;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static Utils.Constants.BASE_URL_SAMPLES;
import static Utils.Constants.EMAIL_SAMPLES;
import static Utils.Constants.USER_ID;
import static Utils.Endpoints.USERS_ENDPOINT;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class SingleUserTest {

    @Test
    public void getSingleUserValidIdTest() {

        baseURI = format("%s%s/%s", BASE_URL_SAMPLES, USERS_ENDPOINT, USER_ID);
        System.out.println(baseURI);

        Response response = given()
            .when()
            .get();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");

        LinkedHashMap<String, String> actualEmail = response.getBody().jsonPath().get("data");
        assertEquals(actualEmail.get("email"), EMAIL_SAMPLES, format("Incorrect email address. Expected: %s", EMAIL_SAMPLES));
    }
}
