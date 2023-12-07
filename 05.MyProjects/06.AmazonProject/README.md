# Task 3 - API Test

**Note:** Java 11 is used for development, TestNG is used for testing, and an XML file is provided for test execution. 

Additionally, a Postman version of this API test is available and will be added to GitHub.

## Scenario 1: Counting Posts for User <user>

**Test Scenario:**
- API Endpoint: `https://jsonplaceholder.typicode.com/posts` (GET)
- Objective: Simulate the retrieval of blog posts and count the number of posts for a specific user.

### Test Cases
1. **User 5 with 10 Posts**
  - When I get a list of blog posts using the API endpoint
  - Then user 5 should have 10 posts.

2. **User 7 with 10 Posts**
  - When I get a list of blog posts using the API endpoint
  - Then user 7 should have 10 posts.

3. **User 9 with 10 Posts**
  - When I get a list of blog posts using the API endpoint
  - Then user 9 should have 10 posts.

## Scenario 2: Unique ID per Post

**Test Scenario:**
- API Endpoint: `https://jsonplaceholder.typicode.com/posts` (GET)
- Objective: Ensure that each blog post has a unique ID.

### Test Case
- When I get a list of blog posts using the API endpoint
- Then each blog post should have a unique ID.

## Execution Instructions

1. Clone the repository for branch Task3:

2. Open the project in IntelliJ IDEA.

3. Configure the project with the necessary dependencies. Ensure that Java 11 and TestNG are included in the project.

4. Open the provided XML file (`testng.xml`) in the `src/test/resources` directory.

5. Run the XML file to execute the API tests.

## Postman Collection

A Postman version of this API test is available in the repository and can be found in the `postman` directory.

