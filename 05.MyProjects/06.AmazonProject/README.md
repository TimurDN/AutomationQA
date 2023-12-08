# Amazon Website Crawler

## Task 2 - Simple Site Crawl

This project involves the creation of a crawler designed for the Amazon website. The purpose of the crawler is to perform a simple site crawl based on the following task:

*NOTE: The HTTP requests are failing with server error code 503. Tried with different request methods however result is the same and due to that
links look like broken. I am assuming Amazon is blocking my requests somehow.*

### Task Description

Write a crawler that performs the following actions on the Amazon website:

1. Open the “Shop By Department” dropdown menu.
2. Obtain a list of all department links.
3. Visit each department link to verify that there are no dead links.

The crawler keeps track of visited links and records the information in a text file in the following format: (link, page title, status), where the status can be either "OK" or "Dead link." The result file is named `<timestamp>_results.txt`.

### Project Structure

- The Page Object Model (POM) is employed, organizing the code into separate classes for assertions, elements, and actions for each page.
- JUnit 5 is utilized for testing.
- JDK 11 is used as the programming language.

### Usage Instructions

1. **Clone the repository:**

2. **Open the project in IntelliJ IDEA.**

3. **Configure the project:**
   Ensure that Selenium WebDriver and JUnit 5 are included in the project.

4. **Run the test:**
   Open the `AmazonCrawlerTest` class in `src/test/java` and run the test to initiate the site crawl.

### Results

After running the crawler, the results will be stored in a text file named `<timestamp>_results.txt`. Each line in the file contains information about a visited link, including the link itself, the page title, and the status ("OK" or "Dead link").

Feel free to explore the code, adapt it to your needs, and extend the functionality as necessary. Happy crawling!
