# Calculator Framework

This repository contains an automation testing framework for testing the Calculator.net website. The framework is built using **Java**, **Maven**, **Selenium WebDriver**, and **TestNG**.

## Project Structure

- **`src/main/java`**: Contains the main application code (e.g., page object classes).
- **`src/test/java`**: Contains the test classes for the application.
- **`src/test/resources`**: Contains test resources like `testng.xml` for test configuration.
- **`pom.xml`**: Maven configuration file for managing dependencies and build lifecycle.

## Prerequisites

Ensure the following are installed on your system:

1. **Java**: JDK 11 or higher.
2. **Maven**: Maven 3.6 or higher.
3. **Browser Driver**: The appropriate WebDriver (e.g., ChromeDriver) for your browser.
4. **IDE**: IntelliJ IDEA or any Java IDE.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Madhiseelan/CarbCalculator.git

## Navigate to the project directory:
cd your-repo-name

**Install dependencies**:
mvn clean install

**How to Run the Tests Using Maven**

Run All Tests:  
mvn clean test

-- Open the project in IntelliJ IDEA.  
-- Right-click on the test class or method and select Run.

**Test Configuration**: 
The testng.xml file located in src/test/resources/test-suites defines the test suite configuration. Update the file as needed to include or exclude specific tests.

## Dependencies ## 
The following dependencies are used in this project:  
Selenium WebDriver: For browser automation.
TestNG: For test execution and reporting.
WebDriverManager: For managing browser drivers automatically.
These dependencies are managed in the pom.xml file.
