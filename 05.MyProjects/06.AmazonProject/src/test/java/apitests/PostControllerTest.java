package apitests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static api.ErrorMessages.ERROR_MESSAGE_STATUS_CODE;
import static api.SuccessMessages.SHOW_MESSAGE_GET_ALL_POSTS;
import static org.apache.http.HttpStatus.SC_OK;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PostControllerTest extends BaseTestSetup {

    Logger logger = Logger.getLogger("");

    @Test
    public void getAllPostsTest() {

        Response response = showAllPosts();
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_STATUS_CODE);
        logger.info(SHOW_MESSAGE_GET_ALL_POSTS);
    }

    @Test
    public void getAllPostsOfUserId5Test() {

        Response response = showAllPostsOfSpecificUser("5");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_STATUS_CODE);
        logger.info(SHOW_MESSAGE_GET_ALL_POSTS);

        int userId = 5;
        int expectedNumPosts = 10;
        int actualNumPosts = response.jsonPath().getList("$").size();

        // Assert that the actual number of posts matches the expected number of posts
        assertEquals(actualNumPosts, expectedNumPosts,
                String.format("Expected %d posts for user %d, but found %d", expectedNumPosts, userId, actualNumPosts));
    }

    @Test
    public void getAllPostsOfUserId7Test() {

        Response response = showAllPostsOfSpecificUser("7");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_STATUS_CODE);
        logger.info(SHOW_MESSAGE_GET_ALL_POSTS);

        int userId = 7;
        int expectedNumPosts = 10;
        int actualNumPosts = response.jsonPath().getList("$").size();

        // Assert that the actual number of posts matches the expected number of posts
        assertEquals(actualNumPosts, expectedNumPosts,
                String.format("Expected %d posts for user %d, but found %d", expectedNumPosts, userId, actualNumPosts));
    }

    @Test
    public void getAllPostsOfUserId9Test() {

        Response response = showAllPostsOfSpecificUser("9");
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_STATUS_CODE);
        logger.info(SHOW_MESSAGE_GET_ALL_POSTS);

        int userId = 9;
        int expectedNumPosts = 10;
        int actualNumPosts = response.jsonPath().getList("$").size();

        // Assert that the actual number of posts matches the expected number of posts
        assertEquals(actualNumPosts, expectedNumPosts,
                String.format("Expected %d posts for user %d, but found %d", expectedNumPosts, userId, actualNumPosts));
    }

    @Test
    public void uniquePostIdPerPostTest() {

        Response response = showAllPosts();
        int statusCode = response.getStatusCode();

        assertEquals(statusCode, SC_OK, ERROR_MESSAGE_STATUS_CODE);
        logger.info(SHOW_MESSAGE_GET_ALL_POSTS);

        List<Integer> postIds = response.jsonPath().getList("id");
        Set<Integer> uniquePostIds = new HashSet<>();
        for (Integer postId : postIds) {
            assertTrue(uniquePostIds.add(postId), "Duplicate post ID found in the response: " + postId);
        }
            // Compare the size of the list and the set to identify duplicates
            assertEquals(postIds.size(), uniquePostIds.size(), "Duplicate post IDs found in the response.");
        }
    }
