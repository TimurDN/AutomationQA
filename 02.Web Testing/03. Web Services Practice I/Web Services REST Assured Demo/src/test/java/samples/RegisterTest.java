package samples;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static Utils.Constants.BASE_URL_SAMPLES;
import static Utils.Constants.EMAIL_SAMPLES;
import static Utils.Constants.PASSWORD_SAMPLES;
import static Utils.Constants.USER_ID;
import static Utils.Endpoints.REGISTER_ENDPOINT;
import static Utils.JSONRequests.USER_DEFINED_EMAIL;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;

public class RegisterTest {

    @Test
    public void registerSuccessfulDefinedEmailTest() {

        baseURI = format("%s%s", BASE_URL_SAMPLES, REGISTER_ENDPOINT);

        System.out.println(baseURI);
        Response response = given()
            .contentType("application/json")
            .body(format(USER_DEFINED_EMAIL, EMAIL_SAMPLES, PASSWORD_SAMPLES))
            .when()
            .post();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200.");

        USER_ID = response.getBody().jsonPath().getInt("id");
        System.out.println(USER_ID);
    }

    @Test
    public void registerBadRequestTest() {

        baseURI = format("%s%s", BASE_URL_SAMPLES, REGISTER_ENDPOINT);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm..ssssss");
        Timestamp temp = new Timestamp(System.currentTimeMillis());
        String timestamp = sdf.format(temp);
        System.out.println(timestamp);

        System.out.println(baseURI);
        Response response = given()
            .contentType("application/json")
            .body(format(USER_DEFINED_EMAIL, format("%s%s", timestamp, EMAIL_SAMPLES), PASSWORD_SAMPLES))
            .when()
            .post();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, SC_BAD_REQUEST, "Incorrect status code. Expected 400.");
    }
}
