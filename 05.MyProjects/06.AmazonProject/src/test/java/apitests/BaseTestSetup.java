package apitests;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

import static api.Endpoints.BASE_URL;
import static api.Endpoints.GET_ALL_POSTS_ENDPOINT;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class BaseTestSetup {

    @BeforeSuite
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);

    }

    protected static Response showAllPosts() {
        baseURI = BASE_URL + GET_ALL_POSTS_ENDPOINT;

        return given().when().get(baseURI);
    }

    protected static Response showAllPostsOfSpecificUser(String userId) {
        baseURI = BASE_URL + GET_ALL_POSTS_ENDPOINT;

        return given().queryParam("userId", userId).when().get(baseURI);
    }

}
