# Selenium WebDriver Automated Tests - README

## Introduction

This README provides comprehensive insights into the implementation of acceptance criteria using Java and Selenium WebDriver, specifically designed for the Chrome browser. The project leverages IntelliJ as the IDE, JDK 11, and adheres to industry best practices such as JUnit 5 for testing, Object-Oriented Principles (OOP), and the Page Object Model (POM). The framework is meticulously crafted to ensure code maintainability and reusability.

## Acceptance Criteria

### Test Workflow

1. **Amazon Homepage Navigation:**
  - Open the Chrome browser and navigate to [amazon.com](https://www.amazon.com/).
  - Validate the integrity of the homepage.

2. **Laptop Search:**
  - Execute a search using the keyword "laptop."

3. **Cart Population:**
  - Add non-discounted, in-stock products from the first page of search results to the shopping cart.

4. **Cart Verification:**
  - Go to the cart and meticulously verify the correctness of the added products.

### Framework Highlights

#### Technology Stack

- **IDE:** IntelliJ
- **JDK:** 11
- **Selenium WebDriver:** Chrome browser (Supports multiple browsers)
- **Testing Framework:** JUnit 5

#### Key Features

- **Flexibility and Configurability:**
  - The framework accommodates various browsers, easily configurable through properties.

- **Modular Code Structure:**
  - Implements the Page Object Model (POM) for a modular code structure.
  - Distinct classes for assertions, elements, and page objects ensure code maintainability and reusability.

### Running the Tests

1. Open the project in IntelliJ.
2. Confirm JDK 11 is configured in your environment and load maven.
3. Adjust the browser preference (Chrome or others) in the properties file.
4. Execute the test suite "seleniumRunBat.bat" using JUnit 5.
5. Html report will be auto generated in target/site/surefire-report.html
